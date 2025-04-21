package ComicBookHeroManager;

public class Main {
    public static void main(String[] args) {
        HeroManager manager = new HeroManager();

        // Adding heroes of all affiliations and their power levels
        manager.addHero(new Hero("IronMan", 85, Affiliation.AVENGERS));
        manager.addHero(new Hero("Superman", 80, Affiliation.JUSTICE_LEAUGE));
        manager.addHero(new Hero("Nightcrowler", 90, Affiliation.X_MEN));
        manager.addHero(new Hero(" Invisible Woman", 85, Affiliation.FANTASTIC_FOUR));

        System.out.println("Original List:");
        manager.displayHeroes();

        // a bubble Sort
        System.out.println("\nSorted by Bubble Sort:");
        manager.bubbleSortByPower();
        manager.displayHeroes();

        // Removing a hero
        manager.removeHero("Superman");

        // Adding a new hero in its space
        manager.addHero(new Hero("Batman", 95, Affiliation.JUSTICE_LEAUGE));

        // An insertion Sort
        System.out.println("\nSorted by Insertion Sort:");
        manager.insertionSortByPower();
        manager.displayHeroes();

        // This will make it show up as 2D array
        System.out.println("\nHeroes in 2D Array Format:");
        manager.displayHeroesAs2DArray();
    }
}

