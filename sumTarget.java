package com.solveQuestions.lab;
import java.util.ArrayList;
import java.util.Scanner;

public class sumTarget {
	
	public static ArrayList<Integer> sumTargetIndices(int nums[], int target) {
		ArrayList<Integer> sum = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			for(int j= i+1; j<nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					sum.add(i);
					sum.add(j);
					return sum;
				}
				else if(nums[i] + nums[j] > target) {
					break;
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int n, nums[], target;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of array elements.");
		n = sc.nextInt();
		nums = new int[n];
		System.out.println("Enter the array elements");
		for(int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println("Enter the target element.");
		target = sc.nextInt();
		System.out.println(sumTargetIndices(nums, target));
	}

}
