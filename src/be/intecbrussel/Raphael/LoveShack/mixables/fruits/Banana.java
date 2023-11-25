package be.intecbrussel.Raphael.LoveShack.mixables.fruits;

public class Banana extends Fruit{
    public Banana(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("Banana is Mashed and added");
    }

    @Override
    public String toString() {
        return "Banana: "+getPricePerPiece()+" $";
    }
}
