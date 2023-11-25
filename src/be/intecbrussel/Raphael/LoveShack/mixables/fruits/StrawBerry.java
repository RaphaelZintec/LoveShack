package be.intecbrussel.Raphael.LoveShack.mixables.fruits;

public class StrawBerry extends Fruit{
    public StrawBerry(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("StrawBerry is Mashed and added");
    }

    @Override
    public String toString() {
        return "StrawBerry: "+getPricePerPiece()+" $";
    }
}
