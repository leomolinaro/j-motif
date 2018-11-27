package motif.agot.logic.round.phases.challenges.challenge;

import java.util.stream.Collectors;

import motif.agot.ang.AgotText;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.EventTrigger;
import motif.agot.logic.events.list.DetermineAChallengeEvent;
import motif.agot.logic.round.phases.Step;
import motif.agot.logic.round.phases.challenges.IChallengesPhaseStep;
import motif.agot.state.Challenge;
import motif.agot.state.AgotGame;

public class DetermineWinnerStep extends Step<IChallengesPhaseStep> {

	private Challenge data;

	public DetermineWinnerStep (Challenge data, AgotGame game) {
		super (game);
		this.data = data;
	} // DetermineWinnerStep
	
	@Override
	public String getStepTitle () { return AgotText.title ().determineWinner (); }

	@Override
	public IAgotTask getStartTask (AgotContext context) {
		int attStr = data.attackers ().collect (Collectors.summingInt (att -> att.getStrength ()));
		int defStr = data.defenders ().collect (Collectors.summingInt (def -> def.getStrength ()));
		data.attStr = attStr;
		data.defStr = defStr;
		if (attStr >= defStr && attStr > 0 && data.attackers ().findAny ().isPresent ()) {
			data.setAttackWins ();
			data.setDefenseLoses ();
			if (data.defStr == 0 && data.attStr > 0) {
				data.setUnopposed ();
				game.log ().winsTheChallengeUnopposed (data.attacker (), context);				
			} else {
				game.log ().winsTheChallenge (data.attacker (), context);				
			} // if - else
		} else if (attStr < defStr && defStr > 0 && data.defenders ().findAny ().isPresent ()) {
			data.setDefenseWins ();
			data.setAttackLoses ();
			game.log ().winsTheChallenge (data.defender, context);
		} // if - else
		Event event = new DetermineAChallengeEvent (data, game);
		return EventTrigger.execute (event, game);
	} // getStartTask

	@Override
	public ChallengeBonusStep getNextTask (AgotContext context) {
		return new ChallengeBonusStep (data, game);
	} // getNextTask

} // DetermineWinnerStep
