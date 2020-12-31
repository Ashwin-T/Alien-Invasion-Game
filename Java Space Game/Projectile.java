import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Projectile{

  private int x, y, shIx, shIy;
  private boolean shot;
  private boolean visible = false;
  
    public Projectile(int xL, int yL){	
		
		this.x = xL;
        this.y = yL;
		shot = false;
    }
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
	
	public void updatePos(int x0, int y0){
		this.x = x0;
		this.y = y0;
		shot = false;
	}
	public void updateY(int yT){
		this.y = yT;
	}
	public void updateX(int xT){
		this.x = xT;
	}
	
	public void fire(boolean shot){
		if (shot == true){
			this.x += 25;
		}
	}
	public void move(int xL, int yL){
		this.x = xL;
		this.y = yL;
	}
	
	public void debugPos(){
		System.out.println("("+this.x +", " + this.y +")");
	}
	

    public void draw(Graphics g) {
		if (shot == true){
			Color red = new Color(255, 0, 0);
			g.setColor(red);
			g.fillRect(x,y, 20, 10);
		}
	}
	public int getX(){
		
		return (x);
	} 
	public int getY(){
		
		return (y);
	} 
	public boolean getVisible(){
		return (visible);
	}
	public boolean colisonupdater(boolean hit){
		if (hit == true){
			this.x = 1001;
		}
		return (false);
				
	}
	
	
	
    	
}

    
  