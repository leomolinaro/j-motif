package motif.agot.flow.task;

import java.util.Iterator;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.request.AgotRequest;
import motif.agot.flow.request.AgotRequest.AgotOption;
import motif.agot.flow.request.AgotResponse;
import motif.shared.flow.task.MotifHumanTask;

public abstract class AgotHumanTask extends MotifHumanTask<AgotContext, AgotRequest<?>, AgotResponse> implements IAgotTask {
	
	@Override
	public boolean validResponse (AgotRequest<?> request, AgotResponse response) {
		boolean valid = false;
		String command = response.getCommand ();
		Iterator<?> optionIt = request.options ().iterator ();
		while (optionIt.hasNext () && !valid) {
			AgotOption<?> option = (AgotOption<?>) optionIt.next ();
			if (option.getKey ().equals (command)) { valid = true; }
		} // while
		return valid;
	} // validResponse

	@Override
	public abstract IAgotTask receiveResponse (AgotResponse response, AgotContext context);
	
} // HumanTask
