package application.collision;

import application.tools2D.Particule2D;
import static application.tools2D.Vector2D.subtract;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.List;
import static application.collision.Constants1.*;
import static application.tools2D.Vector2D.subtract;
import static java.lang.Math.pow;

public class Collision {

    List<Particule2D> allParticules_1;
    List<Particule2D> allParticules;
    double deltaT;

    public Collision(List<Particule2D> allParticules, double deltaT) {
        this.allParticules_1 = new ArrayList<>();
        this.allParticules = allParticules;
        this.deltaT = deltaT;
        allParticules.forEach(p -> acc(p));
    }

    private void acc(Particule2D p) {
        for (Particule2D q : allParticules) {
            if (!p.equals(q)) {//equals ?
                double dist = subtract(q.X, p.X).magnitude();
                double dist3 = pow(dist, 3);
                if (dist > dist_collision) {
                    p.a.x += q.m * (q.X.x - p.X.x) / dist3;
                    p.a.y += q.m * (q.X.y - p.X.y) / dist3;
                } 
//                else {
//                    p.a.x -= -q.a.x;
//                    p.a.y -= -q.a.y;
//
//                }
            }
        }

        allParticules_1.add(p);
    }

    void move() {

        for (Particule2D p : allParticules_1) {
            double deltaT2 = pow(deltaT, 2) / 2;
            //positions
            p.X.x += deltaT2 * p.a.x + deltaT * p.v.x;
            p.X.y += deltaT2 * p.a.y + deltaT * p.v.y;
            //vitesses
            p.v.x += p.a.x;
            p.v.y += p.a.y;
        }
    }

//    private Particule2D limit(Particule2D p) {
//        if (p.X.x - dim / 2 < dist_collision) {
//            p.a.x = -p.a.x;
//            return p;
//        } else if (dim - p.X.x / 2 < dist_collision) {
//
//        } else if (dim - p.X.y / 2 < dist_collision) {
//
//        } else if (p.X.y - dim / 2 < dist_collision) {
//            p.a.y = -p.a.y;
//            return p;
//        }
//        return p;
//    }
}
