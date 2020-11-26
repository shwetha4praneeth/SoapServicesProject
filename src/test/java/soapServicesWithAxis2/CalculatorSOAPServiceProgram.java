package soapServicesWithAxis2;

import java.util.Scanner;

import soapServicesWithAxis2.CalculatorStub.Add;
import soapServicesWithAxis2.CalculatorStub.AddResponse;
import soapServicesWithAxis2.CalculatorStub.Divide;
import soapServicesWithAxis2.CalculatorStub.DivideResponse;
import soapServicesWithAxis2.CalculatorStub.Multiply;
import soapServicesWithAxis2.CalculatorStub.MultiplyResponse;
import soapServicesWithAxis2.CalculatorStub.Subtract;
import soapServicesWithAxis2.CalculatorStub.SubtractResponse;

public class CalculatorSOAPServiceProgram
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter input1");
		int x=sc.nextInt();
		System.out.println("Enter input2");
		int y=sc.nextInt();
		//Create object to stub class
		CalculatorStub stub=new CalculatorStub();
		
		//Add operation testing
		Add req1=new Add();
		req1.setIntA(x);
		req1.setIntB(y);
		AddResponse res1=stub.add(req1);
		int z1=res1.getAddResult();
		System.out.println("Addition result is "+z1);
		if(z1==x+y)
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		
		//Subtract operation testing
		Subtract req2=new Subtract();
		req2.setIntA(x);
		req2.setIntB(y);
		SubtractResponse res2=stub.subtract(req2);
		int z2=res2.getSubtractResult();
		System.out.println("Subtraction result is "+z2);
		if(z2==x-y)
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		
		//Multiply operation testing
		Multiply req3=new Multiply();
		req3.setIntA(x);
		req3.setIntB(y);
		MultiplyResponse res3=stub.multiply(req3);
		int z3=res3.getMultiplyResult();
		System.out.println("Multiply result is "+z3);
		if(z3==x*y)
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		
		//Divide operation testing
		Divide req4=new Divide();
		req4.setIntA(x);
		req4.setIntB(y);
		DivideResponse res4=stub.divide(req4);
		int z4=res4.getDivideResult();
		System.out.println("Divide result is "+z4);
		if(z4==x/y)
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
	}
}
