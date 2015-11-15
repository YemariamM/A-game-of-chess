import java.util.Random;

//Class Computer is the AI computer player
public class Computer {
	//coordinates
	public static int x1;
	public static int x2;
	public static int y1;
	public static int y2;	
	//method computerMove monitors the moves the computer makes
	//iterate through p array to find the right piece then choose a destination
	public static void computerMove()
	{
		Random rand = new Random();
		//Choosing a piece to move
		outer: for(int i = rand.nextInt(8) ; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				if(Chess.p[i][j] != null && Chess.p[i][j].color.equals("white"))
				{
					x1 = j;
					y1 = i;
					break outer;
					//break if it's the computer
					}
				}
			}
			//choosing a place to move
			outerloop: for(int i=0; i<8; i++)
			{
				for(int j=0; j<8; j++)
				{
					boolean isTrue = Chess.p[y1][x1].canMove(x1, y1, i, j);
					if(isTrue==true)
					{
						x2 = i;
						y2 = j;
						break outerloop;
						//break if the destination is valid
					}
				}
			}
		System.out.println("Computer moves " + Chess.p[y1][x1] +  Chess.p[y1][x1].color+ " to" + x2 + " " + y2);
	}		
}