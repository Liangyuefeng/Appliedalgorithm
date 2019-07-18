/**
 * Shortest Common Super String Problem
 * DATA SET 2 (connect the quartets)
 * @author Leszek A Gasieniec
 */

// find the shortest string which contains

import java.util.*;

public class SuperString2 {
	
	private String createSuperString(Set<String> subStrings) {
        int totalStrings = subStrings.size();    //the number of elements in this set
        String[] finalsuperstring = new String[totalStrings];
        int i = 0;

        for(String superString : subStrings) {    //traversal the subStrings
            Set<String> temp = new HashSet<>(subStrings);
            String maxSuperString = superString;
            while(temp.size() > 1) {              

                String subString = "";
                String nextMaxSuperString = maxSuperString;

                for(String nextString : temp) {     //pick out one string in temp and compared with maxSuperString

                    if(!nextString.equals(nextMaxSuperString)) {    //compare the two string, if not equal
                        String superTemp = getSuperString(maxSuperString, nextString);   //combine two strings to superTemp
                        if (nextMaxSuperString.equals(maxSuperString) || nextMaxSuperString.length() > superTemp.length()) {
                        	//if equal or nextMaxstring bigger than superTemp
                            nextMaxSuperString = superTemp;
                            subString = nextString;
                        }
                    }
                  }

                temp.remove(maxSuperString);  //remove the string which has finished contrast
                temp.remove(subString);      //
                maxSuperString = nextMaxSuperString;
                temp.add(maxSuperString);    //add the superstring back to temp set for comparison
            }

            finalsuperstring[i] = maxSuperString;
            System.out.println(finalsuperstring[i]);    //output each superstring
            i++;
        }

        String bestSol = finalsuperstring[0];

        for(i = 1; i < finalsuperstring.length; i++) {             //find out the shortest the superstring
            if(bestSol.length() > finalsuperstring[i].length()) {
                bestSol = finalsuperstring[i];
            }
        }

        return bestSol;

    }

    private String getSuperString(String String1, String String2) {
        String result = String1;

        int endIndex = String2.length() - 1;
        // substring() return a substring, which from 0 to endIndex; endsWith() tests if the string ends with the specified suffix.  
        while(endIndex > 0 && !String1.endsWith(String2.substring(0, endIndex)))	{    //compare the prefix of the string2 with the suffix of the string1
            endIndex--;
        }


        if(endIndex > 0) {
            result += String2.substring(endIndex);//add the prefix of the string2 to string1
        } else {
            result += String2;                    //else combine the string2 with the string1
        }

        return result;
    }


   public static void main(String[] args) {
	   
	   Set<String> fragments = new HashSet<String>();
	   
       SuperString2 superStringCreator = new SuperString2();

	    int fail=0, evid=-1; // failure flag + evidence

		float REF=33; // reference point

		float Quotient=100;

	    String Solution=""; // initialisation of the solution

		String[] S = new String[24];

		S[0] = "abcd";
		S[1] = "abdc";
		S[2] = "acbd";
		S[3] = "acdb";
		S[4] = "adbc";
		S[5] = "adcb";
		S[6] = "bacd";
		S[7] = "badc";
		S[8] = "bcad";
		S[9] = "bcda";

		S[10] = "bdac";
		S[11] = "bdca";
		S[12] = "cabd";
		S[13] = "cadb";
		S[14] = "cbad";
		S[15] = "cbda";
		S[16] = "cdab";
		S[17] = "cdba";
		S[18] = "dabc";
		S[19] = "dacb";
        S[20] = "dbac";
		S[21] = "dbca";
		S[22] = "dcab";
		S[23] = "dcba";
		
		int j = 0;
		for(j=0;j<S.length;j++) {
			fragments.add(S[j]);
			
		}


    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// YOU ARE ALLOWED TO INTRODUCE DEFINITIONS AND NEW METHODS ABOVE THIS LINE
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

		// Insert your solution below
		// In the current solution all strings from S[] are simply concatenated.
		// Try to improve this solution. Go as close as possible with quality quotient to (or even below) 1

		Solution=superStringCreator.createSuperString(fragments);
		System.out.println(" solution = \"" + Solution + "\", with length = " + Solution.length());
        
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// DO NOT CHANGE ANYTHING BELOW THIS LINE
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

		// computes how many string are not included

		for (int i = 0; i < 20; i++) {
			if (!Solution.contains(S[i])) {fail++;evid=i;}
		}

		// Calculation of the quality quotient (wrt the reference REF)

		Quotient=((float)Solution.length())/REF;

		if (fail>0) {System.out.println(" This is not a superstring, string S["+evid+"] is not included, #fails= "+fail);}
			else {System.out.println(" Well done! Your quality quotient= "+Quotient);}


   }

}