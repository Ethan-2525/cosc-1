package ComicBookHeroManager;
public class Hero {
    private final String name;
    private final int powerLevel;
    private final Affiliation affiliation;

    // The Attributes
    public Hero(String name, int powerLevel, Affiliation affiliation) {
        this.name = name;
        this.powerLevel = powerLevel;
        this.affiliation = affiliation;
    }

    // A getter for the name
    public String getName() {
        return name;
    }

    // A getter for the power level
    public int getPowerLevel() {
        return powerLevel;
    }
    
    // A getter for the affiliation
    public Affiliation getAffiliation() {
        return affiliation;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Power Level: " + powerLevel + ", Affiliation: " + affiliation;
    }
}
