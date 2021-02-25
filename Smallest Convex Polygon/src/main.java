
import java.util.Random;
import java.util.Arrays;

public class deneme {

	

	

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			StdDraw.setCanvasSize(600,600);
			// set the scale of the coordinate system
			StdDraw.setXscale(-0.5, 1.5);
			StdDraw.setYscale(-0.5, 1.5);
			StdDraw.clear(StdDraw.BLACK);
			Random random = new Random();
			
			int size = 10;
			
			Stack stack = new Stack(size);
		
			Point p;
			
			Point[] temps = new Point[size];
			
			for (int i =0; i<size; i++) {
				p = new Point(random.nextDouble(),random.nextDouble());
				p.draw();
				temps[i] = p;
				
				
				
				
			}
			
			
			for(int i = 0; i<temps.length; i++) {
				System.out.println(temps[i].getX() + "         " + temps[i].getY()); //location of the points
				
			}
			
			//lowest point
			int lowestpoint = 0;
			
			for (int i = 1; i<temps.length; i++) {
				if(temps[i].getY()<temps[lowestpoint].getY()) {
					lowestpoint=i;
				}
			}
			
			System.out.println("lowest point = "  +temps[lowestpoint].getX()+temps[lowestpoint].getY());
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.setPenRadius(0.02);  // set pen size
			StdDraw.point(temps[lowestpoint].getX(),temps[lowestpoint].getY());
			StdDraw.show();
			
		
			double[] sorted =new double[size];
			for(int i = 0; i<temps.length; i++) {
				sorted[i] = angles(temps[lowestpoint],temps[i]);
			}
		
			selectionSort(sorted);
			
			System.out.println("*******");

			for(int i =0; i<sorted.length; i++) {
				System.out.println(sorted[i]);
			}
		
		

		
		}
		
			
			 
		
		public static double angles(Point a, Point b) {
				double x = b.getX()-a.getX();
				double y = b.getY()-a.getY();
				return  Math.toDegrees(Math.atan2(y,x)) ;
		
		}
		//sorta
		
		public static void selectionSort(double[] angles){  
	        
		for (int i = 0; i < angles.length - 1; i++) {
			     // Find the minimum in the list[i..list.length-1]
			          double currentMin = angles[i];
			          int currentMinIndex = i;
			    
			          for (int j = i + 1; j < angles.length; j++) {
			            if (currentMin > angles[j]) {
			              currentMin = angles[j];
			             currentMinIndex = j;
			           }
			         }
			   
			         // Swap list[i] with list[currentMinIndex] if necessary;
			         if (currentMinIndex != i) {
			           angles[currentMinIndex] = angles[i];
			           angles[i] = currentMin;
			         }
			       }
			     }
			
			
			
			
			
			
			
			
			
			
			
			
		
			
			
			
		}




