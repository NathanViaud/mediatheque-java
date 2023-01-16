import java.io.Serializable;

public abstract class Empruntable extends Item implements Serializable {
    private boolean borrowed;

    public Empruntable(String reference, String titre, boolean borrowed) {
        super(reference, titre);
        this.borrowed = borrowed;
    }

    public boolean isBorrowed() {
        return borrowed;
    }
}
