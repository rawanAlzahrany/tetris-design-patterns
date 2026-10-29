/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rwan
 */


import java.awt.Color;
import java.awt.Graphics;

// Concrete Decorator - Neon Theme
public class NeonThemeDecorator
        extends BlockDrawDecorator {

    public NeonThemeDecorator(BlockDraw blockDraw) {
        super(blockDraw);
    }

    @Override
    public void draw(Graphics g, int x, int y,
                     int size, Color originalColor) {

        // Draw the original block first
        super.draw(g, x, y, size, originalColor);

        Color neon = neonColor(originalColor);

        // Add dark inner background
        g.setColor(new Color(20, 18, 35));
        g.fillRect(x + 1, y + 1, size - 2, size - 2);

        // Add neon color and border
        g.setColor(neon);
        g.fillRect(x + 4, y + 4, size - 8, size - 8);
        g.drawRect(x + 1, y + 1, size - 3, size - 3);

        // Add white highlight
        g.setColor(Color.WHITE);
        g.drawLine(x + 5, y + 5,
                   x + size - 7, y + 5);
    }

    private Color neonColor(Color color) {

        if (Color.PINK.equals(color))
            return new Color(255, 43, 127);

        if (Color.MAGENTA.equals(color))
            return new Color(186, 63, 255);

        if (Color.YELLOW.equals(color))
            return new Color(255, 228, 0);

        if (Color.CYAN.equals(color))
            return new Color(0, 225, 255);

        if (Color.GRAY.equals(color))
            return new Color(65, 255, 121);

        return color;
    }
}

