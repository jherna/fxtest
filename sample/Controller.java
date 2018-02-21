package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class Controller {
    @FXML private Canvas canvas;
    //Image pilota;
    Pilota pilota, p2, p3;
    GraphicsContext gc;
    Scene sc;

    @FXML public void initialize() {
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.RED);

        pilota = new Pilota();
        p2 = new Pilota(200,100);

        pilota.setImage(new Image("/sample/ball.png"));
        p2.setImage(new Image("/sample/ball.png"));


        animationTimer.start();


    }

    AnimationTimer animationTimer = new AnimationTimer() {
        long lastNanoTime = System.nanoTime();
        @Override
        public void handle(long now) {
            double elapsedTime = (now - lastNanoTime) / 100000000.0;
            lastNanoTime = now;
            pilota.clear(gc);
           // p2.clear(gc);
           // System.out.println(elapsedTime);
            pilota.update(elapsedTime);
            //p2.update(elapsedTime);
            //pilota.move();
            pilota.render(gc);
            //p2.render(gc);



        }
    };

    public void setScene(Scene scene) {
        sc = scene;
        System.out.println("MIDA----->" + sc.getHeight());
        sc.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(pilota.isClicked(new Point2D(event.getX(),event.getY()))) {
                    pilota.clear(gc);
                    pilota.changeDir();
                }

            }
        });
    }


}
