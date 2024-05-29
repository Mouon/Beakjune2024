package org.example.stackQ;

import java.io.IOException;
import java.util.*;

public class Q11866 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int N = scan.nextInt();
        int K = scan.nextInt();

        for (int i=1;i<=N;i++){
            queue.add(i);
        }

        while (!queue.isEmpty()){
            for(int i=0;i<K-1;i++){
                int temp=queue.remove();
                queue.add(temp);
            }
            arr.add(queue.remove());
        }

        for(int i=0;i<N;i++){
            if(i==0){
                System.out.print("<");
            }
            System.out.print(arr.get(i));
            if(i!=N-1){
                System.out.print(", ");
            }
            if(i==N-1){
                System.out.print(">");
            }
        }


    }
}
