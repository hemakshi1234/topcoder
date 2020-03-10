public class TennisRallies {
	public int howMany(int numLength, String[] forbidden, int allowed) {
		int result = 0;
		for (int code = 0; code < (1 << numLength); ++code) {
			int forbidCount = 0;
			for (String f : forbidden) {
				int pattern = 0;
				for (int i = 0; i < f.length(); ++i) {
					pattern = pattern * 2 + f.charAt(i) - 'c';
				}

				int current = 0;
				for (int i = 0; i < f.length() - 1; ++i) {
					current = current * 2 + ((code & (1 << i)) == 0 ? 0 : 1);
				}

				int mod = 1 << f.length();
				for (int i = f.length() - 1; i < numLength; ++i) {
					current = (current * 2 + ((code & (1 << i)) == 0 ? 0 : 1)) % mod;

					if (current == pattern) {
						++forbidCount;
					}
				}
			}

			if (forbidCount < allowed) {
				++result;
			}
		}

		return result;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, String[] p1, int p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}" + "," + p2);
		System.out.println("]");
		TennisRallies obj;
		int answer;
		obj = new TennisRallies();
		long startTime = System.currentTimeMillis();
		answer = obj.howMany(p0, p1, p2);
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

		int p0;
		String[] p1;
		int p2;
		int p3;

		// ----- test 0 -----
		p0 = 3;
		p1 = new String[] { "cc", "dd" };
		p2 = 1;
		p3 = 2;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = 10;
		p1 = new String[] { "c" };
		p2 = 1;
		p3 = 1;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = 10;
		p1 = new String[] { "c" };
		p2 = 2;
		p3 = 11;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = 18;
		p1 = new String[] { "c", "d" };
		p2 = 1;
		p3 = 0;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = 18;
		p1 = new String[] {};
		p2 = 1;
		p3 = 262144;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = 18;
		p1 = new String[] { "c", "cc", "ccc", "cccc", "ccccc", "cccccc", "ccccccc", "cccccccc", "ccccccccc",
				"cccccccccc" };
		p2 = 100;
		p3 = 262122;
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
