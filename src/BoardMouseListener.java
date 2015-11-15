import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardMouseListener implements MouseListener
{
	int initialX;
	int initialY;
	int finalX;
	int finalY;

	static Piece currentPosition;
	public static Piece piece;

	@Override
	public void mouseClicked(MouseEvent e) {}
	//Method mousePressed finds the coordinates of where the mouse was pressed
	public void mousePressed(MouseEvent e) 
	{		
		initialX = (e.getX()*8)/Chess.WIDTH;
		initialY = (e.getY()*8)/Chess.WIDTH;
		//currentPosition corresponds to the pressed coordinates
		currentPosition = Chess.p[initialY][initialX];		
	}

	//Method mouseReleased finds where mouse was released
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		finalX = (e.getX()*8)/Chess.WIDTH;
		finalY = (e.getY()*8)/Chess.WIDTH;
		if(Chess.turn==true)
		{
			Chess.whoseTurn = "black";
		}
		if(Chess.turn == false)
		{
			Chess.whoseTurn = "white";
		}
		if(Chess.gameOver==false){
		if(Chess.p[initialY][initialX].color.equals(Chess.whoseTurn))
		{
			//Can selected piece move to the destination coordinates?
			boolean isTrue = currentPosition.canMove(initialX, initialY, finalX, finalY);
			if(isTrue==true)
			{
				//If it can, then set final coordinates to the selected piece and initial coordinates to null
				if(Chess.p[finalY][finalX] instanceof King)
				{
					Chess.gameOver = true;
					Chess.p[finalY][finalX] = currentPosition; 
					Chess.p[initialY][initialX] = null;
				}
				//If the black pawn makes it to the end of the board, it can turn into a queen
				if(finalY == 7 && Chess.p[initialY][initialX] instanceof Pawn)
				{
					Chess.p[finalY][finalX] = new Queen(true, "black");
					Chess.p[initialY][initialX] = null;
				}
				else
				{
					Chess.p[finalY][finalX] = currentPosition; 
					Chess.p[initialY][initialX] = null;
				}
				//Repaint board and switch the turn variable
				Chess.board.repaint();
				Chess.turn ^=true;
			}
		}
		
		else
		{
			System.out.println("Can't move there!");
		}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}