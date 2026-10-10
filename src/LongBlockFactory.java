// FACTORY PATTERN CHANGE CONTINUED: Creates a fresh LONG piece from its prototype.

public class LongBlockFactory extends BlockFactory
{
    @Override
    public TetrisBlock createBlock()
    {
        //// Give the game its own long piece to move
        return TetrisBlock.LONG.makeCopy();
    }
}
// FACTORY PATTERN CHANGE END