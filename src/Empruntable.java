public abstract class Empruntable extends Item {
    private boolean borrowed;

    public Empruntable(String reference, String titre, String type, boolean borrowed) {
        super(reference, titre, type);
        this.borrowed = borrowed;
    }

    public boolean isBorrowed() {
        return borrowed;
    }
}
