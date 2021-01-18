package com.ing.codility;


import java.util.HashMap;
import java.util.Map;

/*You are given an implementation of a funtion:
 * class Solution { public int solution(int[] A) }
 * which accepts as input a non-empty zero-indexed array A consisting of N integers.
 * 
 * The function works slowly on large input data and the goal is to optimize it so as to achieve better time and/or space complexity.
 * The optimize function should return the same result as the given implementation for every input that satisfies the assumptions.*/
public class Test2 {

	public static void main(String[] args) {
		int a[] = { 4, 6, 2, 2, 6, 6, 1 };

		System.out.println(solution1(a));

	}

	// Given implementation with Time Complexity - O(n^2)
	static int solution(int[] A) {
		int N = A.length;
		int result = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (A[i] == A[j])
					result = Math.max(result, Math.abs(i - j));
		return result;
	}
	
	// Optimize implementation with Time Complexity - O(n)
	static int solution1(int[] A) {

		Map<Integer, Integer> map = new HashMap<>();
		int ans = 0;

		for (int i = 0; i < A.length; i++) {

			if (map.containsKey(A[i])) {
				ans = Math.max(ans, Math.max(map.get(A[i]), (i - map.get(A[i]))));
			} else {
				map.put(A[i], i);
			}
		}

		return ans;
	}

}
