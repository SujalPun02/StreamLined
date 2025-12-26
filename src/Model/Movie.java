/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author sujalpun
 */
public class Movie
{
    private int movieId;
    private String title;
    private String genre;
    private int releaseYear;
    private double rating;
    private int duration;

    public Movie(int movieId, String title, String genre, int releaseYear, double rating, int duration) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
    }

    // Getters and Setters
    public int getMovieId()
    { 
        return movieId; 
    }
    public String getTitle()
    {
        return title;
    }
    public String getGenre()
    {
        return genre;
    }
    public int getReleaseYear()
    { 
        return releaseYear;
    }
    public double getRating()
    { 
        return rating;
    }
    public int getDuration()
    {
        return duration;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }
    public void setRating(double rating)
    {
        this.rating = rating;
    }
    public void setDuration(int duration)
    {
        this.duration = duration;
    }
}