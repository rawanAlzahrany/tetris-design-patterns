// FACTORY PATTERN CHANGE START
// BlockFactory is the common parent for the different block factories like long or tee, etc
public abstract class BlockFactory
{
    public abstract TetrisBlock createBlock();

    // PICKS A RANDOM FACTORY AND USES IT TO CREATE A BLOCK
    public static BlockFactory randomFactory()
    {
        switch ((int)(Math.random() * 5))
        {
            case 0: return new LongBlockFactory();
            case 1: return new LeftLBlockFactory();
            case 2: return new TeeBlockFactory();
            case 3: return new RightLBlockFactory();
            default: return new SquareBlockFactory();
        }
    }
}
// FACTORY PATTERN CHANGE CONTINUES ON LEFT,LONG.RIGHT,SQUARE, AND TEE BLOCK FACTORIES