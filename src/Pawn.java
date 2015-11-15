import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Pawn extends Piece
{
	public Pawn(boolean p, String bw)
	{
		color = bw;
		if(color.equals("black"))
		{
			ImageIcon pawnIcon = new ImageIcon("res/bpawn.gif");
			pieceImage = pawnIcon;
		}
		
		if(color.equals("white"))
		{
			ImageIcon pawnIcon = new ImageIcon("res/wpawn.gif");
			pieceImage = pawnIcon;
		}
	}
	@Override
	public boolean canMove(int originX, int originY, int destX, int destY)
	{
		if(Chess.p[originY][originX].color.equals("black"))		
		{
			if(originY==1 && destX==originX && destY-originY ==2 && Chess.p[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if(destX==originX && destY-originY ==1 && Chess.p[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if(Math.abs(destX-originX) == 1 && destY-originY == 1 && Chess.p[destY][destX]!= null && Chess.p[destY][destX].color != color)
			{
				return canPieceMove = true;
			}
			else
				return canPieceMove = false;
		}	
		//If it's computer's it moves up the chessboard

		if(Chess.p[originY][originX].color.equals("white"))
		{
			if(originY==6 && destX==originX && destY-originY ==-2 && Chess.p[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if(destX==originX && destY-originY == -1 && Chess.p[destY][destX] == null)
			{
				return canPieceMove = true;
			}
			if(Math.abs(destX-originX) == 1 && destY-originY == -1 && Chess.p[destY][destX]!= null && Chess.p[destY][destX].color != color)
			{
				return canPieceMove = true;
			}
			else
				return canPieceMove = false;
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