package l0020_groovybeans

import static groovy.test.GroovyAssert.shouldFail


// Groovy introduces an easier way to create JavaBeans. They're called GroovyBeans.
// Have a read here: http://groovy.codehaus.org/Groovy+Beans

import org.junit.Test
/**
 *
 * TODO Ensure that all tests in this class are running successfully
 */

class Lesson {
	// TODO Rework your Groovy bean called "GroovyPerson" to have the the properties "firstName", "lastName" and "ssn"

	@Test
	void test01_IntroToGroovyBeans() {
		// JavaBeans (or POJOs) are simple Java objects with getters (getX) and setters (setX) for its members
		JavaPerson javaPerson = new JavaPerson("Argus", "Filch", "1234")

		// GroovyBeans are simpler
		GroovyPerson groovyPerson = new GroovyPerson('Harry', 'Potter', '3322')

		def javaFirstName
		def groovyFirstName
		// Assign the firstName of javaPerson to javaFirstName and the first name of groovyPerson to groovyFirstName
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------

		assert javaFirstName == 'Argus'
		assert groovyFirstName == 'Harry'
	}

	@Test
	void test02_ReadOnlyFieldInGroovyBean() {
		// Groovy automatically generates getters/setters for you. Mark the field ssn with 'final'
		// to prevent Groovy from doing that

		// Try to modify the following ssn. You should get a ReadOnlyPropertyException.
		def person = new GroovyPerson('Ken', 'Kousen', '7878')
		def failed = true
		shouldFail (ReadOnlyPropertyException) {
			// ------------ START EDITING HERE ----------------------
			// ------------ STOP EDITING HERE  ----------------------
			failed = false
		}

		assert failed
		// The code wrapping your additions verifies that the ReadOnlyProperty exception has been thrown.
		// The curly brackets ({}) represent a closure. You learn later what this means.
	}
	@Test
	void test03_NamedParametersInConstructors() {
		// To enhance code clarity, Groovy supports using named arguments in methods.
		def quote = new SimpleGroovyBean(title: 'Quote object',
		data: "Never trust anything that can think for itself if you can't see where it keeps its brain")

		// If you pay close attention, you'll see that 'data' is actually untyped.
		// Practically, it's the same as specifying an 'Object' as the type.

		// Create a SimpleGroovyBean using named arguments, to represent a transaction with -30 as its data.
		def transaction
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------

		assert transaction.data == -30
	}
	@Test
	void test04_DefaultValues() {

		// Ensure that the greeter methods uses default values if no values are specified
		// use "Hello" for the first parameter and "world" for the second parameter
		def g = new Greeter()
		assert 'Hello world!' == g.greeter()
		// right most parameter with default value is eliminated first.
		assert 'Moin world!' == g.greeter('Moin')
		// fix this test
		assert 'Moin Hamburg!' == g.greeter('Moin', 'Hamburg');
	}


}