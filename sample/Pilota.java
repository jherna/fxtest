package sample;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;



public class Pilota {
    private Image image;
    private double posX, posY, velX, velY, width, height;
    private int dirX, dirY;

    public Pilota() {
        this.posX = 0.0f;
        this.posY = 0.0f;
        this.velX = 4.0f;
        this.velY = 4.0f;
        this.dirX = 1;
        this.dirY = 1;
    }

    public Pilota(double x, double y) {
        this.posX = x;
        this.posY = y;
        this.velX = 4.0f;
        this.velY = 4.0f;
        this.dirX = 1;
        this.dirY = 1;
    }


    public void update(double time) {
       // System.out.println(posX + "," + posY);
        if(dirX == 1) {
            posX += velX*time;
            if(posX>=400-width) dirX = (-1)*dirX;
        }else {
            posX += (-velX)*time;
            if(posX<=0) dirX = (-1)*dirX;
        }
        if(dirY == 1){
            posY += velY*time;
            if(posY>=500-height) dirY = (-1)*dirY;
        }
        else {
            posY += (-velY)*time;
            if(posY<=0) dirY = (-1)*dirY;
        }
    }

    public void move() {
        if(dirX == 1) {
            posX += 1;
            if(posX>=400-width) dirX = (-1)*dirX;
        }else {
            posX -= 1;
            if(posX<=0) dirX = (-1)*dirX;
        }
        if(dirY == 1){
            posY += 1;
            if(posY>=500-height) dirY = (-1)*dirY;
        }
        else {
            posY -= 1;
            if(posY<=0) dirY = (-1)*dirY;
        }
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image, posX, posY);
        //System.out.println(posX + ":" + posY);
    }

    public void setImage(Image i) {
        image = i;
        width = image.getWidth();
        height = image.getHeight();
    }

    public void clear(GraphicsContext gc) {
        gc.clearRect(posX,posY, width, height);
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(posX,posY,width,height);
    }

    public boolean isClicked(Point2D p) {
        if(getBoundary().contains(p)) return true;
        else return false;
    }

    public void changeDir() {
        dirX = dirX*(-1);
    }

}
