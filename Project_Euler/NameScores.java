//Problem 22: For example, when the list is sorted into alphabetical order,
//COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
//So, COLIN would obtain a score of 938 × 53 = 49714.
//What is the total of all the name scores in the file?
import java.util.*;
import java.io.*;
import java.math.BigInteger;

class NameScores {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		try {
			File file = new File("p022_names.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			List<String> allNames = new ArrayList<>();
			BigInteger sum = BigInteger.ZERO;
			while ((line = br.readLine()) != null) {
				String[] names = line.split(",");
				for (String n : names) {
					n = n.substring(1, n.length()-1);
					allNames.add(n);
				}
			}
			Collections.sort(allNames);
			for (int i = 0; i < allNames.size(); i++) {
				int product = i+1;
				String currentName = allNames.get(i);
				char[] characters = currentName.toCharArray();
				int sumOfCharValue = 0;
				for (char c : characters) {
					int ascii = (int)c;
					int charValue = ascii - 64;
					sumOfCharValue += charValue;
				}
				product *= sumOfCharValue;
				sum = sum.add(BigInteger.valueOf(product));
			}
			System.out.println(sum);
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			System.out.println(timeElapsed/1000000 + " ms");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}