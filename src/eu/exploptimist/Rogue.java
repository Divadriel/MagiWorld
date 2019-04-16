package eu.exploptimist;

public class Rogue extends Character {
    public Rogue(int level, int strength, int dexterity, int intelligence, String name) {
        super(level, strength, dexterity, intelligence, name);
    }

    @Override
    public void basicAttack(Character target) {
        target.setHealth(target.getHealth() - this.getDexterity());
        System.out.println(this.getName() + " utilise Tir à l'Arc et inflige " + this.getDexterity() + " dommages.");
        System.out.println(target.getName() + " perd " + this.getDexterity() + " points de vie.");
        if(target.isDead()){
            System.out.println(target.getName() + " est mort");
        }
    }

    @Override
    public void specialAttack(Character target) {
        this.setDexterity(this.getDexterity() + (this.getLevel() / 2));
        System.out.println(this.getName() + " utilise Concentration et gagne " + this.getLevel() / 2 + " en Agilité.");
    }
}
