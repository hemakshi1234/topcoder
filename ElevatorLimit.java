import java.util.stream.IntStream;

public class ElevatorLimit {
	public int[] getRange(int[] enter, int[] exit, int physicalLimit) {
		int[] initials = IntStream.rangeClosed(0, physicalLimit).filter(x -> check(enter, exit, physicalLimit, x))
				.toArray();

		return (initials.length == 0) ? new int[0] : new int[] { initials[0], initials[initials.length - 1] };
	}

	boolean check(int[] enter, int[] exit, int physicalLimit, int initial) {
		int current = initial;
		for (int i = 0; i < enter.length; ++i) {
			if (exit[i] > current) {
				return false;
			}

			current += enter[i] - exit[i];

			if (current > physicalLimit) {
				return false;
			}
		}

		return true;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int p2, boolean hasAnswer, int[] p3) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}" + "," + p2);
		System.out.println("]");
		ElevatorLimit obj;
		int[] answer;
		obj = new ElevatorLimit();
		long startTime = System.currentTimeMillis();
		answer = obj.getRange(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p3.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p3[i]);
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(answer[i]);
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p3.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p3[i]) {
						res = false;
					}
				}
			}
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

		int[] p0;
		int[] p1;
		int p2;
		int[] p3;

		// ----- test 0 -----
		p0 = new int[] { 1, 0 };
		p1 = new int[] { 0, 1 };
		p2 = 1;
		p3 = new int[] { 0, 0 };
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new int[] { 1, 0 };
		p1 = new int[] { 0, 1 };
		p2 = 2;
		p3 = new int[] { 0, 1 };
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new int[] { 0, 1 };
		p1 = new int[] { 1, 0 };
		p2 = 1;
		p3 = new int[] { 1, 1 };
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new int[] { 0, 2 };
		p1 = new int[] { 1, 0 };
		p2 = 1;
		p3 = new int[] {};
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new int[] { 6, 85, 106, 1, 199, 76, 162, 141 };
		p1 = new int[] { 38, 68, 62, 83, 170, 12, 61, 114 };
		p2 = 668;
		p3 = new int[] { 223, 500 };
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = new int[] { 179, 135, 104, 90, 97, 186, 187, 47, 152, 100, 119, 28, 193, 11, 103, 100, 179, 11, 80, 163,
				50, 131, 103, 50, 142, 51, 112, 62, 69, 72, 88, 3, 162, 93, 190, 85, 79, 86, 146, 71, 65, 131, 179, 119,
				66, 111 };
		p1 = new int[] { 134, 81, 178, 168, 86, 128, 1, 165, 62, 46, 188, 70, 104, 111, 3, 47, 144, 69, 163, 21, 101,
				126, 169, 84, 146, 165, 198, 1, 65, 181, 135, 99, 100, 195, 171, 47, 16, 54, 79, 69, 6, 97, 154, 80,
				151, 76 };
		p2 = 954;
		p3 = new int[] { 453, 659 };
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 6 -----
		p0 = new int[] { 2 };
		p1 = new int[] { 3 };
		p2 = 2;
		p3 = new int[] {};
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
