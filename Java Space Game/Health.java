import java.awt.Graphics;	
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Font;

public class Health{

  private int health;
  
  private int x = 75;
  private int y = 550;
  Font font = new Font("Times New Roman", Font.PLAIN, 15);
  

    public Health(int heal){
       health = heal;
	   
		

    }

    public void draw(Graphics g){
		
		g.setColor(Color.white);
		g.fillRect(x,y,162,28);
		g.setColor(Color.green);
		if (health == 3){
			g.setColor(Color.green);
			g.fillRect(x+6, y+4, 150, 20);
		}
		if (health == 2){
			g.setColor(Color.yellow);
			g.fillRect(x+6, y+4, 100, 20);
			g.setFont(font);
			g.drawString(("Warning shields have been breached. Health levels at: " + health), 25, 50);
		}
		if (health == 1){
			g.setColor(Color.red);
			g.fillRect(x+6, y+4, 50, 20);
			g.setFont(font);
			g.drawString(("Warning hull have been damaged. Health levels at: " + health), 25, 50);
		}
		g.setColor(Color.black);
		g.drawLine(x+106, y, x+106, y+28);
		g.drawLine(x+56, y, x+56, y+28);
		
		
		
	
    }
	public void update(int lives){
		 health = lives;			
	}
	public int getHealth(){
		return health;
	}
}