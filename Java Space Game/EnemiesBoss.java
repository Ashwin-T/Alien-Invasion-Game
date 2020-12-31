import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Polygon;

public class EnemiesBoss{

	private int x, y, levels, yS, yT, xSet, ySet;
	boolean shown;
	boolean passed;
	int score = 0;
	int numberTimesHit = 10;
	
    public EnemiesBoss(int xL, int yL){	
		
		this.x = xL;
		xSet = xL;
		ySet = yL;
        this.y = yL;	
		shown = true;
		yS = this.y;
		yT = 1;
		passed = false;
		
    }

    public void draw(Graphics g) {
		
		if (shown == true){
			Color lightBlue = new Color(35, 172, 196);
			g.setColor(lightBlue);
			
			g.fillOval(x,y, 120,120);
			
			/*
			Color alienGreen = new Color(75,255,75);
			g.setColor(alienGreen);
			g.fillOval(x+10,y+15, 20, 10);
			*/

			Color grey = new Color(211,211,211);
			g.setColor(grey);
			
			g.fillOval(x-60, y+60, 240, 80);
			
			g.setColor(Color.black);
			Font font = new Font("Times New Roman", Font.PLAIN, 25);
			g.setFont(font);
			g.drawString(String.valueOf(numberTimesHit), x+50, y+100);
		}	
    }
	
	public int getX(){
		
		return (x);
	} 
	public int getY(){
		
		return (y);
	} 
	
	public void move(){
		if (shown){
			this.x -= 0.5;
		
		
			if (this.x < 15){
				passed = true;
			}
		}
	}
	
	public boolean passedCheck(){
		
		return(passed);
		
	}
	public boolean colisionDetected(int missleX, int missleY){
		if (shown == true){
			if ((((missleX) <= 1.05 * this.x) && ((missleX) >= 0.95* this.x)) && (((missleY) >= -2 + this.y) && (missleY <= (2 * this.y)))){
				numberTimesHit--;
				if (numberTimesHit <= 0){
					shown = false;
				}	
				return (true);
			}
		}
		return (false);		
	}
	public void updatePosEnemy(int xT, int yT){
		this.x = xT;
		this.y = yT;
	}
	
	public int getnumberTimesHit(){
		return (numberTimesHit);
	}
	
	public void updateShown(){
		if (numberTimesHit <= 0){
			shown = false;
		}
	}
	
	public void updateX(int xT){
		this.x = xT;
	}
		
	public void reset(){
		
		this.x = xSet;
		
		this.y = ySet;
		shown = true;
		yS = this.y;
		yT = 1;
		passed = false;
		numberTimesHit = 10;
		
	}


	

    
}