package feature.movie;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.app.movie.Catalog;
import com.mycompany.app.movie.Movie;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MovieSearchSteps {
	
	Catalog catalog = new Catalog();
	List<Movie> resultList = new ArrayList<Movie>();

	@Given("a movie with the title '([^']+)', produced by '([^']+)', released (.+)")
	public void addNewMovie(String title, String producer, String date) throws ParseException {
		Movie movie = new Movie(title, producer, new SimpleDateFormat("dd MMMMM yyyy").parse(date));
		catalog.addMovie(movie);
	}

//	@Given("a movie with the title 'Out of Africa', produced by 'Universal Pictures', released 20 December 1985")
//	public void addAnotherMovie() throws ParseException {
//		Movie movie = new Movie("Out of Africa", "Universal Pictures", new SimpleDateFormat("dd MMMMM yyyy").parse("20 December 1985"));
//		catalog.addMovie(movie);
//	}
//	
//	@Given("a movie with the title 'Avatar', produced by '20th Century Fox', released 18 December 2009")
//	public void addYetAnotherMovie() throws ParseException {
//		Movie movie = new Movie("Avatar", "20th Century Fox",new SimpleDateFormat("dd MMMMM yyyy").parse("18 December 2009"));
//		catalog.addMovie(movie);
//	}

	@When("the customer searches for movies with the keyword '([^']+)'")
	public void setSearchParameters(String keyword) {
		resultList = catalog.findMovieByKeyword(keyword);
	}

	@Then("(\\d+) movies? should have been found")
	public void verifyQuantityOfMoviesFound(int quantity) {
		assertThat(resultList.size(), equalTo(quantity));
	}

	@Then("the catalog should have 3 total movies")
	public void verifyCatalog() {
		assertThat(catalog.getSize(), equalTo(3));
	}

	@When("the customer searches for the third movie")
	public void setOrdinalSearchParameters() {
		resultList = catalog.findMovieByOrder(2);
	}

	@Then("the movie title should be 'Avatar'")
	public void verifyMovieTitle() {
		assertThat(resultList.get(0).getTitle(), equalTo("Avatar"));
	}

}