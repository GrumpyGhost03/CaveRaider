package its.pbo.caveRaider;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import its.pbo.utilz.LoadSave;

public class LevelManager {
	private Game game;
	private BufferedImage[] levelSprite;
	private Level levelOne;
	
	public LevelManager(Game game) {
		this.game = game;
		importOutsideSprites();
		levelOne = new Level(LoadSave.GetLevelData());
	}
	
	private void importOutsideSprites() {
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
		levelSprite = new BufferedImage[48];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 12; j++) {
				int index = i*12+j;
				levelSprite[index] = img.getSubimage(j*32, i*32, 32, 32);
			}
		}
	}
	public void draw(Graphics g) {
		for (int j = 0; j < Game.TILES_IN_HEIGHT; j++)
			for (int i = 0; i < Game.TILES_IN_WIDTH; i++) {
				int index = levelOne.getSpriteIndex(i, j);
				g.drawImage(levelSprite[index], Game.TILES_SIZE * i, Game.TILES_SIZE * j, Game.TILES_SIZE, Game.TILES_SIZE, null);
			}
//		g.drawImage(levelSprite[2], 0, 0, null);
	}
	public void update() {
		
	}
	
	public Level getCurrentLevel() {
		return levelOne;
	}
}