import java.io.Serializable;

public class DVD extends Empruntable implements Serializable {
    private String director;
    private String zone;

    public DVD(String reference, String titre, boolean borrowed, String director, String zone) {
        super(reference, titre, borrowed);
        this.director = director;
        this.zone = zone;
    }

    public String toString() {
        return "Titre: " + this.getTitre() +
                "Director: " + this.director +
                "Zone géographique: " + this.zone +
                "Disponible: " + (this.isBorrowed() ? "Oui" : "Non");
    }
}
