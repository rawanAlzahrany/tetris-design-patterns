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


// where user chose the original color theme 
// Concrete Component
public class BasicBlockDraw implements BlockDraw {

    @Override
    public void draw(Graphics g, int x, int y,
                     int size, Color originalColor) {

        // Draw the block with its original color
        g.setColor(originalColor);
        g.fillRect(x, y, size - 1, size - 1);

        // Draw the black border
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size - 1, size - 1);
    }
}
