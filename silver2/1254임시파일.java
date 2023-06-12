
String s = br.readLine();
int n= s.length();
int ans=0, right=n-1;
for ( int left=0; left<n; left++) {
   if (left==right) { //홀수개인 경우 종료 조건
    ans++;     
     break;
   }
   else if (left>right) break; //짝수개인 경우 종료 조건


   if (s.charAt(left)==s.charAt(right))  //같은 쌍이 있으면
     right--;
   
   //쌍이 있든 없든 2개 증가
    ans+=2; 
   

}


bw.write(Integer.toString(ans));
