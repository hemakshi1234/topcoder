import java.util.Arrays;
import java.util.stream.IntStream;

public class Inventory {
	static final double EPSILON = 1E-9;

	public int monthlyOrder(int[] sales, int[] daysAvailable) {
		return (int) Math.ceil(IntStream.range(0, sales.length).filter(i -> daysAvailable[i] != 0)
				.mapToDouble(i -> sales[i] * 30.0 / daysAvailable[i]).sum()
				/ Arrays.stream(daysAvailable).filter(day -> day != 0).count() - EPSILON);
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, int p2) {
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
		System.out.print("}");
		System.out.println("]");
		Inventory obj;
		int answer;
		obj = new Inventory();
		long startTime = System.currentTimeMillis();
		answer = obj.monthlyOrder(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
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

		// ----- test 0 -----
		p0 = new int[] { 5 };
		p1 = new int[] { 15 };
		p2 = 10;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new int[] { 75, 120, 0, 93 };
		p1 = new int[] { 24, 30, 0, 30 };
		p2 = 103;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new int[] { 8773 };
		p1 = new int[] { 16 };
		p2 = 16450;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new int[] { 1115, 7264, 3206, 6868, 7301 };
		p1 = new int[] { 1, 3, 9, 4, 18 };
		p2 = 36091;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
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
