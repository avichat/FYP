package re.structure;

import java.util.HashSet;
import java.util.Set;

import re.automata.NFA;
import re.automata.State;
import re.automata.Transition;



public class Any extends RE{

	
	public Any()
	{
	}
	
	public Set<Var> getVars()
	{
		return new HashSet<Var>();
	}
	
	public NFA toAutomaton(Set<String> identifiers) throws Exception
	{
		NFA fa = new NFA();
		
		//create a starting and a final state
		State starting = new State(State.STARTING, State.NONFINAL);
		State finall = new State(State.NONSTARTING, State.FINAL);
		
		//create a transition for every variable
		for (String identifier: identifiers)
			fa.addTransition(new Transition(starting, identifier, finall));
		
		return fa;
	}
	
	public String toString()
	{
		return "?";
	}
	
	public boolean hasEmpty()
	{
		return false;
	}
	
	public boolean isNothing()
	{
		return false;
	}
	
	public RE clone()
	{
		return new Any();
	}
	
	public String getConstructor()
	{
		return "new Any()";
	}
	
	public RE residual(String input)
	{
		return new End();
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