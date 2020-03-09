import java.util.stream.IntStream;

public class BeatTheStar {
	public double doesItMatter(int N, int G) {
		int total = N * (N + 1) / 2 - G;

		double[] probs = new double[total + 1];
		probs[0] = 1;
		for (int i = 1; i <= N; ++i) {
			if (i != G) {
				double[] nextProbs = new double[probs.length];
				for (int j = 0; j < nextProbs.length; ++j) {
					nextProbs[j] += probs[j] / 2;
				}
				for (int j = i; j < nextProbs.length; ++j) {
					nextProbs[j] += probs[j - i] / 2;
				}

				probs = nextProbs;
			}
		}

		double[] probs_ = probs;
		return IntStream.range(0, probs.length).filter(i -> Math.abs(total - i - i) <= G).mapToDouble(i -> probs_[i])
				.sum();
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, double p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		BeatTheStar obj;
		double answer;
		obj = new BeatTheStar();
		long startTime = System.currentTimeMillis();
		answer = obj.doesItMatter(p0, p1);
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
			res = Math.abs(p2 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p2));
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
		double p2;

		// ----- test 0 -----
		p0 = 2;
		p1 = 1;
		p2 = 0.0D;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = 5;
		p1 = 5;
		p2 = 0.625D;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = 5;
		p1 = 1;
		p2 = 0.125D;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = 5;
		p1 = 2;
		p2 = 0.125D;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = 9;
		p1 = 7;
		p2 = 0.328125D;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = 100;
		p1 = 1;
		all_right = KawigiEdit_RunTest(5, p0, p1, false, p2) && all_right;
		// ------------------

		// ----- test 6 -----
		p0 = 98;
		p1 = 47;
		p2 = 0.06629019390986395;
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
