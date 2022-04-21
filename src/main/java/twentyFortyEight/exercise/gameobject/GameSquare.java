package twentyFortyEight.exercise.gameobject;

import java.util.Random;
import twentyFortyEight.exercise.Application;
import twentyFortyEight.exercise.game.Game;
import twentyFortyEight.exercise.graphics.Renderer;
import twentyFortyEight.exercise.graphics.Sprite;

public class GameSquare {

	public double x, y;
	public int width, height;
	public Sprite sprite;
	public int speed = 8;
	public boolean moving = false, remove = false, hasMoved = false;
	public final GameSquareNumber value;
	
	private Random rand = new Random();
	private GameSquareFactory squareFactory = new GameSquareFactory();

	protected GameSquare(double x, double y, GameSquareNumber number) {
		this.x = x;
		this.y = y;
		this.value = number;
		this.sprite = createSprite(this.value);
		this.width = sprite.width;
		this.height = sprite.height;
	}

	protected GameSquare(double x, double y) {
		this.x = x;
		this.y = y;
		this.value = (rand.nextBoolean() ? GameSquareNumber.TWO : GameSquareNumber.FOUR);
		this.sprite = createSprite(this.value);
		this.width = sprite.width;
		this.height = sprite.height;
	}

	private Sprite createSprite(GameSquareNumber number) {
		return new Sprite(0xefe5db);
	}

	public boolean canMove() {
		if(x < 0 || x + width > Application.WIDTH || y < 0 || y + height > Application.HEIGHT) {
			return false;
		}
		for(int i = 0; i < Game.objects.size(); i++) {
			GameSquare o = Game.objects.get(i);
			if(this == o) continue;
			if(x + width > o.x && x < o.x + o.width && y + height > o.y && y < o.y + o.height && value != o.value) {
				return false;
			}
		}
		return true;
	}
	
	public void update() {
/*
	You will need to implement the update function which is called on every game square every frame.
	Things you will need to keep in mind:
	 * Has the player moved this frame?
	 * Can this square move?
	 * Use the game direction to check which direction to move the square in

 */
	}
	
	public void render() {
		Renderer.renderSprite(sprite, (int) x, (int) y);
	}
}
