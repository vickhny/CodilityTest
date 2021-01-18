package com.ing.codility;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*You are given an array A of N positive integer and an integer K. Find the largest possible even sum of K elements at different positions in A.
 * For Example given A = [4,9,8,2,6] and K=3, the largest even sum of three elements is 18. The three selected elements are A[0]=4, A[2]=8 and A[4]=6.
 * Similarly for given A = [ 2, 3, 3, 5, 5] and K=3, the largest even sum of three elements is 12, because 5+5+2 = 12.*/
//Time Complexity - O(N+K)
public class Test3 {

	static int solution(int A[], int K) {

		if (K > A.length) {
			return -1;
		}

		int sum = 0;

		Comparator<Integer> sortIntegers = new Comparator<Integer>() {

			@Override
			public int compare(Integer p1, Integer p2) {
				return p1.compareTo(p2);
			}
		};

		List<Integer> listOfEvenNum = new ArrayList<Integer>();

		List<Integer> listofOddNum = new ArrayList<Integer>();

		Arrays.stream(A).forEach(num -> {
			if (num % 2 == 1) {
				listofOddNum.add(num);
			} else {
				listOfEvenNum.add(num);
			}
		});

		listOfEvenNum.sort(sortIntegers);
		listofOddNum.sort(sortIntegers);

		int itrEven = listOfEvenNum.size() - 1;
		int itrOdd = listofOddNum.size() - 1;

		while (K > 0) {
			if (K % 2 == 1) {
				if (itrEven >= 0) {
					sum += listOfEvenNum.get(itrEven);
					itrEven--;
				} else {
					return -1;
				}
				K--;
			} else if (itrEven >= 1 && itrOdd >= 1) {
				if (listOfEvenNum.get(itrEven) + listOfEvenNum.get(itrEven - 1) <= listofOddNum.get(itrOdd)
						+ listofOddNum.get(itrOdd - 1)) {

					sum += listofOddNum.get(itrOdd) + listofOddNum.get(itrOdd - 1);
					itrOdd -= 2;
				} else {
					sum += listOfEvenNum.get(itrEven) + listOfEvenNum.get(itrEven - 1);
					itrEven -= 2;
				}
				K -= 2;
			} else if (itrEven >= 1) {
				sum += listOfEvenNum.get(itrEven) + listOfEvenNum.get(itrEven - 1);
				itrEven -= 2;
				K -= 2;
			} else if (itrOdd >= 2) {
				sum += listofOddNum.get(itrOdd) + listofOddNum.get(itrOdd - 1);
				itrOdd -= 2;
				K -= 2;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 3, 5, 5 };
		int K = 3;

		System.out.println(solution(arr, K));
	}

}
