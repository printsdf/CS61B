/**
 * Body
 * @author printsdf
 */
public class Planet {

    /**
     * @param create 6 instance varibles
     */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    /**
     * @param Constructors
     */
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
                xxPos = xP;
                yyPos = yP;
                xxVel = xV;
                yyVel = yV;
                mass = m;
                imgFileName = img;
              }

    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    /**
     * calculate the distance between p1 and p2
     * @param p
     * @return distance
     */
    public double calcDistance(Planet p) {
      double dx = Math.sqrt(Math.pow(this.xxPos - p.xxPos, 2));
      double dy = Math.sqrt(Math.pow(this.yyPos - p.yyPos, 2));
      double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
      return r;
    }

    /**
     * define a const num G
     */
    private static final double gConst = 6.67e-11;

    /**
     * calculate the force exerted by p
     * @param p
     * @return force
     */
    public double calcForceExertedBy(Planet p) {
      double r = this.calcDistance(p);
      double force = gConst * p.mass * this.mass / Math.pow(r, 2);
      return force;
    }

    /**
     * calculate the x-force exerted by p
     * @param p
     * @return x-force
     */
    public double calcForceExertedByX(Planet p) {
      double r = this.calcDistance(p);
      double force = calcForceExertedBy(p);
      double forceX = force * (p.xxPos - this.xxPos) / r;
      return forceX;
    }

    /**
     * calculate the y-force exerted by p
     * @param p
     * @return y-force
     */
    public double calcForceExertedByY(Planet p) {
      double r = this.calcDistance(p);
      double force = calcForceExertedBy(p);
      double forceY = force * (p.yyPos - this.yyPos) / r;
      return forceY;
    }

    /**
     * calculate the x-force exerted by ps
     * @param ps
     * @return all the x-force
     */
    public double calcNetForceExertedByX(Planet[] ps) {
      double forceX = 0;
      for (Planet p : ps) {
        if (!this.equals(p)) 
          forceX += calcForceExertedByX(p);
      }
      return forceX;
    }

    /**
     * calculate the y-force exerted by ps
     * @param ps
     * @return all the y-force
     */
    public double calcNetForceExertedByY(Planet[] ps) {
      double forceY = 0;
      for (Planet p : ps) {
        if (!this.equals(p)) 
          forceY += calcForceExertedByY(p);
      }
      return forceY;
    }

    public void update(double dt, double fX, double fY) {
      double aX = fX / this.mass;
      double aY = fY / this.mass;
      this.xxVel += dt * aX;
      this.yyVel += dt * aY;
      this.xxPos += dt * this.xxVel;
      this.yyPos += dt * this.yyVel;
    }

    public void draw() {
      StdDraw.picture(this.xxPos, this.yyPos, "images/" + imgFileName);
    }
}