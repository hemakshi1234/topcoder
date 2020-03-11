import java.util.Arrays;

public class FairWorkload {
	public int getMostWork(int[] folders, int workers) {
		int lower = Arrays.stream(folders).max().getAsInt();
		int upper = Arrays.stream(folders).sum();
		int result = -1;
		while (lower <= upper) {
			int middle = (lower + upper) / 2;

			if (check(folders, workers, middle)) {
				result = middle;
				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}

		return result;
	}

	boolean check(int[] folders, int workers, int sumLimit) {
		int count = 0;
		int sum = sumLimit;
		for (int folder : folders) {
			if (sum + folder <= sumLimit) {
				sum += folder;
			} else {
				++count;
				sum = folder;
			}
		}

		return count <= workers;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		FairWorkload obj;
		int answer;
		obj = new FairWorkload();
		long startTime = System.currentTimeMillis();
		answer = obj.getMostWork(p0, p1);
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
		int p1;
		int p2;

		// ----- test 0 -----
		p0 = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		p1 = 3;
		p2 = 170;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		p1 = 5;
		p2 = 110;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new int[] { 568, 712, 412, 231, 241, 393, 865, 287, 128, 457, 238, 98, 980, 23, 782 };
		p1 = 4;
		p2 = 1785;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1000 };
		p1 = 2;
		p2 = 1000;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new int[] { 50, 50, 50, 50, 50, 50, 50 };
		p1 = 2;
		p2 = 200;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = new int[] { 1, 1, 1, 1, 100 };
		p1 = 5;
		p2 = 100;
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 6 -----
		p0 = new int[] { 950, 650, 250, 250, 350, 100, 650, 150, 150, 700 };
		p1 = 6;
		p2 = 950;
		all_right = KawigiEdit_RunTest(6, p0, p1, true, p2) && all_right;
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
