package com.motif.shared.flow;

import java.util.Stack;

import com.motif.shared.endpoint.MotifContext;
import com.motif.shared.flow.request.MotifClientRequest;
import com.motif.shared.flow.request.MotifClientResponse;
import com.motif.shared.flow.taskV2.IMotifSubTaskV2;
import com.motif.shared.flow.taskV2.MotifAutoTaskV2;
import com.motif.shared.flow.taskV2.MotifHumanTaskV2;

public class TaskTriggerV2<
	Ctx extends MotifContext,
	Req extends MotifClientRequest<Res>,
	Res extends MotifClientResponse
> {

	private IMotifSender<Ctx, Req> sender;
	
	public TaskTriggerV2 (IMotifSender<Ctx, Req> sender) {
		super ();
		this.sender = sender;
	} // TaskTrigger

	private Stack<MotifAutoTaskV2<Ctx, ?, ?>> taskStack = new Stack<MotifAutoTaskV2<Ctx, ?, ?>> ();
	private MotifHumanTaskV2<Ctx, Req, Res> humanTask = null;
	
	private Req pendingRequest = null;
	public Req getPendingRequest () { return pendingRequest; }
	public boolean hasPendingRequest () { return pendingRequest != null; }
	
	private void request (MotifHumanTaskV2<Ctx, Req, Res> humanTask, Ctx context) {
		this.humanTask = humanTask;
		Req request = humanTask.getRequest ();
		this.pendingRequest = request;
		sender.send (request, context);			
	} // send
		
	public void receive (Res response, Ctx context) {
		if (humanTask.validResponse (pendingRequest, response)) {
			this.pendingRequest = null;
			humanTask.receiveResponse (response);
			MotifAutoTaskV2<Ctx, ?, ?> autoTask = taskStack.peek ();
			IMotifSubTaskV2<Ctx, ?, ?> subTask = autoTask.drive (humanTask, context);
			humanTask = null;
			execute (subTask, autoTask, context);
		} else {
			sender.send (pendingRequest, context);
		} // if - else
	} // receive
	
	public void start (MotifAutoTaskV2<Ctx, ?, ?> autoTask, Ctx context) {
		taskStack.push (autoTask);
		IMotifSubTaskV2<Ctx, ?, ?> subTask = autoTask.start (context);
		execute (subTask, autoTask, context);
	} // start
	
	private void end (MotifAutoTaskV2<Ctx, ?, ?> autoTask, Ctx context) {
		taskStack.pop ();
		if (!taskStack.isEmpty ()) {
			MotifAutoTaskV2<Ctx, ?, ?> father = taskStack.peek ();
			IMotifSubTaskV2<Ctx, ?, ?> subTask = father.drive (autoTask, context);
			execute (subTask, father, context);
		} // if
	} // end
	
	@SuppressWarnings("unchecked")
	private void execute (IMotifSubTaskV2<Ctx, ?, ?> task, MotifAutoTaskV2<Ctx, ?, ?> father, Ctx context) {
		if (task == null) {
			end (father, context);
		} else if (task instanceof MotifAutoTaskV2) {
			start ((MotifAutoTaskV2<Ctx, ?, ?>) task, context);
		} else {
			request ((MotifHumanTaskV2<Ctx, Req, Res>) task, context);
		} // if - else
	} // execute

} // TaskTrigger
