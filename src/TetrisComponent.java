
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// OLD VERSION
// public class TetrisComponent extends JComponent
//         implements KeyListener, Runnable

// REFACTORED VERSION
public class TetrisComponent extends JComponent
        implements KeyListener {

    public static final int DROP_DELAY_DECRESE_SPEED = 500;
    public static final int MIN_DROP_DELAY = 3;

    // OLD VERSION
    // private TetrisGrid grid;

    private final TetrisGrid grid;

    // REFACTORED VERSION - Swing Timer
    private final Timer gameTimer;

    private int dropDelay = 25;
    private int delay = 0;
    private int delayDelay = 0;
// ========== FACADE START ==========

// Tracks whether the game is paused
private boolean paused = false;

// ========== FACADE END ==========
    public TetrisComponent(int width, int height) {

        super();

        grid = new TetrisGrid(width, height);

        setPreferredSize(new Dimension(
            grid.getGraphicsWidth(),
            grid.getGraphicsHeight()));

        addKeyListener(this);
        setFocusable(true);

        // OLD VERSION - Thread
        // Thread run = new Thread(this);
        // run.start();

        // REFACTORED VERSION - Swing Timer
        // Create the first block immediately
        grid.update();

        gameTimer = new Timer(20, event -> {
            updateGame();
            repaint();
        });

        gameTimer.start();
    }

    // ========== DECORATOR START ==========

    // Change the block appearance
    public void setBlockDraw(BlockDraw blockDraw) {

        grid.setBlockDraw(blockDraw);
        repaint();
    }

    // ========== DECORATOR END ==========

// ========== FACADE START ==========

// Pause the game
public void pauseGame() {

    if (!paused) {
        gameTimer.stop();
        paused = true;
    }
}
// Resume the paused game
public void resumeGame() {

    if (paused) {
        gameTimer.start();
        paused = false;
    }

    requestFocusInWindow();
}
// Restart the game
public void restartGame() {

    // Stop the current game
    gameTimer.stop();

    // Reset the falling speed
    dropDelay = 25;
    delay = 0;
    delayDelay = 0;

    // Reset the board and score
    grid.resetGame();

    // Create the first block
    grid.update();

    // Start the new game
    paused = false;
    gameTimer.start();

    repaint();
    requestFocusInWindow();
}

// ========== FACADE END ==========
    // OLD VERSION - run() using Thread
    /*
    public void run() {

        while (true) {

            try {
                Thread.sleep(20);
            }
            catch (Exception ex) {
            }

            requestFocus();
            update();
            repaint();
        }
    }
    */


    // OLD VERSION - paint()
    /*
    public void paint(Graphics g) {

        synchronized (g) {
            grid.draw(g);
        }
    }
    */

    // REFACTORED VERSION - paintComponent()
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        grid.draw(g);
    }


    // OLD VERSION - update()
    /*
    public void update() {

        delayDelay = (delayDelay+1)%DROP_DELAY_DECRESE_SPEED;

        if (delayDelay == 0) {

            dropDelay--;

            if (dropDelay < MIN_DROP_DELAY)
                dropDelay = MIN_DROP_DELAY;
        }

        delay = (delay+1)%dropDelay;

        if (delay == 0)
            grid.moveDown();

        grid.update();
    }
    */

    // REFACTORED VERSION - updateGame()
    // Same game logic, renamed for clarity
    private void updateGame() {

        delayDelay = (delayDelay + 1)
                     % DROP_DELAY_DECRESE_SPEED;

        if (delayDelay == 0) {

            dropDelay--;

            if (dropDelay < MIN_DROP_DELAY)
                dropDelay = MIN_DROP_DELAY;
        }

        delay = (delay + 1) % dropDelay;

        if (delay == 0)
            grid.moveDown();

        grid.update();
    }


    @Override
    public void keyPressed(KeyEvent ke) {
        
// ========== FACADE START ==========
// Prevent block movement while paused
if (paused) {
    return;
}
// ========== FACADE END ==========
        if (ke.getKeyCode() == KeyEvent.VK_LEFT)
            grid.moveLeft();

        else if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
            grid.moveRight();

        else if (ke.getKeyCode() == KeyEvent.VK_DOWN)
            grid.moveDown();

        else if (ke.getKeyCode() == KeyEvent.VK_UP)
            grid.turnRight();

        else if (ke.getKeyCode() == KeyEvent.VK_COMMA)
            grid.turnLeft();

        else if (ke.getKeyCode() == KeyEvent.VK_PERIOD)
            grid.turnRight();

        // REFACTORED VERSION
        // Refresh immediately after keyboard movement
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
