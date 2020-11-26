package soapServicesWithAxis2;

import soapServicesWithAxis2.EnricoStub.DateType;
import soapServicesWithAxis2.EnricoStub.GetSupportedCountries;
import soapServicesWithAxis2.EnricoStub.GetSupportedCountriesResponse;
import soapServicesWithAxis2.EnricoStub.SupportedCountriesType;
import soapServicesWithAxis2.EnricoStub.SupportedCountryType;

public class SupportedCountriesEnrico 
{
	public static void main(String[] args) throws Exception
	{
		//Create object Stub class
		EnricoStub stub=new EnricoStub();
		//Create request object for desired operation in service
		GetSupportedCountries req=new GetSupportedCountries();
		//Create response object by submitting request to service
		GetSupportedCountriesResponse res=stub.getSupportedCountries(req);
		//Parse response for required values
		SupportedCountriesType sct=res.getSupportedCountries();
		SupportedCountryType[] x=sct.getSupportedCountry();
		System.out.println("Count of all supported countries is"+x.length);
		for(int i=0;i<x.length;i++)
		{
			//Get display country name & code
			System.out.println(x[i].getFullName()+"-----"+x[i].getCountryCode());
			
			//Get & display no or more regions in country
			try
			{
				int l=x[i].getRegion().length;
				System.out.println("Regions in "+x[i].getFullName()+"are:");
				for(int j=0;j<l;j++)
				{
					System.out.print(x[i].getRegion()[j]+"\t");
				}
				System.out.println();
			}
			catch(Exception ex)
			{
				System.out.println("No regions in "+x[i].getFullName());
			}
			
			//Get & display no or more holiday types in country
			
			try
			{
				int l=x[i].getHolidayType().length;
				System.out.print("Holiday types in "+x[i].getFullName()+"are:");
				for(int j=0;j<l;j++)
				{
					System.out.print(x[i].getHolidayType()[j]+"\t");
				}
				System.out.println();
			}
			catch(Exception ex)
			{
				System.out.println("No Holiday types in "+x[i].getFullName());
			}
			
			//Get & diplay from date & to date
			DateType fdt=x[i].getFromDate();
			System.out.println(fdt.getDay()+":"+fdt.getMonth()+":"+fdt.getYear());
			DateType tdt=x[i].getToDate();
			System.out.println(tdt.getDay()+":"+tdt.getMonth()+":"+tdt.getYear());
		}
	}
}
