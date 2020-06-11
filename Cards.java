import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cards {
	public String[] deal(int numPlayers, String deck) {
		return IntStream.range(0, numPlayers)
				.mapToObj(i -> IntStream.range(0, deck.length() / numPlayers)
						.mapToObj(j -> String.valueOf(deck.charAt(j * numPlayers + i))).collect(Collectors.joining()))
				.toArray(String[]::new);
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, String p1, boolean hasAnswer, String[] p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "\"" + p1 + "\"");
		System.out.println("]");
		Cards obj;
		String[] answer;
		obj = new Cards();
		long startTime = System.currentTimeMillis();
		answer = obj.deal(p0, p1);
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

		int p0;
		String p1;
		String[] p2;

		// ----- test 0 -----
		p0 = 6;
		p1 = "012345012345012345";
		p2 = new String[] { "000", "111", "222", "333", "444", "555" };
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = 4;
		p1 = "111122223333";
		p2 = new String[] { "123", "123", "123", "123" };
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = 1;
		p1 = "012345012345012345";
		p2 = new String[] { "012345012345012345" };
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = 6;
		p1 = "01234";
		p2 = new String[] { "", "", "", "", "", "" };
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = 2;
		p1 = "";
		p2 = new String[] { "", "" };
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
