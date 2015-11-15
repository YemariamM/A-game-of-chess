import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Rook extends Piece
{
	public Rook(boolean p, String bw)
	{
		color = bw;
		if(color.equals("black"))
		{
			ImageIcon rookIcon = new ImageIcon("res/brook.gif");
			pieceImage = rookIcon;
		}
		
		if(color.equals("white"))
		{
			ImageIcon rookIcon = new ImageIcon("res/wrook.gif");
			pieceImage = rookIcon;
		}
	}
	@Override
	public boolean canMove(int originX, int originY, int destX, int destY)
	{
		if(Chess.p[destY][destX]!=null && Chess.p[destY][destX].color == color)
		{
			return canPieceMove = false;
		}
		//vertical moves
		if(destY==originY)
		{
			//check to see if there no pieces in the way
			if(destX>originX)
			{
				for(int i = originX+1; i < destX; i++)
				{
						if(Chess.p[destY][i]!=null)
						{	
							return canPieceMove = false;
						}
				}
				return canPieceMove = true;

			}
			//check to see if there no pieces in the way
			if(destX<originX)
			{
				for(int i = originX-1; i > destX; i--)
				{
						if(Chess.p[destY][i]!=null)
						{
							return canPieceMove = false;
						}
				}
				return canPieceMove = true;
			}	
		}
		//horizontal moves
		if(destX==originX)
		{
			//check to see if there no pieces in the way
			if(destY>originY)
			{
				for(int i = originY+1; i < destY; i++)
				{
					if(Chess.p[i][destX]!=null)
					{
						return canPieceMove = false;
					}
				}
				return canPieceMove = true;
			}
			//check to see if there no pieces in the way
			if(destY<originY)
			{
				for(int i = originY-1; i > destY; i--)
				{
					if(Chess.p[i][destX]!=null)
					{
						return canPieceMove = false;
					}
				}
				return canPieceMove = true;
			}
		}
		else
		{
			canPieceMove = false;
		}
		return canPieceMove;	
	}
	@Override
	public void drawPiece(int x, int y, Graphics g) 
	{
		// TODO Auto-generated method stub
		xpos = x;
		ypos = y;
		g.drawImage(pieceImage.getImage(), xpos, ypos, null);
	}

}