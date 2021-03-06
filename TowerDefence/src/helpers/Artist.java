package helpers;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Artist {

	public static final int WIDTH = 1280, HEIGHT = 960;
	public static final int TILE_SIZE = 64;
	
	public static void BeginSession() {
		Display.setTitle("Tower Defence");

		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();

		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1); // What the screen is gonna see.
		glEnable(GL_TEXTURE_2D);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_BLEND);// More colors
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);// Transparency

	}

	public static boolean CheckCollision(float x1, float y1, float width1,
			float height1, float x2, float y2, float width2, float height2) {

		if (x1 + width1 > x2 && x1 < x2 + width2 && y1 + height1 > y2
				&& y1 < y2 + height2)
			return true;
		return false;
	}

	public static void DrawQuad(float x, float y, float width, float height) {
		// glBegin(GL_LINES);//Begins drawing a line.
		// glVertex2f(10, 10);//Draws from 10,10
		// glVertex2f(100,100);//Ends line at 100,100
		// glEnd();// Stops drawing

		glBegin(GL_QUADS);
		glVertex2f(x, y); // Top left corner
		glVertex2f(x + width, y); // Top right corner
		glVertex2f(x + width, y + height); // Bottom right corner
		glVertex2f(x, y + height); // Bottom left corner
		glEnd();
	}

	public static void DrawQuadTexture(float x, float y, float width,
			float height, Texture texture) {
		texture.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity(); // Needs to be at the end
	}

	public static void DrawQuadTextureRotate(float x, float y, float width,
			float height, Texture texture, float angle) {
		texture.bind();
		glTranslatef(x + width / 2, y + height / 2, 0); // finds the center of
														// the square
		glRotatef(angle, 0, 0, 1);
		glTranslatef(-width / 2, -height / 2, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity(); // Needs to be at the end

	}

	public static Texture LoadTexture(String path, String fileType) {
		Texture texture = null;

		InputStream in = ResourceLoader.getResourceAsStream(path);

		try {
			texture = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return texture;
	}

	public static Texture QuickLoad(String name) {
		Texture texture = null;
		texture = LoadTexture("res/" + name + ".png", "PNG");
		return texture;
	}
}
