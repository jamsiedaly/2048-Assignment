package twentyFortyEight.exercise.game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import twentyFortyEight.exercise.Application;
import twentyFortyEight.exercise.gameobject.GameSquare;
import twentyFortyEight.exercise.gameobject.GameSquareFactory;
import twentyFortyEight.exercise.graphics.Renderer;
import twentyFortyEight.exercise.input.Keyboard;

public class Game {

	public static List<GameSquare> objects;
	
	public static boolean moving = false, hasMoved = true, somethingIsMoving = false;
	public static int dir = 0;
	
	private Random rand = new Random();
	private GameSquareFactory squareFactory = new GameSquareFactory();
	
	public Game() {
		init();
	}

	public void init() {
		objects = new ArrayList<GameSquare>();
		moving = false;
		hasMoved = true;
		somethingIsMoving = false;
		spawn();
	}

	public void update() {
		if(Keyboard.keyUp(KeyEvent.VK_R)) {
			init();
		}
		
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).update();
		}
		
		checkForValueIncrease();
		
		movingLogic();
	}
	

// You going to iterate over all our tiles.
// If two tiles are occupying the same square and are the same value, they can be merged.
// Remember that the product of all new tiles must be the sum of the two previous tiles.
// The old tiles must be removed from the list of objects after merging
	private void checkForValueIncrease() {
	}

//	Tiles must be spawnd on a random square
//	The square must be empty
	private void spawn() {
		objects.add(squareFactory.createNewSquare(0, 0));
	}

	private void movingLogic() {
		somethingIsMoving = false;
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i).moving) {
				somethingIsMoving = true;
			}
		}
		if(!somethingIsMoving) {
			moving = false;
			for(int i = 0; i < objects.size(); i++) {
				objects.get(i).hasMoved = false;
			}
		}
		if(!moving && hasMoved) {
			hasMoved = false;
		}
		if(!moving && !hasMoved) {
			if(Keyboard.keyDown(KeyEvent.VK_A)) {
				hasMoved = true;
				moving = true;
				dir = 0;
			}else if(Keyboard.keyDown(KeyEvent.VK_D)) {
				hasMoved = true;
				moving = true;
				dir = 1;
			}else if(Keyboard.keyDown(KeyEvent.VK_W)) {
				hasMoved = true;
				moving = true;
				dir = 2;
			}else if(Keyboard.keyDown(KeyEvent.VK_S)) {
				hasMoved = true;
				moving = true;
				dir = 3;
			}
		}
	}
	
	public void render() {
		Renderer.renderBackground();

		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).render();
		}
		
		for(int i = 0; i < Application.pixels.length; i++) {
			Application.pixels[i] = Renderer.pixels[i];
		}
	}
	
	public void renderText(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font("Verdana", 0, 100));
		g.setColor(Color.BLACK);
		
		for(int i = 0; i < objects.size(); i++) {
			GameSquare o = objects.get(i);
			String s = (int)(Math.pow(0.5, o.value.ordinal() + 1)) + "";
			int sw = (int) (g.getFontMetrics().stringWidth(s) / 2 / Application.scale);
			g.drawString(s, (int) (o.x + o.width / 2 - sw) * Application.scale, (int) (o.y + o.height / 2 + 18) * Application.scale);
		}
		
	}	
}
