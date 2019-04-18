package eu.exploptimist.tests;

import eu.exploptimist.Warrior;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    Warrior player = new Warrior(10, 10, 0, 0, "Joueur 1");
    Warrior target = new Warrior(15, 10, 5, 0, "Joueur 2");

    @Test
    void Given_targetDead_When_basicAttack_Then_displayDeath() {
        target.setHealth(8);
        player.attack(1, target);
        assertEquals("Joueur 1 utilise Coup d'Epée et inflige 10 dommages.\n" +
                "Joueur 2 perd 10 points de vie.\n" +
                "Joueur 2 est mort\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_targetDead_When_specialAttack_Then_displayDeath() {
        target.setHealth(15);
        player.attack(2, target);
        assertEquals("Joueur 1 utilise Coup de Rage et inflige 20 dommages.\n" +
                "Joueur 2 perd 20 points de vie.\n" +
                "Joueur 2 est mort\n" +
                "Joueur 1 perd 5 points de vie.\n", outContent.toString().replace("\r\n", "\n"));
    }
}