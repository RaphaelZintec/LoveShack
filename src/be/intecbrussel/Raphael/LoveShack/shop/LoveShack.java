package be.intecbrussel.Raphael.LoveShack.shop;

import be.intecbrussel.Raphael.LoveShack.mixables.Food;
import be.intecbrussel.Raphael.LoveShack.mixables.Mixable;
import be.intecbrussel.Raphael.LoveShack.mixables.fruits.*;
import be.intecbrussel.Raphael.LoveShack.mixables.vegetables.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoveShack {
    //ATTRIBUTES
    private SmoothieRecipe[] orders = new SmoothieRecipe[4];
    private double totalPrice;
    private final Orange ORANGE           = new Orange(1);
    private final StrawBerry STRAWBERRY   = new StrawBerry(2);
    private final Banana BANANA           = new Banana(1.25);
    private final Apple APPLE             = new Apple(0.5);
    private final Lemon LEMON             = new Lemon(0.75);
    private final Spinache SPINACHE       = new Spinache(1.25);
    private final Celery CELERY           = new Celery(1);

    //CONSTRUCTOR
    public LoveShack(){}

    //METHODS
    public void order(){

        Scanner sc = new Scanner(System.in);
        int[] chosenSmoothies = new int[3];

        //1.USER SELECT 3 NON CUSTOM SMOOTHIES
        for (int i = 0; i<3; ++i){
            do {
                System.out.println("\n\uD83E\uDD64Choose your smoothie n°"+(i+1)+
                        "\nCITRUS:              1"+
                        "\nSTRAWBERRY DREAM:    2"+
                        "\nBANANA SLIDE:        3"+
                        "\nVEGIE SLURRY:        4");
                try{
                    chosenSmoothies[i] = sc.nextInt();
                    if (chosenSmoothies[i] < 1 || chosenSmoothies[i] >4){
                        System.out.println("\n⛔Enter only a number between 1-4. Please try again.");
                        continue;
                    }
                    else
                        break;
                } catch(Exception e){
                    System.out.println("\n⛔Enter only a number. Please try again.");
                    sc.nextLine();
                    continue;
                }
            } while(true);
        }

        //1.2 ADD SELECTED NON CUSTOM SMOOTHIES
        int indexChosenSmoothies = 0;
        for(int i = 0; i<chosenSmoothies.length; ++i){
            switch (chosenSmoothies[i]){
                case 1: orders[i] = SmoothieRecipe.CITRUS; break;
                case 2: orders[i] = SmoothieRecipe.STRAWBERRY_DREAM; break;
                case 3: orders[i] = SmoothieRecipe.BANANA_SLIDE; break;
                case 4: orders[i] = SmoothieRecipe.VEGIE_SLURRY;
            }
        }

        //2.USER CUSTOM 1 SMOOTHIE
        int[] customSmoothie = new int[4];
        for (int i = 0; i<4; ++i) {
            do{
                System.out.println("\n\uD83E\uDD5BCustom smoothie, choose the flavor n°" + (i + 1) +
                        "\nOrange:      1" +
                        "\nLemon:       2" +
                        "\nBanana:      3" +
                        "\nStrawBerry:  4" +
                        "\nApple:       5" +
                        "\nCelery:      6" +
                        "\nSpinache:    7");
                try {
                    customSmoothie[i] = sc.nextInt();
                    if (customSmoothie[i] < 1 || customSmoothie[i] >8){
                        System.out.println("\n⛔Enter only a number between 1-7. Please try again.");
                        continue;
                    }
                    else
                        break;
                } catch(Exception e){
                    System.out.println("\n⛔Enter only a number. Please try again.");
                    sc.nextLine();
                    continue;
                }
            } while(true);
            if(i>=1 && i!=3){
                sc.nextLine();
                String addMoreFlavor = "";
                do {
                    System.out.println("\nDo you wanna add another flavor for your custom smoothie? Type yes/no");
                    addMoreFlavor = sc.nextLine();
                    if(addMoreFlavor.equalsIgnoreCase("yes") || addMoreFlavor.equalsIgnoreCase("no"))
                       break;
                } while(true);

                if (addMoreFlavor.equalsIgnoreCase("no"))
                    break;
            }
        }

        //2.2 ADD NON CUSTOM SMOOTHIE
        ArrayList<Food> recipe = new ArrayList<>();
        Arrays.stream(customSmoothie).filter(f->f>0).forEach(f->{
            switch (f){
                case 1: recipe.add(ORANGE); break;
                case 2: recipe.add(LEMON); break;
                case 3: recipe.add(BANANA); break;
                case 4: recipe.add(STRAWBERRY); break;
                case 5: recipe.add(APPLE); break;
                case 6: recipe.add(CELERY); break;
                case 7: recipe.add(SPINACHE);
            }
        });
        orders[3] = SmoothieRecipe.CUSTOM_SMOOTHIE;
        orders[3].setRecipe(recipe.toArray(Food[]::new));

        //3.PREPARATION
        System.out.println("\nPreparing your order \uD83D\uDC69\u200D\uD83C\uDF73⏳");
        for (int i=0; i<orders.length; ++i){
            if(orders[i] != null){
                System.out.println("\nPreparing smoothie #"+(i+1)+" ("+orders[i]+")");
                Arrays.stream(orders[i].getRecipe()).forEach(Mixable::mix);
            }
            else
                break;
        }

        //4.PRICE
        totalPrice = Arrays.stream(orders).limit(3).mapToDouble(SmoothieRecipe::getTotalPrice).sum();
        System.out.println("\nPRICES \uD83C\uDFE7");
        System.out.println("3 smoothies: "+orderFromSmoothieRecipe()+" $ ("+ Arrays.stream(orders).limit(3).map(SmoothieRecipe::toString).collect(Collectors.joining(", ")) +")");
        System.out.println("custom smoothie: "+customOrder()+" $ ("+ Arrays.stream(orders[3].getRecipe()).map(Food::toString).collect(Collectors.joining(", "))+")");
    }
    private double orderFromSmoothieRecipe(){
        return totalPrice;
    }
    private double customOrder(){
        return orders[3].getTotalPrice();
    }
}
