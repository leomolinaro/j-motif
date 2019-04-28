package com.motif.agot.logic.events.list;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.IEventVisitor;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.EnterGameProcedure;
import com.motif.agot.logic.requests.AttachToRequest;
import com.motif.agot.logic.requests.AttachToRequest.IHasAttachToRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.LocationCard;
import com.motif.agot.state.cards.MarshallCard;

import lombok.Getter;

public class MarshallEvent extends AgotEvent implements IHasAttachToRequest {

	@Getter private final MarshallCard<?> marshalledCard;

	private final AgotPlayer player;
	private final MarshallCard<?> duplicateTo;
	private final Stream<MarshallCard<?>> attachableTo;
	
	public MarshallEvent(MarshallCard<?> card, AgotPlayer player, MarshallCard<?> duplicateTo,
	        Stream<MarshallCard<?>> attachableTo, AgotGame game) {
		super(game);
		this.marshalledCard = card;
		this.player = player;
		this.duplicateTo = duplicateTo;
		this.attachableTo = attachableTo;
	}
	
	@Override
	public IAgotFlowStep start (AgotContext context) {
		if (this.marshalledCard.isLimited ()) { player.registerMarshalledLimited (); }
		if (this.duplicateTo == null) {
			switch (this.marshalledCard.getType ()) {
				case ATTACHMENT:
					return new AttachToRequest(
							this.attachableTo.collect(Collectors.toList()),
							(AttachmentCard) this.marshalledCard,
							this.player,
							this
					);
				case CHARACTER:
					EnterGameProcedure.play ((CharacterCard) this.marshalledCard, this.player, this.game, context);
					game.log ().marshalls (this.player, this.marshalledCard, context);
					return null;
				case LOCATION:
					EnterGameProcedure.play ((LocationCard) this.marshalledCard, this.player, this.game, context);
					game.log ().marshalls (this.player, this.marshalledCard, context);
					return null;
				default: return null;
			}
		} else {
			this.player.playAsDuplicate(this.marshalledCard, this.duplicateTo, context);
			this.game.log ().duplicates(this.player, this.marshalledCard, context);
			return null;
		}
	}
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

	@Override
	public IAgotFlowStep after(AttachToRequest decision, AgotContext context) {
		var attachment = (AttachmentCard) this.marshalledCard;
		var attachTo = decision.getChoosenModel();
		EnterGameProcedure.play(attachment, attachTo, this.player, this.game, context);
		game.log ().marhallsAttachedTo (this.player, attachment, attachTo, context);
		return null;
	}
	
}
