
package re;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import re.automata.DFA;
import re.automata.NFA;

public class MainAutomata {
	
	//modified by Avinash Chatlani
	public static void main(String [] args) 
	{
		long start = System.currentTimeMillis();
		String userPath = "/Users/Owner/workspace/FYPAJ/src/";
		String coursePath = "";
		
		
		String topicPath = "";
		
		try {
			REScript script = new REScript(userPath + coursePath + topicPath
					+ "/properties.txt");
					
			
			try {
//		          File file_java = new File(userPath + coursePath + topicPath
//							+ "/transactionsystem/Verification.java");
//		        		  
//		          BufferedWriter output = new BufferedWriter(new FileWriter(file_java));
//		          output.write(script.getAuxiliaryCode());
//		          output.close();

		          //this is purely for display purposes
		          for (RegExp re : script.getRegExps())
		          {
		        	    System.out.println("\n");
		        	  	
		        	    System.out.println("RE: " + re.getMatching() +" " + re.getRE());
		        	  	
		        	    NFA nfa = re.getRE().toAutomaton(re.getIdentifiers());
		        	    
		        	  	System.out.println("Equivalent Automaton: " + nfa);
		        	  	
		        	  	DFA dfa = nfa.determinise();
		        	  	
		        	  	System.out.println("Equivalent Deterministic Automaton: " + dfa);
		        	  	
		        	  	System.out.println("Total Automaton: " + dfa.makeTotal(re.getIdentifiers()));
		        	  	
		        	  	System.out.println("Complemented Automaton: " + dfa.complement());
		        	  	
		        	  	System.out.println("\n");
		          }
		          
		          
//		          File file_aj = new File(userPath + coursePath + topicPath
//							+ "/transactionsystem/Properties.aj");
//		          output = new BufferedWriter(new FileWriter(file_aj));
//  		  		  output.write(script.toAspectJAutomata());
//		          output.close();
		          
		          File file_lrv = new File(userPath + coursePath + topicPath
							+ "caseStudy.lrv");//caseStudy.lrv
		          BufferedWriter output = new BufferedWriter(new FileWriter(file_lrv));
		  		  output.write(script.toLarvaAutomata());
		          output.close();
		          //System.out.println(System.currentTimeMillis() - start);
		          long endTime = System.currentTimeMillis();
		          System.out.println("Total execution time: " + (endTime-start) + "ms");
		          long L = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		          System.out.println("Total used memory: " + L + " bytes");

			} catch ( IOException e ) {
		           e.printStackTrace();
		        }
		} catch (Exception msg) {
			System.out.println("Error: ");
			msg.printStackTrace();
		}
	}
	
}

/*This file is part of ARVISummerSchoolCode.

Copyright (C) 2016  Christian Colombo
Modified by Avinash Chatlani 2018
ARVISummerSchoolCode is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

ARVISummerSchoolCode is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with files from ARVISummerSchoolCode.  If not, see <http://www.gnu.org/licenses/>.
*/
