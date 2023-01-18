import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private Connection connection;
    private Statement statement;
    public Mapper() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque", "root", "");
        this.statement = connection.createStatement();
    }

    public List<Book> bookMapper() throws SQLException {

        ResultSet resultSet = this.statement.executeQuery("SELECT * FROM book");
        final List<Book> result = new ArrayList<>();

        while(resultSet.next()){
            // Book attributes
            final String reference = resultSet.getString("reference");
            final String title = resultSet.getString("title");
            final boolean borrowed = resultSet.getBoolean("borrowed");
            final String author = resultSet.getString("author");
            final String genre = resultSet.getString("genre");

            result.add(new Book(reference, title, borrowed,author,genre));
        }
        return  result;
    }

    public void insertIntoBook(String author, String genre, String reference, String title, boolean borrowed) throws SQLException {
        String sql = String.format("INSERT INTO book(author, genre, reference, title, borrowed)VALUES( \"%s\", \"%s\", \"%s\", \"%s\", %b)",author, genre, reference, title, borrowed);
        this.statement.execute(sql);

    }

    public List<CD> cdMapper() throws SQLException{

        ResultSet resultSet = this.statement.executeQuery("SELECT * FROM cd");
        final List<CD> result = new ArrayList<>();

        while (resultSet.next()){
            // CD attributes
            final String reference = resultSet.getString("reference");
            final String title = resultSet.getString("title");
            final boolean borrowed = resultSet.getBoolean("borrowed");
            final int nbOfTracks = resultSet.getInt("nb_of_tracks");
            final String artist = resultSet.getString("artist");

            result.add(new CD(reference, title, borrowed, nbOfTracks, artist));
        }
        return result;
    }

    public void insertIntoCD(String artist, int nbOfTracks, String reference, String title, boolean borrowed) throws SQLException {
        String sql = String.format("INSERT INTO cd(nb_of_tracks, artist, reference, title, borrowed)VALUES(\"%d\", \"%s\", \"%s\", \"%s\", %b)",nbOfTracks, artist, reference, title, borrowed);
        this.statement.execute(sql);
    }


    public List<DVD> dvdMapper() throws SQLException{
        ResultSet resultSet = this.statement.executeQuery("SELECT * FROM dvd");

        final List<DVD> result = new ArrayList<>();

        while(resultSet.next()){
            // DVD attributes
            final String reference = resultSet.getString("reference");
            final String title = resultSet.getString("title");
            final boolean borrowed = resultSet.getBoolean("borrowed");
            final String producer = resultSet.getString("producer");
            final String zone = resultSet.getString("zone");

            result.add(new DVD(reference, title,borrowed, producer, zone));
        }
        return result;
    }

    public void insertIntoDVD(String producer, String zone, String reference, String title, boolean borrowed) throws SQLException {
        String sql = String.format("INSERT INTO dvd(producer, zone, reference, title, borrowed) VALUES( \"%s\", \"%s\", \"%s\", \"%s\", %b)",producer, zone, reference, title, borrowed);
        this.statement.execute(sql);
    }

    public List<Magazine> magazineMapper() throws SQLException {
        ResultSet resultSet = this.statement.executeQuery("SELECT * FROM magazine");

        final List<Magazine> result = new ArrayList<>();

        while(resultSet.next()){
            // DVD attributes
            final String reference = resultSet.getString("reference");
            final String title = resultSet.getString("title");
            final String weekTheme = resultSet.getString("weekTheme");
            final String editor = resultSet.getString("editor");

            result.add(new Magazine(reference, title, weekTheme, editor));
        }
        return result;
    }

    public void insertIntoMagazine(String editor, String weekTheme, String reference, String title) throws SQLException {
        String sql = String.format("INSERT INTO magazine(editor, weekTheme, reference, title) VALUES(\"%s\", \"%s\", \"%s\", \"%s\")", editor, weekTheme, reference, title);
        this.statement.execute(sql);
    }

}
