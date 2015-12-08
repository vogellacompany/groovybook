package l0070_groovytruth

import org.junit.Test

class Lession {

	@Test
	void test01_RegularBooleanExpressions() {
		// boolean expressions work as expected. true evaluates to true and false to false.
		def predicate1 = false
		def predicate2 = true

		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------

		assert predicate1
		assert predicate2 == false
	}
	@Test
	void test02_Collections() {
		// Lists and map evaluate to false if they're empty. Otherwise, they evaluate to true
		Map<String, String> map = [:]
		List<String> list = ['item']

		// TODO Add an entry to the Map and clear the List
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------

		assert map.asBoolean()
		assert list.asBoolean() == false
	}
	@Test
	void test03_StringTruth() {
		// intuitively, empty (or null) strings are false.
		String s1 = 'Non-empty string'
		String s2 = ''
		// TODO set s1 to an empty string or null and ensure s2 is not empty
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------

		// note how we can use String expressions inside an if statement.  It is automatically converted into a boolean.
		if (s1) {
			fail()
		}
		assert !s2.isEmpty()
	}
	@Test
	void test04_NumericTruth() {
		// Similar to C code, null or zeros are false. Any other number is true.
		def balance = [2, -3, 6, 0, 5]

		// Remove (or change) the offending integer to continue
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------

		def result = true
		for (int i : balance) {
			result = result && i.asBoolean()
		}
		assert result
	}

}