import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Asteriods{
	private int x, y, xSet, ySet;
	private Color rust;
	double yMove;
	boolean shown = true;

	
	public Asteriods(int xL, int yL, double moveY){
		
		x = xL;
		y = yL;
		yMove = moveY;
		xSet = xL;
		ySet = yL;
		
		
		
		
		
		rust = new Color(165,150,146);

	}
	
	public void draw(Graphics g){
		
		
		if (shown == true){
		Color moongrey = new Color(0,0,0);
		g.setColor(rust);
		g.fillOval(x, y, 50,50);


		g.setColor(moongrey);

      //draws craters
		g.drawOval(x+10, y+10, 10, 10);
		g.drawOval(x+25, y+35, 7, 7);
		g.drawOval(x+30, y+20, 5, 5);
		
		/*
		Color lightblueSteel = new Color(176, 196, 222);
		g.setColor(lightblueSteel);
		g.fillRect(x+60, y+ 17, 10, 5);
		g.fillRect(x+60, y+ 23, 10, 5);
		Color medSlate = new Color(123, 104, 238);
		g.setColor(medSlate);
		g.fillRect(x+60, y+	28, 10, 5);
		*/
		}	

		
	}
	
	public void move(){
		this.x -= 5;
		
		this.y += yMove;
			
		
		if(this.x < -75){
			this.x = 810;
			yMove = (int)(Math.random() * (2 - (-2) + 1) + -2);
		}
		else if (y < -12){
			this.y = 615;
		}
		else if (y > 620){
			this.y = -10;
			//yMove = yMove * -1;
		}
	}
	
	public int getX(){
		return(this.x);
	}
	public int getY(){
		return(this.x);
	}
	
	public boolean colisionDetected(int missleX, int missleY){
		if (shown == true){
			if ((((missleX) >= 0.9*this.x) && ((missleX) <= 1.2*this.x))  && ((missleY >= this.y) && (missleY <= (this.y +45)))){
				shown = false;
				return (true);
			}
		}
		return (false);		
	}
	public void reset(){
		this.x = xSet;
		this.y = ySet;
		shown = true;
		//shown = true;
		
		
	}
}