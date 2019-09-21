package baez_johnathan_p3;

import java.util.Scanner;

public class PollingApp {

	public static void main(String[] args) {
		
		Scanner scoa = new Scanner(System.in);
		String[] topics = {"Religion","Political","Food","Sport","Tutorials"};
		int peoples;
		int k = 1;
		int max_v = 0, min_v = 100000, highest_topic = 0, lowest_topic = 0;
		int[][] responses = new int[5][11];	
		// ..............................................................................................
		
		// Responses start at zero
	   for(int i = 0; i < 4;i++){
	       for(int j = 1; j <= 10;j++){
	    	   responses[i][j] = 0; 
	       }
	   }
	   
	   // Users willing to rate
	   System.out.format("\t+-------------------------------------+%n");
	   System.out.print("\t| Enter total regited users to vote:  ");
	   peoples = scoa.nextInt();
	   System.out.format("\t+-------------------------------------+%n");
	   System.out.println("\tATTENTION: 1 (least important) to 10 (most important): ");
	   // ..................................................................................................................

	  // Taking vote about topic k = the amount of people registered to vote
	   while(k <= peoples){

	       for(int update = 0; update < 5; update++){   
	    	   System.out.print("\t Person " + k + " - " + topics[update] + ": ");
	    	   int rate = scoa.nextInt();
	    	   if(rate > 10 || rate < 1) {
	    		   rate = 0;
	    		   System.out.println("\tRate are from 1 - 10," + topics[update] + " vote was invalid.");
	    	   }else {
	    		   responses[update][rate] = responses[update][rate] + 1;
	    	   }
	       }
	       
	   k++;
	   System.out.print("\n");
	   }
	   // Scanner closed to prevent overflow
	   scoa.close();
	// ..................................................................................................................
	   	   
	   System.out.format("\t+------------+-----------------------------------------------------+%n");
	   System.out.format("\t|   Topics   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | Avg_Rating |%n");
	   System.out.format("\t+------------+-----------------------------------------------------+%n");
	   
	   // Count votes
	   for(k = 0; k < 5; k++)
	   {
	       int total = 0,voteCounted = 0;
	       for(int j = 1; j <= 10; j++)
	       {
	    	   // Total Points
	           total += (j * responses[k][j]); 
	           // Total Responses
	           voteCounted += responses[k][j]; 
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
		   // topic[k] topics
		   
		   int n,n1,n2,n3,n4,n5,n6,n7,n8,n9,n10;
		   n1 = 0; n2 = 0; n3 = 0; n4 = 0; n5 = 0; n6 = 0; n7 = 0; n8 = 0; n9 = 0; n10 = 0;
		   n = (int)lk;
		   switch (n) {
		   case 1:
			   n1 = 1;
			   break;
		   case 2:
			   n2 = 1;
			   break;
		   case 3:
			   n3 = 1;
			   break;
		   case 4:
			   n4 = 1;
			   break;
		   case 5:
			   n5 = 1;
			   break;
		   case 6:
			   n6 = 1;
			   break;
		   case 7:
			   n7 = 1;
			   break;
		   case 8:
			   n8 = 1;
			   break;
		   case 9:
			   n9 = 1;
			   break;
		   case 10:
			   n10 = 1;
			   break;
		   }
		   String centerAlignFormat = "\t| %-10s | %-1d | %-1d | %-1d | %-1d | %-1d | %-1d | %-1d | %-1d | %-1d | %-2d | %.2f       |%n";
		  
		   System.out.format(centerAlignFormat, topics[k] , n1 , n2 , n3 , n4 , n5 , n6 , n7 , n8 , n9 , n10, lk);
		   System.out.format("\t+------------+-----------------------------------------------------+%n");
		   
	   }
	   clearScreen();
	   // ..................................................................................................................
	   
	   System.out.println("\t\t MAX & MIN");
	   System.out.format("\t\t-----------%n");
	   System.out.println("\tMax_Point_Topic " + "Total_Rating");
	   System.out.println("\t" + topics[highest_topic] + " " + max_v);
	   System.out.println("\tMin_Point_Topic " + "Total_Rating");
	   System.out.println("\t" + topics[lowest_topic] + " " + min_v);
	}
	
	public static void clearScreen() {  
	    System.out.print("\n\n\n");  
	    System.out.flush();  
	}  
}
