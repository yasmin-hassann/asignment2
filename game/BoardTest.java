package org.example;

import javafx.application.Platform;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
public class BoardTest {

    @Test
    public void testBoardSize() {
        Platform.runLater(() -> {
            // Create a mock Game instance
            Game game = new Game();

            // Define the expected board size
            int expectedSize = 8; // Adjust this value based on your test case

            // Create a Board instance with the expected board size
            Board board = new Board(expectedSize, game);

            // Get the actual board size from the Board instance
            int actualSize = board.getBoardSize();

            // Verify that the actual board size matches the expected board size
            assertEquals(expectedSize, actualSize);

        });
    }
}


