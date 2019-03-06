package com.motif.shared.flow;

import java.util.Stack;

import com.motif.shared.endpoint.MotifContext;
import com.motif.shared.flow.request.MotifClientRequest;
import com.motif.shared.flow.request.MotifClientResponse;
import com.motif.shared.flow.task.IMotifTask;
import com.motif.shared.flow.task.IMotifTaskVisitor;
import com.motif.shared.flow.task.MotifAutoTask;
import com.motif.shared.flow.task.MotifComplexTask;
import com.motif.shared.flow.task.MotifHumanTask;

public class TaskTrigger<Ctx extends MotifContext, Req extends MotifClientRequest<Res>, Res extends MotifClientResponse> {

	private IMotifSender<Ctx, Req> sender;
	
	public TaskTrigger (IMotifSender<Ctx, Req> sender) {
		super ();
		this.sender = sender;
	} // TaskTrigger

	private Stack<MotifComplexTask<Ctx, Req, Res>> taskStack = new Stack<MotifComplexTask<Ctx, Req, Res>> ();
	private MotifHumanTask<Ctx, Req, Res> humanTask = null;
	
	private Req pendingRequest = null;
	public Req getPendingRequest () { return pendingRequest; }
	public boolean hasPendingRequest () { return pendingRequest != null; }
	
	public void start (IMotifTask<Ctx, Req, Res> task, Ctx context) {
		execute (task, context);
	} // start
	
	private void send (Req request, Ctx context) {
		pendingRequest = request;
		Res autoResponse = request.getAutoResponse ();
		if (autoResponse == null) {
			sender.send (request, context);			
		} else {
			receive (autoResponse, context);
		} // if - else
	} // send
		
	public void receive (Res response, Ctx context) {
		if (humanTask.validResponse (pendingRequest, response)) {
			pendingRequest = null;
			IMotifTask<Ctx, Req, Res> next = humanTask.receiveResponse (response, context);
			humanTask = null;
			execute (next, context);			
		} else {
			send (pendingRequest, context);
		} // if - else
	} // receive
	
	public void execute (IMotifTask<Ctx, Req, Res> task, Ctx context) {
		if (task == null) {
			if (!taskStack.isEmpty ()) {
				MotifComplexTask<Ctx, Req, Res> flux = taskStack.pop ();
				task = flux.getNextTask (context);
				execute (task, context);
			} // if
		} else {
			TaskExecuter executer = new TaskExecuter (context);
			task.accept (executer);
			Req request = executer.getRequest ();
			if (request == null) {
				IMotifTask<Ctx, Req, Res> next = executer.getNext ();
				execute (next, context);
			} else {
				send (request, context);
			} // if - else
		} // if - else
	} // execute
	
//	public void execute (IMotifTask<Ctx, Req, Res> task, Ctx context) {
//		if (task == null && !taskStack.isEmpty ()) {
//			MotifComplexTask<Ctx, Req, Res> flux = taskStack.pop ();
//			task = flux.getNextTask (context);
//		} // if
//		if (task != null) {
//			Req request = null;
//			IMotifTask<Ctx, Req, Res> next = task;
//			do {
//				TaskExecuter executer = new TaskExecuter (context);
//				next.accept (executer);
//				next = executer.getNext ();
//				if (next == null) {
//					request = executer.getRequest ();
//					if (request == null && !taskStack.isEmpty ()) {
//						MotifComplexTask<Ctx, Req, Res> flux = taskStack.pop ();
//						next = flux.getNextTask (context);
//					} // if
//				} // if
//			} while (next != null);
//			if (request != null) { send (request, context); }
//		} // if - else
//	} // execute
	
	private class TaskExecuter implements IMotifTaskVisitor<Ctx, Req, Res> {

		private IMotifTask<Ctx, Req, Res> next;
		public IMotifTask<Ctx, Req, Res> getNext () { return next; }		

		private Req request;
		public Req getRequest () { return request; }		
		
		private Ctx context;
		public TaskExecuter (Ctx context) { this.context = context; }

		@Override public void visit (MotifAutoTask<Ctx, Req, Res> task) {
			next = task.execute (context);
		} // visit

		@Override public void visit (MotifHumanTask<Ctx, Req, Res> task) {
			humanTask = task;
			request = task.getRequest (context);
		} // visit

		@Override public void visit (MotifComplexTask<Ctx, Req, Res> task) {
			taskStack.push (task);
			next = task.getStart (context);
		} // visit

	} // TaskExecuter

} // TaskTrigger
