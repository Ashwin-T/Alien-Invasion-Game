import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class AsteriodsInfin{
	private int x, y, xSet, ySet;
	private Color rust;
	double yMove;
	boolean shown = true;
	int hitScore;
	int score;

	
	public AsteriodsInfin(int xL, int yL, double moveY){
		
		x = xL;
		y = yL;
		yMove = moveY;
		xSet = xL;
		ySet = yL;
		
		
		
		
		
		rust = new Color(165,150,146);

	}
	
	public void draw(Graphics g){
		
		
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
	
	public void move(){
		if (returnHitscore() < 3){
			this.x -= 5;
		}
		if ((returnHitscore() > 3) && (returnHitscore() < 7)){
			this.x -= 6;
		}
		if ((returnHitscore() > 7) && (returnHitscore() < 11)){
			this.x -= 7;
		}
		if (returnHitscore() > 14){
			this.x -=10;
		}
		
		
		this.y += yMove;
			
		
		if(this.x < -25){
			this.x = (int)(Math.random() * (925 - (820) + 1) + 820);
			yMove = (int)(Math.random() * (2 - (-2) + 1) + -2);
			score++;
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
		return(this.y);
	}
	public int getScore(){
		return (score);
	}
	
	public boolean colisionDetected(int missleX, int missleY){
		if ((((missleX) >= 0.9*this.x) && ((missleX) <= 1.2*this.x))  && ((missleY >= this.y) && (missleY <= (this.y +45)))){
			hitScore++;
			reset();
			return (true);
		}	
		return (false);
	
	}
	public int returnHitscore(){
		return hitScore;
	}
	public void reset(){
		this.x = xSet;
		this.y = ySet;
		//shown = true;
		
		
	}
}