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

// Concrete Decorator - Pastel Theme
public class PastelThemeDecorator
        extends BlockDrawDecorator {

    public PastelThemeDecorator(BlockDraw blockDraw) {
        super(blockDraw);
    }

    @Override
    public void draw(Graphics g, int x, int y,
                     int size, Color originalColor) {

        // Draw the original block first
        super.draw(g, x, y, size, originalColor);

        // Add pastel color
        g.setColor(pastelColor(originalColor));
        g.fillRect(x + 1, y + 1, size - 2, size - 2);

        // Add a white highlight
        g.setColor(Color.WHITE);
        g.drawLine(x + 3, y + 3,
                   x + size - 5, y + 3);
    }

    private Color pastelColor(Color color) {

        if (Color.PINK.equals(color))
            return new Color(255, 194, 218);

        if (Color.MAGENTA.equals(color))
            return new Color(211, 191, 245);

        if (Color.YELLOW.equals(color))
            return new Color(255, 235, 177);

        if (Color.CYAN.equals(color))
            return new Color(174, 234, 244);

        if (Color.GRAY.equals(color))
            return new Color(179, 228, 197);

        return color;
    }
}

