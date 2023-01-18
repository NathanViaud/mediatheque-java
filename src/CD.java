import java.io.Serializable;

public class CD extends Empruntable implements Serializable {
    private int nbOfTracks;
    private String artist;

    public CD(String reference, String titre, boolean borrowed, int nbOfTracks, String artist) {
        super(reference, titre, borrowed);
        this.nbOfTracks = nbOfTracks;
        this.artist = artist;
    }

    public String toString() {
        return "---------- CD ----------\n" +
                "Titre: " + this.getTitre() +
                "\nArtiste: " + this.artist +
                "\nNombre de pistes: " + this.nbOfTracks +
                "\nDisponible: " + (!this.isBorrowed() ? "Oui" : "Non") +
                "\n------------------------";
    }
}
