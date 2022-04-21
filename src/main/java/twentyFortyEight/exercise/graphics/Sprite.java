package twentyFortyEight.exercise.graphics;

public class Sprite {

	public int width, height;
	public int[] pixels;
	
	public Sprite(int color) {
		this.width = 100;
		this.height = 100;
		this.pixels = new int[width * height];
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				pixels[x + y * width] = color;

				roundEdges(y, x);
			}
		}
	}

	private void roundEdges(int y, int x) {
		if(x % 100 < 3 || x % 100 > 97 || y % 100 < 3 || y % 100 > 97) {
			pixels[x + y * width] = 0xffff00ff;
		}
	}


}
