import java.util.stream.IntStream;

public class RegularSeason {
	public String[] finalStandings(String[] teams, int rounds) {
		int n = teams.length;
		String[] names = new String[n];
		int[] totals = new int[n];
		for (int i = 0; i < n; ++i) {
			String[] parts = teams[i].split(" ");

			names[i] = parts[0];

			for (int j = 0; j < n; ++j) {
				if (j != i) {
					int pij = Integer.parseInt(parts[j + 1]);

					totals[i] += pij * rounds;
					totals[j] += (100 - pij) * rounds;
				}
			}
		}

		return IntStream.range(0, n).boxed()
				.sorted((i1, i2) -> (totals[i1] != totals[i2]) ? -Integer.compare(totals[i1], totals[i2])
						: names[i1].compareTo(names[i2]))
				.map(i -> String.format("%s %d", names[i], (totals[i] + 50) / 100)).toArray(String[]::new);
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, String[] p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		RegularSeason obj;
		String[] answer;
		obj = new RegularSeason();
		long startTime = System.currentTimeMillis();
		answer = obj.finalStandings(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p2.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print("\"" + p2[i] + "\"");
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + answer[i] + "\"");
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p2.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (!answer[i].equals(p2[i])) {
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

		String[] p0;
		int p1;
		String[] p2;

		// ----- test 0 -----
		p0 = new String[] { "A 0 10 50", "B 100 0 100", "C 50 10 0" };
		p1 = 5;
		p2 = new String[] { "B 19", "A 6", "C 6" };
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = new String[] { "SPURS 0 33 67 100", "LAKERS 67 0 33 100", "WOLVES 33 67 0 100", "KINGS 0 75 75 0" };
		p1 = 2;
		p2 = new String[] { "SPURS 8", "LAKERS 7", "WOLVES 7", "KINGS 3" };
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = new String[] { "A 0 10 20 30 40 50 60 70 80 90", "AA 90 0 10 20 30 40 50 60 70 80",
				"AAA 80 90 0 10 20 30 40 50 60 70", "AAAA 70 80 90 0 10 20 30 40 50 60",
				"AAAAA 60 70 80 90 0 10 20 30 40 50", "AAAAAA 50 60 70 80 90 0 10 20 30 40",
				"AAAAAAA 40 50 60 70 80 90 0 10 20 30", "AAAAAAAA 30 40 50 60 70 80 90 0 10 20",
				"AAAAAAAAA 20 30 40 50 60 70 80 90 0 10", "AAAAAAAAAA 10 20 30 40 50 60 70 80 90 0" };
		p1 = 10;
		p2 = new String[] { "A 90", "AA 90", "AAA 90", "AAAA 90", "AAAAA 90", "AAAAAA 90", "AAAAAAA 90", "AAAAAAAA 90",
				"AAAAAAAAA 90", "AAAAAAAAAA 90" };
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = new String[] { "WF 0 0 71 10 62 87 49 75 50", "OZ 38 0 79 55 36 96 63 17 37", "C 13 75 0 96 61 2 33 5 64",
				"LCG 13 85 87 0 60 72 86 1 12", "GDDYC 71 62 21 6 0 17 63 34 32", "B 37 66 81 81 53 0 61 80 90",
				"XK 14 63 40 25 13 86 0 6 43", "YVN 57 30 55 22 31 11 81 0 13", "SKGAN 28 79 90 79 75 62 36 86 0" };
		p1 = 10;
		p2 = new String[] { "SKGAN 99", "WF 93", "B 92", "LCG 84", "YVN 80", "OZ 76", "GDDYC 72", "C 63", "XK 62" };
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = new String[] { "ZSN 0 61 70 44 69 40 84 59 20", "SJKB 95 0 88 39 99 18 90 58 44",
				"EBIUF 63 71 0 5 28 26 41 90 71", "MA 73 90 39 0 40 91 31 39 57", "NPT 35 74 75 74 0 74 14 20 27",
				"JVY 68 92 37 52 11 0 91 20 52", "ZBOW 66 44 69 9 8 7 0 2 35", "HH 31 70 14 39 6 68 73 0 20",
				"P 70 62 66 54 9 55 5 98 0" };
		p1 = 10;
		p2 = new String[] { "MA 94", "NPT 92", "P 89", "JVY 84", "SJKB 77", "ZSN 75", "EBIUF 74", "HH 74", "ZBOW 61" };
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
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
