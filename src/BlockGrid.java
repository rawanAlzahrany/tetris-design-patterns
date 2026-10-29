
import java.awt.*;

public class BlockGrid {

    public static final int BLOCK_SIDE = 25;
    public static final Color BACKGROUND_COLOR = Color.WHITE;

    private Color[][] blocks;
    private Color currentColor = BACKGROUND_COLOR;

    // ========== DECORATOR START ==========

    // Basic drawing object
    private BlockDraw blockDraw = new BasicBlockDraw();

    // Change the drawing object when a theme is selected
    public void setBlockDraw(BlockDraw blockDraw) {

        if (blockDraw == null)
            throw new IllegalArgumentException(
                "BlockDraw cannot be null");

        this.blockDraw = blockDraw;
    }

    // ========== DECORATOR END ==========


    public BlockGrid(int width, int height) {

        blocks = new Color[width][height];
    }


    public void drawSquare(int x, int y) {

        try {
            blocks[x][y] = currentColor;
        }
        catch (Exception ex) {
        }
    }


    public void drawSquare(Point p) {

        drawSquare(p.x, p.y);
    }


    public void setColor(Color color) {

        currentColor = color;
    }


    public int getWidth() {

        return blocks.length;
    }


    public int getHeight() {

        return blocks[0].length;
    }


    public int getGraphicsWidth() {

        return getWidth() * BLOCK_SIDE;
    }


    public int getGraphicsHeight() {

        return getHeight() * BLOCK_SIDE;
    }


    public void clear() {

        blocks = new Color[blocks.length][blocks[0].length];
    }


    public void draw(Graphics g) {

        // OLD VERSION - Drawing directly in BlockGrid
        /*
        for (int i = 0; i < blocks.length; i++) {

            for (int j = 0; j < blocks[0].length; j++) {

                if (blocks[i][j] != null)
                    g.setColor(blocks[i][j]);
                else
                    g.setColor(BACKGROUND_COLOR);

                g.fillRect(
                    i*BLOCK_SIDE, j*BLOCK_SIDE,
                    BLOCK_SIDE-1, BLOCK_SIDE-1);

                g.setColor(Color.BLACK);

                g.drawRect(
                    i*BLOCK_SIDE, j*BLOCK_SIDE,
                    BLOCK_SIDE-1, BLOCK_SIDE-1);
            }
        }
        */


        // ========== DECORATOR START ==========
        // REFACTORED VERSION - Draw using BlockDraw

        for (int i = 0; i < blocks.length; i++) {

            for (int j = 0; j < blocks[0].length; j++) {

                int px = i * BLOCK_SIDE;
                int py = j * BLOCK_SIDE;

                if (blocks[i][j] != null) {

                    // Draw using the selected theme
                    blockDraw.draw(
                        g, px, py, BLOCK_SIDE, blocks[i][j]);

                } else {

                    // Keep empty squares unchanged
                    g.setColor(BACKGROUND_COLOR);

                    g.fillRect(
                        px, py,
                        BLOCK_SIDE - 1, BLOCK_SIDE - 1);

                    g.setColor(Color.BLACK);

                    g.drawRect(
                        px, py,
                        BLOCK_SIDE - 1, BLOCK_SIDE - 1);
                }
            }
        }

        // ========== DECORATOR END ==========
    }


    public String toString() {

        String ret = "";

        for (int j = 0; j < blocks[0].length; j++) {

            if (j != 0)
                ret += "\n";

            for (int i = 0; i < blocks.length; i++) {

                if (blocks[i][j] != null)
                    ret += "#";
                else
                    ret += "-";
            }
        }

        return ret;
    }


    public static void main(String[] args) {

        BlockGrid grid = new BlockGrid(10, 20);

        TetrisBlock.RIGHT_L.setLocation(0, 2).draw(grid);

        // OLD VERSION - already commented in Stage 1
        // TetrisBlock.RIGHT_L.setLocation(1,15).rotateLeft().draw(grid);

        System.out.println(grid);
    }
}
