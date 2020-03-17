public class EngineersPrimes {
	public long smallestNonPrime(int N) {
		int prime = 2;
		for (int i = 0; i < N; ++i) {
			prime = findNextPrime(prime);
		}

		return (long) prime * prime;
	}

	int findNextPrime(int x) {
		do {
			++x;
		} while (!isPrime(x));

		return x;
	}

	boolean isPrime(int x) {
		for (int i = 2; i * i <= x; ++i) {
			if (x % i == 0) {
				return false;
			}
		}

		return true;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, boolean hasAnswer, long p1) {
		System.out.print("Test " + testNum + ": [" + p0);
		System.out.println("]");
		EngineersPrimes obj;
		long answer;
		obj = new EngineersPrimes();
		long startTime = System.currentTimeMillis();
		answer = obj.smallestNonPrime(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
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
		long p1;

		// ----- test 0 -----
		p0 = 3;
		p1 = 49L;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = 1;
		p1 = 9L;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = 265;
		p1 = 2886601L;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = 1835;
		p1 = 247716121L;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = 10000;
		p1 = 10971096049L;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = 100000;
		all_right = KawigiEdit_RunTest(5, p0, false, p1) && all_right;
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
