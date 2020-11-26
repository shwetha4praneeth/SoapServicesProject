package soapServicesWithAxis2;

import java.math.BigInteger;

import soapServicesWithAxis2.EnricoStub.GetHolidaysForMonth;
import soapServicesWithAxis2.EnricoStub.GetHolidaysForMonthResponse;
import soapServicesWithAxis2.EnricoStub.HolidayCollectionType;
import soapServicesWithAxis2.EnricoStub.HolidayType;

public class GetHolidaysForMonthEnrico 
{
	public static void main(String[] args) throws Exception
	{
		//Create object Stub class
		EnricoStub stub=new EnricoStub();
		//Create request object with parameters
		GetHolidaysForMonth req=new GetHolidaysForMonth();
		Integer m=new Integer(11);
		BigInteger bm=BigInteger.valueOf(m);
		Integer y=new Integer(2020);
		BigInteger by=BigInteger.valueOf(y);
		req.setMonth(bm);
		req.setYear(by);
		req.setCountry("usa");
		req.setRegion("mn");
		req.setHolidayType("public_holiday");
		try
		{
			GetHolidaysForMonthResponse res=stub.getHolidaysForMonth(req);
			HolidayCollectionType l=res.getHolidays();
			HolidayType x[]=l.getHoliday();
			for(int i=0;i<x.length;i++)
			{
				System.out.println(x[i].getDate().getDay()+":"+x[i].getHolidayType());
			}
		}
			catch(Exception ex)
			{
				System.out.println("No holidays in that month");
			}
	}
}
