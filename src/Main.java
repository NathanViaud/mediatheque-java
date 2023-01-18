import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String fileName = args[1];

        if(args[0] == "1") {
            try{
                Mapper mapper = new Mapper();

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

                writeObject(allItems, fileName);

            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(args[0] == "2") {
            List<Item> allItems = readObject(fileName);
            // Carlos fait ton travail
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
        for(Item i: l) {
            System.out.println(i.toString());
        }
        in.close();
        return l;
    }
}

