package com.capgemini.springcore;

import com.capgemini.springcore.bean.EmployeeAddressInfo;
import com.capgemini.springcore.bean.EmployeePrimaryInfo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EmployeeAddressInfo address  = new EmployeeAddressInfo();
    	address.setAid(1);
    	address.setCity("Hyd");
    	address.setAddressType("Permanent");
    	EmployeePrimaryInfo info = new EmployeePrimaryInfo();
    	info.setId(2);
    	info.setName("Shalini");
    	info.setAddress(address);
    }
}
