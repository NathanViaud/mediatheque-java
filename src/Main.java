import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        String fileName = args[1];
        Mapper mapper = new Mapper();

        if(args[0].equals("1")) {
            try{

                List<Book> allBooks = mapper.bookMapper();
                List<CD> allCD = mapper.cdMapper();
                List<DVD> allDVD = mapper.dvdMapper();
                List<Magazine> allMagazine = mapper.magazineMapper();

                allBooks.forEach(System.out::println);

                List<Item> allItems = new ArrayList<>();
                allItems.addAll(allBooks);
                allItems.addAll(allCD);
                allItems.addAll(allDVD);
                allItems.addAll(allMagazine);

                System.out.println(allItems.isEmpty());

                writeObject(allItems, fileName);

            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(args[0].equals("2")) {
            List<Item> allItems = readObject(fileName);
            allItems.forEach(i -> {
                if(i.getClass() == Book.class){
                    try {
                        mapper.insertIntoBook(((Book) i).getAuthor(), ((Book) i).getGenre(), i.getReference(), i.getTitre(),((Book) i).isBorrowed());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                } else if(i.getClass() == CD.class) {
                    try {
                        mapper.insertIntoCD( ((CD) i).getArtist(),((CD) i).getNbOfTracks(), i.getReference(), i.getTitre(), ((CD) i).isBorrowed());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                } else if(i.getClass() == DVD.class) {
                    try {
                        mapper.insertIntoDVD(((DVD) i).getDirector(), ((DVD) i).getZone(), i.getReference(), i.getTitre(), ((DVD) i).isBorrowed());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                } else if(i.getClass() == Magazine.class) {
                    try {
                        mapper.insertIntoMagazine(((Magazine) i).getEditor(), ((Magazine) i).getWeekTheme(), i.getReference(), i.getTitre());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    public static String generateRef() {
        return UUID.randomUUID().toString();
    }

    public static void writeObject(List<Item> items, String fileName) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(items);
        out.close();
    }

    public static List<Item> readObject(String fileName) throws IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        List<Item> l = (List<Item>)in.readObject();
        in.close();
        return l;
    }
}

