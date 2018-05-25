package re.structure;

import java.util.Set;

import re.automata.NFA;


public class Or extends RE{

	private RE op1, op2;
	
	public Or(RE op1, RE op2)
	{
		this.op1 = op1;
		this.op2 = op2;
	}	
	
	public RE get1()
	{
		return op1;
	}
	
	public RE get2()
	{
		return op2;
	}
	
	public Set<Var> getVars()
	{
		Set<Var> vars = op1.getVars();
		vars.addAll(op2.getVars());
		
		return vars;
	}
	
	public NFA toAutomaton(Set<String> identifiers) throws Exception
	{
		return NFA.choice(op1.toAutomaton(identifiers), op2.toAutomaton(identifiers));
	}
	
	public String toString()
	{
		return "(" + op1 + " + " + op2 + ")";
	}
	
	public boolean hasEmpty()
	{
		return op1.hasEmpty() || op2.hasEmpty();
	}
	
	public boolean isNothing()
	{
		return op1.isNothing() && op2.isNothing();
	}
	
	public RE clone()
	{
		return new Or(op1.clone(), op2.clone());
	}
	
	public String getConstructor()
	{
		return "new Or("+op1.getConstructor()+","+ op2.getConstructor()+")";
	}
	
	public RE residual(String input)
	{
		return new Or(op1.residual(input),op2.residual(input));
	}
	
	public RE simplify()
	{
		op1 = op1.simplify();
		op2 = op2.simplify();
		
		if (op1 instanceof Nothing)
			return op2;
		else if (op2 instanceof Nothing)
			return op1;
		
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