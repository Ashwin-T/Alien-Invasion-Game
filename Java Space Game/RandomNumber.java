import java.util.Scanner;
import java.util.Random;
public class RandomNumber
{
	public RandomNumber(){
		
	}
	
	public int GetRandomNumberRandomX(int minX, int maxX)
	{
	//Generate random int value
		int random_intx = (int)(Math.random() * (maxX - minX + 1) + minX);
		return(random_intx);
	}
	public int GetRandomNumberRandomY(int minY, int maxY, int i)
	{
	//Generate random int value
		int random_intY = (int)(Math.random() * (maxY - minY + 1) + minY);
		return(random_intY);
	}
}	