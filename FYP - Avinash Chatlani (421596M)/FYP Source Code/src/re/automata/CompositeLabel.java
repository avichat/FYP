
package re.automata;

import java.util.Set;
import java.util.TreeSet;

public class CompositeLabel extends Label {

	private Set<String> subLabels = new TreeSet<String>(); 
	
	
	public CompositeLabel()
	{
		super();
	}
	
	public CompositeLabel(String s)
	{
		super();
		addLabel(s);
	}
	
	public CompositeLabel(String... ss)
	{
		super();
		for (String s: ss)
			addLabel(s);
	}
	
//	public CompositeLabel(Set<String> ss)
//	{
//		super();
//		for (String s: ss)
//			addLabel(s);
//	}
	
	public CompositeLabel(Set<State> ss)
	{
		super();
		for (State s : ss)
			addLabel(s.getLabel().toString());
	}
	
	public CompositeLabel addLabel(String s)
	{
		subLabels.add(s);
		return this;
	}
	
	public boolean addComposite(CompositeLabel cl)
	{
		return subLabels.addAll(cl.getSubLabels());
	}
	
	public int hashCode()
	{
		return 0;
	}
	
	public boolean equals(Object o)
	{
		if (o == null)
			return false;
		else if (!(o instanceof CompositeLabel))
			return false;
		else 
			return ((CompositeLabel)o).toString().equals(toString());
	}
	
	public Set<String> getSubLabels()
	{ 
		return subLabels;
	}
	
	public String toString()
	{
		return "{"+subLabels+"}";
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
