package com.motif.agot.test;

import com.motif.agot.test.Test.AgotTestException;
import com.motif.agot.test.list.coreset.T001_AClashOfKings;
import com.motif.shared.exceptions.MotifException;

public class TestRunner {

	public static void main (String[] args) throws AgotTestException, MotifException {
		new T001_AClashOfKings ().run ();
//		new T002_AFeastForCrows ().run ();
//		new T036_NobleLigeage ().run ();
		System.out.println ("Test completed successfully!");
	} // main

} // TestRunner
