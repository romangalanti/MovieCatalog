package feature.movie;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.app.movie.Catalog;
import com.mycompany.app.movie.Movie;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CatalogStatusSteps {
	
	Catalog catalog = new Catalog();
	List<Movie> resultList = new ArrayList<Movie>();

	@Given("That I want to quickly and easily manage my catalog of movies")
	public void testMoviesCatalogExists() {
		
	}
	
	@When("I add [0-9] movies to the catalog")
	public void addMoviesToList() {
		
	}
	
	@Then("I will have [0-9] movies in the catalog")
	public void checkNumberOfMoviesInCatalog() {
		
	}
	
	
}