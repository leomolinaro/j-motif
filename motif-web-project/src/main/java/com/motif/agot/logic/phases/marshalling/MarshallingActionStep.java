package com.motif.agot.logic.phases.marshalling;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.act.ActionAct;
import com.motif.agot.logic.act.IPhaseAct;
import com.motif.agot.logic.act.MarshallingAct;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.AActionPhaseStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.shared.util.StreamUtil;

import lombok.Getter;

public class MarshallingActionStep extends AActionPhaseStep<IMarshallingPhaseStep, IPhaseAct> {

	@Getter private final AgotPlayer activePlayer;
	
	public interface IHasMarshallingActionStep extends IAgotFlowProcess { public APhaseStep<IMarshallingPhaseStep> after(MarshallingActionStep marshallingActionStep, AgotContext context); }
	@Getter private final IHasMarshallingActionStep parent; 
	@Override public APhaseStep<IMarshallingPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public MarshallingActionStep(AgotPlayer activePlayer, AgotGame game, IHasMarshallingActionStep parent) {
		super (AngPhase.MARSHALLING, game);
		this.activePlayer = activePlayer;
		this.parent = parent;
	}

	@Override
	public String getStepTitle() { return AgotText.title().marshallingActionStep(this.activePlayer); }
	
	@Override
	protected List<IPhaseAct> getAvailableActions() {
		Stream<IPhaseAct> availableActs = this.player.interactingCards().filter(card -> card.hasAction())
		        .map(card -> (IPhaseAct) new ActionAct(this.phase, card.getAction(), card, this.player, this.game, this))
		        .filter(actionStep -> actionStep.canBeInitiated() && actionStep.canBePaid());
		if (this.player == this.activePlayer) {
			availableActs = StreamUtil.concat(availableActs,
			        this.activePlayer.hand().filter(card -> !card.isType(AngType.EVENT))
			                .map(card -> new MarshallingAct((MarshallCard<?>) card, this.player, this.game, this))
			                .filter(act -> act.canBeInitiated() && act.canBePaid()));
		} // if
		return availableActs.collect(Collectors.toList());
	}
	
}
