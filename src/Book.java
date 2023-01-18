import java.io.Serializable;

public class Book extends Empruntable implements Serializable {
    private String author;
    private String genre;

    public Book(String reference, String titre, boolean borrowed, String author, String genre) {
        super(reference, titre, borrowed);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }



    public String toString() {
        return "---------- Livre ----------\n" +
                "Titre: " + this.getTitre() +
                "\nAuteur: " + this.author +
                "\nGenre: " + this.genre +
                "\nDisponible: " + (!this.isBorrowed() ? "Oui" : "Non") +
                "\n--------------------------";
    }
}
