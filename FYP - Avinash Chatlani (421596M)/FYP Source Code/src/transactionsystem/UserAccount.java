package transactionsystem;

public class UserAccount {
	protected boolean opened;
	protected String account_number;
	protected double balance;
	protected Integer owner;
	
	public UserAccount(Integer uid, String anumber) {
		account_number = anumber;
		balance = 0;
		opened = false;
		owner = uid;
	}

	public String getAccountNumber() 
	{ 
		return account_number; 
	}
	public double getBalance()
	{
		return balance;
	}
	public Integer getOwner()
	{
		return owner;
	}
	
	public void activateAccount()
	{
		opened = true;
	}
	public void closeAccount() 
	{
		opened = false;
	}

	public void withdraw(double amount) 
	{
		balance -= amount;
	}
	public void deposit(double amount) 
	{
		balance += amount;
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