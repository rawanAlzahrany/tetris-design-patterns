/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gf400
 */
public class CloneFactory
{
    public BlockPrototype getClone(BlockPrototype blockSample)
    {
        return blockSample.makeCopy();
    }
}
