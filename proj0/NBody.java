/**
 * NBody
 * @author printsdf
 */

public class NBody {
    
    public static double readRadius(String s) {
        In in = new In(s);
        int n = in.readInt();
		double r = in.readDouble();
        return r;
    }

    public static Planet[] readPlanets(String s) {
        In in = new In(s);
        int n = in.readInt();
		double r = in.readDouble();
        Planet[] ps = new Planet[n];
        for (int i = 0; i < ps.length; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            ps[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return ps;
    }

    public static void main(String[] args) {

        /**
         * some arguments
         */
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] ps = readPlanets(filename);
        double r = readRadius(filename);

        StdDraw.setScale(-r, r);
        StdDraw.enableDoubleBuffering();

        double t = 0;
        int len = ps.length;
        for (; t < T; t += dt) {
            double xForces[] = new double[len];
            double yForces[] = new double[len];
            for (int i = 0; i < len; i++) {
                xForces[i] = ps[i].calcNetForceExertedByX(ps);
                yForces[i] = ps[i].calcNetForceExertedByY(ps);
            }

            for (int i = 0; i < len; i++) 
                ps[i].update(dt, xForces[i], yForces[i]);

            StdDraw.picture(0, 0, "images/starfield.jpg");

            for (Planet p : ps)
                p.draw();

            StdDraw.show();

            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", len);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < ps.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  ps[i].xxPos, ps[i].yyPos, ps[i].xxVel,
                  ps[i].yyVel, ps[i].mass, ps[i].imgFileName);   
}
    }
}
