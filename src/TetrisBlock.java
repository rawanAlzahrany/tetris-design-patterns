import java.awt.Color;
import java.util.Vector;


/*S
- represent shapes
- handels movments
- rotate
- block creation
*/
public class TetrisBlock implements BlockPrototype
{
        // the shapes of the blocks
	public static final TetrisBlock LONG = new TetrisBlock(
		new boolean[][]{{true, true, true, true}}, Color.RED);

	public static final TetrisBlock LEFT_L = new TetrisBlock(new boolean[][]{
		{true, true, true}, {true, false, false}}, Color.BLUE);

	public static final TetrisBlock TEE = new TetrisBlock(
		new boolean[][]{{true, true, true}, {false, true, false}}, Color.BLUE);

	public static final TetrisBlock RIGHT_L = new TetrisBlock(new boolean[][]{
		{true, true, true}, {false, false, true}}, Color.CYAN);

	public static final TetrisBlock SQUARE = new TetrisBlock(new boolean[][]{
		{true, true}, {true, true}}, Color.BLACK);

	private boolean[][] blocks;
	private Color color;

	// location of the bottum left hand corner.
	private int x, y;

	private TetrisBlock(boolean[][] blocks, Color color)
	{
		this.blocks = blocks;
		this.color = color;
	}

	private TetrisBlock(boolean[][] blocks, Color color, int x, int y)
	{
		this(blocks, color);
		this.x = x;
		this.y = y;
	}
        
     // -------------- start --------------   
    // PROTOTYPE: same makeCopy() approach as the slides
    @Override
    public TetrisBlock makeCopy()
    {
        TetrisBlock blockObject = null;

        try
        {
            blockObject = (TetrisBlock) super.clone(); // create a copy with the same field values.
            
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return blockObject;
    }
    
    // -------------- end --------------  


// FACTORY PATTERN CHANGE START: make piece selection the concrete factorie's responsibility

 public static TetrisBlock getRandomBlock()
{
    return BlockFactory.randomFactory().createBlock();
}
// FACTORY PATTERN CHANGE END

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getWidth()
	{
		return blocks.length;
	}

	public int getHeight()
	{
		return blocks[0].length;
	}

        
        // changed after pattren
	public TetrisBlock setLocation(int x, int y)
	{
		 TetrisBlock copy = makeCopy();
                 copy.x = x;
                 copy.y = y;
                 return copy;
	}

	public TetrisBlock moveDown()
	{
            // (old)- return new TetrisBlock(blocks, color, x, y+1);
            TetrisBlock copy = makeCopy();
            copy.y++;
            return copy;
	}

        // instead of modifying existing it creates new object
	public TetrisBlock moveLeft()
	{
            // (old)- return new TetrisBlock(blocks, color, x-1, y);
            TetrisBlock copy = makeCopy();
            copy.x--;
            return copy;
	}

	public TetrisBlock moveRight()
	{
	    // (old)- return new TetrisBlock(blocks, color, x+1, y);
            TetrisBlock copy = makeCopy();
            copy.x++;
            return copy;
	}

	public boolean overlaps(int x, int y)
	{
		for(int i = 0; i < blocks.length; i++)
		{
			for(int j = 0; j < blocks[0].length; j++)
			{
				if(blocks[i][j])
				{
					if((this.x+i == x) && (this.y-blocks[0].length+1+j == y))
						return true;
				}
			}
		}
		return false;
	}

	public boolean overlaps(TetrisBlock other)
	{
		for(int i = 0; i < blocks.length; i++)
		{
			for(int j = 0; j < blocks[0].length; j++)
			{
				if(blocks[i][j])
				{
					if(other.overlaps(x+i, y-blocks[0].length+1+j))
						return true;
				}
			}
		}
		return false;
	}

        // build a rotated version of the shape's boolean array and return a new TetrisBlock
	public TetrisBlock turnRight()
	{
		boolean[][] newBlocks = new boolean[blocks[0].length][blocks.length];
		for(int i = 0; i < blocks.length; i++)
		{
			for(int j = 0; j < blocks[0].length; j++)
			{
				newBlocks[blocks[0].length-1-j][i] = blocks[i][j];
			}
		}
                
                // (old) - return new TetrisBlock(newBlocks, color, x, y);
		 TetrisBlock copy = makeCopy();
                 copy.blocks = newBlocks;
                 return copy;
	}

	public TetrisBlock turnLeft()
	{
		boolean[][] newBlocks = new boolean[blocks[0].length][blocks.length];
		for(int i = 0; i < blocks.length; i++)
		{
			for(int j = 0; j < blocks[0].length; j++)
			{
				newBlocks[j][blocks.length-1-i] = blocks[i][j];
			}
		}
		// (old) - return new TetrisBlock(newBlocks, color, x, y);
                TetrisBlock copy = makeCopy();
                copy.blocks = newBlocks;
                return copy;
	}
      
	public String toString()
	{
		String ret = "";
		for(int j = 0; j < blocks[0].length; j++)
		{
			ret+=(j!=0)?"\n":"";
			for(int i = 0; i < blocks.length; i++)
			{
				if(blocks[i][j])
					ret+="#";
				else
					ret+=" ";
			}
		}
		return ret;
	}

	public static TetrisBlock getSingleBlock(int x, int y, Color color)
	{
		return new TetrisBlock(new boolean[][]{{true}}, color, x, y);
	}

        // convert shapes into one square blocks
	public Vector<TetrisBlock> getSingleBlocks()
	{
		Vector<TetrisBlock> parts = new Vector();
		for(int i = 0; i < blocks.length; i++)
		{
			for(int j = 0; j < blocks[0].length; j++)
			{
				if(blocks[i][j])
					parts.add(getSingleBlock(x+i,y-blocks[0].length+1+j, color));
			}
		}
		return parts;
	}

	public void draw(BlockGrid grid)
	{
		grid.setColor(color);
		for(int i = 0; i < blocks.length; i++)
		{
			for(int j = 0; j < blocks[0].length; j++)
			{
				if(blocks[i][j])
					grid.drawSquare(x+i,y-blocks[0].length+1+j);
			}
		}
	}

	public static void main(String[] args)
	{
            /* (old)
		TetrisBlock a = TetrisBlock.SQUARE.setLocation(2,2);
		TetrisBlock b = TetrisBlock.SQUARE.setLocation(5,2);
		System.out.println(a.overlaps(b));
             */
            
            
	}
}