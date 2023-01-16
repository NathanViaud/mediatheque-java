import java.io.Serializable;

public class Magazine extends Item implements Serializable {
    private String weekTheme;
    private String editor;

    public Magazine(String reference, String titre, String weekTheme, String editor) {
        super(reference, titre);
        this.weekTheme = weekTheme;
        this.editor = editor;
    }

    public String toString() {
        return "Titre: " + this.getTitre() +
                "Thème: " + this.weekTheme +
                "Editeur: " + this.editor;
    }
}
