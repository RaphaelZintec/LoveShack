package be.intecbrussel.Raphael.LoveShack.shop;

import be.intecbrussel.Raphael.LoveShack.mixables.Food;
import be.intecbrussel.Raphael.LoveShack.mixables.fruits.*;
import be.intecbrussel.Raphael.LoveShack.mixables.vegetables.Celery;
import be.intecbrussel.Raphael.LoveShack.mixables.vegetables.Spinache;

import java.util.Arrays;

public enum SmoothieRecipe {
    //ENUM

    CITRUS(           new Food[]{new Orange(1),     new Orange(1),    new Lemon(0.75)}),
    STRAWBERRY_DREAM( new Food[]{new StrawBerry(2), new Orange(1),    new Orange(1),       new Banana(1.25)}),
    BANANA_SLIDE(     new Food[]{new Banana(1.25),  new Banana(1.25), new Orange(1)}),
    VEGIE_SLURRY(     new Food[]{new Banana(1.25),  new Celery(1),    new Spinache(1.25),  new Apple(0.5)}),
    CUSTOM_SMOOTHIE(  new Food[]{});

    //ATTRIBUTES
    private Food[] recipe;
    private double totalPrice;

    //CONSTRUCTOR
    SmoothieRecipe(Food[] recipe) {
        this.recipe = recipe;
        totalPrice = Arrays.stream(recipe).mapToDouble(Food::getPricePerPiece).sum();
    }

    //METHODS
    public double getTotalPrice() {
        return totalPrice;
    }
    public Food[] getRecipe() {
        return recipe;
    }
    public void setRecipe(Food[] recipe) {
        if (this == CUSTOM_SMOOTHIE) {
            if(recipe.length < 2 || recipe.length > 4)
                System.out.println("mininimum 2 en maximum 4");
            else{
                this.recipe = recipe;
                totalPrice = Arrays.stream(recipe).mapToDouble(Food::getPricePerPiece).sum();
            }
        }
    }

    @Override
    public String toString() {
        return name()+": "+getTotalPrice()+" $";
    }
}
