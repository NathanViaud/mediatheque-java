import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try{


            Mapper mapper = new Mapper();

            List<Book> allBooks = mapper.bookMapper();

            System.out.println(allBooks.isEmpty());

            allBooks.forEach(System.out::println);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}