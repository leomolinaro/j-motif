package com.motif.agot.logic.act;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.motif.agot.ang.enums.AngType;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.flow.IAgotModelChoice;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.other.EnterGameProcedure;
import com.motif.agot.logic.other.FilterMatcher;
import com.motif.agot.logic.requests.AAgotRequest.AgotRequestType;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.logic.requests.AgotChoice.AgotChoiceCardAction;
import com.motif.agot.logic.requests.AttachToRequest;
import com.motif.agot.logic.requests.AttachToRequest.IHasAttachToRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.LocationCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.shared.util.MotifConsole;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SetupAct implements IAgotFlowProcess, IHasAttachToRequest, IAgotModelChoice {

	@Getter private final MarshallCard<?> card;
	private final AgotPlayer player;
	private final AgotGame game;
	
	public interface IHasSetupAct extends IAgotFlowProcess { public IAgotFlowStep after (SetupAct setupAct, AgotContext context); }
	@Getter private final IHasSetupAct parent; 
	@Override public IAgotFlowStep next (AgotContext context) { return this.parent.after (this, context); }
	
	@Override
	public final IAgotFlowStep start (AgotContext context) {
		var cost = this.card.getCost ();
		this.player.payGold (cost, context);
		var attachableTo = this.card.isType (AngType.ATTACHMENT) ? attachableTo () : null;
		var duplicateTo = getDuplicate ();
		
		if (this.card.isLimited ()) { this.player.registerMarshalledLimited (); }
		if (duplicateTo == null) {
			switch (this.card.getType ()) {
				case ATTACHMENT:
					return new AttachToRequest (
							attachableTo.collect (Collectors.toList()),
							(AttachmentCard) this.card,
							this.player,
							this
					);
				case CHARACTER:
					EnterGameProcedure.play ((CharacterCard) this.card, this.player, this.game, context);
					// game.logManager ().marshalls (this.player, this.marshalledCard, context);
					return null;
				case LOCATION:
					EnterGameProcedure.play ((LocationCard) this.card, this.player, this.game, context);
					// game.logManager ().marshalls (this.player, this.marshalledCard, context);
					return null;
				default: return null;
			}
		} else {
			this.player.playAsDuplicate (card, duplicateTo, context);
			// this.game.logManager ().duplicates (this.player, this.marshalledCard, context);
			return null;
		} // if - else
		
	} // start
	
	@Override
	public IAgotFlowStep after (AttachToRequest decision, AgotContext context) {
		var attachment = (AttachmentCard) this.card;
		var attachTo = decision.getChoosenModel ();
		EnterGameProcedure.play (attachment, attachTo, this.player, this.game, context);
		// game.logManager ().marhallsAttachedTo (this.player, attachment, attachTo, context);
		return null;
	} // after
	
	public boolean canBeSetup () {
		if (!this.card.isControlledBy (this.player)) { return false; }
		if (!this.card.isInHand ()) { return false; }
		if (this.card.isLimited ()) {
			if (this.player.getMarshalledLimited () > 0) { return false; }
		} // if
		if (this.card.isType (AngType.ATTACHMENT)) { if (!canBeAttached ()) { return false; } }
		if (!enterAsDuplicate () && this.card.getCost () > this.player.gold ()) { return false; }
		return true;
	} // canBeSetup

	private boolean canBeAttached () {
		return attachableTo ().findAny ().isPresent ();
	} // canBeAttached
	
	private Stream<? extends MarshallCard<?>> attachableTo () {
		AttachmentCard att = (AttachmentCard) this.card;
		Stream<CharacterCard> attachable = this.player.characters ();
		if (att.hasRestriction ()) {
			attachable = attachable.filter (card -> FilterMatcher.doesMatch (card, new AbilityContext (this.card, this.player), att.getRestriction ()));
		}
		return attachable;
	} // attachableTo
	
	private boolean enterAsDuplicate () {
		return getDuplicate () != null;
	} // enterAsDuplicate
	
	private MarshallCard<?> getDuplicate () {
		return player.charactersLocationsAndAttachments ()
		.filter (c -> c.isDuplicate (card))
		.findFirst ()
		.orElse (null);
	} // getDuplicate

	@Override
	public String toString() { return MotifConsole.format ("Setup {0}", card.getTitle ()); }

	@Override
	public AgotChoice getChoice (AgotRequestType requestType) {
		return AgotChoice.selectCardActionChoice (requestType, this.card, AgotChoiceCardAction.SETUP);
	}

} // SetupAct
