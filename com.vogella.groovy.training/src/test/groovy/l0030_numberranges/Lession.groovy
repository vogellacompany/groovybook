package l0030_numberranges

import org.junit.Test



/**
 * Lession- Learn about Groovy Numbers and Operator overload
 *
 */

class Lession  {


	@Test
    void test01_Numbers() {
		// Use the times method to calculate the sum of the numbers until 15
		// you can use "it" to get the current value of the number in the method body
		int result = 0
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert result == 105
    }

	@Test
	void test02_Numbers() {
		// Use the upTo method to calculate the sum of the numbers between 71 and 84
		// you can use "it" to get the current value of the number in the method body
		int result = 0
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert result == 1085
	}

	@Test
	void test03_LeftShift() {
		// Use the left-shift operator to change number to 8
		// Hint this is a byte-shift
		int number= 1
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert number == 8

		// Use the left-shift operator to append to text the String "Hello"
		// Hint this is a byte-shift
		String text= "Test"
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert text == "TestHello"

		// Append 5 times hello
		String result= "Test"
		// ------------ START EDITING HERE ----------------------
		5.times {result = result  << "Hello"}// Use the step method to create a sequence of numbers
		// ------------ STOP EDITING HERE  ----------------------
		assert result == "TestHelloHelloHelloHelloHello"


	}

	@Test
	void test04_operatorOverloading() {
		def p1 = new GroovyPerson();
		def p2 = new GroovyPerson();
		def result
		// GroovyPerson implements plus which is mapped to plus
		// Assign result to the result of adding p1 and p2
		// ------------ START EDITING HERE ----------------------
		// ------------ START EDITING HERE ----------------------

		assert result instanceof l0030_numberranges.GroovyCouple
	}

	@Test
	void test05_createSteps() {
		def numbers = []
		// Use the step method to create a sequence of numbers from 1.0 to 1.9 separated by 0.1
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert numbers.join(",") == '1.0,1.1,1.2,1.3,1.4,1.5,1.6,1.7,1.8,1.9' //notice how the first value changed to 1.0

	}


}