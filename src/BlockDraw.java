/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rwan
 */

// Decoretor 
// block-drawing classes must implement this interface 

import java.awt.Color;
import java.awt.Graphics;

// Component Interface
public interface BlockDraw {

    void draw(Graphics g, int x, int y,
              int size, Color originalColor);
}
