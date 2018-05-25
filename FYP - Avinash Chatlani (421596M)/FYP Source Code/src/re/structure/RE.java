package re.structure;

import java.util.Set;

import re.automata.NFA;

public abstract class RE {
	
	/* RE ::= 
	 *     |    ?        Any
	 *     |    0        Nothing
	 *     |    1        End of string
	 *     |    a        Proposition
	 *     |    !a       All the propositions except a
	 *     |    RE + RE  Choice
	 *     |    RE ; RE  Sequence
	 *     |    RE*      Repetition
	 *     |    (RE)     Bracketed expression
	 */
	
	public abstract NFA toAutomaton(Set<String> identifiers) throws Exception;

	public abstract Set<Var> getVars();
	
	public abstract boolean hasEmpty();
	
	public abstract RE clone();
	
	public abstract RE residual(String input);
	
	public abstract String getConstructor();
	
	public abstract boolean isNothing();
	
	public abstract RE simplify();
	public abstract String toString();
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