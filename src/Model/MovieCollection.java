/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.LinkedList;

/**
 *
 * @author sujalpun
 */
public class MovieCollection
{
    private LinkedList<Movie> movies = new LinkedList<>();

    // CREATE
    public boolean addMovie(Movie movie) {
        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(movie.getTitle())) {
                return false; // Duplicate title
            }
        }
        movies.add(movie);
        return true;
    }

    // READ
    public LinkedList<Movie> getAllMovies() {
        return movies;
    }

    // UPDATE
    public boolean updateMovie(int id, Movie updatedMovie) {
        for (Movie m : movies) {
            if (m.getMovieId() == id) {
                m.setTitle(updatedMovie.getTitle());
                m.setGenre(updatedMovie.getGenre());
                m.setReleaseYear(updatedMovie.getReleaseYear());
                m.setRating(updatedMovie.getRating());
                m.setDuration(updatedMovie.getDuration());
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteMovie(int id) {
        return movies.removeIf(m -> m.getMovieId() == id);
    }
}
