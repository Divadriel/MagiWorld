package eu.exploptimist;

public abstract class Character {
    private int level;
    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;

    /**
     * Constructor for abstract class Character.
     * @param level         The level chosen by the player
     * @param strength      The strength chosen by the player
     * @param dexterity     The dexterity chosen by the player
     * @param intelligence  The intelligence chosen by the player
     */
    public Character(int level, int strength, int dexterity, int intelligence){
        this.level = level;
        this.health = level * 5;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    /**
     * Basic attack.
     */
    public abstract void basicAttack();

    /**
     * Special attack.
     */
    public abstract void specialAttack();

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
