package org.example;


import javafx.application.Platform;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
public class GameTest {

    @Test
    public void testSelectBoardSize() {
        Platform.runLater(() -> {
            Game game = new Game();
            int selectedSize = game.takeGameInfo();
            // Verify  the selectedSize is within the expected range.
            // For example, if your valid board sizes range from 3 to 15:
            assertTrue(selectedSize >= 3 && selectedSize <= 15);
        });
    }

    @Test
    public void testSelectGameMode() {
        Platform.runLater(() -> {
            Game game = new Game();
            game.takeGameInfo();

            // Simulate selecting the General mode
            game.changeGameMode("General");

            // Verify that the mode is set to General
            assertTrue(game.isModeS() == false);

            // Simulate selecting the Simple mode
            game.changeGameMode("Simple");

            // Verify that the mode is set to Simple
            assertTrue(game.isModeS() == true);
        });
    }

    @Test
    public void testMakeSMoveInSimpleMode() {
        Platform.runLater(() -> {
            Game game = new Game();
            game.takeGameInfo();
            game.changeGameMode("Simple");

            // Simulate making an 'S' move
            game.makeMove("S");

            // Verify that the game state is updated correctly
            assertTrue(game.isPlayerTurn() == false);
        });
    }

    @Test
    public void testMakeOMoveInGeneralMode() {
        Platform.runLater(() -> {
            Game game = new Game();
            game.takeGameInfo();
            game.changeGameMode("General");

            // Simulate making an 'O' move
            game.makeMove("O");

            // Verify that the game state is updated correctly
            assertTrue(game.isPlayerTurn() == false);
        });
    }



}
