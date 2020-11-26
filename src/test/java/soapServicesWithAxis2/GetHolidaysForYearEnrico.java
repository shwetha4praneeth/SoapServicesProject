package soapServicesWithAxis2;

import java.math.BigInteger;

import soapServicesWithAxis2.EnricoStub.DateType;
import soapServicesWithAxis2.EnricoStub.GetHolidaysForYear;
import soapServicesWithAxis2.EnricoStub.GetHolidaysForYearResponse;
import soapServicesWithAxis2.EnricoStub.HolidayCollectionType;
import soapServicesWithAxis2.EnricoStub.HolidayType;

public class GetHolidaysForYearEnrico 
{
	public static void main(String[] args) throws Exception
	{
		EnricoStub stub=new EnricoStub();
		GetHolidaysForYear req=new GetHolidaysForYear();
		Integer y=new Integer(2020);
		BigInteger by=BigInteger.valueOf(y);
		req.setYear(by);
		req.setCountry("usa");
		req.setRegion("ca");
		req.setHolidayType("public_holiday");
		try
		{
			GetHolidaysForYearResponse res=stub.getHolidaysForYear(req);
			HolidayCollectionType l=res.getHolidays();
			HolidayType x[]=l.getHoliday();
			for(int i=0;i<x.length;i++)
			{
				DateType dt=x[i].getDate();
				System.out.println(dt.getDay()+"-"+dt.getMonth()+":"+x[i].getHolidayType());
			}
		}
		catch(Exception ex)
		{
			System.out.println("No holidays in that year");
		}
	}
}
