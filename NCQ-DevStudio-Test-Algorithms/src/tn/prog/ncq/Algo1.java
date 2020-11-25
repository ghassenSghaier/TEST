package tn.prog.ncq;

public class Algo1 {
	public static int max_table(int[] array) {
		int max = array[0];
		for (int counter = 0; counter < array.length; counter++) {
			if (array[counter] > max) {
				max = array[counter];
			}
		}
		return max;
	}

	public static int[] setAllMax(int[] array) {
		int max = max_table(array);
		for (int counter = 0; counter < array.length; counter++) {
			array[counter] = max;
		}
		return array;
	}

	public static int[] solution(int N, int[] A) {
		int[] array = new int[N];
		for (int counter = 0; counter < A.length; counter++) {
			if (A[counter] > 0 && A[counter] <= N) {
				array[A[counter] - 1]++;
			} else if (A[counter] == N + 1) {
				array = setAllMax(array);
			}
		}
		return array;
	}

	public static void main(String[] args) {
		int[] A = { 3, 4, 4, 6, 1, 4, 4 };
		int[] B = solution(5, A);
		for (int counter = 0; counter < B.length; counter++) {
			System.out.print(B[counter]);
		}

	}

}
