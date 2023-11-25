package be.intecbrussel.Raphael.LoveShack.mixables.fruits;

public class Lemon extends Fruit{
    public Lemon(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("Lemon is pressed and added");
    }

    @Override
    public String toString() {
        return "Lemon: "+getPricePerPiece()+" $";
    }
}
