import java.io.Serializable;

public abstract class Item implements Serializable {
    private String reference;
    private String titre;

    public Item(String reference, String titre) {
        this.reference = reference;
        this.titre = titre;
    }

    public String getReference() {
        return reference;
    }

    public String getTitre() {
        return titre;
    }

}
