public class Magazine extends Item {
    private String weekTheme;
    private String editor;

    public Magazine(String reference, String titre, String type, String weekTheme, String editor) {
        super(reference, titre, type);
        this.weekTheme = weekTheme;
        this.editor = editor;
    }

    public String toString() {
        return "Titre: " + this.getTitre() +
                "Thème: " + this.weekTheme +
                "Editeur: " + this.editor;
    }
}
