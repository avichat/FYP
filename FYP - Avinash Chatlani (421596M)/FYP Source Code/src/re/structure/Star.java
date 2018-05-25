package re.structure;

import java.util.Set;

import re.automata.Label;
import re.automata.NFA;
import re.automata.State;
import re.automata.Transition;


public class Star extends RE{

	private RE op;
	
	public Star(RE op)
	{
		this.op = op;
	}	
	
	public RE get()
	{
		return op;
	}
	
	public Set<Var> getVars()
	{
		return op.getVars();
	}
	
	public NFA toAutomaton(Set<String> identifiers) throws Exception
	{
		NFA fa = new NFA();
		
		//create a starting and a final state
		State starting = new State(State.STARTING, State.NONFINAL);
		State finall = new State(State.NONSTARTING, State.FINAL);
		
		//a transition from start to end
		fa.addTransition(new Transition(starting, Label.empty, finall));
		
		NFA sub = op.toAutomaton(identifiers);
		
		for (State s: sub.getStates())
		{
			if (s.isStarting())
			{
				s.setStarting(State.NONSTARTING);
				
				//from the new start state to the old starting
				fa.addTransition(new Transition(starting, Label.empty, s));
				
				//create a loop by connecting the new final state to the old starting
				fa.addTransition(new Transition(finall, Label.empty, s));
			}
			
			if (s.isFinal())
			{
				s.setFinal(State.NONFINAL);
				
				//connect the old final to the new
				fa.addTransition(new Transition(s, Label.empty, finall));
			}
		}
		
		//copy the existing transitions
		fa.addTransitionSet(sub.getTransitions());
		
		
		return fa;
	}
	
	public String toString()
	{
		return "(" + op + ")*";
	}
	
	public boolean hasEmpty()
	{
		return true;
	}
	
	public boolean isNothing()
	{
		return op.isNothing();
	}
	
	public RE clone()
	{
		return new Star(op.clone());
	}
	
	public String getConstructor()
	{
		return "new Star("+ op.getConstructor() + ")";
	}
	
	public RE residual(String input)
	{
		return new Seq(op.residual(input),this.clone());
	}
	
	public RE simplify()
	{	
		op = op.simplify();
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