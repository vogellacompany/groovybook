package l0120_slurper

import org.junit.Test

/**
 * Slurpers
 */

class Lession  {
	final String path = "./input/movies.xml"

	@Test
    void test01_XmlSlurpersReader() {
		// Use  XmlSlurper and its parse method to read the content of movies.xml
		// and find out how many movies are listed.
        def movieCount
		 // ------------ START EDITING HERE ----------------------
        // ------------ STOP EDITING HERE  ----------------------
        assert movieCount == 7

        // return all the movie names that contain the word 'the' (case-insensitive)
        // Hint: use the findAll method
        List<String> moviesWithThe = []
        // ------------ START EDITING HERE ----------------------
        // ------------ STOP EDITING HERE  ----------------------
        assert moviesWithThe.containsAll(['Conan the Barbarian', 'The Expendables', 'The Terminator'])

        // How many movie ids have a value greater than 5?
        def movieIdsGreaterThan5
        // ------------ START EDITING HERE ----------------------
        // ------------ STOP EDITING HERE  ----------------------
        assert movieIdsGreaterThan5 == 2
    }

}
