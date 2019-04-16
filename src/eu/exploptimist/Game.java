package eu.exploptimist;

import java.util.Scanner;

public class Game {

    private Scanner sc = new Scanner(System.in);
    private Character player1;
    private Character player2;

    public void launchGame(){
        player1 = createCharacter(1);
        player2 = createCharacter(2);
        this.fight(player1, player2);
    }

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
    public void fight(Character player1, Character player2){
        while(player1.getHealth() > 0 || player2.getHealth() > 0){
            System.out.println("Player1 Health: "+ player1.getHealth());
            System.out.println("Player2 Health: "+ player2.getHealth());
            play(player1, 1, player2);

            if(player2.getHealth() <= 0){
                // player1 wins!
                this.endGame(2);
                break;
            } else if(player1.getHealth() <= 0){
                // player2 wins!
                this.endGame(1);
                break;
            }

            play(player2, 2, player1);
        }
    }

    private void play(Character player, int playerNb, Character target){
        System.out.println("Joueur " + playerNb + " (" + player.getHealth() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale");
        int action = sc.nextInt();
        player.attack(action, target);
    }

    private void endGame(int loseNb) {
        System.out.println("Joueur " + loseNb + " a perdu !");
    }
}
