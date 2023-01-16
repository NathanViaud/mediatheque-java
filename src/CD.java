public class CD extends Empruntable {
    private int nbOfTracks;
    private String artist;

    public CD(String reference, String titre, String type, boolean borrowed, int nbOfTracks, String artist) {
        super(reference, titre, type, borrowed);
        this.nbOfTracks = nbOfTracks;
        this.artist = artist;
    }

    public String toString() {
        return "Titre: " + this.getTitre() +
                "Artiste: " + this.artist +
                "Nombre de pistes: " + this.nbOfTracks +
                "Disponible: " + (this.isBorrowed() ? "Oui" : "Non");
    }
}
