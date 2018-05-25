
package re.automata;

import java.util.HashSet;
import java.util.Set;

public abstract class FA {
	
	private Set<State> states = new HashSet<State>();
	private Set<Label> labels = new HashSet<Label>();
	private Set<Transition> transitions = new HashSet<Transition>();
	
	//returns true is t does not already exist in transitions
	//note this is overridden in DFAs to check to non-determinism
	public boolean addTransition(Transition t)throws Exception
	{
		State source=null;
		State destination=null;
		
		//ensure that the actual object states referred to by the transition are actually pointed to by the Set of states
		//otherwise when complementing some states will not be affected
		if (!states.add(t.getSource()))
		{
			for (State s: states)
				if (s.equals(t.getSource()))
				{
					source = s;
					break;
				}
		}		
		else
			source = t.getSource();
		
		if (!states.add(t.getDestination()))
		{
			for (State s: states)
				if (s.equals(t.getDestination()))
				{
					destination = s;
					break;
				}
		}else
			destination = t.getDestination();
		
		
		labels.add(t.getLabel());
		
		return transitions.add(new Transition(source,t.getLabel(),destination));
	}
	
	public void addTransitionSet(Set<Transition> transitions) throws Exception
	{
		for (Transition t : transitions)
			addTransition(t);
	}
	
	public Set<State> getStates()
	{
		return states;
	}
	
	public Set<Label> getLabels()
	{
		return labels;
	}
	
	public Set<Transition> getTransitions()
	{
		return transitions;
	}
	
	public abstract DFA determinise();
	
	public String toString()
	{
		return transitions.toString();
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