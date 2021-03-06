package eu.exploptimist;

public abstract class Character {
    private int level;
    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;
    private String name;

    /**
     * Constructor for abstract class Character.
     * @param level         The level chosen by the player
     * @param strength      The strength chosen by the player
     * @param dexterity     The dexterity chosen by the player
     * @param intelligence  The intelligence chosen by the player
     * @param name          The name "Joueur 1" or "Joueur 2"
     */
    public Character(int level, int strength, int dexterity, int intelligence, String name){
        this.level = level;
        this.health = level * 5;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.name = name;
    }

    /**
     * Basic attack.
     */
    public abstract void basicAttack(Character target);

    /**
     * Special attack.
     */
    public abstract void specialAttack(Character target);

    /**
     * Return whether player is dead or not, depending on remaining health.
     * @return Answer on living state.
     */
    public boolean isDead(){
        return (this.getHealth() <= 0);
    }

    /**
     * General method to launch an attack.
     * @param action    The type of attack, chosen by the player.
     * @param target    Target of the attack (the other player).
     */
    public void attack(int action, Character target){
        if(action == 2){
            this.specialAttack(target);
        } else {
            this.basicAttack(target);
        }
    }

    /**
     * Display all character perks.
     * @return Perks description.
     */
    public String displayPerks(){
        String perks = this.name + " niveau " + this.level
                + " je possède " + this.health + " de vitalité, "
                + this.strength + " de force, "
                + this.dexterity + " d'agilité et "
                + this.intelligence + " d'intelligence !";
        return perks;
    }

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

    public String getName(){
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
}
