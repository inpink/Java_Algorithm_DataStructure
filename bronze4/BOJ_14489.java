import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;	
import java.util.StringTokenizer;

public class Main { //class name은 Main 이어야 함
	public static void main(String[] args) throws IOException { //예외처리 꼭 해줘야 함
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());
		BigInteger a=new BigInteger(st.nextToken());
		BigInteger b=new BigInteger(st.nextToken());
		
		BigInteger n=new BigInteger(br.readLine()).multiply(BigInteger.valueOf(2)); //☆
		
		BigInteger sum=a.add(b);
		//System.out.println(n.toString() + " " + sum.toString());
		if (sum.compareTo(n)>=0) //sum>= a+b
			sum=sum.subtract(n);
			
		System.out.println(sum.toString());
				

    }
}
