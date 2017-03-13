package com.teckSys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DeDup {

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(String[] args) {
		DeDup dd = new DeDup();
		System.out.println("Calling removeDup1 :" + Arrays.toString(dd.removeDup1()));

		// Retain the Original Order
		System.out.println("Calling removeDup2 :" + Arrays.toString(dd.removeDup2()));

		// Retain the Original Order
		System.out.println("Calling removeDup3 :" + Arrays.toString(dd.removeDup3()));
	}

	/**
	 * Using Set to remove duplicate
	 * 
	 * @return Integer[]
	 */
	public int[] removeDup1() {
		int end = randomIntegers.length;
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < end; i++) {
			set.add(randomIntegers[i]);
		}
		int[] output = new int[set.size()];
		int i = 0;
		for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
			output[i++] = it.next();
		}
		return output;
	}

	/**
	 * Using Arraylist to remove duplicate
	 * 
	 * @return Integer[]
	 */
	public int[] removeDup2() {
		int[] input = randomIntegers.clone();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			if (!list.contains(input[i])) {
				list.add(input[i]);
			}
		}
		int[] output = new int[list.size()];
		int i = 0;
		for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
			output[i++] = it.next();
		}
		return output;
	}

	/**
	 * Using looping to remove duplicate
	 * 
	 * @return Integer[]
	 */
	public int[] removeDup3() {
		int[] input = randomIntegers.clone();
		int tail = 1;
		for (int i = 1; i < input.length; i++) {
			int j = 0;
			for (; j < tail; j++) {
				if (input[j] == input[i]) {
					break;
				}
			}
			if (j == tail) {
				input[tail] = input[i];
				tail++;
			}
		}
		int[] output = new int[tail];
		for (int i = 0; i < tail; i++) {
			output[i] = input[i];
		}
		return output;
	}

}
