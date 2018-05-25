package transactionsystem;

public class Main {
	//Modified by Avinash Chatlani
	public static void main(String [] args) 
	{
		//long start = System.currentTimeMillis();
		Runtime.getRuntime().gc();
		long current = System.nanoTime();
		long memory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		
		//Scenarios.runAllScenarios();
		Scenarios.runAllScenario4();
		//Scenarios.runAllScenario10();
		//Scenarios.runAllScenario12();
		//Scenarios.runAllScenario20();
		
//		System.out.println(System.currentTimeMillis() - start);
//        long L = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//        System.out.println(L);
		Runtime.getRuntime().gc();
        long memory2 = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		
		System.out.println("Test took " + ((System.nanoTime()-current)/(double)1000000) + " milliseconds ");
		System.out.println("Test used " + ((memory2 - memory)/(double)1000) + " Kb ");
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
