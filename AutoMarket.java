import java.util.Arrays;
import java.util.stream.IntStream;

public class AutoMarket {
	public int maxSet(int[] cost, int[] features, int[] fixTimes) {
		int n = cost.length;

		int[] sortedIndices = IntStream.range(0, n).boxed().sorted((i1, i2) -> Integer.compare(cost[i1], cost[i2]))
				.mapToInt(x -> x).toArray();

		int[] maxSizes = new int[n];
		for (int i = 0; i < maxSizes.length; ++i) {
			int maxPrev = 0;
			for (int j = 0; j < i; ++j) {
				if (cost[sortedIndices[j]] < cost[sortedIndices[i]]
						&& features[sortedIndices[j]] > features[sortedIndices[i]]
						&& fixTimes[sortedIndices[j]] < fixTimes[sortedIndices[i]]) {
					maxPrev = Math.max(maxPrev, maxSizes[j]);
				}
			}

			maxSizes[i] = maxPrev + 1;
		}

		return Arrays.stream(maxSizes).max().getAsInt();
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int[] p2, boolean hasAnswer, int p3) {
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
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		AutoMarket obj;
		int answer;
		obj = new AutoMarket();
		long startTime = System.currentTimeMillis();
		answer = obj.maxSet(p0, p1, p2);
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
		int[] p2;
		int p3;

		// ----- test 0 -----
		p0 = new int[] { 10000, 14000, 8000, 12000 };
		p1 = new int[] { 1, 2, 4, 3 };
		p2 = new int[] { 17, 15, 8, 11 };
		p3 = 3;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new int[] { 1, 2, 3, 4, 5 };
		p1 = new int[] { 1, 2, 3, 4, 5 };
		p2 = new int[] { 1, 2, 3, 4, 5 };
		p3 = 1;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new int[] { 9000, 6000, 5000, 5000, 7000 };
		p1 = new int[] { 1, 3, 4, 5, 2 };
		p2 = new int[] { 10, 6, 6, 5, 9 };
		p3 = 4;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		p1 = new int[] { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		p2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		p3 = 20;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new int[] { 1000, 1000, 1000, 1000, 2000 };
		p1 = new int[] { 3, 3, 4, 3, 3 };
		p2 = new int[] { 3, 3, 3, 4, 3 };
		p3 = 1;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
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
