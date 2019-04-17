package eu.exploptimist;

public class Rogue extends Character {
    public Rogue(int level, int strength, int dexterity, int intelligence, String name) {
        super(level, strength, dexterity, intelligence, name);
    }

    /**
     * Rogue's basic attack, called "Tir à l'Arc" and causing player's dexterity level of damage.
     * @param target
     */
    @Override
    public void basicAttack(Character target) {
        target.setHealth(target.getHealth() - this.getDexterity());
        System.out.println(this.getName() + " utilise Tir à l'Arc et inflige " + this.getDexterity() + " dommages.");
        System.out.println(target.getName() + " perd " + this.getDexterity() + " points de vie.");
        if(target.isDead()){
            System.out.println(target.getName() + " est mort");
        }
    }

    /**
     * Rogue's special attack, called "Concentration", which adds half player level to dexterity perk.
     * @param target    The other player, even if not used here (needed for correctly overriding the method).
     */
    @Override
    public void specialAttack(Character target) {
        this.setDexterity(this.getDexterity() + (this.getLevel() / 2));
        System.out.println(this.getName() + " utilise Concentration et gagne " + this.getLevel() / 2 + " en Agilité.");
    }
}
