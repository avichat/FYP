
package re;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
//import re.automata.Label;

public class REScript {

	// Data
	private ArrayList<RegExp> regExps;
	private String auxiliaryCode;
	private String prelude;
	
	// Constructors
	public REScript() 
	{
		regExps = new ArrayList<RegExp>();
		auxiliaryCode = "";
		prelude = "";
	}
	public REScript(String filename) throws Exception
	{
		String re_txt = "";
		String code_txt = "";
		String prelude_txt = "";
		Integer readMode = 0; 
		// 0=before VERIFICATIONCODE, 1=in VERIFICATIONCODE, 2=in PRELUDE, 3=in RULES
				
		BufferedReader br = new BufferedReader(new FileReader(filename));
	    try {
	        String line = br.readLine();

	        while (line != null) {
	        	line = line.trim();

	        	switch (readMode) {
	        	case 0:
	        		if (line.equals("VERIFICATIONCODE")) {
	        			readMode = 1;
	        		} else
	        		if (!(line.equals("")  || line.startsWith("//"))) { 
	        			throw (new Exception("Non-comment line before VERIFICATIONMODULE")); 
	        		}
	        		break;
	        	case 1:
	        		if (line.equals("PRELUDE")) {
	        			readMode = 2;
	        		} else {
	        			code_txt += line+"\n";
	        		}
	        		break;
	        	case 2:
	        		if (line.equals("REGULAREXPRESSIONS")) {
	        			readMode = 3;
	        		} else {
	        			prelude_txt += line+"\n";
	        		}
	        		break;
	        	case 3:
	        		if (!line.startsWith("//")) {
	        			re_txt += line+" ";
	        		}	        		
	        	}
	            line = br.readLine();
	        }
	    } finally {
	        br.close();
	    }
    	if (readMode < 3) 
    		throw (new Exception("Missing parts of REGULAREXPRESSIONS script")); 
	    
	    auxiliaryCode = code_txt;
	    prelude = prelude_txt;
	    regExps = REParser.parseRegExps(re_txt);
	}
	
	// Getters
	public ArrayList<RegExp> getRegExps() 
	{ 
		return regExps; 
	}
	public String getAuxiliaryCode() 
	{
		return auxiliaryCode;
	}
	public String getPrelude()
	{
		return prelude;
	}
	
	
	// Setters
	public void setAuxiliaryCode(String s)
	{ 
		auxiliaryCode = s;
	}
	public void addRegExp(RegExp regExp) 
	{
		regExps.add(regExp);
	}
	public void setPrelude(String s)
	{
		prelude = s;
	}
	
	// Pretty printing
	public String toString() 
	{
		String result = auxiliaryCode + "\n\nREGULAREXPRESSIONS\n\n";

		Iterator<RegExp> iterator = regExps.iterator();
		while (iterator.hasNext()) {
			result += iterator.next().toString()+";\n";
		}
		
		return result;
	}
	
	
	public String toAspectJAutomata() throws Exception
	{
		String result = 
				prelude+"\n\npublic aspect Properties {\n";
		
        for (RegExp a : regExps){
      	  result += a.toAspectJAutomata()+"\n\n";
        }
        
        
        result += "public static void initialise() {";
        for (RegExp a : regExps){
      	  result += a.getInit()+"\n";
        }
        
		result += "\n}\n}\n";
		
        return result;
	}

	public String toAspectJResiduals() throws Exception
	{
		String result = 
				prelude+"\n\npublic aspect Properties {\n";
		
        for (RegExp a : regExps){
      	  result += a.toAspectJResiduals()+"\n\n";
        }
        
        
        result += "public static void initialise() {";
        for (RegExp a : regExps){
      	  result += a.getInit()+"\n";
        }
        
		result += "\n}\n}\n";
        
	
		
        return result;
	}
	//by Avinash Chatlani
	public String toLarvaAutomata() throws Exception
	{
		
		String result = "";
		
        for (RegExp a : regExps){
      	  result += a.toLarvaAutomata()+"\n\n";
        }
        
        
        //result += "public static void initialise() {";
//        for (RegExp a : regExps){
//      	  result += a.getInit()+"\n";
//        }
//        
//		result += "\n}\n}\n";
		
        return result;
	}
	//by Avinash Chatlani
	public String toLarvaResidual() throws Exception
	{
		String result = "";
	
        for (RegExp a : regExps){
      	  result += a.toLarvaResidual()+"\n\n";
        }
        
        
        //result += "public static void initialise() {";
//        for (RegExp a : regExps){
//      	  result += a.getInit()+"\n";
//        }
//        
//		result += "\n}\n}\n";
		result += "\n}";
        return result;
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