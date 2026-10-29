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

// Abstract Decorator
public abstract class BlockDrawDecorator
        implements BlockDraw {

    protected BlockDraw decoratedBlock;

    public BlockDrawDecorator(BlockDraw decoratedBlock) {
        this.decoratedBlock = decoratedBlock;
    }

    @Override
    public void draw(Graphics g, int x, int y,
                     int size, Color originalColor) {

        decoratedBlock.draw(g, x, y, size, originalColor);
    }
}

