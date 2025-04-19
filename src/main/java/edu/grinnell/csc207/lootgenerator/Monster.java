package edu.grinnell.csc207.lootgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class monster
 */
public class Monster {
    private static final String DATA_SET = "data/small";
    final Scanner scanner;
    int randomMonster;

    /**
     * Creates a new scanner when the monster class is instantiated
     * 
     * @throws FileNotFoundException
     * @throws FileNotFoundException
     * @throws FileNotFoundException
     */
    public Monster() throws FileNotFoundException, FileNotFoundException, FileNotFoundException {
        this.scanner = new Scanner(new File(DATA_SET + "/monstats.txt"));
    }

    /**
     * Returns true if the scanner does have next and false if it does not
     * 
     * @return returns true or false
     */
    public boolean hasNext() {
        return scanner.hasNext();
    }

    /**
     * gets the amount of lines in the thing that is being scanned
     * 
     * @param scanner
     * @return returns number of lines
     */
    public int getLines(Scanner scanner) {
        int lines = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lines++;
        }
        return lines;
    }

    /**
     * gets a random line, essentially choosing the monster
     * 
     * @return line number of the monster
     * @throws FileNotFoundException
     */
    public int getMonsterNum() throws FileNotFoundException {
        Scanner lineScanner = new Scanner(new File(DATA_SET + "/monstats.txt"));
        int totalMonsters = getLines(lineScanner);
        lineScanner.close();
        randomMonster = (int) (Math.random() * totalMonsters);
        return randomMonster;
    }

    /**
     * gets the name of the monster on the line given
     * 
     * @param monsterNum
     * @return String monster name
     * @throws FileNotFoundException
     */
    public String getMonster(int monsterNum) throws FileNotFoundException {
        Scanner monsterScanner = new Scanner(new File(DATA_SET + "/monstats.txt"));
        ArrayList<String> monsterList = new ArrayList<>();
        while (monsterScanner.hasNext()) {
            String monsterInfo = (monsterScanner.nextLine());
            String[] monster = monsterInfo.split("\\t");
            monsterList.add(monster[0]);
        }
        return monsterList.get(monsterNum);
    }

    /**
     * gets the treasure class for that turn
     * 
     * @param monster
     * @return returns treasure class for the monster
     * @throws FileNotFoundException
     */
    public String getTreasureClass(int monster) throws FileNotFoundException {
        Scanner treasureClassScanner = new Scanner(new File(DATA_SET + "/monstats.txt"));
        ArrayList<String> treasureClassList = new ArrayList<>();
        while (treasureClassScanner.hasNext()) {
            String monsterInfo = (treasureClassScanner.nextLine());
            String[] treasureClass = monsterInfo.split("\\t");
            treasureClassList.add(treasureClass[3]);
        }
        return treasureClassList.get(monster);
    }

    /**
     * gets a random number 1-3
     * 
     * @return returns number
     */
    public int getOnetoThree() {
        int randomNum = (int) (Math.random() * 3) + 1;
        return randomNum;
    }

    /**
     * gets the treasure out of the given treasure class
     * 
     * @param treasureClass
     * @return treasure
     * @throws FileNotFoundException
     */
    public String getTreasure(String treasureClass) throws FileNotFoundException {
        String treasure = "There is no treasure here!";
        Scanner treasureScanner = new Scanner(new File(DATA_SET
                + "/TreasureClassEx.txt"));
        ArrayList<String> treasureList = new ArrayList<>();
        treasureScanner.close();
        return treasure;
    }

    /**
     * gets the defense number from the given treasure
     * 
     * @param treasure
     * @return string representation of defense
     * @throws FileNotFoundException
     */
    public String getDefense(String treasure) throws FileNotFoundException {
        Scanner armorScanner = new Scanner(new File(DATA_SET + "/armor.txt"));
        ArrayList<String> armorList = new ArrayList<>();
        ArrayList<String> minList = new ArrayList<>();
        ArrayList<String> maxList = new ArrayList<>();
        while (armorScanner.hasNext()) {
            String armorInfo = (armorScanner.nextLine());
            String[] armor = armorInfo.split("\\t");
            armorList.add(armor[0]);
            minList.add(armor[1]);
            maxList.add(armor[2]);
        }
        for (int i = 0; i < armorList.size(); i++) {
            if (armorList.get(i).equals(treasure)) {
                int min = Integer.parseInt(minList.get(i));
                int max = Integer.parseInt(maxList.get(i));
                int randomDefense = (int) (Math.random() * (max - min + 1)) + min;
                return String.valueOf(randomDefense);
            }
        }
        return "DOES NOT EXIST";
    }

    /**
     * checks if a prefix or suffix is going to occur or not
     * 
     * @return returns a random true or false
     */
    public boolean occurs() {
        int randomNum = (int) (Math.random() * 2) + 1;
        if (randomNum == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * gets a random number one to the amount given
     * 
     * @param amount
     * @return random number
     */
    public int getOnetoAmount(int amount) {
        int randomNum = (int) (Math.random() * amount) + 1;
        return randomNum;
    }

    /**
     * gets the prefix if there is one
     * 
     * @param occurs
     * @return returns string of the prefix or none if there isn't any
     * @throws FileNotFoundException
     */
    public String getPrefix(boolean occurs) throws FileNotFoundException {
        if (occurs == true) {
            Scanner prefixScanner = new Scanner(new File(DATA_SET + "/MagicPrefix.txt"));
            ArrayList<String> prefixList = new ArrayList<>();
            while (prefixScanner.hasNext()) {
                String prefixInfo = (prefixScanner.nextLine());
                String[] prefix = prefixInfo.split("\\t");
                prefixList.add(prefix[0]);
            }
            int prefixNumber = getOnetoAmount(prefixList.size());
            return (prefixList.get(prefixNumber - 1) + " ");
        } else {
            return "";
        }
    }

    /**
     * gets the ModCode for the prefix
     * 
     * @param prefixName
     * @return returns modCode
     * @throws FileNotFoundException
     */
    public String getModCode(String prefixName) throws FileNotFoundException {
        Scanner prefixScanner = new Scanner(new File(DATA_SET + "/MagicPrefix.txt"));
        ArrayList<String> prefixList = new ArrayList<>();
        ArrayList<String> modCodeList = new ArrayList<>();
        while (prefixScanner.hasNext()) {
            String prefixInfo = (prefixScanner.nextLine());
            String[] prefix = prefixInfo.split("\\t");
            prefixList.add(prefix[0]);
            modCodeList.add(prefix[0]);
        }
        for (int i = 0; i < prefixList.size(); i++) {
            if (prefixList.get(i).equals(prefixName)) {
                String modCode = modCodeList.get(i);
                return modCode;
            }
        }
        return "";
    }

    /**
     * gets the prefix number
     * 
     * @param prefixName
     * @return returns the prefix number, or 1 if there is not one
     * @throws FileNotFoundException
     */
    public int getPrefixNum(String prefixName) throws FileNotFoundException {
        Scanner prefixScanner = new Scanner(new File(DATA_SET + "/MagicPrefix.txt"));
        ArrayList<String> prefixList = new ArrayList<>();
        ArrayList<String> minList = new ArrayList<>();
        ArrayList<String> maxList = new ArrayList<>();
        while (prefixScanner.hasNext()) {
            String prefixInfo = (prefixScanner.nextLine());
            String[] prefix = prefixInfo.split("\\t");
            prefixList.add(prefix[0]);
            minList.add(prefix[2]);
            maxList.add(prefix[3]);
        }
        for (int i = 0; i < prefixList.size(); i++) {
            String pref = prefixList.get(i);
            if (pref.equals(prefixName)) {
                int min = Integer.parseInt(minList.get(i));
                int max = Integer.parseInt(maxList.get(i));
                int randomDefense = (int) (Math.random() * (max - min + 1)) + min;
                return randomDefense;
            }
        }
        return 1;
    }

    /**
     * gets the suffix if there is one
     * 
     * @param occurs
     * @return returns string of the prefix or none if there isn't any
     * @throws FileNotFoundException
     */
    public String getSuffix(boolean occurs) throws FileNotFoundException {
        if (occurs == true) {
            Scanner suffixScanner = new Scanner(new File(DATA_SET + "/MagicPrefix.txt"));
            ArrayList<String> suffixList = new ArrayList<>();
            while (suffixScanner.hasNext()) {
                String prefixInfo = (suffixScanner.nextLine());
                String[] suffix = prefixInfo.split("\\t");
                suffixList.add(suffix[0]);
            }
            int suffixNumber = getOnetoAmount(suffixList.size());
            return (suffixList.get(suffixNumber - 1) + " ");
        } else {
            return "";
        }
    }

    /**
     * gets the ModCode for the suffix
     * 
     * @param suffixName
     * @return returns modCode
     * @throws FileNotFoundException
     */
    public String getSuffixModCode(String suffixName) throws FileNotFoundException {
        Scanner suffixScanner = new Scanner(new File(DATA_SET + "/MagicPrefix.txt"));
        ArrayList<String> suffixList = new ArrayList<>();
        ArrayList<String> modCodeList = new ArrayList<>();
        while (suffixScanner.hasNext()) {
            String suffixInfo = (suffixScanner.nextLine());
            String[] suffix = suffixInfo.split("\\t");
            suffixList.add(suffix[0]);
            modCodeList.add(suffix[0]);
        }
        for (int i = 0; i < suffixList.size(); i++) {
            if (suffixList.get(i).equals(suffixName)) {
                String modCode = modCodeList.get(i);
                return modCode;
            }
        }
        return "";
    }

    /**
     * gets the suffix number
     * 
     * @param suffixName
     * @return returns the prefix number, or 1 if there is not one
     * @throws FileNotFoundException
     */
    public int getSuffixNum(String suffixName) throws FileNotFoundException {
        Scanner suffixScanner = new Scanner(new File(DATA_SET + "/MagicPrefix.txt"));
        ArrayList<String> suffixList = new ArrayList<>();
        ArrayList<String> minList = new ArrayList<>();
        ArrayList<String> maxList = new ArrayList<>();
        while (suffixScanner.hasNext()) {
            String suffixInfo = (suffixScanner.nextLine());
            String[] suffix = suffixInfo.split("\\t");
            suffixList.add(suffix[0]);
            minList.add(suffix[2]);
            maxList.add(suffix[3]);
        }
        for (int i = 0; i < suffixList.size(); i++) {
            String suf = suffixList.get(i);
            if (suf.equals(suffixName)) {
                int min = Integer.parseInt(minList.get(i));
                int max = Integer.parseInt(maxList.get(i));
                int randomDefense = (int) (Math.random() * (max - min + 1)) + min;
                return randomDefense;
            }
        }
        return 1;
    }
}
