package l0094_moreclosures

import org.junit.Test


class Lession {

	@Test
	void test01_WithMethod() {
		// The 'with()' method  allows you to access an object within a closure without explicitly referring to it.

		// This is how Java StringBuilders are used:
		StringBuilder javaStringBuilder = new StringBuilder()
		javaStringBuilder.append("roses are #FF0000\\n")
		javaStringBuilder.append("violets are #0000FF\\n")
		javaStringBuilder.append("all my base\\n")
		javaStringBuilder.append("are belong to you\\n")
		String javaResult = javaStringBuilder.toString()

		// Groovy-fy the above code, using StringBuilder and with() to get the same result in Groovy
		String groovyResult
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert groovyResult == javaResult
	}

	@Test
	void test02_CollectMethodOnLists() {
		// We're often required to iterate through a whole list and and perform some sort of transformation on
		// some (or all) of the items, returning a new list. Groovy has a method just for that in its
		// groovy-jdk/java/lang/Object.html#collect(groovy.lang.Closure)

		// Using collect() and the unique() method from groovy-jdk Collection to assign
		// a list of unique class types to uniqueTypes from the following list:
		def differentTypes = [1, 'String', "GString", 'a', 'Another string', 0]
		def uniqueTypes = []
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert uniqueTypes == [Integer, String]
	}

	@Test
	void test03_FileIteration() {
		// Groovy's File enhancements includes an iterator that walks through all files
		// File.html#eachFileRecurse(groovy.lang.Closure)

		// Use the eachFileRecurse iterator to find the number of files that contain the string 'Lorem'
		// under the src directory. You can access the text of a file via its text property
		int count = 0
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert count == 3

	}

	@Test
	void test04_ConcludingExercise() {
		// Using the methods findAll and every from Groovy object Object.html and
		// range objects, store all the prime numbers between 200 and 250 in the target variable
		def primesBetween200And250 = []
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert primesBetween200And250 == [211, 223, 227, 229, 233, 239, 241]

	}

}