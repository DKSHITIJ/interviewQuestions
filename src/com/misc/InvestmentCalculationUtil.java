package com.misc;

public class InvestmentCalculationUtil {

	public static final double AMOUNTINVESTEDEACHYEAR = 120000;
	public static final double PERCENTOFRETURN = 0.15;
	public static final int DURATIONOFINVESTMENT = 20;

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		fixDeposit();
		// sipInvestment();
	}

	public static double fixDeposit() {
		double returnOnInvestment = 0;
		double totalAmountInvested = 0;
		double interest = 0;
		for (int i = 0; i < DURATIONOFINVESTMENT; i++) {
			returnOnInvestment = returnOnInvestment + AMOUNTINVESTEDEACHYEAR;
			interest = returnOnInvestment * PERCENTOFRETURN;
			returnOnInvestment = returnOnInvestment + interest;
			totalAmountInvested = totalAmountInvested + AMOUNTINVESTEDEACHYEAR;
		}
		System.out.println("Total Amount Invested = " + totalAmountInvested);
		System.out.format("Return On Investment = %f ", returnOnInvestment);
		return returnOnInvestment;

	}
}