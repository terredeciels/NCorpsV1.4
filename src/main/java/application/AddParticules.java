package application;

import application.tools2D.Particule2D;
import application.tools2D.Vector2D;
import javafx.animation.AnimationTimer;
import setting.Constants;

import java.util.List;
import java.util.Random;

import static java.lang.Math.*;
import static setting.Constants.*;

public abstract class AddParticules extends AnimationTimer {

    final Random random = new Random();
    public List<Particule2D> allParticles;
    int index;

    public void addParticule() {

        double r = R + random.nextDouble() * ep;
//        double r = R * random.nextDouble();
        double theta = random.nextDouble() * 2 * PI;

        double x = W / 2 + r * cos(theta);
        double y = H / 2 + r * sin(theta);
        Vector2D X = new Vector2D(x, y);

        Vector2D v = new Vector2D(0,0);
        if (index <NbParticules/2) {
             v = new Vector2D(-sin(theta), cos(theta));
            v.multiply(multiply_vit_pos);
        }else{
             v = new Vector2D(sin(theta), -cos(theta));
            v.multiply(multiply_vit_neg);
        }
        index++;
        Vector2D a = new Vector2D(0, 0);
        Particule2D particle = new Particule2D(m_part, X, v, a);

        allParticles.add(particle);

    }

    void addParticule_0() {
        double x = W / 2;
        double y = H / 2;
        Vector2D X = new Vector2D(x, y);
        Vector2D v = new Vector2D(0, 0);
        Vector2D a = new Vector2D(0, 0);
        Particule2D p = new Particule2D(M_centre, X, v, a);
        allParticles.add(p);
    }

//    void addParticule_1() {
//        double x = 4 * W / 5;
//        double y = H / 2;
//        Vector2D X = new Vector2D(x, y);
//        Vector2D v = new Vector2D(0, 0);
//        Vector2D a = new Vector2D(0, 0);
//        Particule2D p = new Particule2D(M_centre2, X, v, a);
//        allParticles.add(p);
//    }

}
