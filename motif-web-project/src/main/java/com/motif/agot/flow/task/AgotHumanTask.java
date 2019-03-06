package com.motif.agot.flow.task;

import java.util.Iterator;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.flow.request.AgotRequest;
import com.motif.agot.flow.request.AgotResponse;
import com.motif.agot.flow.request.AgotRequest.AgotOption;
import com.motif.shared.flow.task.MotifHumanTask;

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
