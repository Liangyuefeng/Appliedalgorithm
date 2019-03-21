import java.util.*;

public class exe1 {
	public static void main(String[] args) {

	      Queue<Integer> Perque = new LinkedList<Integer>();
	      

			int Guard = 0;
			int[] GrowthRate;
			GrowthRate = new int[8];
			GrowthRate[0] = 2;
			GrowthRate[1] = 3;
			GrowthRate[2] = 5;

		    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			// DO NOT CHANGE ANYTHING ABOVE THIS LINE
	        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	        // feed the queue with a combination of indices 0,1,2,3,4,5,6,7 NOT LONGER than 1000
	        // use operation Perque.add(i) to feed the queue
			// the following sequence of indices corresponds to the Round Robin Approach

	        Perque.add(2);
	        Perque.add(1);
	        Perque.add(0);
	        
	        Perque.add(2);
	        

	        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			// DO NOT CHANGE ANYTHING BELOW THIS LINE
	        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
          // use the periodic queue 10000 times

	        int[] Count;
			Count = new int[8];
			Count[0]=1;
			Count[1]=1;
			Count[2]=1;
			

	       int Index;               // next index drawn from the queue

	       float Quotient = 1.0f; // we want to see this quotient as small as possible

	       int H=GrowthRate[0]+GrowthRate[1]+GrowthRate[2];
		   // H is the sum of all growth rates

		   int MaxHeight=0;


			for (int i = 0; i < 100; i++) {

				// draw the next index from the front of the queue
	            Index=Perque.remove();

	            // Testing: System.out.println(" Next element = " + Element);

				//update maximum height if needed
	            for (int j=0; j<2; j++)
					if ((Count[j]*GrowthRate[j])>MaxHeight) {MaxHeight=(Count[j]*GrowthRate[j]);}

				//update the height of each bamboo with its daily growth rate
				for (int j=0; j<2; j++)
					if(Index==j) 
					{Count[j]=1;}
					else {Count[j]++;}

				// stored the used index at the end of the queue
				Perque.add(Index);

			} // end loop for

			// Compute quotient and print it
			Quotient=((float)MaxHeight/(float)H);
			System.out.println(" Quotient= " + Quotient + " MaxHeight= " + MaxHeight + " H= " + H);
	   }

}
