@tag
Feature: Movie Search
  To allow a user to search through a movie catalog and find a desired movie.

  Background:
    Given a movie with the title 'Inside Out', produced by 'Pixar', released 19 June 2015
	And a movie with the title 'Out of Africa', produced by 'Universal Pictures', released 20 December 1985
    And a movie with the title 'Avatar', produced by '20th Century Fox', released 18 December 2009
    
  @tag1
  Scenario Outline: Search movies by title
    #Given a movie with the title 'Inside Out', produced by 'Pixar', released 19 June 2015
    #And a movie with the title 'Out of Africa', produced by 'Universal Pictures', released 20 December 1985
    #And a movie with the title 'Avatar', produced by '20th Century Fox', released 18 December 2009
    When the customer searches for movies with the keyword <keyword>
    Then <num_mov> movie should have been found
    And the catalog should have <tot_mov> total movies
    
	Examples:
	|	keyword | num_mov |	tot_mov |
    |	'Out'   | 2       | 3       |
    	
    
  @tag1
  Scenario: Search movies by order
    #Given a movie with the title 'Inside Out', produced by 'Pixar', released 19 June 2015
    #And a movie with the title 'Out of Africa', produced by 'Universal Pictures', released 20 December 1985
    #And a movie with the title 'Avatar', produced by '20th Century Fox', released 18 December 2009
    When the customer searches for the third movie
    Then 1 movie should have been found
    And the movie title should be 'Avatar'