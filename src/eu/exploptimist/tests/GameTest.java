package eu.exploptimist.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
//outContent.toString().replace("\r\n", "\n")

class GameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void launchGame() {
    }

    @Test
    void checkClass() {
    }

    @Test
    void checkLevel() {
    }

    @Test
    void checkPerk() {
    }

    @Test
    void checkAllPerks() {
    }

    @Test
    void selectClass() {
    }

    @Test
    void selectLevel() {
    }

    @Test
    void selectPerks() {
    }

    @Test
    void createCharacter() {
    }

    @Test
    void fight() {
    }

    @Test
    void play() {
    }

    @Test
    void endGame() {
    }
}