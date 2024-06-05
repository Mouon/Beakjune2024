package org.example.implement;

import java.util.*;

public class Q7785 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        long N = scan.nextInt();
        scan.nextLine();
        HashMap<String,String> hash = new HashMap<>();
        ArrayList<String> strArr = new ArrayList<>();

        for(int i=0;i<N;i++){
            String str = scan.nextLine();
            String[] command = str.split(" ");
            if(command[1].equals("enter")){
                hash.put(command[0],command[1]);
            } else if (command[1].equals("leave")) {
                hash.remove(command[0]);
            }
        }

        List<String> keySet = new ArrayList<>(hash.keySet());

        Collections.sort(keySet,Collections.reverseOrder());

        for(int i=0;i< hash.size();i++){
            System.out.println(keySet.get(i));
        }



    }
}
