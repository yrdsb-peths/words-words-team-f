import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class WordList extends Actor
{
    //this is the wordList, it will include arraylist or stacks. 
    public static void main(String[] args)
    {
        ArrayList<String> ingredients = new ArrayList<String>();
        
        //each map will have their own difficulty
        //three maps in total
        
        //there should be three different lists in each class
        //map 1: normal kitchen
        //dish 1 (easy): rataoiile
        ingredients.add("tomato");
        ingredients.add("cucumber");
        ingredients.add("carrot");
        //dish 1 (hard): cake
        ingredients.add("egg");
        ingredients.add("flour");
        ingredients.add("milk");
        ingredients.add("love");
        ingredients.add("sugar");
        //map 2: pirate ship
        //dish 1: fish feast
        ingredients.add("fish");
        ingredients.add("lobster");
        ingredients.add("crab");
        //dish 2: 
        ingredients.add("shrimp");
        ingredients.add("shark");
        ingredients.add("jellyfish");
        ingredients.add("kraken");
        ingredients.add("gold");
        //map3: spaceship
        //dish 1: alein mega feast 
        ingredients.add("glorb");
        ingredients.add("slime");
        ingredients.add("blorg");
        //dish 2: 
        ingredients.add("goo");
        ingredients.add("oomp");
        ingredients.add("bluerb");
        ingredients.add("zenit");
        ingredients.add("kenpler");
    }
}
