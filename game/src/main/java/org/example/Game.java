package org.example;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Window;


/**
 * Game class extending Scene to manage and display the game.
 * It handles the UI components for setting and resetting the game,
 * managing turns, updating modes, and interacting with user inputs.
 */
public class Game extends Scene {
    private BorderPane pane;
    private Boolean modeS = true; // Mode switcher for the game, "S" or "O" mode.
    private UserPanel blue, red;// Panels for blue and red players respectively.
    private Boolean playerTurn = true;// Indicator for which player's turn is it. True for Blue, False for Red.
    private boolean gameMode = true;// Game mode switcher. True for "Simple", False for "General".
    private Label status = new Label("Blue Player's Turn");
    private Board board;
    /**
     * Constructor to initialize the Game scene.
     */
    public Game() {
        super(new BorderPane());
        int boardSize = takeGameInfo();
        pane = (BorderPane) getRoot();
        blue = new UserPanel("Blue Player", this);
        red = new UserPanel("Red Player", this);

        HBox topPanel = new HBox();
        topPanel.setStyle("-fx-border-color: #000000; -fx-padding: 10px;");
        topPanel.prefHeight(60);

        Label SOS = new Label("SOS (" + (gameMode ? "Simple" : "General") + " Mode)                            ");
        SOS.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        topPanel.getChildren().add(SOS);

        Button reset = new Button("Reset");
        reset.setOnAction(e -> {
            resetGame();
        });
        topPanel.getChildren().add(reset);
        pane.setTop(topPanel);

        pane.setLeft(blue);
        pane.setRight(red);

        FlowPane bottom = new FlowPane();
        bottom.setStyle("-fx-border-color: #000000; -fx-padding: 10px;");
        bottom.prefHeight(60);
        bottom.getChildren().add(status);
        pane.setBottom(bottom);

        board = new Board(boardSize, this);
        pane.setCenter(board);

        blue.setActivatedBackground();
    }

    private int takeGameInfo() {
        Dialog dialog = new Dialog<>();
        dialog.setTitle("Game Mode");
        dialog.setHeaderText("Choose the game mode");
        Window window = dialog.getDialogPane().getScene().getWindow();
        window.setOnCloseRequest(event -> window.hide());
        DialogPane dialogPane = dialog.getDialogPane();
        Button simple = new Button("Simple");
        simple.setOnAction(e -> {
            gameMode = true;
            dialog.close();
            dialog.hide();
            window.hide();
        });
        Button general = new Button("General");
        general.setOnAction(e -> {
            gameMode = false;
            dialog.close();
            dialog.hide();
            window.hide();
        });
        HBox hbox = new HBox();
        hbox.setSpacing(65);
        hbox.getChildren().addAll(simple, general);
        dialogPane.setContent(hbox);
        dialog.showAndWait();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Board Size");
        alert.setHeaderText("Choose the board size");
        ChoiceBox<Integer> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        choiceBox.setValue(8);
        Button cancelButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setVisible(false);
        alert.getDialogPane().setContent(choiceBox);
        alert.showAndWait();
        return choiceBox.getValue();
    }


    /**
     * Checks if the game is in mode S.
     *
     * @return True if the game is in mode S, otherwise False.
     */
    public boolean isModeS() {
        return modeS;
    }

    public void updateMode() {
        if (playerTurn) {
            modeS = blue.isModeS();
        } else {
            modeS = red.isModeS();
        }
    }

    public void alterTurn() {
        playerTurn = !playerTurn;
        if (playerTurn) {
            status.setText("Blue Player's Turn");
            modeS = blue.isModeS();
            blue.setActivatedBackground();
            red.resetBackground();
        } else {
            status.setText("Red Player's Turn");
            modeS = red.isModeS();
            red.setActivatedBackground();
            blue.resetBackground();
        }
    }

    private void resetGame() {
        board = new Board(board.getBoardSize(), this);
        pane.setCenter(board);
        playerTurn = true;
        status.setText("Blue Player's Turn");
        modeS = blue.isModeS();
        blue.setActivatedBackground();
        red.resetBackground();
    }
}


