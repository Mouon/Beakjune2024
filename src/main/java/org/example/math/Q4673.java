package org.example.math;

public class Q4673 {
    public static void main(String[] args) {
        boolean[] nonSelfNum = new boolean[10001];

        for(int i=1;i<10001;i++){
            int num = computeDn(i);
            if(num<10001) nonSelfNum[num] = true;
        }
        for(int i=1;i<10001;i++){
            if(!nonSelfNum[i]) System.out.println(i);
        }

    }
    public static int computeDn(int num) {
        int sum=num;
        while (num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
