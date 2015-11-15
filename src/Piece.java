import javax.swing.ImageIcon;
import java.awt.Graphics;

//Piece stores the ImageIcon of a chess piece,color of the piece &method drawPiece()
public abstract class Piece 
{
	private Chess chessobject;
	//Color of the piece
	public String color;
	//Boolean canPieceMove returns whether or not piece can move to coordinates
	public boolean canPieceMove;	
	//Coordinates
	public int xpos;
	public int ypos;
	//ImageIcon
	ImageIcon pieceImage = new ImageIcon();
	public Piece(Chess chess)
	{
		chessobject = chess;
	}
	public Piece(){}
	//Abstract method drawPiece draws pieces
	public abstract void drawPiece(int x, int y, Graphics g);
	//Abstract method canMove checks if piece can move
	public abstract boolean canMove(int originX, int originY, int destX, int destY);
}