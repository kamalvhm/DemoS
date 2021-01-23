package com.intquetions;

import java.util.HashMap;
import java.util.Map;

public class MathRelated {
	//166. Fraction to Recurring Decimal
	//IN MyLInkedList.java check addTwoNumbers()
	//IN StringProblems check 67. Add Binary

	public static void main(String[] args) {
		
		int a =2,b=15;
		//To find remainder
		long rem=(long) b%a;
		
		//to find co-efficient divide both 
		long cofficient=b/a;
		
		//To process on digit at a time from back side where r is processed digit 
		int x=123;
		long r = 0;
        while (x != 0) {
            r = r * 10 + (x % 10);
            x /= 10;
            System.out.println("R-"+r+" X "+x);
        }
        
        
        System.out.print(fractionToDecimal(2,3));

	}
	//166. Fraction to Recurring Decimal
	 public static String fractionToDecimal(int dividend, int divisor) {
			StringBuffer ans = new StringBuffer();
			if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
				ans.insert(0,"-");
			}
			dividend = Math.abs(dividend);
			divisor = Math.abs(divisor);
			long quotient = (long)dividend / divisor;
			long remainder = (long)dividend % divisor;
			ans.append(quotient);
			if (remainder == 0) {
				return ans.toString();
			} else {
				ans.append(".");
				// This map will hold remainder and position on which that remainder occurred in ans.
				HashMap<Long, Integer> map = new HashMap<>();
				while (remainder != 0) {
					if (map.containsKey(remainder)) {
						int len = map.get(remainder);
						ans.insert(len, "(");
						ans.append(")");
						break;
					} else {
						remainder *= 10;
						quotient = remainder / divisor;
						remainder = remainder % divisor;
						ans.append(Math.abs(quotient));
					}
				}
			}

			return ans.toString();
		}
	 
	public String fractionToDecimal2(int numerator, int denominator) {

		// If numerator is 0 (=> result = 0) no negative sign in result
		String sign = (numerator != 0) && (numerator < 0 ^ denominator < 0) ? "-" : "";
		long absNum = Math.abs((long) numerator), absDen = Math.abs((long) denominator);
		String integerPart = String.valueOf(absNum / absDen);

		if (absNum % absDen == 0) {
			return sign + integerPart;
		}

		StringBuilder decimalPart = new StringBuilder();
		long reminder = absNum % absDen;

		// The first time we saw this reminder in positions after decimal point-
		// For example, we would see 4/6 for the first time in 1/6 at 0.1|6|666... i.e.
		// pos 2
		// This is to identify repeating decimals
		HashMap<Long, Integer> reminderPositions = new HashMap<>();

		while (reminder != 0) {
			if (reminderPositions.containsKey(reminder)) {
				decimalPart.insert(reminderPositions.get(reminder), "(");
				decimalPart.append(")");
				break;
			}

			reminderPositions.put(reminder, decimalPart.length());
			decimalPart.append(String.valueOf(reminder * 10 / absDen));
			reminder = (reminder * 10) % absDen;
		}

		return sign + integerPart + "." + decimalPart.toString();
	}


}
