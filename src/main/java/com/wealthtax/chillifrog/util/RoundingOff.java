package com.wealthtax.chillifrog.util;

public class RoundingOff {

	/**
	 * This method return a rounded value of actual amount Based upon the less
	 * than and greater than number of millions
	 * 
	 * @param actualValue
	 *            Double
	 * @return int
	 */
	public int roundValue(Double actualValue) {
		Double multiply = 0.0;

		/**
		 * less than 100 thousand
		 */
		if (actualValue <= 100000) {
			System.out.println("I am less than actual Value");
			multiply = actualValue;
		}
		/**
		 * less than 1 million
		 */
		else if (actualValue > 100000 && actualValue <= 999999) {
			System.out.println("I am Greater than 100000");
			multiply = floorValue(actualValue, 100000);
		}
		/**
		 * less than 10 million
		 */
		else if (actualValue > 1000000 && actualValue <= 9999999) {
			System.out.println("I am Greater than 1000000");
			multiply = floorValue(actualValue, 500000);
		}
		/**
		 * less than 20 million
		 */
		else if (actualValue > 10000000 && actualValue <= 19999999) {
			System.out.println("I am Greater than 10000000");
			multiply = floorValue(actualValue, 1000000);
		}
		/**
		 * less than 100 million
		 */
		else if (actualValue > 20000000 && actualValue <= 99999999) {
			System.out.println("I am Greater than 20000000");
			multiply = floorValue(actualValue, 5000000);
		}
		/**
		 * less than 1000 million
		 */
		else if (actualValue > 100000000 && actualValue <= 1000000000) {
			System.out.println("I am Greater than 100000000");
			multiply = floorValue(actualValue, 10000000);
		}
		/**
		 * above than 1000000000 million
		 */
		else if (actualValue > 1000000000) {
			System.out.println("I am Greater than 1000000000");
			multiply = floorValue(actualValue, 100000000);
		}

		return multiply.intValue();
	}

	
//	 public static void main (String [] args ){
//	 System.out.println("Actual Value after Rounding off: "+
//	 new RoundingOff().floorValue(1596051.97475, 500000));
//	
//	 }

	/**
	 * Private return Double value of calculated rounded value for given amount
	 * 
	 * @param actualValue Double
	 * @param roundedTo Integer
	 * @return Double
	 */

	private Double floorValue(Double actualValue, Integer roundedTo) {
		System.out.println(Math.floor(actualValue / roundedTo));
		return Math.floor(actualValue / roundedTo) * (roundedTo);

	}
	
	
}
