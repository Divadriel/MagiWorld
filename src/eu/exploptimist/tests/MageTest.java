package eu.exploptimist.tests;

import eu.exploptimist.Mage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    Mage player = new Mage(10, 0, 0, 10, "Joueur 1");
    Mage target = new Mage(15, 0, 0, 15, "Joueur 2");

    @Test
    void Given_targetDead_When_basicAttack_Then_displayDeath() {
        target.setHealth(8);
        player.attack(1, target);
        assertEquals("Joueur 1 utilise Boule de Feu et inflige 10 dommages.\n" +
                "Joueur 2 perd 10 points de vie.\n" +
                "Joueur 2 est mort\n", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_playerAlive_When_specialAttack_Then_displayImprovedHealth() {
        player.setHealth(20);
        player.attack(2, target);
        assertEquals("Joueur 1 utilise Soin et gagne 20 en Vitalité.\n", outContent.toString().replace("\r\n", "\n"));
        assertEquals(40, player.getHealth());
    }
}