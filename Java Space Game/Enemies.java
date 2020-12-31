import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Polygon;

public class Enemies{

	private int x, y, levels, yS, yT, xSet, ySet;
	boolean shown;
	boolean passed;
	int score = 0;
	
    public Enemies(int xL, int yL){	
		
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
			
			g.fillOval(x,y, 40,40);
			
			Color alienGreen = new Color(75,255,75);
			g.setColor(alienGreen);
			g.fillOval(x+10,y+15, 20, 10);

			Color grey = new Color(211,211,211);
			g.setColor(grey);
			
			g.fillOval(x-20, y+20, 80, 20);
		}
		
		
		

    }
	
	public int EnemiesgetX(){
		
		return (x);
	} 
	public int EnemiesgetY(){
		
		return (y);
	} 
	
	public void move(double item){
		this.x -= item;
		
		this.y += yT;
		if (this.y <= 0){
			yT = +3;
		}
		if (this.y >= 590){
			yT = -3;
		}
		
		if(this.y >= (yS + 12)){
			yT = -1;
		}
		else if(this.y <= (yS - 12)){
			yT = 1;
		}
		
		if (this.x < 15){
			passed = true;
		}
	}
	
	public boolean passedCheck(){
		
		return(passed);
		
	}
	public boolean colisionDetected(int missleX, int missleY){
		if (shown == true){
			if ((((missleX) <= 1.05 * this.x) && ((missleX) >= 0.95* this.x)) && (((missleY) >= -2 + this.y) && (missleY <= (1.35 * this.y)))){
				shown = false;
				return (true);
			}
		}
		return (false);		
	}
	public void updateShow(){
		shown = false;
	}
	public void updatePosEnemy(int xT, int yT){
		this.x = xT;
		this.y = yT;
	}
	public int updateScore(){
		return score;
	}
	public void updateX(int xT){
		this.x = xT;
	}
		
	public void reset(){
		
		this.x = xSet;
		
		this.y = (int)(Math.random() * (550 - (50) + 1) + 50);
		shown = true;
		yS = this.y;
		yT = 1;
		passed = false;
		
	}


	

    
}