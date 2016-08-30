package application;

import application.tools2D.Particule2D;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import javafx.scene.shape.Line;

import static setting.Constants.*;

public class Animation0 extends AddParticules {

    private final GraphicsContext graphicsContext;
    private Image particuleImg;
    private Image vitesseImg;

    Animation0(final Start start) {

        graphicsContext = start.graphicsContext;

        allParticles = new ArrayList<>();

        for (int i = 0; i < NbParticules; i++) {
            addParticule();
        }
        addParticule_0();
//        addParticule_1();

//        graphicsContext.setFill(graphicsContextsetFill);
//        graphicsContext.fillRect(0, 0, W, H);
    }

    @Override
    public void handle(long now) {

        Gravity g = new Gravity(allParticles, DeltaT);
        g.move();

        graphicsContext.setFill(graphicsContextsetFill);
        graphicsContext.fillRect(0, 0, W, H);
        
        g.allParticules_1.forEach((p) -> {
            particuleImg = createImage(createParticleImg(p));
//            vitesseImg = createImage(createVitesseImg(p));
            graphicsContext.drawImage(particuleImg, p.X.x, p.X.y);
//            graphicsContext.drawImage(vitesseImg, p.X.x, p.X.y);

        });
        allParticles = g.allParticules_1;

        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillText("Nb Particules: " + allParticles.size(), 1, 10);
        graphicsContext.fillText("Nb Particules: " + g.allParticules_1.size(), 1, 20);

    }

    private Circle createParticleImg(Particule2D p) {

        if (p.m < M_centre) {
            Circle ball = new Circle(p.m * diam_part_fact);
            ball.setFill(color_ball);
            return ball;
        } else {
            Circle ball = new Circle(Diam_M_Centre);// M0
            ball.setFill(color_ball_center);
            return ball;
        }

    }

//    private Line createVitesseImg(Particule2D p) {
//        // line vitesse
//        float n = (float) p.v.magnitude();
//        float nx = (float) (p.X.x + ds * p.v.x / n);
//        float ny = (float) (p.X.y + ds * p.v.y / n);
//
//        Line l = new Line(p.X.x, p.X.y, nx, ny);
//        l.setStroke(ds_color);
//        l.setStrokeWidth(ds_ep);
//        return l;
//
//    }

    private Image createImage(Node node) {
        WritableImage wi;
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        int imageWidth = (int) node.getBoundsInLocal().getWidth();
        int imageHeight = (int) node.getBoundsInLocal().getHeight();
        wi = new WritableImage(imageWidth, imageHeight);
        node.snapshot(parameters, wi);
        return wi;
    }
}
