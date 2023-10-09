package org.example;



import javafx.scene.control.Label;
/**
 * BoardLabel class extends Label, a component from JavaFX.
 * It represents a cell in the game board, containing additional
 * positional attributes to track its location on the board.
 */
public class BoardLabel extends Label {



    // Instance variables to store the position of the label on the board

    private int i,j;

    public BoardLabel(int i, int j){
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

}