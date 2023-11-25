package be.intecbrussel.Raphael.LoveShack.mixables.fruits;

public class Apple extends Fruit{
    public Apple(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("Apple is Mashed and added");
    }

    @Override
    public String toString() {
        return "Apple: "+getPricePerPiece()+" $";
    }
}
