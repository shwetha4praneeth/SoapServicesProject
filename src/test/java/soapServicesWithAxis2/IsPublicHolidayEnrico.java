package soapServicesWithAxis2;

import soapServicesWithAxis2.EnricoStub.DateType;
import soapServicesWithAxis2.EnricoStub.IsHolidayType;
import soapServicesWithAxis2.EnricoStub.IsPublicHoliday;
import soapServicesWithAxis2.EnricoStub.IsPublicHolidayResponse;

public class IsPublicHolidayEnrico 
{
	public static void main(String[] args) throws Exception
	{
		//Create object Stub class
		EnricoStub stub=new EnricoStub();
		//Create request object with parameters
		DateType dt=new DateType();
		dt.setDay(4);
		dt.setMonth(7);
		dt.setYear(2020);
		IsPublicHoliday req=new IsPublicHoliday();
		req.setDate(dt);
		req.setCountry("usa");
		req.setRegion("ca");
		IsPublicHolidayResponse res=stub.isPublicHoliday(req);
		IsHolidayType l=res.getIsPublicHoliday();
		boolean b=l.getIsHoliday();
		if(b)
		{
			System.out.println("Yes, it is a holiday");
		}
		else
		{
			System.out.println("No, it is not a holiday");
		}
	}
}
