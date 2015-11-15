import java.awt.Graphics;
import javax.swing.ImageIcon;

public class King extends Piece
{
	public King(boolean p, String bw)
	{
		color = bw;
		if(color.equals("black"))
		{
			ImageIcon kingIcon = new ImageIcon("res/bking.gif");
			pieceImage = kingIcon;
		}
		
		if(color.equals("white"))
		{
			ImageIcon kingIcon = new ImageIcon("res/wking.gif");
			pieceImage = kingIcon;
		}
	}
	
	@Override
	public boolean canMove(int originX, int originY, int destX, int destY)
	{
		//Check if vertical one space move
		if(destX==originX && Math.abs(destY-originY) ==1)
		{
			//Making sure that the destination is either empty or has an opponent's piece and empty
			if( Chess.p[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if( Chess.p[destY][destX] != null &&  Chess.p[destY][destX].color != color)
			{
				return canPieceMove = true;
			}
		}
		//Check if horizontal one space move
		if(destY==originY && Math.abs(destX-originX) == 1)
		{
			//Making sure that the destination is either empty or has an opponent's piece and path is empty
			if( Chess.p[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if( Chess.p[destY][destX] != null &&  Chess.p[destY][destX].color != color)
			{
				return canPieceMove = true;
			}
		}
		//Check if diagonal one space move
		if(Math.abs(destX-originX) == 1 && Math.abs(destY-originY) == 1)
		{
			//Making sure that the destination is either empty or has an opponent's piece and path is empty
			if( Chess.p[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if( Chess.p[destY][destX] != null &&  Chess.p[destY][destX].color != color)
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
