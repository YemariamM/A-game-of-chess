import java.awt.Graphics;

import javax.swing.ImageIcon;
public class Bishop extends Piece
{
	public Bishop(boolean p, String bw)
	{
		//is piece black or white
		color = bw;
		if(color.equals("black"))
		{
			ImageIcon bishopIcon = new ImageIcon("res/bbishop.gif");
			pieceImage = bishopIcon;
		}		
		
		if(color.equals("white"))
		{
			ImageIcon bishopIcon = new ImageIcon("res/wbishop.gif");
			pieceImage = bishopIcon;
		}
	}
	
	//Method canMove is an abstract inherited method from Piece
	
	@Override
	public boolean canMove(int originX, int originY, int destX, int destY)
	{
		//This if statement checks to see whether or not the destination is diagonal from the origin
		if(Chess.p[destY][destX]!=null && Chess.p[destY][destX].color == color)
		{
			return canPieceMove = false;
		}
		if(Math.abs(destX-originX) == Math.abs(destY-originY))
		{
			if(destX>originX && destY>originY)
			{
				for(int i = originX+1; i< destX; i++)
				{
					for(int j = originY+1; j<destY; j++)
					{
						if(i-originX == j - originY)
						{
							//Making sure that the destination is either empty or has an opponent's piece and path is empty
							if(Chess.p[j][i]!=null)
							{
								return canPieceMove = false;
							}
						}
					}
					
				}
				return canPieceMove = true;
			}
			if(destX<originX && destY<originY)
			{
				for(int i = originX-1; i> destX; i--)
				{
					for(int j = originY-1; j>destY; j--)
					{
						if(i-originX == j - originY)
						{
							//Making sure that the destination is either empty or has an opponent's piece and path is empty 
							if(Chess.p[j][i]!=null)
							{	
								return canPieceMove = false;
							}
						}
					}
				}
				return canPieceMove = true;
			}

			if(destX<originX && destY>originY)
			{
				for(int i = originX-1; i> destX; i--)
				{
					for(int j = originY+1; j<destY; j++)
					{
						if(i-originX == j - originY)
						{
							//Making sure that the destination is either empty or has an opponent's piece and path is empty 
	
							if(Chess.p[j][i]!=null)
							{	
								return canPieceMove = false;
							}
						}	
					}
				}
				return canPieceMove = true;
			}
			if(destX>originX && destY<originY)
			{
				for(int i = originX+1; i< destX; i++)
				{
					for(int j = originY-1; j>destY; j--)
					{
						if(Math.abs(i-originX) == Math.abs(j - originY))
						{
							//Making sure that the destination is either empty or has an opponent's piece and path is empty
							if(Chess.p[j][i]!=null)
							{	
								return canPieceMove = false;
							}
						}
					}
				}
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