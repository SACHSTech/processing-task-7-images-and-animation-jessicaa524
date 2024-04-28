import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
    
    PImage imgKuromi;
    PImage imgBackground;

    float fltKuromiX;
    float fltKuromiY;
    float fltSpeedX = 8; 
    float fltSpeedY = -15; 
    float fltGravity = 0.3f; 

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        imgBackground = loadImage("images/heartbackground.jpeg");
        imgBackground.resize(width, height);

        imgKuromi = loadImage("images/Kuromi.png");
        imgKuromi.resize(width / 5, height / 5);

        // sets start at center
        fltKuromiX = width / 2; 
        fltKuromiY = height / 2; 
    }

    public void draw() {
        background(imgBackground);

        image(imgKuromi, fltKuromiX, fltKuromiY);

        // Kuromi's position
        fltKuromiX += fltSpeedX;
        fltKuromiY += fltSpeedY;
        fltSpeedY += fltGravity;

        // Setting boundaries and direction
        if (fltKuromiX <= 0 || fltKuromiX >= width - imgKuromi.width) {
            fltSpeedX *= -1; 
            fltKuromiX = constrain(fltKuromiX, 0, width - imgKuromi.width); // keepinging within boudnaries
        }
        if (fltKuromiY >= height - imgKuromi.height) {
            fltSpeedY *= -0.9; 
            fltKuromiY = height - imgKuromi.height; // keeping within boundaries 
        }
    }
}