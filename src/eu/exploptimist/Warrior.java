package eu.exploptimist;

public class Warrior extends Character {


    public Warrior(int level, int strength, int dexterity, int intelligence, String name) {
        super(level, strength, dexterity, intelligence, name);
    }

    @Override
    public void basicAttack(Character target) {
        target.setHealth(target.getHealth() - this.getStrength());
        System.out.println(this.getName() + " utilise Coup d'Epée et inflige " + this.getStrength() + " dommages.");
        System.out.println(target.getName() + " perd " + this.getStrength() + " points de vie.");
        if(target.isDead()){
            System.out.println(target.getName() + " est mort");
        }
    }

    @Override
    public void specialAttack(Character target) {
        target.setHealth(target.getHealth() - (2*this.getStrength()));
        this.setHealth(this.getHealth() - (this.getStrength() / 2));
        System.out.println(this.getName() + " utilise Coup de Rage et inflige " + 2*this.getStrength() + " dommages.");
        System.out.println(target.getName() + " perd " + this.getStrength() + " points de vie.");
        System.out.println(this.getName() + " perd " + (this.getStrength() / 2) + " points de vie.");
        if(target.isDead()){
            System.out.println(target.getName() + " est mort");
        } else if(this.isDead()){
            System.out.println(this.getName() + " est mort");
        }
    }
}
