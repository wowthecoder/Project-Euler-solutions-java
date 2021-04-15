//Problem 42: how many are triangle numbers?
import java.io.*;

class CodedTriangleNum {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		try {
			File file = new File("p042_words.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";	
			int count = 0;
			while((line = br.readLine()) != null) {
				String[] words = line.split(",");
				for (String w : words) {
					w = w.substring(1, w.length()-1);//remove the quotation marks
					char[] characters = w.toCharArray();
					int sumOfCharValue = 0;
					for (char c : characters) {
						int ascii = (int)c;
						int charValue = ascii - 64;
						sumOfCharValue += charValue;
					}
					if (isTriangle(sumOfCharValue)) 
						count++;
				}
			}
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed/1000000 + " ms");
	}
	
	static boolean isTriangle(int number) {
		number *= 2;
		//completing the square, n^2 + n = (n + 1/2)^2 - 1/4
		//inverse the function, (sqrt(4x+1))/2 - 1/2
		int numer = number*4 + 1;
		double sqrtNumer = Math.sqrt(numer);
		if ((int)sqrtNumer != sqrtNumer)
			return false;
		double finalNum = (double)((int)sqrtNumer - 1) / 2.0;
		if ((int)finalNum == finalNum)
			return true;
		return false;
	}
}
