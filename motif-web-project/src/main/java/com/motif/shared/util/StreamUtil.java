package com.motif.shared.util;

import java.util.function.BiConsumer;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class StreamUtil {

	@SafeVarargs
	public static <M> Stream<M> concat (Stream<? extends M>...streams) {
		switch (streams.length) {
			case 0: return Stream.empty ();
			case 1: return streams[0].map (s -> s);
			case 2:
				return Stream.concat (streams[0], streams[1]);
			default: 
				Builder<Stream<? extends M>> builder = Stream.builder ();
				for (Stream<? extends M> stream : streams) { builder.add (stream); }
				return builder.build ().flatMap (s -> s);
		} // switch
	} // concat
	
	@SafeVarargs
	public static <M> Stream<M> ofNotNull (M...elements) {
		Builder<M> b = Stream.builder ();
		for (M element : elements) {
			if (element != null) { b.add (element); }
		} // for
		return b.build ();
	} // ofNotNull
	
	public static <M> void forEachWithIndex (Stream<M> stream, BiConsumer<M, Integer> action) {
		int[] index = new int[] { 0 };
		stream.forEach (x -> action.accept (x, index[0]++));
	} // forEachWithIndex
	
} // StreamUtil
