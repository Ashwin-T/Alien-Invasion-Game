import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Polygon;

public class Ship{

  private int x, y, xSet, ySet;
  

    public Ship(int xL, int yL){	
		
		this.x = xL;
        this.y = yL;
		xSet = xL;
		ySet = yL;
			
    }

    public void draw(Graphics g) {
		//head
		Color lightPurple = new Color(138,43,226);
		g.setColor(lightPurple);	
		g.fillOval(x+50, y, 20,20); 
		//body
		Color cream = new Color(255,253,208);
		g.setColor(cream);
		g.fillRect(x,y, 60, 20);
		//wings
		
		Polygon wingTop = new Polygon();
		g.setColor(lightPurple);
		wingTop.addPoint(x+5,y);
		wingTop.addPoint(x+5,y-20);
		wingTop.addPoint(x+25,y);
		g.fillPolygon(wingTop);
		
		Polygon wingBottom = new Polygon();
		wingBottom.addPoint(x+5,y+20);
		wingBottom.addPoint(x+5,y+40);
		wingBottom.addPoint(x+25,y+20);
		g.fillPolygon(wingBottom);

		//fireFlames
		Color flameColor = new Color(255, 35, 13);
		g.setColor(flameColor);
		Polygon flame = new Polygon();
		flame.addPoint(x, y+3);
		flame.addPoint(x, y+17);
		flame.addPoint(x-10, y+10);
		g.fillPolygon(flame);		

    }
	
	public int getX(){
		
		return (x);
	} 
	public int getY(){
		
		return (y);
	} 
	public void moveUp(){
		if(y>25){
			y -= 10;
		}
	}
	public void moveDown(){
		if(y<560){
			y += 10;
		}
	}
	public void reset(){
		this.x = xSet;
		this.y = ySet;
	}
	public void move(){
		this.x +=3;
		if (this.x > 825){
			this.x = -10;
		}
	}

    
}