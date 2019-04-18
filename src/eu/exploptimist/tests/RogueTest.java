package eu.exploptimist.tests;

import eu.exploptimist.Rogue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RogueTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    Rogue player = new Rogue(10, 0, 10, 0, "Joueur 1");
    Rogue target = new Rogue(15, 0, 15, 0, "Joueur 2");

    @Test
    void Given_targetDead_When_basicAttack_Then_displayDeath() {
        target.setHealth(8);
        player.attack(1, target);
        assertEquals("Joueur 1 utilise Tir à l'Arc et inflige 10 dommages.\n" +
                "Joueur 2 perd 10 points de vie.\n" +
                "Joueur 2 est mort\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_playerAlive_When_specialAttack_Then_displayImprovedDexterity() {
        player.attack(2, target);
        assertEquals("Joueur 1 utilise Concentration et gagne 5 en Agilité.\n", outContent.toString().replace("\r\n", "\n"));
        assertEquals(15, player.getDexterity());
    }
}