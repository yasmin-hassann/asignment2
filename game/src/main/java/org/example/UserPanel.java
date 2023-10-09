
package org.example;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * UserPanel class extending VBox to manage and display player options in the game.
 * It contains CheckBox options for selecting the play mode ("S" or "O") and
 * provides visual feedback for player turns.
 */
public class UserPanel extends VBox {
    private Game game; // The main game instance.
    private CheckBox choiceBoxS, choiceBoxO;// CheckBox options for "S" and "O".

    private boolean isModeS = true; // Mode indicator for the panel. True for "S", False for "O".

    public UserPanel(String name, Game game) {
        super();
        this.game = game;
        choiceBoxS = new CheckBox("S");
        choiceBoxO = new CheckBox("O");

        setStyle("-fx-border-color: #000000; -fx-padding: 10px;");

        Text nameText = new Text(name);
        nameText.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        getChildren().add(nameText);

        // add vertical space
        getChildren().add(new Label(" "));

        getChildren().add(choiceBoxS);
        getChildren().add(choiceBoxO);

        // add vertical space
        getChildren().add(new Label(" "));
        getChildren().add(new Label(" "));

        choiceBoxO.setOnAction(this::onChoiceBoxO);
        choiceBoxS.setOnAction(this::onChoiceBoxS);

        choiceBoxS.setSelected(true);
        choiceBoxO.setSelected(false);
    }

    private void onChoiceBoxS(ActionEvent actionEvent) {
        choiceBoxS.setSelected(true);
        choiceBoxO.setSelected(false);
        isModeS = true;
    }

    private void onChoiceBoxO(ActionEvent actionEvent) {
        choiceBoxS.setSelected(false);
        choiceBoxO.setSelected(true);
        isModeS = false;
    }

    public boolean isModeS() {
        return isModeS;
    }

    public void resetBackground() {
        setStyle("-fx-border-color: #000000; -fx-padding: 10px;");
    }

    public void setActivatedBackground() {
        setStyle("-fx-border-color: #000000; -fx-padding: 10px; -fx-background-color: #00ff00;");
    }
}