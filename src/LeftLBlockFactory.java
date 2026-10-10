// FACTORY PATTERN CHANGE CONTINUED: Creates a fresh LEFT piece from its prototype

public class LeftLBlockFactory extends BlockFactory
{
    @Override
    // each specific factory decides what kind of block to return.
    public TetrisBlock createBlock()
    {
        // Give the game its own left L piece to move
        return TetrisBlock.LEFT_L.makeCopy();
    }
}
// FACTORY PATTERN CHANGE END