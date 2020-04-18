public class EllysTicketPrices {
	public double getPrice(int N, int[] C, int target) {
		int lower = 0;
		int upper = target * N * 100;
		while (true) {
			int middle = (lower + upper) / 2;

			int expected = computeExpected(N, C, (target * 100 + 1) * N, middle);
			if (expected < target * 100) {
				lower = middle + 1;
			} else if (expected > target * 100) {
				upper = middle - 1;
			} else {
				return middle / 100.0;
			}
		}
	}

	int computeExpected(int N, int[] C, int limit, int initial) {
		int[] prices = new int[N];
		prices[0] = initial;

		int sum = initial;
		for (int i = 1; i < prices.length; ++i) {
			prices[i] = divRound(prices[i - 1] * (100L + C[i - 1]), 100);

			sum += prices[i];
			if (sum > limit) {
				break;
			}
		}

		return divRound(sum, N);
	}

	int divRound(long x, int y) {
		return (int) ((x * 10 / y + 5) / 10);
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int[] p1, int p2, boolean hasAnswer, double p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}" + "," + p2);
		System.out.println("]");
		EllysTicketPrices obj;
		double answer;
		obj = new EllysTicketPrices();
		long startTime = System.currentTimeMillis();
		answer = obj.getPrice(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p3);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = Math.abs(p3 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p3));
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}

	public static void main(String[] args) {
		boolean all_right;
		all_right = true;

		int p0;
		int[] p1;
		int p2;
		double p3;

		// ----- test 0 -----
		p0 = 5;
		p1 = new int[] { -10, 15, 5, -20 };
		p2 = 180;
		p3 = 184.01D;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = 11;
		p1 = new int[] { 5, 16, 17, -3, -10, 20, 20, 14, 2, 0 };
		p2 = 1337;
		p3 = 874.77D;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = 2;
		p1 = new int[] { 0 };
		p2 = 42;
		p3 = 42.0D;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = 20;
		p1 = new int[] { 30, -26, 87, 47, -39, 25, -67, 62, -38, 68, -84, 5, 28, -20, 50, -61, 10, 63, -71 };
		p2 = 392;
		p3 = 476.28D;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = 50;
		p1 = new int[] { -60, 61, 17, 86, 56, 27, 9, 41, -27, -36, 57, -16, 1, 50, -55, -36, 14, 13, -93, 14, 18, 25,
				62, -18, 40, 79, 56, 19, 10, -55, -43, 45, -43, -84, 61, -64, 41, -55, 38, 18, 36, -43, 79, 33, 87, 19,
				-47, 38, -56 };
		p2 = 8887;
		p3 = 9451.93D;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = 95;
		p1 = new int[] { 70, 91, 57, 69, -40, 85, -75, 83, 19, -36, 66, 29, -61, 44, 90, -29, 49, -95, 50, 11, 23, 79,
				-58, 90, -17, -74, 62, -65, -78, 36, 0, -39, -57, 46, 71, 29, -54, 24, -9, 68, 12, -58, -22, 67, -28,
				45, -21, 64, 12, 19, 1, -39, -1, -35, -20, 87, 22, 99, -46, 6, 58, 65, 12, 77, 22, -79, -51, 74, 67, 53,
				21, -31, -8, 96, 23, -57, 19, -38, -58, 14, -5, 54, 96, 36, 92, 3, -41, -20, -88, 47, 44, 83, 80, 47 };
		p2 = 5804;
		p3 = 5451.61D;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 6 -----
		p0 = 54;
		p1 = new int[] { 83, 62, -8, 39, 17, -11, -74, -59, 47, 38, -50, -38, -49, 94, 32, -31, 31, -5, -19, 61, -65,
				88, 19, -94, -2, -29, 98, 99, -40, -24, 55, 66, 82, 12, 82, -60, -49, 62, 19, 37, 76, -10, -7, 14, -43,
				-12, 8, 92, -70, 82, 44, 59, 46 };
		p2 = 298;
		p3 = 526.25D;
		all_right = KawigiEdit_RunTest(6, p0, p1, p2, true, p3) && all_right;
		// ------------------

		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
// Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
