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

    public List<CD> CdMapper(ResultSet resultSet) throws SQLException{
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

    public List<DVD> DvdMapper(ResultSet resultSet) throws SQLException{
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


}
