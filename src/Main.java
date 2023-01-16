import java.io.*;
import java.util.UUID;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Book b1 = new Book(generateRef(), "Nouveau Livre", "book", false, "Nathan", "polar" ) ;
        CD cd1 = new CD(generateRef(), "Album", "cd", false, 47, "CarlosBaila");
        DVD dvd1 = new DVD(generateRef(), "Shrek", "dvd", true, "Moi", "EU");
        Magazine m1 = new Magazine(generateRef(), "Mode", "magazine", "Theme", "Grazia");

        Vector<Item> v = new Vector<>();
        String fileName = "/Users/nviaud/Documents/EPSI/Java/Mediateque/data/item.txt";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));

        v.add(b1);
        v.add(cd1);
        v.add(dvd1);
        v.add(m1);

        out.writeObject(v);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        v = (Vector<Item>)in.readObject();
        for(Item i: v) {
            System.out.println(i.toString());
        }
        in.close();
    }

    public static String generateRef() {
        return UUID.randomUUID().toString();
    }
}