package com.motif.shared.endpoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.reactivestreams.Publisher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class MotifGraphqlUtil {

	public static <T> Publisher<T> subscribe (Map<String, List<FluxSink<T>>> sinksByUser, MotifUser user) {
		var sinks = sinksByUser.get (user.getUsername ());
		if (sinks == null) {
			sinks = new ArrayList<FluxSink<T>> ();
			sinksByUser.put (user.getUsername (), sinks);
		} // if
		var finalSinks = sinks;
		Flux<T> flux = Flux.create (sink -> {
			finalSinks.add (sink);
			sink.onDispose (() -> onSinkDispose (sink, finalSinks, sinksByUser, user));
		}); // create
		return flux;
	} // subscribe
	
	private static <T> void onSinkDispose (FluxSink<T> sink, List<FluxSink<T>> sinks, Map<String, List<FluxSink<T>>> sinksByUser, MotifUser user) {
		sinks.remove (sink);
		if (sinks.isEmpty ()) {
			sinksByUser.remove (user.getUsername ());
		} // if
	} // onSinkDispose
	
	public static <T> void publish (T element, Map<String, List<FluxSink<T>>> sinksByUser, Collection<MotifUser> users) {
		for (var user : users) {
			var sinks = sinksByUser.get (user.getUsername ());
			if (sinks != null) {
				sinks.forEach (sink -> sink.next (element));
			} // if
		} // for
	} // publish
	
	public static <T> void publish (T element, Map<String, List<FluxSink<T>>> sinksByUser, MotifUser user) {
		var sinks = sinksByUser.get (user.getUsername ());
		if (sinks != null) {
			sinks.forEach (sink -> sink.next (element));
		} // if
	} // publish
	
} // MotifGraphqlUtil
