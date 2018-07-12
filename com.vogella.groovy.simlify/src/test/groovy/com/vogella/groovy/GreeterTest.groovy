package com.vogella.groovy;

import spock.lang.Specification
import com.vogella.groovy.Greeter

class GreeterTest extends Specification{
	def "Ensure that a greeter is greeting correctly"() {
		setup:
		Greeter greeter = new Greeter()
		greeter.owner = 'Simon'

		when:
		def result = greeter.greet('Gradle')

		then:
		result == 'Hello Gradle, I am Simon'
	}
	
	def "Ensure greetings list is filled correctly"() {
		setup:
		Greeter greeter = new Greeter()
		greeter.owner = 'Simon'
			
		when:
		greeter.greet('Gradle')
				
		then:
		greeter.greetings.size == 1
		greeter.greetings[0] == 'Hello Gradle, I am Simon'
	}
	
	def getGreeterSourceFileContents() {
		// find local Greeter.groovy file
		def file = new File('.', '/src/main/groovy/com/vogella/groovy/Greeter.groovy')
		// get the text of the source file
		file.text
	}

	def "Groovy Greeter without unnecessary modifier"() {
		setup:

		def greeterContents = getGreeterSourceFileContents()

		expect:
		!greeterContents.contains(keyword)

		where:
		// check for keywords, which can be omitted in groovy files
		keyword << ['public' , ';', 'return']
	}

	def "ArrayLists are declared in groovy style"() {
		when:
		def greeterContents = getGreeterSourceFileContents()
		
		then:
		!greeterContents.contains('new ArrayList')
	}
	
	def "HashMaps are declared in groovy style"() {
		when:
		def greeterContents = getGreeterSourceFileContents()
			
		then:
		!greeterContents.contains('new HashMap')
	}
	
	def "Make use of Scripting behaviour"() {
		when:
		def greeterContents = getGreeterSourceFileContents()
			
		then:
		!greeterContents.contains('public static void main(')
	}
}
