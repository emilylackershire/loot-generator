package edu.grinnell.csc207.lootgenerator;

import java.io.FileNotFoundException;

public class LootGenerator {
    /** The path to the dataset (either the small or large set). */
    //private static final String DATA_SET = "data/small";

    public LootGenerator() {
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        Monster monster = new Monster();
        System.out.println("\nThis program kills monsters and generates loot!");
        System.out.println("Monster: " + monster.getMonster());
        System.out.println("Monster: " + monster.getTreasure());
    }
}
