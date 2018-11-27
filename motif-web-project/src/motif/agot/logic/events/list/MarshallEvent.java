package motif.agot.logic.events.list;

import java.util.stream.Stream;

import motif.agot.ang.AgotText;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.request.AgotRequest;
import motif.agot.flow.request.AgotResponse;
import motif.agot.flow.request.AgotRequest.AgotRequestCod;
import motif.agot.flow.task.AgotHumanTask;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.logic.other.EnterGameProcedure;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.AttachmentCard;
import motif.agot.state.cards.CharacterCard;
import motif.agot.state.cards.LocationCard;
import motif.agot.state.cards.MarshallCard;

public class MarshallEvent extends Event {

	private MarshallCard<?> marshalledCard;
	public MarshallCard<?> getMarshalledCard () { return marshalledCard; }

	private AgotPlayer player;
	private MarshallCard<?> duplicateTo;
	private Stream<MarshallCard<?>> attachableTo;
	
	public MarshallEvent (MarshallCard<?> card, AgotPlayer player, MarshallCard<?> duplicateTo, Stream<MarshallCard<?>> attachableTo , AgotGame game) {
		super (game);
		this.marshalledCard = card;
		this.player = player;
		this.duplicateTo = duplicateTo;
		this.attachableTo = attachableTo;
	} // MarshallOccurrence
	
	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		if (marshalledCard.isLimited ()) { player.registerMarshalledLimited (); }
		if (duplicateTo == null) {
			switch (marshalledCard.getType ()) {
				case ATTACHMENT:
					return new AttachToRequest ((AttachmentCard) marshalledCard);
				case CHARACTER:
					EnterGameProcedure.play ((CharacterCard) marshalledCard, player, game, context);
					game.log ().marshalls (player, marshalledCard, context);
					return null;
				case LOCATION:
					EnterGameProcedure.play ((LocationCard) marshalledCard, player, game, context);
					game.log ().marshalls (player, marshalledCard, context);
					return null;
				default: return null;
			} // switch
		} else {
			player.playAsDuplicate (marshalledCard, duplicateTo, context);
			game.log ().duplicates (player, marshalledCard, context);
			return null;
		} // if - else
	} // getEffectResolver
	
	private class AttachToRequest extends AgotHumanTask {

		private AgotRequest<MarshallCard<?>> pendingRequest = null;
		
		private AttachmentCard card;
		
		public AttachToRequest (AttachmentCard card) {
			this.card = card;
		} // AttachToRequest

		@Override
		public IAgotTask receiveResponse (AgotResponse response, AgotContext context) {
			MarshallCard<?> attachTo = pendingRequest.getChoice (response).getModel ();
			EnterGameProcedure.play (card, attachTo, player, game, context);
			game.log ().marhallsAttachedTo (player, card, attachTo, context);
			return null;
		} // receiveResponse

		@Override
		public AgotRequest<?> getRequest (AgotContext context) {
			pendingRequest = AgotRequest.createRequest (AgotRequestCod.SELECT_CARD_TO_ATTACH, player, attachableTo, AgotText.request ().selectCardToAttach (player, card));
			return pendingRequest;
		} // getRequest
		
	} // AttachToRequest
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }
	
} // MarshallEvent
