// FACTORY METHOD CHANGE START: Creates a fresh SQUARE piece from its prototype.

public class SquareBlockFactory extends BlockFactory
{
    @Override
    public TetrisBlock createBlock()
    {
        //// Give the game its own square piece to move
        return TetrisBlock.SQUARE.makeCopy();
    }
}
// FACTORY PATTERN CHANGE END