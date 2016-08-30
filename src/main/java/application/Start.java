package application;

import application.collision.Animation1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import static setting.Constants.H;
import static setting.Constants.W;

public class Start extends Application {

    public GraphicsContext graphicsContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(W, H);
        graphicsContext = canvas.getGraphicsContext2D();
        Pane layerPane = new Pane();
        layerPane.getChildren().addAll(canvas);
        canvas.widthProperty().bind(layerPane.widthProperty());
        root.setCenter(layerPane);
        Line h = new Line(0, H / 2, W, H / 2);
        Line v = new Line(W / 2, 0, W / 2, H);
        h.setStroke(Color.WHITE);
        v.setStroke(Color.WHITE);
        h.setStrokeWidth(0.3);
        v.setStrokeWidth(0.3);
        layerPane.getChildren().add(h);
        layerPane.getChildren().add(v);
        /**
         * Node toolbar = Settings.get().createToolbar();
         * root.setRight(toolbar);
         */
        Scene scene = new Scene(root, W, H);
        primaryStage.setScene(scene);
        primaryStage.setTitle("N Particules");
        primaryStage.show();

        Animation0 anim = new Animation0(this);
        //  new Gui(anim).setVisible(true);
        anim.start();
//        Animation1 anim = new Animation1(this);
//        //  new Gui(anim).setVisible(true);
//        anim.start();
    }

}
