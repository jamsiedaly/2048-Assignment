package twentyFortyEight.solution.gameobject;

import twentyFortyEight.solution.Application;
import java.util.Random;

import twentyFortyEight.solution.game.Game;
import twentyFortyEight.solution.graphics.Renderer;
import twentyFortyEight.solution.graphics.Sprite;

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
		switch (number) {
			case TWO:
				return new Sprite(100, 100, 0xefe5db);
			case FOUR:
				return new Sprite(100, 100, 0xece0c8);
			case EIGHT:
				return new Sprite(100, 100, 0xf1b078);
			case SIXTEEN:
				return new Sprite(100, 100, 0xEB8C52);
			case THIRTY_TWO:
				return new Sprite(100, 100, 0xF57C5F);
			case SIXTY_FOUR:
				return new Sprite(100, 100, 0xEC563D);
			case ONE_HUNDRED_TWENTY_EIGHT:
				return new Sprite(100, 100, 0xF2D86A);
			case TWO_HUNDRED_FIFTY_SIX:
				return new Sprite(100, 100, 0xECC750);
			case FIVE_HUNDRED_TWELVE:
				return new Sprite(100, 100, 0xE5BF2D);
			case ONE_THOUSAND_TWENTY_FOUR:
				return new Sprite(100, 100, 0xE2B913);
			case TWO_THOUSAND_FORTY_EIGHT:
				return new Sprite(100, 100, 0xEDC22E);
			default:
				throw new RuntimeException();
		}
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
		if(Game.moving) {
			if(!hasMoved) {
				hasMoved = true;
			}
			if(canMove()) {
				moving = true;
				if(Game.dir == 0) x -= speed;
				if(Game.dir == 1) x += speed;
				if(Game.dir == 2) y -= speed;
				if(Game.dir == 3) y += speed;
			}

			if(!canMove()) {
				moving = false;
				x = Math.round(x / 100) * 100;
				y = Math.round(y / 100) * 100;
			}
		}
	
	}
	
	public void render() {
		Renderer.renderSprite(sprite, (int) x, (int) y);
	}
}
