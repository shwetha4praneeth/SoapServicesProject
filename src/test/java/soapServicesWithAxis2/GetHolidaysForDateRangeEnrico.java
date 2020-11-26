package soapServicesWithAxis2;

import soapServicesWithAxis2.EnricoStub.DateType;
import soapServicesWithAxis2.EnricoStub.GetHolidaysForDateRange;
import soapServicesWithAxis2.EnricoStub.GetHolidaysForDateRangeResponse;
import soapServicesWithAxis2.EnricoStub.GetHolidaysForYear;
import soapServicesWithAxis2.EnricoStub.HolidayCollectionType;
import soapServicesWithAxis2.EnricoStub.HolidayType;
import soapServicesWithAxis2.EnricoStub.IsPublicHoliday;

public class GetHolidaysForDateRangeEnrico 
{
	public static void main(String[] args) throws Exception
	{
		EnricoStub stub=new EnricoStub();
		GetHolidaysForDateRange req=new GetHolidaysForDateRange();
		DateType dt1=new DateType();
		dt1.setDay(1);
		dt1.setMonth(1);
		dt1.setYear(2020);
		DateType dt2=new DateType();
		dt1.setDay(31);
		dt1.setMonth(12);
		dt1.setYear(2021);
		req.setFromDate(dt1);
		req.setToDate(dt2);
		req.setCountry("usa");
		req.setRegion("ca");
		req.setHolidayType("public_holiday");
		try
		{
			GetHolidaysForDateRangeResponse res=stub.getHolidaysForDateRange(req);
			HolidayCollectionType l=res.getHolidays();
			HolidayType x[]=l.getHoliday();
			for(int i=0;i<x.length;i++)
			{
				DateType dt=x[i].getDate();
				System.out.println(dt.getDay()+"-"+dt.getMonth()+"-"+dt.getYear()+":"+x[i].getHolidayType());
			}
		}
		catch(Exception ex)
		{
			System.out.println("No holidays in that year");
		}
	}
}
