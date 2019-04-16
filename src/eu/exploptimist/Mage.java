package eu.exploptimist;

public class Mage extends Character {
    public Mage(int level, int strength, int dexterity, int intelligence, String name) {
        super(level, strength, dexterity, intelligence, name);
    }

    @Override
    public void basicAttack(Character target) {
        target.setHealth(target.getHealth() - this.getIntelligence());
        System.out.println(this.getName() + " utilise Boule de Feu et inflige " + this.getIntelligence() + " dommages.");
        System.out.println(target.getName() + " perd " + this.getIntelligence() + " points de vie.");
        if(target.isDead()){
            System.out.println(target.getName() + " est mort");
        }
    }

    @Override
    public void specialAttack(Character target) {
        int healthGain = this.getIntelligence() * 2;
        int maxHealth = this.getLevel() * 5;
        int currentHealth = this.getHealth();
        this.setHealth(Math.min(maxHealth, currentHealth + healthGain));
        System.out.println(this.getName() + " utilise Soin et gagne " + (this.getHealth() - currentHealth) + " en Vitalité.");
    }
}
