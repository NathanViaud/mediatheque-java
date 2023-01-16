import java.io.Serializable;

public abstract class Item implements Serializable {
    private String reference;
    private String titre;
    private String type;

    public Item(String reference, String titre, String type) {
        this.reference = reference;
        this.titre = titre;
        this.type = type;
    }

    public String getReference() {
        return reference;
    }

    public String getTitre() {
        return titre;
    }

    public String getType() {
        return type;
    }
}
