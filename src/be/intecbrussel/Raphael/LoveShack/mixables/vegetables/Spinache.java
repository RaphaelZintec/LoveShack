package be.intecbrussel.Raphael.LoveShack.mixables.vegetables;

public class Spinache extends Vegetables{
    public Spinache(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("Spinache is Mashed and added");
    }

    @Override
    public String toString() {
        return "Spinache: "+getPricePerPiece()+" $";
    }
}
