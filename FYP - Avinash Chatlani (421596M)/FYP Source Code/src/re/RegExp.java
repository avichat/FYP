
package re;

import java.util.Set;

import re.automata.DFA;
import re.automata.Label;
import re.automata.State;
import re.automata.Transition;
import re.structure.RE;

public class RegExp {
	
	public enum Matching {EXPECT, UNEXPECT};
	
	private RE re;	
	private Matching matching;
	
	private String foreach_type;
	private String foreach_variable;
	
	private Set<String> identifiers;
	
	public RegExp(RE re,
			Matching matching,
			String foreach_type,
			String foreach_variable,
			Set<String> identifiers)
	{
		this.re = re;
		this.matching = matching;
		this.foreach_type = foreach_type;
		this.foreach_variable = foreach_variable;
		this.identifiers = identifiers;
	}
	
	
	public RegExp(RE re, Matching matching,
			Set<String> identifiers)
	{
		this(re, matching, null, null,identifiers);
	}
	
	//getters

	public RE getRE()
	{
		return re;
	}
	
	
	public Matching getMatching()
	{
		return matching;
	}
	
	public String getForeachType()
	{
		return foreach_type;
	}
	
	public String getForeachVariable()
	{
		return foreach_variable;
	}
	
	public Set<String> getIdentifiers()
	{
		return identifiers;
	}
	
	//tostring
	public String toString()
	{
		String result = "property ";
		
		if (foreach_type != null)
		{
			result += "foreach target (" + foreach_type + " " + foreach_variable + ") ";
		}
		
		result += "{ "+ matching + " " + re + "}";
		
		return result;
		
	}
	
	
	//toAJ
	public String toAspectJAutomata() throws Exception
	{
		
		String result = "\n\n// the code for "+matching+": " + re.toString();
		
		//obtain a unique number
		String id = super.toString().substring(11);
		
		//obtain automaton
		DFA dfa = re.toAutomaton(getIdentifiers()).determinise().makeTotal(getIdentifiers());
		
		//complement if necessary
		//if we are trying to detect a violation according to a "correct" specification,
		//  then the final states are the good one while the non-final are the bad ones
		if (matching.equals(Matching.EXPECT))
			dfa.complement();
		
		//checkMonitor function
		if (foreach_type == null)
		{			
			//initial state
			result += "\nstatic String monitorState"+id+" = null;"
					+ "\nstatic void init" +id+ "(){ "
					+ "\n monitorState"+id+" = \""+dfa.getStartState().toString()+"\"; "
				//	+ "\n System.out.println(\" INITIALISED: "+matching+" "+re+"\"); "
							+ "}\n\n";
			
			result += "\n\nstatic boolean checkMonitor"+id+"(String state) { return state.equals(monitorState"+id+"); }";
		}
		else
		{   
			//Hashmap
			result += "\nstatic HashMap<"+foreach_type+", String> monitors"+id+" = null;";
			
			result +=  "\nstatic void init" +id+ "(){ monitors"+id+ "= new HashMap<"+foreach_type+", String>(); }\n\n";
			
			result += "\n\nstatic boolean checkMonitor"+id+"("+foreach_type+" target, String state) { "
					+ "\n if (monitors"+id+".containsKey(target))"
					+ "\n  return state.equals(monitors"+id+".get(target));"
					+ "\n else {"
					+ "\n  monitors"+id+".put(target, \""+dfa.getStartState().toString()+"\");"
					+ "\n  return state.equals(\""+dfa.getStartState().toString()+"\"); }"
					+ "\n }";
		}
		
		
		//setMonitor function
		if (foreach_type == null)
		{			
			result += "\n\nstatic boolean setMonitor"+id+"(String state) { "
					+ "\n  monitorState"+id+"=state; "
					+ "\n  return true; }";
			
			
		}
		else
		{   
			result += "\n\nstatic boolean setMonitor"+id+"("+foreach_type+" target, String state) { "
					+ "\n if (monitors"+id+".containsKey(target))"
					+ "\n { monitors"+id+".put(target,state);"
					+ "\n   return true; "
					+ "\n }"
					+ "\n else {"
					+ "\n  return false; }"
					+ "\n }";
		}
		
		
		
		for (Label l : dfa.getLabels())
		{
			
			result += "\n\nbefore ";
			
			if (foreach_variable == null)
				result += "()";
		    else
				result += "("+foreach_type+" "+foreach_variable+")";
			
			result += ": call(* *."+l+"(..))";
			
			if (foreach_variable != null) {
				result += " &&\n    target("+foreach_variable+")";
			}

			result +=  "{ \n if (1==0) {}";			
			
			for (Transition t : dfa.getTransitions())
				if (t.getLabel().equals(l))
			{
				
				if (foreach_type==null)
					
					result += 
						
						"\n   else if ( checkMonitor"+id+"(\"" + t.getSource() + "\")"
								// inserted the change of state in the condition to avoid messing with the action
								+"\n && (setMonitor"+id+"(\"" + t.getDestination() + "\"))) {";
					

				else
					
					result +=
							"\n   else if ( checkMonitor"+id+"(" + foreach_variable + ", \""+ t.getSource() + "\")"
							// inserted the change of state in the condition to avoid messing with the action
							+"\n && (setMonitor"+id+"("+foreach_variable+", \"" + t.getDestination() + "\"))) {";
					

				
				//display text related to destination state
			//	result += "\n System.out.println(\""+matching+" "+re+" REACHED STATE: "+t.getDestination()+"\");";
				
				//fail on a final state
				if (t.getDestination().isFinal())
					result += "\n Verification.fail(\" FAILED ON REGEXP "+matching+" "+re+"\");";
				
				result += "}\n";
			}
			result += "}\n";
		}
		return result;
	
	}
	
	public String toAspectJResiduals() throws Exception
	{
		
		String result = "\n\n// the code for "+matching+": " + re.toString();
		
		//obtain a unique number
		String id = super.toString().substring(11);
		
		
		
		//getCurrentREState function
		if (foreach_type == null)
		{			
			//initial state
			result += "\nstatic RE monitorState"+id+" = null;"
					+ "\nstatic void init" +id+ "(){ "
					+ "\n monitorState"+id+" = "+re.getConstructor()+"; "
				//	+ "\n System.out.println(\" INITIALISED: "+matching+" "+re+"\"); "
							+ "}\n\n";
			
			result += "\n\nstatic RE getCurrentREState"+id+"() { return monitorState"+id+"; }";
		}
		else
		{   
			//Hashmap
			result += "\nstatic HashMap<"+foreach_type+", RE> monitors"+id+" = null;";
			
			result +=  "\nstatic void init" +id+ "(){ monitors"+id+ "= new HashMap<"+foreach_type+", RE>(); }\n\n";
			
			result += "\n\nstatic RE getCurrentREState"+id+"("+foreach_type+" target) { "
					+ "\n if (monitors"+id+".containsKey(target))"
					+ "\n    return monitors"+id+".get(target);"
					+ "\n else {"
					+ "\n    return "+re.getConstructor()+"; }"
					+ "\n }";
		}
		
		//setCurrentREState function
		if (foreach_type == null)
		{			
			result += "\n\nstatic void setCurrentREState"+id+"(RE re) { monitorState"+id+"=re; }";
		}
		else
		{   
			result += "\n\nstatic void setCurrentREState"+id+"("+foreach_type+" target, RE re) { "
					+ "\n    monitors"+id+".put(target,re);"
					+ "\n }";
		}

		
		for (String s : this.identifiers)
		{
			result += "\n\nbefore ";
			
			if (foreach_variable == null)
				result += "()";
		    else
				result += "("+foreach_type+" "+foreach_variable+")";
			
			result += ": call(* *."+s+"(..))";
			
			if (foreach_variable != null) {
				result += " &&\n    target("+foreach_variable+")";
			}

			result += " {\n";
			
			if (foreach_type==null) {
				result += "\n    RE currentREState = getCurrentREState"+id+"();";
			} else {
				result += "\n    RE currentREState = getCurrentREState"+id+"(" + foreach_variable + ");";
			}      
			
			result +=  "\n    RE newREState = currentREState.residual(\""+s+"\").simplify();";
			
			//storing resulting residual
			if (foreach_type==null) {
				result += "\n    setCurrentREState"+id+"(newREState);";
			} else {
				result += "\n    setCurrentREState"+id+"(" + foreach_variable + ",newREState);";
			}	
			
			
	//		result +=  "\n    System.out.println(\""+matching+" \"+currentREState+\" ON "+s+" BECAME: \"+newREState);";
					
			if (matching.equals(Matching.EXPECT))		
				result +=  "\n    if (newREState.isNothing()) {";
			else 
				result +=  "\n    if (newREState.hasEmpty()) {";
	
				//fail on reaching "Nothing"

				result += "\n       Verification.fail(\" FAILED ON REGEXP "+matching+" "+re+"\");";
				
					
			
			result += "}\n  }";
		}
		
		
		return result;
	}
	
	//return a unique string for this object
	public String getInit()
	{
		return "init" +super.toString().substring(11)+"(); ";
	}
	//by Avinash Chatlani
	public String toLarvaAutomata() throws Exception 
	{
		
		DFA dfa = re.toAutomaton(getIdentifiers()).determinise().makeTotal(getIdentifiers());//.complement();
		
		String result = "GLOBAL {\n";
		
		result += "\tVARIABLES {\n";
		result += "\t}";
		
		result += "\n\tEVENTS {\n";
		for (Label l : dfa.getLabels())
		{
			result += "\t\t" + l +"() = {*." + l + "()}\n";
		}
		result += "\t}";
		
		result += "\n\tPROPERTY caseStudyProperty {\n";
		result += "\t\tSTATES {\n";
		
//		result += "\t\t\tACCEPTING {\n";
//		for(State s : dfa.getStates())
//		{
//			if(s.isFinal())
//			result += "\t\t\t\t" + s + "\n";
//		}
//		result += "\t\t\t}\n";
		
		result += "\t\t\tBAD {\n";
		for(State s : dfa.getStates())
		{
			if(s.isFinal())
			result += "\t\t\t\t" + removePunc(s.toString()) + "\n";
		}
		result += "\t\t\t}\n";
		
		result += "\t\t\tNORMAL {\n";
		for(State s : dfa.getStates())
		{
			if(!s.isFinal() && !s.isStarting())
			result += "\t\t\t\t" + removePunc(s.toString()) + "\n";
		}
		result += "\t\t\t}\n";
		
		result += "\t\t\tSTARTING {\n";
		result += "\t\t\t\t" + removePunc(dfa.getStartState().toString()) + "\n";
		result += "\t\t\t}\n";
		result += "\t\t}\n";
//		String test = dfa.getStates().toString();
//		test = test.replace("(", "");
//		test = test.replace(")", "");
//		test = test.replace("[", "");
//		test = test.replace("]", "");
//		test = test.replace("{", "");
//		test = test.replace("}", "");
//		test = test.replace(",", "");
//		test = test.replace(" ", "");
//		System.out.println((removePunc(dfa.getStates().toString())));
		result += "\t\tTRANSITIONS {\n";
		for (Label l : dfa.getLabels())
		{
			for (Transition t : dfa.getTransitions())
			{
				if (t.getLabel().equals(l))
				{
					result += "\t\t\t" + removePunc(t.getSource().toString()) + " -> " + removePunc(t.getDestination().toString()) + " [" + t.getLabel() + "()]\n";
				}
			}
		
		}
		result += "\t\t}\n";		
		result += "\t}\n";	
		result += "\n}";
		return result;
	}
	//by Avinash Chatlani
	public String toLarvaResidual() throws Exception 
	{
		
		//DFA dfa = re.toAutomaton(getIdentifiers()).determinise().makeTotal(getIdentifiers());//.complement();
		String stateStarting = "start";
		String stateBad = "bad";
	//	String stateAccepting = "AS";
	//	String stateNormal = "NS";
		
		String result = "";
		result = "IMPORTS {\n";
		result += "\timport re.structure.*;\n";
		result += "}\n";
		result += "GLOBAL {\n";
		
		result += "\tVARIABLES {\n";
		result += "\t\tRE re = " + re.getConstructor() + ";\n";
		result += "\t}";
		
		result += "\n\tEVENTS {\n";
		for (String s : this.identifiers)
		{
			result += "\t\t" + s +"() = {*." + s + "()}\n";
		}
		result += "\t}";
		
		result += "\n\tPROPERTY caseStudyProperty {\n";
		result += "\t\tSTATES {\n";
		
//		result += "\t\t\tACCEPTING {\n";
//		for(State s : dfa.getStates())
//		{
//			if(s.isFinal())
//			result += "\t\t\t\t" + s + "\n";
//		}
//		result += "\t\t\t}\n";
		
		result += "\t\t\tBAD {\n";
		result += "\t\t\t\t" + stateBad + "\n";
//		for(State s : dfa.getStates())
//		{
//			if(s.isFinal())
//			result += "\t\t\t\t" + removePunc(s.toString()) + "\n";
//		}
		result += "\t\t\t}\n";
		
//		result += "\t\t\tNORMAL {\n";
//		for(State s : dfa.getStates())
//		{
//			if(!s.isFinal() && !s.isStarting())
//			result += "\t\t\t\t" + removePunc(s.toString()) + "\n";
//		}
//		result += "\t\t\t}\n";
		
		result += "\t\t\tSTARTING {\n";
		result += "\t\t\t\t" + stateStarting + "\n";
		result += "\t\t\t}\n";
		result += "\t\t}\n";
//		String test = dfa.getStates().toString();
//		test = test.replace("(", "");
//		test = test.replace(")", "");
//		test = test.replace("[", "");
//		test = test.replace("]", "");
//		test = test.replace("{", "");
//		test = test.replace("}", "");
//		test = test.replace(",", "");
//		test = test.replace(" ", "");
//		System.out.println((removePunc(dfa.getStates().toString())));
		result += "\t\tTRANSITIONS {\n";
		for (String s : this.identifiers)
		{
			//for (Transition t : dfa.getTransitions())
			//{
				//if (t.getLabel().equals(s))
				{
					//result += "\t\t\t" + stateStarting + " -> " + stateBad + " [" + s + "() \\ re.residual(" +"\"" + s +"\"" + ").simplify().toString().equals(" + "\"" + "1" + "\"" + ")]\n";
					//result += "\t\t\t" + stateStarting + " -> " + stateStarting + " [" + s + "() \\\\ " + "re.residual(\""+ s +"\").simplify();" +"]\n";
					
					result += "\t\t\t" + stateStarting + " -> " + stateBad + " [" + s + "() \\ re.residual(" +"\"" + s +"\"" + ").simplify().hasEmpty()]\n";
					result += "\t\t\t" + stateStarting + " -> " + stateStarting + " [" + s + "() \\\\ " + "re = re.residual(\""+ s +"\").simplify();" +"]\n";
				
				}
		//	}
		
		}
		result += "\t\t}\n";		
		result += "\t}\n";	
		return result;
	}
	//by Avinash Chatlani
	public String removePunc(String test) {
		test = test.replace("(", "");
		test = test.replace(")", "");
		test = test.replace("[", "");
		test = test.replace("]", "");
		test = test.replace("{", "");
		test = test.replace("}", "");
		test = test.replace(",", "");
		test = test.replace(" ", "");
		return test;
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
