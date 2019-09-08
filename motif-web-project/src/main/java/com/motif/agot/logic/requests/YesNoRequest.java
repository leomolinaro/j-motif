package com.motif.agot.logic.requests;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class YesNoRequest extends AAgotRequest {

	public static final String CONTINUE_KEY = "c";
	
	@Getter protected Boolean choosenAnswer;
	
	public YesNoRequest (String instruction, AgotPlayer player, IHasYesNoRequest parent) {
		super(
				AgotRequestType.YES_NO,
				player,
				instruction
		);
		this.parent = parent;
		this.addChoice (AgotChoice.selectYesNoChoice (true));
		this.addChoice (AgotChoice.selectYesNoChoice (false));
	} // YesNoRequest
	
	public interface IHasYesNoRequest extends IAgotFlowProcess { public IAgotFlowStep after (YesNoRequest yesNoDecision, AgotContext context); }
	@Getter private final IHasYesNoRequest parent; 
	@Override public IAgotFlowStep next (AgotContext context) { return this.parent.after (this, context); }
	
	@Override
	protected boolean acceptChoice (AgotChoice choice, AgotContext context) {
		this.choosenAnswer = choice.getYesNoAnswer ();
		return true;
	} // acceptChoice
	
	@Override
	public AgotChoice getAutoChoice () {
		return null;
	} // getAutoChoice
	
} // YesNoRequest
