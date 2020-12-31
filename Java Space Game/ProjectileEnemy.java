import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class ProjectileEnemy{

  private int x, y, xSet, ySet;
  private boolean shot;
  private boolean visible = false;
  
    public ProjectileEnemy(int xL, int yL){	
		
		this.x = xL;
		xSet = xL;
		ySet = yL;
        this.y = yL;
		shot = true;
    }
	/*
	public void shotTrue(){
		visible = true;
		shot = true;
	}
	public void shotFalse(){
		shot = false;
	}
	public boolean getShot(){
		return shot;
	}
	*/
	
	public void updatePos(int x0, int y0){
		this.x = x0;
		this.y = y0;
	}
	public void updateY(int yT){
		this.y = yT;
	}
	public void updateX(int xT){
		this.x = xT;
	}
	
	public void fire(){
		this.x -= 12;
	}

	
	public void debugPos(){
		System.out.println("("+this.x +", " + this.y +")");
	}
	

    public void draw(Graphics g) {
			if (shot == true){
				Color green = new Color(0, 255, 0);
				g.setColor(green);
				g.fillRect(x,y, 30, 20);
			}
	}
	public int getX(){
		
		return (x);
	} 
	public int getY(){
		
		return (y);
	} 
	public void changeshot(){
		shot = false;;
	}

	public void colisonupdater(boolean hit){
		if (hit == true){
			this.x = -10;
		}
				
	}
	public boolean colisionDetected(int missleX, int missleY){
		if (shot == true){
			if ((((missleX) <= 1.05 * this.x) && ((missleX) >= 0.95* this.x)) && (((missleY) >= -2 + this.y) && (missleY <= (20+ this.y)))){
				return (true);
			}
		}
		return (false);		
	}
	public void reset(){
		shot = true;
		this.x = xSet;
		this.y = ySet;
	}
	
	
	
    	
}

    
  