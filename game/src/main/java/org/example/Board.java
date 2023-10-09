package org.example;



import javafx.scene.Group;
import javafx.scene.control.Alert;


/**
 * The Board class represents the game board where the game is played.
 * It is responsible for initializing and managing the board's state,
 * as well as handling user interactions with the board's cells.
 */
public class Board extends Group {
    private Game game;
    private int size;
    private BoardLabel[][] board;  // 2D array to store board cells

    Board(int size, Game game) {
        board = new BoardLabel[size][size];
        this.size = size;
        this.game = game;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new BoardLabel(i, j);
                board[i][j].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #ffffff; -fx-font-size: 24px; -fx-font-weight: bold; -fx-alignment: center; -fx-padding: 10px;");
                board[i][j].setPrefSize(50, 50);
                board[i][j].setTranslateX(50 * j);
                board[i][j].setTranslateY(50 * i);
                board[i][j].setOnMouseClicked(e -> {
                    BoardLabel label = (BoardLabel) e.getSource();
                    if (label.getText().equals("S") || label.getText().equals("O")) {
                        // Check if the cell is already occupied
                        showAlert("Invalid Move", "This cell is already occupied. Try again!");
                        return;
                    }
                    game.updateMode();
                    if (game.isModeS()) {
                        label.setText("S");
                    } else {
                        label.setText("O");
                    }
                    game.alterTurn();
                });

                getChildren().add(board[i][j]);
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public boolean isGameOver() {
        return false; // Game is never over in this simplified version
    }

    public int getBoardSize() {
        return size;
    }
}

