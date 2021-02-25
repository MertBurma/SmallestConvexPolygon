/*
 * Mert Burma 
 * 041701033
 * 14.11.2020
 * Summary
 */

import java.util.Random;
import java.util.Stack;
import java.awt.Color;
import java.util.Arrays;

public class burmam{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StdDraw.setCanvasSize(600,600);
		// set the scale of the coordinate system
		StdDraw.setXscale(-0.5, 1.5);
		StdDraw.setYscale(-0.5, 1.5);					//create Canvas and set size,Xscale,Yscale
		StdDraw.clear(StdDraw.BLACK);
		Random random = new Random();
		
		int size = 10; //number of points
		
		Stack<Point> stack = new Stack();
	
		Point p;							
		
		Point[] temps = new Point[size];
		
		for (int i =0; i<size; i++) {
			p = new Point(random.nextDouble(),random.nextDouble());			//creating Point object
			p.draw();									//Call for draw point	
			temps[i] = p;
			
			
			
			
			
		}
		
		
		for(int i = 0; i<temps.length; i++) {
			System.out.println(temps[i].getX() + "         " + temps[i].getY()); //location of the points
			
		}
		
		//lowest point
		int lowestpoint = 0;
		
		for (int i = 1; i<temps.length; i++) {
			if(temps[i].getY()<temps[lowestpoint].getY()) {		//find the lowestpoint
				lowestpoint=i;
			}
		}
		
		
		//I show lowestpoint in canvas
		
		System.out.println("lowest point = "  +temps[lowestpoint].getX()+temps[lowestpoint].getY());
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.setPenRadius(0.02);  // set pen size
		StdDraw.point(temps[lowestpoint].getX(),temps[lowestpoint].getY());		
	
		
	
		//ý kept all the angles in array
		double[] sorted =new double[size];
		for(int i = 0; i<temps.length; i++) {
			sorted[i] = angles(temps[lowestpoint],temps[i]);
		}
	
		
		//I combined all angle values with point object using the setAngle method
		for(int i=0; i<temps.length;i++) {
			temps[i].setAngle(sorted[i]);
		}
		
		for(int i=0; i<temps.length;i++) {
		System.out.println("X :" + temps[i].getX()+" Y: "+temps[i].getY()+" Angle: " + temps[i].getAngle());
		}
		
		
		System.out.println("******* WÝTH SORTING***************");

		Arrays.sort(temps); //sort temps array base field angle
		
		for(int i =0; i<sorted.length; i++) {
			System.out.println("X "+ temps[i].getX() +" Y:" + temps[i].getY() +" Angle: " +temps[i].getAngle());
		}

		//top first and second element in stack 
		int i =0;
		while(i<3) {
		stack.push(temps[i]);
		i++;		
		}
		
	
		
		while(i<temps.length) {
			Point t1 = stack.peek();
			Point temp = stack.pop(); // I  kept the point where I pop is in temps
			Point t2 = stack.peek();
			stack.push(temp);
			
			//checkk left and right
			double a = ((t1.getX() - t2.getX()) * (temps[i].getY() - t2.getY())) - ((temps[i].getX() - t2.getX()) * (t1.getY() - t2.getY()));
            if (a > 0) {
                stack.push(temps[i]);
                i++;
            } else {
                stack.pop();
            }
		}
	
	Point lastelement = stack.peek();
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.setPenRadius(0.01);
		while(stack.size()>1) {		//if stack size bigger than one  keep  peeking
			Point a=stack.peek();
			stack.pop();			
			Point b = stack.peek();
			StdDraw.line(a.getX(), a.getY(), b.getX(), b.getY()); //printing line a to b in stack
			
		}
		//StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.line(lastelement.getX(), lastelement.getY(), temps[0].getX(),temps[0].getY()); //print line last element to first element in stack
	
	}
		
	
	public static double angles(Point a, Point b) {
			double x = b.getX()-a.getX();					//find angles method
			double y = b.getY()-a.getY();
			return  Math.toDegrees(Math.atan2(y,x)) ;
	
	}

	
	

}
	

		
	


