import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Chess extends BoardMouseListener
{
	//Piece initialized
	public static Piece piece;
	public static King king;
	
	//whose turn it is
	public static  boolean turn=false;
	public static String whoseTurn;
	
	//Boolean variable for whether someone's won
	public static boolean gameOver = false;
	
	//Coordinates AI's turns
	public static int y1;
	public static int x1;
	public static int y2;
	public static int x2;
	
	//BoardComponent initialized
	public static BoardComponent board;
	
	//Position array initialized
	public static Piece[][] p = new Piece[8][8];
	
	//Coordinates
	public static int xpos;
	public static int ypos;
	
	//Window width
	public static final int WIDTH = 450;
	
	
	public Chess()
	{
		//Position array
		p[0][0] = new Rook(true, "black");
		p[0][1] = new Knight(true, "black");
		p[0][2] = new Bishop(true, "black");
		p[0][3] = new Queen(true, "black");
		p[0][4] = new King(true, "black");
		p[0][5] = new Bishop(true, "black");
		p[0][6] = new Knight(true, "black");
		p[0][7] = new Rook(true, "black");
		for(int i=0; i<8; i++)
		{
			p[1][i] = new Pawn(true, "black");
		}
		for(int j=2; j<6; j++)
		{
			for(int i=0; i<8;i++)
			{
				p[j][i] = null;
			}
		}
		for(int i=0; i<8; i++)
		{
			p[6][i] = new Pawn(true, "white");
		}
		p[7][0] = new Rook(true, "white");
		p[7][1] = new Knight(true, "white");
		p[7][2] = new Bishop(true, "white");
		p[7][3] = new Queen(true, "white");
		p[7][4] = new King(true, "white");
		p[7][5] = new Bishop(true, "white");
		p[7][6] = new Knight(true, "white");
		p[7][7] = new Rook(true, "white");
		
		//creates window
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, WIDTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board = new BoardComponent(this);
		board.addMouseListener(this);
		board.repaint();
		frame.add(board);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Chess();
		while(gameOver==false)
		{
			//user is black piece
			if(turn == true)
			{
			//System.out.println("It's Your turn!");
			}
			//computer is white piece
			if(turn == false)
			{
				Computer.computerMove();
				Chess.whoseTurn = "white";
				currentPosition = Chess.p[Computer.y1][Computer.x1];

				if(currentPosition.color.equals("white"))
				{
					//Checks to see if destination is valid
					if(currentPosition.canMove(Computer.x1, Computer.y1, Computer.x2, Computer.y2))
					{
						if(Chess.p[Computer.y2][Computer.x2] instanceof King)
						{
							Chess.gameOver = true;
							Chess.p[Computer.y2][Computer.x2] = currentPosition; 
							Chess.p[Computer.y1][Computer.x1] = null;
						}
						if(Computer.y2 == 0 && Chess.p[Computer.y1][Computer.x1] instanceof Pawn)
						{
							Chess.p[Computer.y2][Computer.x2] = new Queen(true, "white");
							Chess.p[Computer.y1][Computer.x1] = null;
						}
						//If it is, set destination with piece & set initial coordinates of chosen piece to null
						else
						{
							Chess.p[Computer.y2][Computer.x2] = currentPosition;
							Chess.p[Computer.y1][Computer.x1] = null;
						}
						//Repaint the board and switch turns
						Chess.board.repaint();
						Chess.turn ^=true;
			
					}
				}
			}
		}
		System.out.println("Game is over!");
	}
}