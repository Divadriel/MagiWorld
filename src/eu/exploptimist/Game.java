package eu.exploptimist;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Scanner sc = new Scanner(System.in);

    /**
     * Launches the game. It creates 2 players and make them fight until death.
     */
    public void launchGame(){
        Character player1 = createCharacter(1);
        Character player2 = createCharacter(2);
        this.fight(player1, player2);
    }

    /**
     * Checks whether class input is correct or not.
     * @param characterClass class input
     * @return               characterClass if input is correct, else -1.
     */
    public boolean checkClass(int characterClass){
        if(characterClass != 1 && characterClass != 2 && characterClass != 3){
            return false;
        }
        return true;
    }

    /**
     * Checks whether level input is correct or not.
     * @param level level input
     * @return      level if input is correct, else -1.
     */
    public boolean checkLevel(int level){
        if(level < 1 || level > 100){
            return false;
        }
        return true;
    }

    /**
     * Checks whether perk input is correct or not.
     * @param perk  perk input
     * @return      perk if input is correct, else -1.
     */
    public boolean checkPerk(int perk){
        if(perk < 0 || perk > 100){
            return false;
        }
        return true;
    }

    /**
     * Checks whether integrity constraint on sum of perks is correct or not.
     * @param level         level input
     * @param strength      strength input
     * @param dexterity     dexterity input
     * @param intelligence  intelligence input
     * @return              true if constraint is correct, else false.
     */
    public boolean checkAllPerks(int level, int strength, int dexterity, int intelligence){
        if (strength + dexterity + intelligence != level){
            System.out.println("La somme des attributs doit être égale au niveau du personnage !");
            return false;
        }
        return true;
    }

    /**
     * do / while loop to select character class.
     * @return  chosen character class.
     */
    public int selectClass(){
        int characterClass;
        do {
            System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
            characterClass = sc.nextInt();
        } while(!checkClass(characterClass));
        return characterClass;
    }

    /**
     * do / while loop to select level.
     * @return  chosen level.
     */
    public int selectLevel(){
        int level;
        do {
            System.out.println("Niveau du personnage ?");
            level = sc.nextInt();
        } while(!checkLevel(level));
        return level;
    }

    /**
     * do / while loop to select perks.
     * @param level level input.
     * @return      ArrayList of chosen perks.
     */
    public ArrayList<Integer> selectPerks(int level){
        int strength, dexterity, intelligence;
        ArrayList<Integer> perks = new ArrayList<>();
        do {
            System.out.println("Force du personnage ?");
            strength = sc.nextInt();
            System.out.println("Agilité du personnage ?");
            dexterity = sc.nextInt();
            System.out.println("Intelligence du personnage ?");
            intelligence = sc.nextInt();
        } while((!checkPerk(strength) || !checkPerk(dexterity) || !checkPerk(intelligence))
                || !checkAllPerks(level, strength, dexterity, intelligence));
        perks.add(strength);
        perks.add(dexterity);
        perks.add(intelligence);
        return perks;
    }

    /**
     * Creates a character, following player input.
     * @param playerNb  The player number, used only for launchGame() method.
     * @return          The created character.
     */
    public Character createCharacter(int playerNb){
        Character player;
        int characterClass, level, strength, dexterity, intelligence;
        System.out.println("Création du personnage du Joueur " + playerNb);

        characterClass = selectClass();
        level = selectLevel();
        ArrayList<Integer> perks = selectPerks(level);
        strength = perks.get(0);
        dexterity = perks.get(1);
        intelligence = perks.get(2);

        /*
          Switch on characterClass variable, to create the corresponding class. player is a Character object,
          as we don't need specificity from other classes after character creation.
          Default case exists to prevent error, Warrior class chosen arbitrarily.
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
     * @param player1   player 1
     * @param player2   player 2
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
    public void play(Character player, int playerNb, Character target){
        System.out.println("Joueur " + playerNb + " (" + player.getHealth() +
                " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale");
        int action = sc.nextInt();
        player.attack(action, target);
    }

    /**
     * Ending the game, by displaying which player lost.
     * @param loseNb    Number of losing player.
     */
    public void endGame(int loseNb) {
        System.out.println("Joueur " + loseNb + " a perdu !");
    }
}
