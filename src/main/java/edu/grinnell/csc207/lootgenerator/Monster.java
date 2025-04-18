package edu.grinnell.csc207.lootgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Monster {
    private static final String DATA_SET = "data/large";
    final Scanner scanner; 
    int randomMonster;

    public Monster() throws FileNotFoundException, FileNotFoundException, FileNotFoundException {
        this.scanner = new Scanner(new File(DATA_SET + "/monstats.txt"));
    }

    /**
     * Returns true if the scanner does have next and false if it does not
     * @return - returns true or false
     */
    public boolean hasNext() { 
        return scanner.hasNext();
    }

    public int getLines(Scanner scanner) {
        int lines = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lines++;
        }
        return lines;
    }

    public int getMonsterNum() throws FileNotFoundException {
        Scanner lineScanner = new Scanner(new File(DATA_SET + "/monstats.txt"));
        int totalMonsters = getLines(lineScanner);
        lineScanner.close();
        randomMonster = (int) (Math.random() * totalMonsters);
        return randomMonster;
    }

    public String getMonster() throws FileNotFoundException {
        Scanner monsterScanner = new Scanner(new File(DATA_SET + "/monstats.txt"));
        ArrayList<String> monsterList = new ArrayList<>();
        while(monsterScanner.hasNext()) {
            String monsterInfo = (monsterScanner.nextLine());
            String[] monster = monsterInfo.split("\\t");
            monsterList.add(monster[0]);
        }
        return monsterList.get(randomMonster);
    }
    public String getTreasure() throws FileNotFoundException {
        Scanner treasureScanner = new Scanner(new File(DATA_SET + "/monstats.txt"));
        ArrayList<String> treasureList = new ArrayList<>();
        while(treasureScanner.hasNext()) {
            String monsterInfo = (treasureScanner.nextLine());
            String[] treasure = monsterInfo.split("\\t");
            treasureList.add(treasure[3]);
        }
        return treasureList.get(randomMonster);
    }
}
