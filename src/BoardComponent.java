import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
public class BoardComponent extends JComponent 
{
	private Chess thechessmainobject;
	
	public BoardComponent(Chess chessmainobject) 
	{
		super();
		thechessmainobject = chessmainobject;
	}
	
	public void paintComponent(Graphics g)
	{		
		//creates board
		Color c1 = new Color(177,113,54); //darker squares
		Color c2 = new Color(233,174,65); //lighter squares

		g.setColor(c1);
		
		g.fillRect(0, 0, Chess.WIDTH, Chess.WIDTH);	//fills the entire board with the darker color
		
		g.setColor(c2);
		for(int i = 0; i<8; i++)	//creates squares based on the width of the board and fills them
		{
			for(int j = 0; j<8; j++)
			{
				if(i%2==j%2)
				{
				g.fillRect(i*(Chess.WIDTH/8), j*(Chess.WIDTH/8), (Chess.WIDTH/8), (Chess.WIDTH/8));
				}
				
			}
		}
		//creates initial structure of pieces on board
		//for loop goes through the p array and draws pieces where they are supposed to be
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				if(thechessmainobject.p[i][j]!=null)
				{
					thechessmainobject.p[i][j].drawPiece(((Chess.WIDTH/8)*j)+2, ((Chess.WIDTH/8)*i)+2, g);
				}
			}
		}	
	}
}