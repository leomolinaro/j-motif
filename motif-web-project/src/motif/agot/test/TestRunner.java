package motif.agot.test;

import motif.agot.test.Test.AgotTestException;
import motif.agot.test.list.coreset.T001_AClashOfKings;
import motif.agot.test.list.coreset.T002_AFeastForCrows;

public class TestRunner {

	public static void main (String[] args) throws AgotTestException {
		new T001_AClashOfKings ().run ();
		new T002_AFeastForCrows ().run ();
	} // main

} // TestRunner
