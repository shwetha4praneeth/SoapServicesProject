package soapServicesWithAxis2;

import soapServicesWithAxis2.EnricoStub.DateType;
import soapServicesWithAxis2.EnricoStub.LocalizedStringType;
import soapServicesWithAxis2.EnricoStub.WhereIsPublicHoliday;
import soapServicesWithAxis2.EnricoStub.WhereIsPublicHolidayCountryListType;
import soapServicesWithAxis2.EnricoStub.WhereIsPublicHolidayResponse;
import soapServicesWithAxis2.EnricoStub.WhereIsPublicHolidayType;

public class WhereIsPublicHolidayEnrico 
{
	public static void main(String[] args) throws Exception
	{
		//Create object Stub class
		EnricoStub stub=new EnricoStub();
		//Create request object with parameters
		DateType dt=new DateType();
		dt.setDay(25);
		dt.setMonth(12);
		dt.setYear(2020);
		WhereIsPublicHoliday req=new WhereIsPublicHoliday();
		req.setDate(dt);
		//Create response object by submitting parameterized request
		WhereIsPublicHolidayResponse res=stub.whereIsPublicHoliday(req);
		WhereIsPublicHolidayCountryListType l=res.getCountryList();
		try
		{
			WhereIsPublicHolidayType[] c=l.getCountry();
			for(int i=0;i<c.length;i++)
			{
				System.out.println(c[i].getCountryFullName()+"-----");
				LocalizedStringType[] ls=c[i].getHolidayName();
				int n=ls.length;
				for(int j=0;j<n;j++)
				{
					System.out.println(ls[j].getText());
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("No holiday for given date in all supported countries");
		}
	}
}
