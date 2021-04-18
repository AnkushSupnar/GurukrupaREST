package com.ankush.controller;

public class Test {

	
	public static void main(String[] args) {
		Test t = new Test();
		t.printEqual(2,1,1);
		t.printEqual(2,3,1);
		t.printEqual(2,1,0);
		t.printEqual(1,1,1);
	}
	
	
	String numberToString(int num) {
		if (num == 1) {
			return "One";

		} else if (num == 2) {
			return "Two";
		} else if (num == 3) {
			return "Three";
		} else if (num == 4) {
			return "Four";
		} else if (num == 5) {
			return "Five";
		} else {
			return "Other";
		}

	}
	
	
	
	
	
	boolean hasEqualSum(int num1,int num2,int num3)
	{
		if((num1+num2)==num3)
		{
			return true;
		}
		else
			return false;
	}
	
	
	
	
	
	boolean shouldWeWakeUp(boolean bark,int hour)
	{
		if(hour<=0 && hour>23)
		{
			return false;
		}
		else if(hour<8 || hour<=22)
		{
			return false;
		}
		else
			return true;
	}
	
	
	
	
	
	
	void printEqual(int num1, int num2, int num3) {
		if (num1 <= 0 || num2 <= 0 || num3 <= 0) {
			System.out.println("Invalid Value");
		} else {
			if (num1 == num2 && num1 == num3) {
				System.out.println("All numbars are equal");
			} else {
				if (num1 != num2 && num1 != num3 && num2 != num3) {
					System.out.println("All numbers are different");
				} else {
					System.out.println("Nither all are equal or different");
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}