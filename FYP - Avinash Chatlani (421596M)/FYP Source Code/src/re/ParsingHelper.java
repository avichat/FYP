
package re;


import re.structure.RE;

public class ParsingHelper {

	private String s;
	private RE temp;
	

	public ParsingHelper(String s)
	{
		this.s = s;
	}
	
	public String consumeString(int len)
	{
		s=s.substring(len).trim();
		return s;
	}
	
	public boolean startsWith(String test)
	{
		return s.startsWith(test);
	}
	
	public boolean end()
	{
		return s.length()==0;
	}
	
	public String getString ()
	{
		return s;
	}
	
	public RE getTemp()
	{
		return temp;
	}
	
	public void setTemp(RE temp)
	{
		this.temp = temp;
	}
	
	public String getIdentifier(String stops)
	{
		int i = 0;
		while (i<s.length() && !stops.contains(Character.toString(s.charAt(i))))
		{ 
			i++;
		}
		
		String identifier = s.substring(0, i);
		consumeString(i);
		
		REParser.registerIdentifier(identifier);
		
		return identifier;
	}
	
	
	// The initial string enclosed between '(' and ')'.
		// Throws an exception if (i) the string does not start with '('; or (i) contains 
		// unbalanced or unclosed delimiters.
	 public Integer getBracketed() throws Exception
		{
			Integer balance = 0, i;

			if (s.charAt(0) != '(') throw (new Exception("Action not enclosed in brackets"));
			
			for (i=0; i<s.length(); i++) {
				switch (s.charAt(i)) {
				case '(': 
					balance++; break;
				case ')': 
					if (balance == 0) { throw (new Exception("Unbalanced '(' and ')' in automaton")); } 
					if (balance == 1) { return (i+1); }
					balance--; break;
				}

			}
			throw (new Exception("Unclosed '(' in regular expression"));
		}
	
	 public String toString()
	 {
		 return "Processing: "+ temp + " ... " + s;
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
