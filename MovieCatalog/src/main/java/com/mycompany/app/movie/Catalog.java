package com.mycompany.app.movie;

	import java.util.ArrayList;
	import java.util.Calendar;
	import java.util.Comparator;
	import java.util.Date;
	import java.util.List;
	import java.util.Collections;
	
	public class Catalog {
		private final List<Movie> store = new ArrayList<Movie>();
	
		public void addMovie(final Movie movie) {
			store.add(movie);
		}
		
		public List<Movie> findMovieByKeyword(final String keyword) {
			List<Movie> result = new ArrayList<Movie>();
			
			for (Movie movie : store) {
				if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
					result.add(movie);
				}
			}
			
			return result;
		}
		
		public List<Movie> findMovieByOrder(int index) {
			List<Movie> result = new ArrayList<Movie>();
			result.add(store.get(index));
			return result;
		}
		
		public int getSize() {
			return store.size();
		}
	}