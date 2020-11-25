package tn.prog.ncq;

public class Algo2 {

	public static int suite_fibonacci_recursive(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return suite_fibonacci_recursive(n - 1) + suite_fibonacci_recursive(n - 2);
	}

	public static boolean verif_doublons(int[] array, int n, int index) {
		for (int i = index - 1; i >= 0; i--) {
			if (array[i] == n) {
				return true;
			}
		}
		return false;
	}

	public static int[] solution(int[] A, int[] B) {
		int[] C = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			if (verif_doublons(A, A[i], i)) {
				C[i] = A[i] / (2 * B[i]);
			} else {
				// System.out.println(suite_fibonacci_recursive(A[i]));
				C[i] = suite_fibonacci_recursive(A[i]);
			}
		}
		return C;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String mot = "A";
//		String s = mot;
//		char[] array = s.toCharArray();
//		int nb = 12;
//		for (int i = 0; i < mot.length(); i++) {
//			array[i] = (char) (((int) s.charAt(i)) + nb);
//			System.out.print(array[i]);
//		}
//		System.out.println((21 / 26) / (7 / 13) / (4 / 8));		
		int[] A = { 4, 4, 5, 5, 1 };
		int[] B = { 3, 2, 4, 3, 1 };
		int[] C = solution(A, B);
		// System.out.println(suite_fibonacci_recursive(5));
		for (int i = 0; i < C.length; i++) {
			System.out.print(C[i]);
		}
	}
}
