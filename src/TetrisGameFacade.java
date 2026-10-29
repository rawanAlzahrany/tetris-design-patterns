/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dana2
 */
// ========== FACADE PATTERN START ==========

// Facade class for managing Tetris game operations
public class TetrisGameFacade {

    // Reference to the game component
    private final TetrisComponent game;

    public TetrisGameFacade(TetrisComponent game) {
        this.game = game;
    }
    
    // Pause the game
public void pauseGame() {
    game.pauseGame();
}

// Resume the game
public void resumeGame() {
    game.resumeGame();
}

// Restart the game
public void restartGame() {
    game.restartGame();
}
}

// ========== FACADE PATTERN END ==========