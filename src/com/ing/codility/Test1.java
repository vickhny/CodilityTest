package com.ing.codility;


/*Write a function solution that, given two integers A and B, returns the number of integers from the range [A..B](ends are included) 
which can be expressed as the product of two consecutive integers, that is X*(X+1), for some integer X and A <= B. 
Example: Given A = 6 and B = 20, the function should return 3 These integers are: 6 = 2 * 3, 12 = 3 * 4, and 20 = 4 * 5.
Given A = 21 and B = 29, the function should return 0, There are no integers of the form  X * (X + 1), for some integer X*/
//Time Complexity - O(1)
public class Test1 {

	public static void main(String[] args) {
		System.out.println(solution(6, 20));

	}

	public static int solution(int A, int B) {

		if (A > B) {
			return 0;
		}

		int start = (int) Math.sqrt(A);
		int end = (int) Math.sqrt(B);

		int firstM = start * (start + 1);
		int endM = end * (end + 1);

		if (firstM < A && endM > B) {
			return 0;
		}

		int includeFirst = firstM <= A ? 1 : 0;

		return (start + includeFirst) <= end ? (start + includeFirst) : (firstM == A ? start : 0);
	}

}
