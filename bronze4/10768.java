import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		String ans="";

		if (m < 2) ans="Before";
		else if (m == 2){
			if (d < 18) {
				ans="Before";
			}else if(d == 18) {
				ans="Special";
			}else {
				ans="After";
			}
		}
        else ans="After";

        System.out.println(ans);

	}

}
