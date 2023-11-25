package be.intecbrussel.Raphael.LoveShack.mixables.vegetables;

public class Celery extends Vegetables{
    public Celery(double pricePerPiece) {
        super(pricePerPiece);
    }

    @Override
    public void mix() {
        System.out.println("Celery is cut and added");
    }

    @Override
    public String toString() {
        return "Celery: "+getPricePerPiece()+" $";
    }
}
