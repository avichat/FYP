package re.structure;

import java.util.HashSet;
import java.util.Set;

import re.automata.NFA;



public class Nothing extends RE{

	
	public Nothing()
	{
	}
	
	public Set<Var> getVars()
	{
		return new HashSet<Var>();
	}
	
	public NFA toAutomaton(Set<String> identifiers) throws Exception
	{
		NFA fa = new NFA();
		
		return fa;
	}
	
	
	public String toString()
	{
		return "0";
	}
	
	public boolean hasEmpty()
	{
		return false;
	}
	
	public boolean isNothing()
	{
		return true;
	}
	
	public RE clone()
	{
		return new Nothing();
	}
	
	public String getConstructor()
	{
		return "new Nothing()";
	}
	
	public RE residual(String input)
	{
		return new Nothing();
	}
	
	public RE simplify()
	{	
		return this;
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