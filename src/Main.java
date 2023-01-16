import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque", "root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM book WHERE author = 'Paolo'");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("empruntable_id"));
                ResultSet rs = statement.executeQuery("SELECT * FROM empruntable WHERE id = resultSet.getInt(\"empruntable_id\")");

                while(resultSet.next()){
                    ResultSet itemRs = statement.executeQuery("SELECT * FROM items WHERE id = resultSet.getInt('reference_id')");
                    while(resultSet.next()){
                        System.out.println(resultSet.getString("author"));
                        String author = resultSet.getObject("author", String.class);
                        String genre = resultSet.getObject("genre", String.class);
                        Book book = new Book(itemRs.getString("reference"), itemRs.getString("title"), rs.getBoolean("borrowed"), author, genre);
                        book.toString();
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}