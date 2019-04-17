package eu.exploptimist;

import java.util.Scanner;

public class Game {

    private Scanner sc = new Scanner(System.in);
    private Character player1;
    private Character player2;

    /**
     * Launches the game. It creates 2 players and make them fight until death.
     */
    public void launchGame(){
        player1 = createCharacter(1);
        player2 = createCharacter(2);
        this.fight(player1, player2);
    }

    /**
     * Creates a character, following player input.
     * @param playerNb  The player number, used only for launchGame() method.
     * @return          The created character.
     */
    public Character createCharacter(int playerNb){
        Character player;
        System.out.println("Création du personnage du Joueur " + playerNb);
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        int characterClass = sc.nextInt();
        System.out.println("Niveau du personnage ?");
        int level = sc.nextInt();
        System.out.println("Force du personnage ?");
        int strength = sc.nextInt();
        System.out.println("Agilité du personnage ?");
        int dexterity = sc.nextInt();
        System.out.println("Intelligence du personnage ?");
        int intelligence = sc.nextInt();

        /**
         * Switch on characterClass variable, to create the corresponding class. player is a Character object,
         * as we don't need specificity from other classes after character creation.
         * Default case exists to prevent error, Warrior class chosen arbitrarily.
         */
        switch (characterClass){
            case 1:
                player = new Warrior(level, strength, dexterity, intelligence, "Joueur " + playerNb);
                System.out.println("Woarg je suis le Guerrier " + player.displayPerks());
                break;
            case 2:
                player = new Rogue(level, strength, dexterity, intelligence, "Joueur " + playerNb);
                System.out.println("Whoohoo je suis le Rôdeur " + player.displayPerks());
                break;
            case 3:
                player = new Mage(level, strength, dexterity, intelligence, "Joueur " + playerNb);
                System.out.println("Abracadabra je suis le Mage " + player.displayPerks());
                break;
            default:
                player = new Warrior(1,1,0,0,"Joueur " + playerNb);
                System.out.println("Huuuuu je suis le Guerrier Joueur " + playerNb + " niveau 1 tout faible...");
        }
        return player;
    }

    /**
     * Main method: it makes players fight together until one of them dies (in a while loop).
     * @param player1
     * @param player2
     */
    public void fight(Character player1, Character player2){
        while(player1.getHealth() > 0 || player2.getHealth() > 0){
            // player 1 starts
            play(player1, 1, player2);

            if(player2.getHealth() <= 0){
                // player1 wins!
                this.endGame(2);
                return;
            } else if(player1.getHealth() <= 0){
                // player2 wins!
                this.endGame(1);
                return;
            }
            // if neither is dead, player 2 plays.
            play(player2, 2, player1);
        }
    }

    /**
     * Asks human player to play, by typing his chosen attack.
     * @param player    The player playing.
     * @param playerNb  Player's number
     * @param target    The other player.
     */
    private void play(Character player, int playerNb, Character target){
        System.out.println("Joueur " + playerNb + " (" + player.getHealth() +
                " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale");
        int action = sc.nextInt();
        player.attack(action, target);
    }

    /**
     * Ending the game, by displaying which player lost.
     * @param loseNb    Number of losing player.
     */
    private void endGame(int loseNb) {
        System.out.println("Joueur " + loseNb + " a perdu !");
    }
}
