package eu.exploptimist.tests;

import eu.exploptimist.Warrior;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import eu.exploptimist.Character;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    Character character = new Warrior(10, 10, 0, 0, "Joueur 2");

    @Test
    void Given_healthNull_When_isDeadRuns_Then_returnTrue() {
        character.setHealth(0);
        assertTrue(character.isDead());
    }

    @Test
    void Given_healthNotNull_When_isDeadRuns_Then_returnFalse(){
        character.setHealth(10);
        assertFalse(character.isDead());
    }

    @Test
    void Given_perks_When_displayPerksRuns_Then_displayAllPerks() {
        String playerDesc = character.displayPerks();
        character.setHealth(50);
        assertEquals("Joueur 2 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !", playerDesc);
    }
}