import java.util.Arrays;

public class PassingGrade {
	int divideToCeil(int x, int y) {
		return (x + y - 1) / y;
	}

	public int pointsNeeded(int[] pointsEarned, int[] pointsPossible, int finalExam) {
		int needed = divideToCeil((Arrays.stream(pointsPossible).sum() + finalExam) * 65, 100)
				- Arrays.stream(pointsEarned).sum();

		return (needed > finalExam) ? -1 : Math.max(0, needed);
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int p2, boolean hasAnswer, int p3) {
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
		PassingGrade obj;
		int answer;
		obj = new PassingGrade();
		long startTime = System.currentTimeMillis();
		answer = obj.pointsNeeded(p0, p1, p2);
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
			res = answer == p3;
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
		int p3;

		// ----- test 0 -----
		p0 = new int[] { 55, 77, 82, 60 };
		p1 = new int[] { 100, 100, 100, 100 };
		p2 = 300;
		p3 = 181;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new int[] { 1, 2, 3, 4 };
		p1 = new int[] { 2, 3, 4, 5 };
		p2 = 7;
		p3 = 4;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new int[] { 1, 2, 2, 1 };
		p1 = new int[] { 9, 9, 9, 9 };
		p2 = 9;
		p3 = -1;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new int[] { 7, 8, 7, 6 };
		p1 = new int[] { 8, 8, 8, 8 };
		p2 = 9;
		p3 = 0;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new int[] { 17, 23, 50, 200, 19, 56, 83, 91, 77, 9, 0 };
		p1 = new int[] { 20, 30, 50, 250, 20, 70, 100, 100, 100, 10, 10 };
		p2 = 400;
		p3 = 129;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = new int[] { 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600,
				600 };
		p1 = new int[] { 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
				1000, 1000, 1000, 901 };
		p2 = 3000;
		p3 = 2886;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
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
