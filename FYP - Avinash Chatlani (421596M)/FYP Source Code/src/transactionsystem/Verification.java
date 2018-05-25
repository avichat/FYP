
package transactionsystem;

import java.util.Set;
import java.util.HashSet;


public class Verification {

static Set<String> msgs;

static public void initialiseVerification()
{
System.out.println("\n\n");
msgs = new HashSet<String>();
//Properties.initialise();
}
 
static public void fail(String s) {

if (msgs.add(s))
System.out.println("ERROR: "+s);
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
