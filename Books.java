import java.util.Arrays;

public class Books {
	public int sortMoves(String[] titles) {
		int[] maxLengths = new int[titles.length];
		for (int i = 0; i < maxLengths.length; ++i) {
			maxLengths[i] = 1;

			for (int j = 0; j < i; ++j) {
				if (titles[j].compareTo(titles[i]) <= 0) {
					maxLengths[i] = Math.max(maxLengths[i], maxLengths[j] + 1);
				}
			}
		}

		return titles.length - Arrays.stream(maxLengths).max().getAsInt();
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		Books obj;
		int answer;
		obj = new Books();
		long startTime = System.currentTimeMillis();
		answer = obj.sortMoves(p0);
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

		String[] p0;
		int p1;

		// ----- test 0 -----
		p0 = new String[] { "Algorithms", "Purely Functional Data Structures", "Intro to C",
				"Automata and Computability" };
		p1 = 2;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new String[] { "the fellowship of the ring", "the return of the king", "The two towers" };
		p1 = 1;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new String[] { "Basic Engineering Circuit Analysis", "A Course in Combinatorics",
				"Artificial Intelligence", "Asimovs Guide to Shakespeare", "The Nature of Space and Time",
				"A Time for Trumpets", "Essentials of Artificial Intelligence", "Life by the Numbers",
				"Cognitive Psychology", "ColdFusion" };
		p1 = 5;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new String[] { "A", "B", "A", "A", "B" };
		p1 = 1;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new String[] { "This Book Has No Title", " This Book Does Have A Title" };
		p1 = 1;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = new String[] { "What Is The", "What Is The ", "What Is The Title Of This Book" };
		p1 = 0;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
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
