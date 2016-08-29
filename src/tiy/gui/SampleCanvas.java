/**
 * Created by jfabiano on 8/29/2016.
 */
package tiy.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SampleCanvas extends Application {

    final double DEFAULT_SCENE_HEIGHT = 600;
    final double DEFAULT_SCENE_WIDTH = 800;
    double strokeSize = 2;

    @Override
    public void start(Stage primaryStage) {
        Group rootGroup = new Group();

//        Scene mainScene = new Scene(rootGroup, 800, 600, Color.BLACK);


        Canvas canvas = new Canvas(DEFAULT_SCENE_WIDTH, DEFAULT_SCENE_HEIGHT);
        canvas.setFocusTraversable(true);//events can trickle down to pieces below the canvas

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
        graphicsContext.setLineWidth(2);
        drawShapes(graphicsContext);
        canvas.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){
                System.out.println("Key pressed was " + event.getCode().getName());//event.getText() to get the text...
                //When the user presses the "A" key on the keyboard, change the color that you draw in to another random color
                if(event.getCode().getName().equals("A"))
                {
                    graphicsContext.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
                }
                //When the user presses the "C" key on the keyboard, clear the screen
                if(event.getCode().getName().equals("C"))
                {
                    graphicsContext.clearRect(0, 0, DEFAULT_SCENE_WIDTH, DEFAULT_SCENE_HEIGHT);
                }
                //Make sure the stroke size never goes below 2 or above 20 (hint: use a set method and add an if block there)
                //When the user presses the "up" arrow, increase the size of the stroke by 1
                if(event.getCode().getName().equals("Up") && strokeSize < 20)
                {
                    strokeSize += 1;
                }
                //When the user presses the "down" arrow, decrease the size of the stroke by 1
                if(event.getCode().getName().equals("Down") && strokeSize > 2)
                {
                    strokeSize -= 1;
                }
            }
        });
        canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {//anonymous implementation of this interface
            //Make the app draw circles when the mouse moves, like the version I demo'd in class
//            @Override
//            public void handle(MouseEvent e) {
//                //e. research this
//                System.out.println("x: " + e.getX() + ", y: " + e.getY());
//                graphicsContext.strokeOval(e.getX(), e.getY(), strokeSize, strokeSize);
//            }
            @Override
            public void handle(MouseEvent e) {
                //e. research this
                System.out.println("x: " + e.getX() + ", y: " + e.getY());
                //graphicsContext.strokeOval(e.getX(), e.getY(), strokeSize, strokeSize);
                graphicsContext.clearRect(0, 0, DEFAULT_SCENE_WIDTH, DEFAULT_SCENE_HEIGHT);
                //ArrayList<GraphicsContext> graphicsArray = new ArrayList<GraphicsContext>();
                for (int index = 0; index < e.getX() && index < e.getY(); index++) {
                    //graphicsArray.add(index, graphicsContext.strokeOval(e.getX() * Math.random(), e.getY() * Math.random(), strokeSize, strokeSize));
                    graphicsContext.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                    graphicsContext.fillOval(e.getX() * Math.random(), e.getY() * Math.random(), strokeSize, strokeSize);
                }
                    //graphicsContext.strokeOval(e.getX() * Math.random(), e.getY() * Math.random(), strokeSize, strokeSize);


                //Math.random();
            }
       });


        rootGroup.getChildren().add(canvas);
        Scene scene = new Scene(rootGroup, DEFAULT_SCENE_WIDTH, DEFAULT_SCENE_HEIGHT);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);
    }
}


