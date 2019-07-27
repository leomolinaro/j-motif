package com.motif.brit.endpoint;

import com.motif.brit.state.BritPlayer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BritContext {

	@Getter
	private final BritPlayer player;

	private BritReduxActionList actions;
	public BritReduxActionList actions() {
		if (actions == null) { actions = new BritReduxActionList(); }
		return this.actions;
	}
	
}
