import java.io.Serializable;

public class Book extends Empruntable implements Serializable {
    private int id;
    private String author;
    private String genre;

    public Book(String reference, String titre, boolean borrowed, String author, String genre) {
        super(reference, titre, borrowed);
        this.author = author;
        this.genre = genre;
    }

    public String toString() {
        return "Titre: " + this.getTitre() +
                "Auteur: " + this.author +
                "Genre: " + this.genre +
                "Disponible: " + (this.isBorrowed() ? "Oui" : "Non");
    }
}
