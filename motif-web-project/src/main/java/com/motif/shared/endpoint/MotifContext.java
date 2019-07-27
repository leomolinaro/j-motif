package com.motif.shared.endpoint;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MotifContext {

	@Getter
	public final MotifUser user;
	
}
