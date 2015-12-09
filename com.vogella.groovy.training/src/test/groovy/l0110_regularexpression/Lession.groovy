package l0110_regularexpression

import java.util.regex.Matcher
import java.util.regex.Pattern

import org.junit.Test

/**
 * First we must understand regular expressions. There's a nice tutorial at
 * 	http://www.vogella.com/articles/JavaRegularExpressions/article.html
 */
class Lession  {

	@Test
    void test01_SimpleRegularExpression() {
        

        // Using your knowledge of regular expressions,
		// create a regexp string that gets all the technologies
        // that begin with 'G' and end with either 'e' or 's'
        def technologies = ['Grails', 'Gradle', '.NET', 'Python', 'Groovy']
        def regexp
        // ------------ START EDITING HERE ----------------------
        // ------------ STOP EDITING HERE  ----------------------
        def result = technologies.findAll { it ==~ regexp }

        assert result == ['Grails', 'Gradle']
    }

	@Test
	void test02_PalindromeWithOutWhitespace() {
		// write the isPalindrome construct which checks if a String is a palindrome, e.g., that the letters are reverse the same at not reverse
		// ignore whitespace

		def palindrome = "abba ab ba"

		//TODO You need to adjust this method
		assert isPalindrome (palindrome)
	}


	@Test
    void test03_SlashyStrings() {
        // the other type of String declaration is called Slashy strings. They're especially useful for
        // regular expressions. Slashy strings don't need escape backslashes in regular expressions.
        // http://docs.groovy-lang.org/latest/html/documentation/index.html#_slashy_string

        // Suppose we have the following text:
        def text = '''|Item          # Sold  Leftover
                      |Xbox          2000    10
                      |Playstation   100     5
                      |Wii           5       1000'''.stripMargin()

        // If we wanted to grab the number of leftover items with a regular expression in Java,
		// we would do this:
        int javaSum = 0
        String javaRegExp = "(?sm)(.*?)\\s+(\\d+)\\s+(\\d+)"
        Matcher javaMatcher = Pattern.compile(javaRegExp).matcher(text)
        while (javaMatcher.find()) {
            javaSum += Integer.valueOf(javaMatcher.group(3))
        }

        //  Translate the above regexp to a Slashy string regexp using the syntax of /regex/
        def groovyRegExp
        // ------------ START EDITING HERE ----------------------
        // ------------ STOP EDITING HERE  ----------------------
        def matcher = text =~ groovyRegExp
        def groovySum = matcher.collect { it[3].toInteger() }.sum()

        // ^^ Look how much more concise the Groovy code is! There's even a shorter version ahead...
        assert groovySum == javaSum
    }

	@Test
    void test04_SpecialRegexpOperators() {
        // Groovy is very useful for text manipulation, and as such regular expressions get 3 special operators:
        // ~str (tilde) : creates a Pattern object from a string. Equivalent to Pattern.compile(str)
        // str =~ pattern : creates a Matcher from a regex and a string. Same as Pattern.compile(pattern).matcher(str)
        // str ==~ pattern : returns a boolean if pattern matches str. Same as Pattern.matches(pattern, str)

        // This is how a Pattern object is defined in Java for an arbitrary phone number format
        // (xxx xxxx or xxxxxxx or xxx,xxxx)
        Pattern patternInJava = Pattern.compile("\\d{3}([,\\s])?\\d{4}")

        // Create the same Pattern object in Groovy
        def patternInGroovy
        // ------------ START EDITING HERE ----------------------
        // ------------ STOP EDITING HERE  ----------------------
        assert patternInGroovy instanceof Pattern
		assert patternInJava.pattern() == patternInGroovy.pattern()

        // Once you have matches using the Groovy Matcher, you are able to iterate through them using the each() method.
        // Create a matcher and get the first names from the source text
        def names = 'John Lennon, Paul McCartney, George Harrison, Ringo Starr'
        def firstNamesList = []
        // ------------ START EDITING HERE ----------------------
        // ------------ STOP EDITING HERE  ----------------------
        assert firstNamesList == ['John', 'Paul', 'George', 'Ringo']

        // And finally, using the ==~ operator, check if the the following number is a valid Visa card:
        // You can get the regular expression for Visas here: http://www.regular-expressions.info/creditcard.html
        def number = '4927856234092'
        boolean isNumberValid = false
        // ------------ START EDITING HERE ----------------------
        // ------------ STOP EDITING HERE  ----------------------
        assert isNumberValid, 'Visa number should be valid!'
    }

	@Test
    void test05_ReplaceAllWithClosure() {
        // If your regular expression needs some "business logic" for search & replace, you can put it into Closures.
        // Reference:
        // http://naleid.com/blog/2009/04/07/groovy-161-released-with-new-find-and-findall-regexp-methods-on-string/
        
        def dictionary = ['town': 'ciudad', 'man': 'hombre', 'life': 'vida']
        def song = '''|In the town where I was born
                      |Lived a man who sailed to sea
                      |And he told us of his life
                      |In the land of submarines'''.stripMargin()
        def result
		
		// Use the replaceAll method and a closure to create a regex that iterates all the words and replaces them using the
		// supplied dictionary.  E.g. 'this town is mad!' -> 'this ciudad is mad!'
        // ------------ START EDITING HERE ----------------------
        // ------------ STOP EDITING HERE  ----------------------

        def expected = '''|In the ciudad where I was born
                          |Lived a hombre who sailed to sea
                          |And he told us of his vida
                          |In the land of submarines'''.stripMargin()

        assert result == expected
    }

	@Test
    void test06_MultilineRegexWithComments() {
        // Regular expression can become lengthy and hard to read. Groovy solves this by adding a special
        // "extended" (x) flag that ignores newlines and spaces. Read about it here:


        // Let's take the text from the exercise above:
        def text = '''|Item          # Sold  Leftover
                      |Xbox          2000    10
                      |Playstation   100     5
                      |Wii           5       1000'''.stripMargin()

        // create the same regular expression to sum the total leftovers, but this time document the regex
        String regexp
        // ------------ START EDITING HERE ----------------------
        // ------------ STOP EDITING HERE  ----------------------
        def sum = text.findAll(regexp) { it[3].toInteger() }.sum()
        // ^^ This is even more concise than the previous example! Choose the one you feel most comfortable with.

        assert sum == 1015
        def options = regexp.find(/\(\?[^\)]*\)/)
        assert options.contains('x'), 'A commented regex must use the x flag'
        assert regexp.contains('#'), 'Comments can be inserted using the # character'
    }

	boolean isPalindrome (String s) {
		// ------------ START EDITING HERE ----------------------
		// ------------ STOP EDITING HERE  ----------------------
	}


}