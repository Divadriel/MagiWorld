package eu.exploptimist;

public class Mage extends Character {
    public Mage(int level, int strength, int dexterity, int intelligence, String name) {
        super(level, strength, dexterity, intelligence, name);
    }

    /**
     * Mage's basic attack, called "Boule de Feu", and causing player's intelligence level of damage.
     * @param target    The other player.
     */
    @Override
    public void basicAttack(Character target) {
        target.setHealth(target.getHealth() - this.getIntelligence());
        System.out.println(this.getName() + " utilise Boule de Feu et inflige " + this.getIntelligence() + " dommages.");
        System.out.println(target.getName() + " perd " + this.getIntelligence() + " points de vie.");
        if(target.isDead()){
            System.out.println(target.getName() + " est mort");
        }
    }

    /**
     * Mage's special attack, called "Soin", healing the player by his twice intelligence level, with a maximum of his base health.
     * @param target    The other player, even if not used here (needed for correctly overriding the method).
     */
    @Override
    public void specialAttack(Character target) {
        int healthGain = this.getIntelligence() * 2;
        int maxHealth = this.getLevel() * 5;
        int currentHealth = this.getHealth();
        this.setHealth(Math.min(maxHealth, currentHealth + healthGain));
        System.out.println(this.getName() + " utilise Soin et gagne " + (this.getHealth() - currentHealth) + " en Vitalité.");
    }
}
