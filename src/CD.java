public class CD extends Empruntable {
    private int nbOfTracks;
    private String artist;

    public CD(String reference, String titre, String type, boolean borrowed, int nbOfTracks, String artist) {
        super(reference, titre, type, borrowed);
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
