

package re;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainResiduals {
	
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
					
				//	"/Users/gordonpace/Documents/Dropbox"
				//	+ "/Data/Current Work/> Papers/InProgress/Book-RV/Code"
				//	+ "/FiTS/Code/FinancialTransactions-03-GCL-Solution/src/properties.rs");
			try {
//		          File file_java = new File(userPath + coursePath + topicPath
//							+ "/transactionsystem/Verification.java");
//		        		  
//		          BufferedWriter output = new BufferedWriter(new FileWriter(file_java));
//		          output.write(script.getAuxiliaryCode());
//		          output.close();
		          
		          
//		          File file_aj = new File(userPath + coursePath + topicPath
//							+ "/transactionsystem/Properties.aj");
//		          output = new BufferedWriter(new FileWriter(file_aj));
//  		  		  output.write(script.toAspectJResiduals());
//		          output.close();
		          
		          File file_lrv = new File(userPath + coursePath + topicPath
							+ "caseStudy.lrv");
		          BufferedWriter output = new BufferedWriter(new FileWriter(file_lrv));
		  		  output.write(script.toLarvaResidual());
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
