import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;

//r = a^e mod n
public class Main {
	public static void main (String args[]) {
		long a, e, n, r;
		String[] input = new String[3];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				input = line.split(" ");

				a = (long) Double.parseDouble(input[0]);
				e = (long) Double.parseDouble(input[1]);
				n = (long) Double.parseDouble(input[2]);

				//compute a^e using square-and-multiply
				//take result mod n to get r
				r = sqAndMulti(a,e) % n;
				System.out.println(r); 


			}
		} catch (IOException err){
			//If we reach an empty line the input is completed, do nothing
		}
	}

	/* Compute x^y using the square-and-multiply algorithm */
	private static long sqAndMulti(long x, long y){
		if (y == 0) return 1; //trivial
		else if (y == 1) return x; //trivial
		else if (y%2 == 0) return sqAndMulti(x*x, y/2); //if y is even
		return (x * sqAndMulti(x*x, (y-1)/2)); //if we reach this, y has to be odd
	}
}