package org.example.dp;

public class Q11057 {
    public static void main(String[] args) {
        System.out.println(solution("123"));
    }
    static public int solution(String s){
        int ans = -1;
        int count = 1;

        char before = s.charAt(0);
        for(int i =1;i<s.length()-1;i++){
            if(before==s.charAt(i)){
                count++;
            }else {
                count=1;
            }
            if(count==3){
                count=1;
                if(ans<before){
                    ans = Character.getNumericValue(before);
                }
            }
            before = s.charAt(i);
        }
        return ans;
    }
}
