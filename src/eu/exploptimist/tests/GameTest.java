package eu.exploptimist.tests;

import eu.exploptimist.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
//outContent.toString().replace("\r\n", "\n")

class GameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Game game = new Game();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void Given_correctClassNumber_When_checkClassRuns_Then_returnTrue() {
        assertEquals(true, game.checkClass(2));
    }

    @Test
    void Given_uncorrectClassNumber_When_checkClassRuns_Then_returnFalse(){
        assertEquals(false, game.checkClass(5));
    }

    @Test
    void Given_correctLevelNumber_When_checkLevelRuns_Then_returnTrue() {
        assertEquals(true, game.checkLevel(42));
        assertEquals(true, game.checkLevel(1));
        assertEquals(true, game.checkLevel(100));
    }

    @Test
    void Given_uncorrectLevelNumber_When_checkLevelRuns_Then_returnFalse(){
        assertEquals(false, game.checkLevel(142));
        assertEquals(false, game.checkLevel(-42));
        assertEquals(false, game.checkLevel(0));
    }

    @Test
    void Given_correctPerkNumber_When_checkPerkRuns_Then_returnTrue() {
        assertEquals(true, game.checkPerk(42));
        assertEquals(true, game.checkPerk(0));
        assertEquals(true, game.checkPerk(100));
    }

    @Test
    void Given_uncorrectPerkNumber_When_checkPerkRuns_Then_returnFalse(){
        assertEquals(false, game.checkPerk(-42));
        assertEquals(false, game.checkPerk(142));
    }

    @Test
    void Given_correctPerks_When_checkAllPerksRuns_Then_returnTrue() {
        assertEquals(true, game.checkAllPerks(20, 10, 5, 5));
        assertEquals(true, game.checkAllPerks(20, 20, 0, 0));
    }

    @Test
    void Given_uncorrectPerks_When_checkAllPerksRuns_Then_returnFalse(){
        assertEquals(false, game.checkAllPerks(20, 15, 15, 15));
        assertEquals(false, game.checkAllPerks(20, 5, 5, 11));
        assertEquals(false, game.checkAllPerks(20, 5, 5, 9));
    }
}