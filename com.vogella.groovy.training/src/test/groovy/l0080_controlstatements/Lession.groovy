package l0080_controlstatements

import org.junit.Test


class Lession {

	@Test
	void test01_MultiAssignment() {
		// Sometimes you want to return more than one variable from a method. Yes, you could do it with an enclosing
		// class, but it could be an overkill. Groovy calls it Multiple Assignments.  You can use [var1 , var2] to
		// return multiple assignments
		
		// See http://www.groovy-lang.org/semantics.html

		// Create a closure that returns two random integers in a given range
		def generateTwoRandomInts = { int maxInt ->
			// ------------ START EDITING HERE ----------------------
			// ------------ STOP EDITING HERE  ----------------------
		}

		def (intA, intB) = generateTwoRandomInts(10)
		assert intA in 0..10
		assert intB in 0..10
	}

}
