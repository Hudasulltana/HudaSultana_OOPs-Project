package com.solveQuestions.lab;
import java.util.*;

public class xPowerN {
	
	public static long findPower(int num, int power) {
		long powerValue = 1;
		int count = 1;
		while(count <= (power/2)) {
			powerValue = powerValue * num;
			count++;
		}
		if(power%2 == 0) {
			powerValue = powerValue * powerValue;
		}
		else {
			powerValue = powerValue * powerValue * num;
		}
		return powerValue;
	}

	public static void main(String[] args) {
		int num, power;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		num = sc.nextInt();
		System.out.println("Enter the power of the number "+num);
		power = sc.nextInt();
		System.out.println(findPower(num, power));
	}

}
