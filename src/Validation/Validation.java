/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

/**
 *
 * @author sujalpun
 */
public class Validation
{

    public static void validateMovie(String title,String genre, String year, String rating, String duration) 
    {

        if (title == null || title.trim().isEmpty())
        {
           throw new IllegalArgumentException("Movie title cannot be empty");
        }
        
        if (genre == null || genre.trim().isEmpty())
        {
           throw new IllegalArgumentException("Movie genre cannot be empty");
        }
        
        if (year == null || year.trim().isEmpty())
        {
           throw new IllegalArgumentException("Movie year cannot be empty");
        }
        
        if (rating == null || rating.trim().isEmpty())
        {
           throw new IllegalArgumentException("Movie rating cannot be empty");
        }
        
        if (duration == null || duration.trim().isEmpty())
        {
           throw new IllegalArgumentException("Movie duration cannot be empty");
        }
        
        int y = Integer.parseInt(year);
        if (y < 1888 || y > 2025)
        {
            throw new IllegalArgumentException("Release year must be between 1888 and 2025");
        }

        double r = Double.parseDouble(rating);
        if (r < 0 || r > 10)
        {
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        }

        int d = Integer.parseInt(duration);
        if (d <= 0)
        {
            throw new IllegalArgumentException("Duration must be a positive number");
        }
    }
}