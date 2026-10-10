// FACTORY PATTERN CHANGE CONTINUED: Creates a fresh RIGHT piece from its prototype.

public class RightLBlockFactory extends BlockFactory
{
    @Override
    public TetrisBlock createBlock()
    {
        //// Give the game its own right L piece to move
        return TetrisBlock.RIGHT_L.makeCopy();
    }
}
// FACTORY PATTERN CHANGE END