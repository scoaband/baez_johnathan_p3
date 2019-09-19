package baez_johnathan_p3;

import java.util.Scanner;

public class PollingApp {

	public static void main(String[] args) {
		
		Scanner scoa = new Scanner(System.in);
		int peoples;
		int k = 1;
		int max_v = 0, min_v = 100000, highest_topic = 0, lowest_topic = 0;
		int[][] vote = new int[5][11];
		String[] topic = {"Religion","Political","Food","Sport","Tutorials"};
	       
		// Responses start at zero
	   for(int i = 0; i < 4;i++){
	       for(int j = 1; j <= 10;j++){
	           vote[i][j] = 0; 
	       }
	   }
	       
	   // Users willing to rate
	   System.out.format("\t+-------------------------------------+%n");
	   System.out.print("\t| Enter total regited users to vote:  ");
	   peoples = scoa.nextInt();
	   System.out.format("\t+-------------------------------------+%n");
	   
	
	  // Taking vote about topic
	   while(k <= peoples){
		   System.out.println("ATTENTION: 1 (least important) to 10 (most important): ");
	       for(int update = 0; update < 5; update++){
	    	   
	    	   System.out.print(" Person " + k + " - " + topic[update] + ": ");
	    	   int rate = scoa.nextInt();
	    	   if(rate > 10 || rate < 1) {
	    		   rate = 0;
	    		   System.out.println("Rate are from 1 - 10," + topic[update] + " vote was invalid.");
	    	   }else {
	    		   vote[update][rate] = vote[update][rate] + 1;
	    	   }
	           
	       }
	       k++;
	       System.out.print("\n");
	   }
	   // Scanner closed to prevent overflow
	   scoa.close();
	   	   
	   System.out.format("\t+------------+--------------+------------+%n");
	   System.out.format("\t|   Topic    | Total_Rating | Avg_Rating |%n");
	   System.out.format("\t+------------+--------------+------------+%n");
	   
	   // Count votes
	   for(k = 0; k < 5; k++)
	   {
	       int total = 0,voteCounted = 0;
	       for(int j = 1; j <= 10; j++)
	       {
	    	   // Total Points
	           total = total + j * vote[k][j]; 
	           // Total Responses
	           voteCounted = voteCounted + vote[k][j]; 
	   }
	         
	   // Taking the highest point
	   if(max_v < total)
	   {  
	       max_v = total;
	       highest_topic = k;
	   }
	   
	   // Taking the lowest point
	   if(min_v > total)
	   {  
	       min_v = total;
	       lowest_topic = k;
	   }
	   
	   double lk = (total + 0.0) / voteCounted;
	   if (!(lk >= 1)) {
		   lk = 1;
	   }
	   
	
	   String leftAlignFormat = "\t| %-10s | %-12d | %.2f       |%n";
	   System.out.format(leftAlignFormat, topic[k] , total , lk);
	   System.out.format("\t+------------+--------------+------------+%n");
	                     
	   }
	   clearScreen();
	   
	   System.out.println("\t\t MAX & MIN");
	   System.out.format("\t\t-----------%n");
	   System.out.println("\tMax_Point_Topic " + "Total_Rating");
	   System.out.println("\t" + topic[highest_topic] + " " + max_v);
	   System.out.println("\tMin_Point_Topic " + "Total_Rating");
	   System.out.println("\t" + topic[lowest_topic] + " " + min_v);
	}
	
	public static void clearScreen() {  
	    System.out.print("\n\n\n");  
	    System.out.flush();  
	}  
}
