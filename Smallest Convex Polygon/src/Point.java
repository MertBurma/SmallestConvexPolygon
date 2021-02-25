/*
 * Mert Burma
 * 041701033
 * 14.11.2020
 * Summary
 */



// A Point class that implements the Comparable interface to be able to sort Point 
// objects based on their angles.
public class Point implements Comparable<Point> {
   // data fields
   private double x;
   private double y;
   // the angle of the line formed by this Point object and p0 with the x-axis is
   // stored in the Point object to sort the points easier
   private double angle;

   // constructor
   public Point(double x, double y) {
      this.x = x;
      this.y = y;
   }

   // getter methods
   public double getX() {
      return x;
   }
   public double getY() {
      return y;
   }
   public double getAngle() {
      return angle;
   }

   // setter methods
   public void setX(double x) {
      this.x = x;
   }
   public void setY(double y) {
      this.y = y;
   }
   public void setAngle(double angle) {
      this.angle = angle;

   }

   // method for drawing the point on the canvas
   public void draw() {
      StdDraw.setPenColor(StdDraw.YELLOW); // set pen color
      StdDraw.setPenRadius(0.02); // set pen size
      StdDraw.point(x, y);
   }

   // compareTo method for comparing 2 Point objects based on their angles
   public int compareTo(Point p) {
      if (angle < p.getAngle())
         return -1;
      if (angle > p.getAngle())
         return 1;
      return 0;
   }
}