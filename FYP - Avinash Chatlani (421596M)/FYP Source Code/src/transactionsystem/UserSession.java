package transactionsystem;

public class UserSession {
	protected Integer sid;
	protected String log;
	protected Integer owner;
	
	public UserSession(Integer uid, Integer sid) {
		this.sid = sid;
		owner = uid;
		log = "";
	}

	public Integer getId() { return sid; }
	public Integer getOwner() { return owner; }
	public String getLog() { return log; }
	public void openSession() 
	{
	}
	public void log(String l) 
	{ 
		log+=l+"\n"; 
	}
	public void closeSession() 
	{
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
