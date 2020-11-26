package soapServicesWithAxis2;

import soapServicesWithAxis2.EnricoStub.DateType;
import soapServicesWithAxis2.EnricoStub.IsWorkDay;
import soapServicesWithAxis2.EnricoStub.IsWorkDayResponse;
import soapServicesWithAxis2.EnricoStub.IsWorkDayType;

public class IsWorkDayEnrico 
{
	public static void main(String[] args) throws Exception
	{
		EnricoStub stub=new EnricoStub();
		DateType dt=new DateType();
		dt.setDay(4);
		dt.setMonth(7);
		dt.setYear(2020);
		IsWorkDay req=new IsWorkDay();
		req.setDate(dt);
		req.setCountry("usa");
		req.setRegion("ca");
		IsWorkDayResponse res=stub.isWorkDay(req);
		IsWorkDayType l=res.getIsWorkDay();
		boolean b=l.getIsWorkDay();
		if(b)
		{
			System.out.println("Yes, it is a working day");
		}
		else
		{
			System.out.println("No, it is not a working day");
		}
	}
}
