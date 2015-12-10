package l0090_closures

import org.junit.Test;
import static groovy.test.GroovyAssert.shouldFail

class Lession{

	@Test
	void test01_IntroToClosures() {
		// Let's start with a simple example.
		def sayHelloClosure = { return 'Hello from Closure' }

		// We can then execute it as if it were a regular method, using:
		def helloClosureResult = sayHelloClosure()
		
		def expectedHelloClosureResult
		// Assign the expected string from the above execution to expectedHelloClosureResult
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert helloClosureResult == expectedHelloClosureResult

		// Closures can also accept parameters, like so
		def personalizedHelloClosure = { String name -> return "Hello $name" }
		String helloRonalda = personalizedHelloClosure('Ronalda')

		// What is the result from the above execution?
		String expectedHelloRonalda
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert helloRonalda == expectedHelloRonalda

		// But there's a shorthand version for this. One parameter closures implicitly add a variable named 'it'
		// which represents that single parameter. We also learned that 'return' isn't mandatory in functions if
		// the last statement is the return statement. Combining those two facts, we get:
		def happyBirthdayClosure = { "Happy Birthday To $it" }
		String happyBirthdayGranger = happyBirthdayClosure('Hermione')

		// What is the result from the above execution?
		def expectedHappyBirthdayGranger
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert happyBirthdayGranger == expectedHappyBirthdayGranger

		// Create a closure that accepts two integers, adds them, and multiplies the result by two
		def resultClosure
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------

		assert resultClosure(2, 3) == 10
		shouldFail { resultClosure('one', 'two') }
	}

	@Test
	void test02_MoreClosureIntro() {

		// So how can we use closures? Everywhere. Groovy adds a lot of convenience methods on top of regular
		// Java constructs.

		def list = ['one', 'two', 'three']
		// In Java 7 or lower, if you wanted to create a list of all items beginning with 't', you would do the following:
		List<String> javaResult = new ArrayList<>()
		for (String s : list) {
			if (s.startsWith("t")) {
				javaResult.add(s)
			}
		}

		// In Groovy (with closures), it's much simpler with the grep method. Use it to filter the list
		// ------------ START EDITING HERE ----------------------
		List<String> groovyResult = null // TODO replace null with Groovy statement
		// ------------ STOP EDITING HERE  ----------------------
				// Let's check that we got the same result (you can use the assert methods)
		assert javaResult == groovyResult
		
		// To make the code even cleaner, Groovy allows some syntactic sugar. If your method has a closure as its
		// last parameter, it can be separated from the rest of the parameters as demonstrated by the following example:

		def monkeyColors = []
		"I have seen blue monkeys, red monkeys, and purple monkeys".eachMatch('(\\w+) monkeys') { entireMatch, color ->
			monkeyColors.add(entireMatch)
		}

		// Which colors does monkeyColors contain?
		def expectedMonkeyColors = []
		// ------------ START EDITING HERE ----------------------
		expectedMonkeyColors = null // TODO set the values expectedMonkeyColors contains
		// ------------ STOP EDITING HERE  ----------------------
		assert monkeyColors == expectedMonkeyColors

		

		// Groovy extends the java.io.File API
		StringWriter filteredResult = new StringWriter()
		def prefix = 'src/test/groovy/l0090_closures/'
		
		// TODO read in the File from $prefix/exercise.txt but leave our lines starting with
		// #. HINT: Use the method filterLine for that
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------

		String result = filteredResult.toString().trim().replaceAll(/[\n\r]+/, /\n/)
		String answer = new File("$prefix/exercise-solved.txt").text.replaceAll(/[\n\r]+/, /\n/)
		assert answer == result
	}
	
	
	
	@Test
	void test03_MoreClosureSyntacticSugar() {
		// Depending on personal preference, you can choose to omit parenthesis from method calls if there is at least
		// one parameter and no ambiguity. For example:

		def count = "That ain't no woman! It's a man, man!".count 'man'

		// Can you guess what count() does? If not, look it up in
		// http://groovy-lang.org/gdk.html
		def expectedCount
		
		//TODO set the expectedCount value to the expected result
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------

		assert count == expectedCount

		// Admittedly, that past example doesn't make the code any clearer.
		// However, when we have methods with a closure as a parameter, it removes a lot of the noise:
		def mysteryList = ['Groovy', 'Baby', 'Yeah'].findAll {
			// no parenthesis
			it.contains('a')
		}

		// What will the value of mysteryList be?
		def expectedMysteryList
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
		assert mysteryList == expectedMysteryList

	}

}