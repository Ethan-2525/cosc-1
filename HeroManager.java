package ComicBookHeroManager;

import java.util.ArrayList;
import java.util.Arrays;

public class HeroManager {
    private final ArrayList<Hero> heroes;

    public HeroManager() {
        heroes = new ArrayList<>();
    }

    // This will add a hero to the list
    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    // This will remove a hero from the list
    public void removeHero(String name) {
        heroes.removeIf(hero -> hero.getName().equalsIgnoreCase(name));
    }

    // Using a bubble sort to sort heros by their power level
    public void bubbleSortByPower() {
        for (int i = 0; i < heroes.size() - 1; i++) {
            for (int j = 0; j < heroes.size() - i - 1; j++) {
                if (heroes.get(j).getPowerLevel() > heroes.get(j + 1).getPowerLevel()) {
                    Hero temp = heroes.get(j);
                    heroes.set(j, heroes.get(j + 1));
                    heroes.set(j + 1, temp);
                }
            }
        }
    }

    public void insertionSortByPower() {
        for (int i = 1; i < heroes.size(); i++) {
            Hero key = heroes.get(i);
            int j = i - 1;
            while (j >= 0 && heroes.get(j).getPowerLevel() > key.getPowerLevel()) {
                heroes.set(j + 1, heroes.get(j));
                j--;
            }
            heroes.set(j + 1, key);
        }
    }

    public void displayHeroes() {
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    // This will display the heroes in a 2D array 
    public void displayHeroesAs2DArray() {
        String[][] heroArray = new String[heroes.size()][3];
        for (int i = 0; i < heroes.size(); i++) {
            heroArray[i][0] = heroes.get(i).getName();
            heroArray[i][1] = String.valueOf(heroes.get(i).getPowerLevel());
            heroArray[i][2] = heroes.get(i).getAffiliation().toString();
        }
        System.out.println(Arrays.deepToString(heroArray));
    }
}

