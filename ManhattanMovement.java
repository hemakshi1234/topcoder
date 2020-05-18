public class ManhattanMovement {
	public double getDistance(int a, int b, int x0, int y0) {
		double result = Double.MAX_VALUE;

		if (b == 0) {
			if ((long) a * x0 == 1) {
				return 0;
			}
		} else {
			result = Math.min(result, Math.abs((1.0 - (long) a * x0) / b - y0));
		}

		if (a == 0) {
			if ((long) b * y0 == 1) {
				return 0;
			}
		} else {
			result = Math.min(result, Math.abs((1.0 - (long) b * y0) / a - x0));
		}

		return result;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, boolean hasAnswer,
			double p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3);
		System.out.println("]");
		ManhattanMovement obj;
		double answer;
		obj = new ManhattanMovement();
		long startTime = System.currentTimeMillis();
		answer = obj.getDistance(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p4);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = Math.abs(p4 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p4));
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
		int p1;
		int p2;
		int p3;
		double p4;

		// ----- test 0 -----
		p0 = 1;
		p1 = 2;
		p2 = -2;
		p3 = 3;
		p4 = 1.5D;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = 37;
		p1 = 37;
		p2 = 42;
		p3 = 19;
		p4 = 60.97297297297297D;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = -100;
		p1 = 0;
		p2 = -999999;
		p3 = 314159;
		p4 = 999998.99D;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = 0;
		p1 = -2147483648;
		p2 = 1;
		p3 = 100000;
		p4 = 100000.00000000047D;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
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
