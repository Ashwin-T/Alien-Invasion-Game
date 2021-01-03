import javax.swing.JPanel;
import java.awt.*; 
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;	
import javax.swing.ImageIcon;
import javax.swing.JLabel;
 
public class Screen extends JPanel implements KeyListener {
	
	RandomNumber rando = new RandomNumber();

    private Projectile proj;
	private Projectile proj1;
	private ProjectileEnemy projEnemy;
    private Ship ship;
	private Ship shipDemo;
	private Ship shipDemo2;
	private Star[] star;
	private Enemies[] ufo;
	private Enemies[] ufo2;
	private Enemies[] ufo3;
	private Enemies[] ufo4;
	


	private EnemiesBoss[] boss;
	private Asteriods[] ast;
	private Asteriods[] ast2;
	private AsteriodsInfin[] astInfin;
	private Health hpbar;
	private Health hpbarInf;

	
	private Asteriods[] ast4;
	
	
	//private ProjectileEnemy badProj;
	
	
	
	private int health = 3;
	private double score = 0;
	private boolean levelpassed = false;
	private boolean loadingscreen = true;
	private int levels = 0;
	private int numberOfTimesPassed = 0;
	private int currentLevel = 0;
	
	private int infiniteScore = 0;
	private int infinitelives = 1;

     
    public Screen(){
         
        ship = new Ship(50,300);
		shipDemo = new Ship(50,500);
		shipDemo2 = new Ship(-10,450);
        proj = new Projectile(ship.getX(),ship.getY());
		proj1 = new Projectile(ship.getX(),ship.getY());

		star = new Star[50];
		ufo = new Enemies[3];
		ufo2 = new Enemies[5];
		ufo3 = new Enemies[2];
		boss = new EnemiesBoss[1];
		ast = new Asteriods[5];
		ast2 = new Asteriods[8];
		
		astInfin = new AsteriodsInfin[13];

	
		
		hpbar = new Health(health);
		hpbarInf = new Health(infinitelives);
		
		
		for (int i = 0; i < star.length; i++){
			star[i] = new Star(rando.GetRandomNumberRandomX(100,800), rando.GetRandomNumberRandomY(0,600, 1));
		}
		for (int i = 0; i < ast.length; i++){
			double randomLV5 = rando.GetRandomNumberRandomX(-2,2);
			ast[i] = new Asteriods(820, rando.GetRandomNumberRandomY(25, 550, 1), randomLV5);
		}
		for (int i = 0; i < ast2.length; i++){
			double randomLV7 = rando.GetRandomNumberRandomX(-3,3);
			ast2[i] = new Asteriods(820, rando.GetRandomNumberRandomY(25, 550, 1), randomLV7);
		}
		
		for (int i = 0; i < astInfin.length; i++){
			double randomLV50 = rando.GetRandomNumberRandomX(-3,3);
			astInfin[i] = new AsteriodsInfin(rando.GetRandomNumberRandomX(820, 1100), rando.GetRandomNumberRandomY(25, 550, 1), randomLV50);
		}
		
		
		
		for (int i = 0; i < ufo.length; i++){
			ufo[i] = new Enemies(800, rando.GetRandomNumberRandomY(50, 500, 1));
		}
		for (int i = 0; i < ufo2.length; i++){
			ufo2[i] = new Enemies(800, rando.GetRandomNumberRandomY(50, 500, 1));
		}

		ufo3[0] = new Enemies(900, 100);
		ufo3[1] = new Enemies(850, 500);
		
		for (int i = 0; i < boss.length; i++){
			boss[i] = new EnemiesBoss(900,200);
			projEnemy = new ProjectileEnemy(boss[0].getX()+20,boss[0].getY()+50);
		}


		
		

		
		
		
		
        
		addKeyListener(this);
		setFocusable(true);
    }
 
    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800,600);
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
		Toolkit t= Toolkit.getDefaultToolkit();  

		
		if (levels == 0){
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			
			Image i=t.getImage("space_stars_sky_night_116649_800x600.JPG");  
			g.drawImage(i, 0,0,this);  
			
			Color green = new Color(0, 255,0);
			g.setColor(green);
			
			Font font1 = new Font("Times New Roman", Font.PLAIN, 50);
			g.setFont(font1);
			
			g.drawString("Welcome to Alien Invasion", 150, 200);
			Color white = new Color(255, 255,255);
			g.setColor(white);
			Font font2 = new Font("Times New Roman", Font.PLAIN, 25);
			g.setFont(font2);
			
			g.drawString("Press 'I' to Start Infin. Mode", 500, 500);
			g.drawString("Press 'S' to Start Reg. Mode", 500, 550);
			g.drawString("Press 'Q' for Instructions", 500, 450);	
			
			
			shipDemo.draw(g);
				
		}
		
		else if(levels == 1){
			Image l=t.getImage("Instructionsbackround.gif");
			g.drawImage(l, 0,0,this);  
			Color purple = new Color(255, 0, 255);
			g.setColor(purple);
			Font font1 = new Font("Times New Roman", Font.PLAIN, 50);
			g.setFont(font1);
			g.drawString("Instructions!", 275, 75);
			g.drawString("__________", 275, 75);

			
			Color white = new Color(255, 255,255);
			g.setColor(white);
			Font font2 = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font2);
			g.drawString("Move UP and DOWN using the 'ARROW' keys!", 75, 200);
			g.drawString("You can SHOOT lazers by using the 'SPACE BAR'!", 75, 275);
			g.drawString("ASTERIODS may be in orbit, be careful as they can DAMAGE your ship! SHOOT them with your lazers to break them!", 75, 350);
			
			g.drawString("Shoot all the enemies and win, BUT BEWARE as if they get past you, shoot you or collide with you", 75, 450);
			g.drawString("your LIVES will run out", 75, 475);
			g.drawString("If you LOSE all your lives, you LOSE THE GAME!", 75, 550);


			Color red = new Color(255, 0, 0);
			g.setColor(red);
			Font font3 = new Font("Times New Roman", Font.PLAIN, 10);
			g.setFont(font3);
			g.drawString("Press 'B' to go Back to the Main Screen", 575, 100);
			g.drawString("Get stuck during any levels or reach any problems?", 575, 150) ;
			g.drawString("Press 'R' to go Restart the game", 575, 175);
			

		}
		
		else if (levels == 2){
			
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			Image o =t.getImage("LoadingScreenbackground.JPG");
			g.drawImage(o, 0,0,this);  
			
			Color white = new Color(255, 255,255);
			g.setColor(white);
			Font font1 = new Font("Times New Roman", Font.PLAIN, 35);
			g.setFont(font1);
			g.drawString("Level 1: Kill the Scouting Enemy Ships",100, 300);
			
			
			Color red = new Color(255, 0, 0);
			g.setColor(red);
			Font font2 = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font2);
			g.drawString("Press 'M' to continue",10,25);
			
			
			
			shipDemo2.draw(g);
			
		}
			
		else if (levels == 3){//level 1
			
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			
			for(int i = 0; i < star.length; i++){	
				star[i].draw(g);
			}
			proj.draw(g);
			ship.draw(g);
			
			for (int i = 0; i < ufo.length; i++){
				ufo[i].draw(g);
			}
			Font font = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font);
			g.drawString(("Score: " + score), 700, 50);
			g.drawString(("HP: "), 30, 569);
			g.drawString(("Current Level: " + currentLevel), 600, 569);
			hpbar.draw(g);
			
			
			
			
		}
		
		else if (levels == 4){
			
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			Image o =t.getImage("LoadingScreenbackground.JPG");
			g.drawImage(o, 0,0,this);  
			
			Color white = new Color(255, 255,255);
			g.setColor(white);
			Font font1 = new Font("Times New Roman", Font.PLAIN, 35);
			g.setFont(font1);
			g.drawString("Level 2: Kill the Approaching Enemy Ships", 75, 300);
			Font font2 = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font2);
			g.drawString("Watch out for asteroids..", 25, 380);
			
			
			Color red = new Color(255, 0, 0);
			g.setColor(red);
			
			g.drawString("Press 'M' to continue",10, 25);
			
			
			
			shipDemo2.draw(g);
			
		}
		
		else if (levels == 5){//level 2
			
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			
			for(int i = 0; i < star.length; i++){	
				star[i].draw(g);
			}
			
			//planets.draw(g);
			
			proj.draw(g);
			//badProj.draw(g);
			ship.draw(g);
			
			for (int i = 0; i < ufo2.length; i++){
				ufo2[i].draw(g);
			}
			for (int i = 0; i < ast.length; i++){
				ast[i].draw(g);
			}
			g.setColor(Color.white);
			Font font = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font);
			g.drawString(("Score: " + score), 700, 50);
			
			g.drawString(("HP: "), 30, 569);
			g.drawString(("Current Level: " + currentLevel), 600, 569);
			hpbar.draw(g);
			
			
			
			
			
		}
		
		else if (levels == 6){
			
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			Image o =t.getImage("LoadingScreenbackground.JPG");
			g.drawImage(o, 0,0,this);  
			
			Color white = new Color(255, 255,255);
			g.setColor(white);
			Font font1 = new Font("Times New Roman", Font.PLAIN, 35);
			g.setFont(font1);
			g.drawString("Level 3: Kill the final Boss", 200, 300);
			
			
			Color red = new Color(255, 0, 0);
			g.setColor(red);
			
			Font font = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font);
			
			g.drawString("Press 'M' to continue",10, 25);
			
			
			
			shipDemo2.draw(g);
			
		}
		
		else if (levels == 7){//level Final
			
						
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			
			for(int i = 0; i < star.length; i++){	
				star[i].draw(g);
			}
			
			//planets.draw(g);
			
			proj.draw(g);
			//badProj.draw(g);
			ship.draw(g);
			
			for (int i = 0; i < boss.length; i++){
				boss[i].draw(g);
				projEnemy.draw(g);
			}
			for (int i = 0; i < ast2.length; i++){
				ast2[i].draw(g);
			}
			for (int i = 0; i < ufo3.length; i++){
				ufo3[i].draw(g);
			}
			g.setColor(Color.white);
			Font font = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font);
			g.drawString(("Score: " + score), 700, 50);
			
			g.drawString(("HP: "), 30, 569);
			g.drawString(("Current Level: " + currentLevel), 600, 569);
			hpbar.draw(g);
			
			
			
		}
		else if (levels == 8){
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			
			for(int i = 0; i < star.length; i++){	
				star[i].draw(g);
			}
			ship.draw(g);
		}
		
		else if (levels == 9){
			
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			Image o =t.getImage("LoadingScreenbackground.JPG");
			g.drawImage(o, 0,0,this);  
			
			Color white = new Color(255, 255,255);
			g.setColor(white);
			Font font1 = new Font("Times New Roman", Font.PLAIN, 35);
			g.setFont(font1);
			g.drawString("GAME OVER!", 300, 300);	
			
			
			Color red = new Color(255, 0, 0);
			g.setColor(red);
			
			Font font = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font);
			
			g.drawString("Press 'R' to retry!",10, 550);
			
				
		}
		else if (levels == 10){
			
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			Image o =t.getImage("Winscreen.JPG");
			g.drawImage(o, 0,0,this);  
			
			Color white = new Color(255, 255,255);
			g.setColor(white);
			Font font1 = new Font("Times New Roman", Font.PLAIN, 35);
			g.setFont(font1);
			g.drawString("YOU WIN CONGRATULATIONS!", 135, 300);	
			
			
			Color red = new Color(255, 0, 0);
			g.setColor(red);
			
			Font font = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font);
			
			g.drawString("Press 'R' to play again!",10, 550);
			
				
		}
		else if(levels == 48){
			
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			Image o =t.getImage("LoadingScreenbackground.JPG");
			g.drawImage(o, 0,0,this);  
			
			Color white = new Color(255, 255,255);
			g.setColor(white);
			Font font1 = new Font("Times New Roman", Font.PLAIN, 35);
			g.setFont(font1);
			g.drawString("Infinite Mode: Dodge all the Asteriods",100, 300);
			Font font = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font);
			g.drawString("The more you dodge the more points you score!",100, 350);
			g.setColor(Color.red);
			g.drawString("WARNING: You only have ONE LIFE!",100, 375);


			
			
			Color red = new Color(255, 0, 0);
			g.setColor(red);
			Font font2 = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font2);
			g.drawString("Press 'M' to continue",10,25);
			
			
			
			shipDemo2.draw(g);
			
		}
		else if (levels == 49){
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			
			for(int i = 0; i < star.length; i++){	
				star[i].draw(g);
			}
			
			ship.draw(g);
			proj1.draw(g);

			
			for (int i = 0; i < astInfin.length; i++){
				astInfin[i].draw(g);
			}
			
			Color white = new Color(255, 255,255);
			g.setColor(white);			
			Font font = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font);
			g.drawString(("Score: " + (astInfin[0].getScore())), 700, 50);
			g.drawString(("HP: "), 30, 569);
			hpbarInf.draw(g);
			

			
		}
		
		else if (levels == 50){
			g.setColor(Color.black);
			g.fillRect(0, 0, 800, 600);
			Image o =t.getImage("LoadingScreenbackground.JPG");
			g.drawImage(o, 0,0,this);  
			
			Color white = new Color(255, 255,255);
			g.setColor(white);
			Font font1 = new Font("Times New Roman", Font.PLAIN, 35);
			g.setFont(font1);
			g.drawString("GAME OVER!", 300, 300);	
			
			
			Color red = new Color(255, 0, 0);
			g.setColor(red);
			
			Font font = new Font("Times New Roman", Font.PLAIN, 15);
			g.setFont(font);
			
			g.drawString("Press 'R' to retry!",10, 550);
			g.setColor(white);
			g.drawString(("Score: " + (astInfin[0].getScore())), 700,50);
		}
		
		
		
	}
		
    public void animate(){
         
        while(true){
            //wait for .01 second
            try {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
			
			//general updates without need for levels
			if(proj.getX() > 1000){
				proj.updatePos(ship.getX()+5,ship.getY()+7);
			}
			if(proj1.getX() > 1000){
				proj1.updatePos(ship.getX()+5,ship.getY()+7);
			}
	
			proj.updateY(ship.getY()+7);
			proj.fire(proj.getShot());
			
			
			proj1.updateY(ship.getY()+7);
			proj1.fire(proj1.getShot());


			
			
			//levels
			if (levels == 2){
				
				shipDemo2.move();

			}
			
			
			else if (levels == 3){
				currentLevel = 1;
				levelpassed = false;
				for(int i = 0; i < star.length; i++){
					star[i].move();
				}
				for (int i = 0; i < ufo.length; i++){
					ufo[i].move(0.25);
				}
				for (int i = 0; i < ufo.length; i++){
					if ((ufo[i].passedCheck()) == true){
						ufo[i].reset();
						ship.reset();
						score = 0;
						numberOfTimesPassed++;
						if (numberOfTimesPassed == 3){
							health--;
							hpbar.update(health);
							numberOfTimesPassed = 0;
						}
					}
				}
				
				for (int i = 0; i < ufo.length; i++){
					if (ufo[i].colisionDetected(proj.getX(), proj.getY())){
						proj.colisonupdater(ufo[i].colisionDetected(proj.getX(), proj.getY()));
						score++;
						if (score == 3){
							levels = 4;
						}
					}
				}
				
				for (int i = 0; i < ufo.length; i++){
					if (ufo[i].colisionDetected(ship.getX()+45, ship.getY())){
						proj.colisonupdater(ufo[i].colisionDetected(ship.getX(), ship.getY()));
						for (int c = 0; c < ufo.length; c++){
							ufo[c].reset();
						}
						ship.reset();
						score = 0;
						health--;
						hpbar.update(health);
					}
				}
				
				
				if (score == 3){
					levels = 4;
				}

				
			}
			
			else if (levels == 4){
				
				shipDemo2.move();

			}
			
			else if (levels == 5){
				currentLevel = 2;
				levelpassed = false;
				//planets.move();
				for (int i = 0; i < ufo2.length; i++){
					ufo2[i].move(1);
				}
				//checks for passed
				for (int i = 0; i < ufo2.length; i++){
					if ((ufo2[i].passedCheck()) == true){
						ufo2[i].reset();
						ship.reset();
						score = 3;
						numberOfTimesPassed++;
						if (numberOfTimesPassed == 3){
							health--;
							hpbar.update(health);
							numberOfTimesPassed = 0;
						}
					}
				}
				for (int i = 0; i < ufo2.length; i++){
					if (ufo2[i].colisionDetected(proj.getX(), proj.getY())){
						proj.updateX(1001);
						score++;
						if (score == 8){
							levels = 6;
						}
						
					}
				}
				for (int i = 0; i < ufo2.length; i++){
					if (ufo2[i].colisionDetected(ship.getX()+45, ship.getY())){
						proj.colisonupdater(ufo2[i].colisionDetected(ship.getX(), ship.getY()));
						for (int c = 0; c < ufo2.length; c++){
							ufo2[c].reset();
						}
						ship.reset();
						score = 3;
						health--;
						hpbar.update(health);
					}

				}
				if (score == 8){
					levels = 6;
				}
				
				for (int i = 0; i < ast.length; i++){
					ast[i].move();
				}
				for (int i = 0; i < ast.length; i++){
					if (ast[i].colisionDetected(ship.getX()+35, ship.getY())){
						ship.reset();
						score = 3;
						health--;
						hpbar.update(health);
						for (int a = 0; a < ast.length; a++){
							ast[a].reset();
						}
						for (int j = 0; j < ufo2.length; j++){
							ufo2[j].reset();
						}
					}
				}
				for (int i = 0; i < ast.length; i++){	
					if (ast[i].colisionDetected(proj.getX(), proj.getY())){
						proj.updateX(1001);
					}
				}
				for(int i = 0; i < star.length; i++){
					star[i].move();
				}

				if (health < 1){
				levels = 9;
				}

			}
			
			else if (levels == 6){
				
				shipDemo2.move();

			}
			
			else if (levels == 7){
				currentLevel = 3;
				levelpassed = false;
				projEnemy.fire();
				if (projEnemy.getX() < -200){
					projEnemy.updatePos(boss[0].getX()+20,boss[0].getY()+50);
				}
				for (int i = 0; i < boss.length; i++){
					boss[i].move();
				}
				//checks for passed
				for (int i = 0; i < boss.length; i++){
					if ((boss[i].passedCheck()) == true){
						boss[i].reset();
						ship.reset();
						score = 8;
						health -= 1;
						hpbar.update(health);
						}
					}
				for (int i = 0; i < boss.length; i++){
					if (boss[i].colisionDetected(proj.getX(), proj.getY())){
						proj.updateX(1001);
						boss[i].updateShown();
						if (boss[i].getnumberTimesHit() <= 0){
							score++;
							projEnemy.changeshot();
						}

						if (score == 11){
							levels = 8;
						}
						
					}
				}
				for (int i = 0; i < boss.length; i++){
					if (boss[i].colisionDetected(ship.getX()+45, ship.getY())){
						//proj.colisonupdater(boss[i].colisionDetected(ship.getX(), ship.getY()));
						boss[i].reset();
						ship.reset();
						ufo3[0].reset();
						ufo3[1].reset();
						ufo3[0].updatePosEnemy(900,100);
						ufo3[1].updatePosEnemy(900,500);
						for (int a = 0; a < ast2.length; a++){
							ast2[a].reset();
						}
						score = 8;
						health--;
						hpbar.update(health);
					}

				}
				if (projEnemy.colisionDetected(ship.getX()+45, ship.getY())){
						//proj.colisonupdater(boss[i].colisionDetected(ship.getX(), ship.getY()));
						boss[0].reset();
						ship.reset();
						ufo3[0].reset();
						ufo3[1].reset();
						ufo3[0].updatePosEnemy(900,100);
						ufo3[1].updatePosEnemy(900,500);
						for (int a = 0; a < ast2.length; a++){
							ast2[a].reset();
						}
					
						score = 8;
						health--;
						hpbar.update(health);
				}

				
	
				//planets.move();
				for (int i = 0; i < ufo3.length; i++){
					ufo3[i].move(0.5);
				}
				//checks for passed
				for (int i = 0; i < ufo3.length; i++){
					if ((ufo3[i].passedCheck()) == true){
						ufo3[i].reset();
						ufo3[0].updatePosEnemy(900,100);
						ufo3[1].updatePosEnemy(900,500);
						for (int a = 0; a < ast2.length; a++){
							ast2[a].reset();
						}
						ship.reset();
						score = 8;
						numberOfTimesPassed++;
						if (numberOfTimesPassed == 2){
							health--;
							hpbar.update(health);
							numberOfTimesPassed = 0;
						}
					}
				}
				for (int i = 0; i < ufo3.length; i++){
					if (ufo3[i].colisionDetected(proj.getX(), proj.getY())){
						proj.updateX(1001);
						score++;
						if (score == 11){
							levels = 8;
						}
						
					}
				}
				for (int i = 0; i < ufo3.length; i++){
					if (ufo3[i].colisionDetected(ship.getX()+45, ship.getY())){
						proj.colisonupdater(ufo3[i].colisionDetected(ship.getX(), ship.getY()));
						for (int c = 0; c < ufo3.length; c++){
							ufo3[c].reset();
						}
						ufo3[0].updatePosEnemy(900,100);
						ufo3[1].updatePosEnemy(900,500);
						ship.reset();
						score = 8;//mistake of last draft
						health--;
						boss[0].reset();//mistake of last draft
						hpbar.update(health);
					}

				}
				if (score == 11){
					levels = 8;
				}
				
				for (int i = 0; i < ast2.length; i++){
					ast2[i].move();
				}
				for (int i = 0; i < ast2.length; i++){
					if (ast2[i].colisionDetected(ship.getX()+35, ship.getY())){
						ship.reset();
						score = 8;
						health--;
						hpbar.update(health);
						for (int a = 0; a < ast2.length; a++){
							ast2[a].reset();
						}
						for (int j = 0; j < ufo3.length; j++){
							ufo3[j].reset();
						}
						ufo3[0].updatePosEnemy(900,100);
							ufo3[1].updatePosEnemy(900,500);
						for (int b = 0; b< boss.length; b++){
						boss[b].reset();
						}
					}
				}
				for (int i = 0; i < ast2.length; i++){	
					if (ast2[i].colisionDetected(proj.getX(), proj.getY())){
						proj.updateX(1001);
					}
				}
				for(int i = 0; i < star.length; i++){
					star[i].move();
				}

				if (health < 1){
				levels = 9;
				}
			}
			
			else if (levels == 8){
				ship.move();
				for(int i = 0; i < star.length; i++){
					star[i].move();
				}
				if (ship.getX() > 810){
					levels = 10;
				}
			}
			
			else if(levels == 48){
				shipDemo2.move();
			}

			else if (levels == 49){
				for(int i = 0; i < star.length; i++){
					star[i].move();
				}
				for (int i = 0; i < astInfin.length; i++){
					if (astInfin[i].colisionDetected(ship.getX()+35, ship.getY())){
						ship.reset();
						infinitelives--;
						hpbarInf.update(infinitelives);
						}
					}
				for (int i = 0; i < astInfin.length; i++){	
					if (astInfin[i].colisionDetected(proj1.getX(), proj1.getY())){
						proj1.updateX(2001);
					}
				}
				for (int i = 0; i < astInfin.length; i++){	
					astInfin[i].move();
				}
				for(int i = 0; i < star.length; i++){
					star[i].move();
				}

				if (infinitelives < 1){
				levels = 50;
				}				
				
				
				
			}
			
			if (levels % 2 == 0){
				loadingscreen = true;
			}
			else{
				loadingscreen = false;
			}
			
            //repaint the graphics drawn
            repaint();
 
		}
	}
	
	public void keyPressed(KeyEvent e){
	
			//System.out.println(e.getKeyCode());	//prints the keycode of the key being pressed
		

			if(e.getKeyCode() == 32){ //space bar
				//shoot the projectile
				proj.shotTrue();
				proj1.shotTrue();
			}
			if (e.getKeyCode() == 73){
				levels = 48;
			}
			else if ((e.getKeyCode() == 38)||(e.getKeyCode() == 87)){
				ship.moveUp();
			}
			else if(((e.getKeyCode() == 40)||(e.getKeyCode() == 83)) && (levels != 0)){
				ship.moveDown();
			}
			else if(e.getKeyCode() == 67){ //c key
				//shoot the target projectile
			}
			else if(e.getKeyCode() == 82) {//r key
				levels = 0;
				health = 3;
				hpbar.update(health);
				score = 0;
				levelpassed = false;
				infiniteScore = 0;
				infinitelives = 1;
				hpbarInf.update(infinitelives);
				for (int i = 0; i < ufo.length; i++){
					ufo[i].reset();
				}	
				for (int i = 0; i < ufo2.length; i++){
					ufo2[i].reset();
				}
				for (int i = 0; i < ufo3.length; i++){
					ufo3[i].reset();
					ufo3[0].updatePosEnemy(900,100);
					ufo3[1].updatePosEnemy(900,500);
				}
				for (int i = 0; i < ast.length; i++){
					ast[i].reset();
				}
				for (int i = 0; i < ast2.length; i++){
					ast2[i].reset();
				}
				for (int i = 0; i < astInfin.length; i++){
					astInfin[i].reset();
				}
				for (int i = 0; i< boss.length; i++){
					boss[i].reset();
				}
				projEnemy.reset();
				ship.reset();
				
			}
			else if(e.getKeyCode() == 81){ //Q key
				levels = 1;
			}
			else if ((e.getKeyCode() == 83) && (levels == 0)){ //s key
				levels = 2;
			}
			else if ((e.getKeyCode() == 77) && (loadingscreen == true)){ //m key
				levels++;
			}
			else if ((e.getKeyCode() == 66) && (levels == 1)){ //b key
				levels--;
			}
			else if (e.getKeyCode() == 80){ //p
					if (levels == 3){
						score = 3;
					}
					if (levels == 5){
						score = 8;
					}
					if (levels == 10){
						levels = 0;
					}
					else{
						levels++;
					}
					//health = 3;
			}
		
	}
	
	public void keyReleased(KeyEvent e){
	}
	public void keyTyped(KeyEvent e){
		
	}
	
}
