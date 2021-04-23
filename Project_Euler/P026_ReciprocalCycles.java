//Problem 26: Find the value of d < 1000 for which 1/d contains 
//the longest recurring cycle in its decimal fraction part.
import java.util.HashMap;

class ReciprocalCycles {
	public static void main(String[] args) {
		int numer = 1*10;
		int maxCycleLength= 0;
		int longestDenom = 0;
		for (int d = 2; d <= 1000; d++) {
			//key is remainder, value is position in decimal
			HashMap<Integer, Integer> remainders = new HashMap<>();
			boolean isRecurring = true;
			int pos = 1;
			int firstOccurence = 0;
			int secondOccurence = 0;
			while (true) {
				if (numer % d == 0) {
					isRecurring = false;
					break;
				}
				int rem = numer % d;
				if (remainders.containsKey(rem)) {
					firstOccurence = remainders.get(rem);
					secondOccurence = pos;
					System.out.println(d + " : " + (secondOccurence-firstOccurence));
					break;	
				}					
				remainders.put(rem, pos);
				numer = rem * 10;
				pos++;
			}
			if (isRecurring && (secondOccurence - firstOccurence) > maxCycleLength) {
				maxCycleLength = secondOccurence - firstOccurence;
				longestDenom = d;
			}
			numer = 10;
		}
		System.out.println(longestDenom);
	}
}
