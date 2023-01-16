public class Book extends Empruntable {
    private String author;
    private String genre;

    public Book(String reference, String titre, String type, boolean borrowed, String author, String genre) {
        super(reference, titre, type, borrowed);
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
