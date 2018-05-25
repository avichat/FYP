
package re.automata;

public class Transition {

	private State source;
	
	private Label label;
	
	private State destination;
	
	
	public Transition(State source, Label label, State destination)
	{
		this.source = source;
		this.label = label;
		this.destination = destination;
	}
	
	public Transition(State source, String label, State destination)
	{
		this.source = source;
		this.label = new Label(label);
		this.destination = destination;
	}
	
	public int hashCode()
	{
		return source.hashCode() + label.hashCode() + destination.hashCode();
	}
	
	public boolean equals(Object o)
	{
		if (o == null || !(o instanceof Transition))
			return false;
		else
		{
			Transition t = (Transition)o;
			if (source == null && t.source!=null)
					return false;
			else if (destination == null && t.destination!=null)
					return false;
			else if (label == null && t.label!=null)
				return false;
			else 
				return source.equals(t.source) && destination.equals(t.destination) && label.equals(label);
		}
	}
	
	
	public State getSource()
	{
		return source;
	}
	
	public State getDestination()
	{
		return destination;
	}
	
	public Label getLabel()
	{
		return label;
	}
	
	public String toString()
	{
		return source + "-[" + label + "]->" + destination; 
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
