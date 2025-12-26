/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Movie;
import Model.MovieCollection;
import Validation.Validation;
import java.awt.HeadlessException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sujalpun
 */
public class MovieManage
{
    private MovieCollection collection = new MovieCollection();
    private int movieCounter = 1;
    public MovieManage() {
        // Sample data
        collection.addMovie(new Movie(1, "Inception", "Sci-Fi", 2010, 8.8, 148));
        collection.addMovie(new Movie(2, "The Godfather", "Drama", 1972, 9.2, 175));
    }

    public void addMovie(String title, String genre, String year, String rating, String duration)
    {
        try
        {
            Validation.validateMovie(title, year, rating, duration);

            Movie movie = new Movie(movieCounter++,
                    title,
                    genre,
                    Integer.parseInt(year),
                    Double.parseDouble(rating),
                    Integer.parseInt(duration));

            if (!collection.addMovie(movie))
            {
                JOptionPane.showMessageDialog(null,
                        "Movie with this title already exists",
                        "Duplicate Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(null, "Movie added successfully!");

        }
        catch (HeadlessException | NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void loadMoviesToTable(JTable table)
    {
        String[] columns = {"ID", "Title", "Genre", "Year", "Rating", "Duration"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Movie m : collection.getAllMovies())
        {
            model.addRow(new Object[]{
                m.getMovieId(),
                m.getTitle(),
                m.getGenre(),
                m.getReleaseYear(),
                m.getRating(),
                m.getDuration() + " mins"});
        }

       table.setModel(model);
    }

    public void updateMovie(int id, String title, String genre, String year, String rating, String duration)
    {
        try
        {
            Validation.validateMovie(title, year, rating, duration);

            Movie updatedMovie = new Movie(id,title, genre, Integer.parseInt(year), Double.parseDouble(rating), Integer.parseInt(duration));

            if (collection.updateMovie(id, updatedMovie))
                {
                    JOptionPane.showMessageDialog(null, "Movie updated successfully!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Movie not found");
                }
        }
        catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deleteMovie(int id) 
    {
        int confirm = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to delete this movie?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION)
        {
            if (collection.deleteMovie(id))
            {
                JOptionPane.showMessageDialog(null, "Movie deleted successfully!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Movie not found");
            }
        }    
    }
}
