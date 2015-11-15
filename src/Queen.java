import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Queen extends Piece
{
	public Queen(boolean p, String bw){
		if(color.equals("black"))
		{
			ImageIcon queenIcon = new ImageIcon("res/bqueen.gif");
			pieceImage = queenIcon;
		}	
		if(color.equals("white"))
		{
			ImageIcon queenIcon = new ImageIcon("res/wqueen.gif");
			pieceImage = queenIcon;
		}
	}
	@Override
	public boolean canMove(int originX, int originY, int destX, int destY)
	{
		//If the destination isn't empty and has a piece of the same color, don't move
		if(Chess.p[destY][destX]!=null && Chess.p[destY][destX].color == color)
		{
			return canPieceMove = false;
		}
		
		// diagonal moves
		if(Math.abs(destX-originX) == Math.abs(destY-originY))
		{
			//check to see if there no pieces in the way
			if(destX>originX && destY>originY)
			{
				for(int i = originX+1; i< destX; i++)
				{
					for(int j = originY+1; j<destY; j++)
					{
						if(Chess.p[j][i]!=null)
						{	
							return canPieceMove = false;
						}
					}
				}
				return canPieceMove = true;
			}
			//check to see if there no pieces in the way
			if(destX<originX && destY<originY)
			{
				for(int i = originX-1; i> destX; i--)
				{
					for(int j = originY-1; j>destY; j--)
					{
						if(Chess.p[j][i]!=null)
						{	
							return canPieceMove = false;
						}
					}
				}
				return canPieceMove = true;
			}
			//check to see if there no pieces in the way
			if(destX<originX && destY>originY)
			{
				System.out.println("destX " + destX + "destY" + destY);

				for(int i = originX-1; i> destX; i--)
				{
					for(int j = originY+1; j<destY; j++)
					{
						if(Chess.p[j][i]!=null)
						{	
							return canPieceMove = false;
						}
					}
				}
				return canPieceMove = true;
			}
			//check to see if there no pieces in the way
			if(destX>originX && destY<originY)
			{
				System.out.println("destX " + destX + "destY" + destY);
				for(int i = originX+1; i< destX; i++)
				{
					for(int j = originY-1; j>destY; j--)
					{
						if(Chess.p[j][i]!=null)
						{	
							return canPieceMove = false;
						}
					}
				}
				return canPieceMove = true;
			}
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
		
		// horizontal moves
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
		xpos = x;
		ypos = y;
		g.drawImage(pieceImage.getImage(), xpos, ypos, null);
	}

}