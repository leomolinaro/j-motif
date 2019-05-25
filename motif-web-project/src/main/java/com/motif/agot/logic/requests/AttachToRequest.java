package com.motif.agot.logic.requests;

import java.util.List;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.MarshallCard;

import lombok.Getter;

public class AttachToRequest extends AAgotModelRequest<MarshallCard<?>> {

	public AttachToRequest(List<MarshallCard<?>> modelChoices, AttachmentCard attachment, AgotPlayer player, IHasAttachToRequest parent) {
		super(
				AgotRequestType.SELECT_CARD_TO_ATTACH,
				modelChoices,
				player,
				AgotText.request ().selectCardToAttach(player, attachment)
		);
		this.parent = parent;
	}
		
	public interface IHasAttachToRequest extends IAgotFlowProcess { public IAgotFlowStep after(AttachToRequest decision, AgotContext context); }
	@Getter private final IHasAttachToRequest parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
}
