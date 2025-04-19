package edu.grinnell.csc207.lootgenerator;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * loot generator
 */
public class LootGenerator {
    /**
     * main
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputScanner = new Scanner(System.in);
        boolean continuePlaying = true;

        while (continuePlaying) {
            Monster monster = new Monster();
            int monsterNum = monster.getMonsterNum();
            String monsterName = monster.getMonster(monsterNum);
            String treasureClass = monster.getTreasureClass(monsterNum);
            String treasure = "Quilted Armor";
            String defense = monster.getDefense(treasure);
            boolean prefixOccurs = monster.occurs();
            String prefix = monster.getPrefix(prefixOccurs);
            int prefixNum = monster.getPrefixNum(prefix);
            boolean suffixOccurs = monster.occurs();
            String suffix = monster.getSuffix(suffixOccurs);
            int suffixNum = monster.getSuffixNum(suffix);

            System.out.println("\nFighting " + monsterName);
            System.out.println("You have slain " + monsterName);
            System.out.println(monsterName + " dropped: \n");
            System.out.println(prefix + treasure + suffix);
            System.out.println("Defense: " + defense);
            if (prefixOccurs == true) {
                System.out.println("Prefix defense: " + prefixNum);
            } 
            if (suffixOccurs == true) {
                System.out.println("Suffix defense: " + suffixNum);
            } 
            System.out.println("\nFight Again? [y/n]\n");
            String input = inputScanner.nextLine();
            if (input.equals("n") || input.equals("N")) {
                continuePlaying = false;
            } else if (input.equals("y") || input.equals("Y")) {
                continuePlaying = true;
            } else {
                System.out.println("This is not a valid input! Press either Y or N");
                input = inputScanner.nextLine();
            }
        }
    }
}
