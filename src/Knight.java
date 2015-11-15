import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Knight extends Piece
{
	public Knight(boolean p, String bw)
	{
		color = bw;
		if(color.equals("black"))
		{
			ImageIcon knightIcon = new ImageIcon("res/bknight.gif");
			pieceImage = knightIcon;
		}
		
		if(color.equals("white"))
		{
			ImageIcon knightIcon = new ImageIcon("res/wknight.gif");
			pieceImage = knightIcon;
		}
	}
	@Override
	public boolean canMove(int originX, int originY, int destX, int destY)
	{
		//Making sure that the destination is either empty or has an opponent's piece and  path is empty
		if(Chess.p[destY][destX]!=null && Chess.p[destY][destX].color == color)
		{
			return canPieceMove = false;
		}
		
		//Make sure the destination does not have the same x or y coordinates as the origin
		if(destY == originY || destX == originX)
		{
			return canPieceMove = false;
		}
		
		//Make sure they aren't diagonal
		if(Math.abs(destX-originX) == Math.abs(destY-originY))
		{
			return canPieceMove = false;
		}	
		
		//The destination X and Y should be no more than 2 spaces away from the origin
		if(destX==originX+1 || destX == originX-1 || destX == originX-2 || destX == originX+2)
		{
			if(destY == originY+1 || destY == originY-1 || destY == originY-2 || destY == originY+2)
			{
					return canPieceMove = true;
			}
		}	
		else
			canPieceMove = false;
		return canPieceMove;	
	}
	@Override
	public void drawPiece(int x, int y, Graphics g) 
	{
		xpos = x;
		ypos = y;
		g.drawImage(pieceImage.getImage(), xpos, ypos, null);
	}

}