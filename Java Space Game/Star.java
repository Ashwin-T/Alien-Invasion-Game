import java.awt.Graphics;	
import java.awt.Color;
import java.awt.Polygon;
import java.util.Random;

public class Star{

  int x, y;

    public Star(int xL, int yL){
        x = xL;
        y = yL;
		

    }

    public void draw(Graphics g){
		
		Color bannana = new Color(252, 244, 163);
		g.setColor(Color.yellow);
		g.fillOval(x,y,5,5);
	
    }
	public void move(){
		x -= 2;
		if(x <= -5){
			x = 803;
			y = (int)(Math.random() * (600 - 0 + 1) + 0);
		}
		
			
	}
}