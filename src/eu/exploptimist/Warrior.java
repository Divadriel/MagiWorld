package eu.exploptimist;

public class Warrior extends Character {


    public Warrior(int level, int strength, int dexterity, int intelligence, String name) {
        super(level, strength, dexterity, intelligence, name);
    }

    /**
     * Warrior's basic attack, called "Coup d'Epée" and causing player's strength level of damage.
     * Code is optimized using less variables.
     * @param target    The other player.
     */
    @Override
    public void basicAttack(Character target) {
        target.setHealth(target.getHealth() - this.getStrength());
        System.out.println(this.getName() + " utilise Coup d'Epée et inflige " + this.getStrength() + " dommages.");
        System.out.println(target.getName() + " perd " + this.getStrength() + " points de vie.");
        if(target.isDead()){
            System.out.println(target.getName() + " est mort");
        }
    }

    /**
     * Warrior's special attack, called "Coup de Rage" and causing twice the basic damage, plus half strength level to himself.
     * @param target    The other player.
     */
    @Override
    public void specialAttack(Character target) {
        target.setHealth(target.getHealth() - (2*this.getStrength()));
        this.setHealth(this.getHealth() - (this.getStrength() / 2));
        System.out.println(this.getName() + " utilise Coup de Rage et inflige " + 2*this.getStrength() + " dommages.");
        System.out.println(target.getName() + " perd " + 2*this.getStrength() + " points de vie.");
        if(target.isDead()){
            System.out.println(target.getName() + " est mort");
        }
        System.out.println(this.getName() + " perd " + (this.getStrength() / 2) + " points de vie.");
        if(this.isDead()){
            System.out.println(this.getName() + " est mort");
        }
    }
}
