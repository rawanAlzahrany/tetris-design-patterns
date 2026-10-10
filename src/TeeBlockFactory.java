// FACTORY PATTERN CHANGE CONTINUED: Creates a fresh T-shaped piece from its prototype.

public class TeeBlockFactory extends BlockFactory
{
    @Override
    public TetrisBlock createBlock()
    {
        //// Give the game its own tee piece to move
        return TetrisBlock.TEE.makeCopy();
    }
}
// FACTORY PATTERN CHANGE END