package org.example.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

/**
 * 알파벳을 순서대로
 * 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다
 *
 * 최소 한개의 모음만 신경쓰면 될듯?
 * */

public class Q1759 {
    static ArrayList<String> moAll = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
    static int L ,C;
    static ArrayList<String> pwd =new ArrayList<>();
    static String[] letters;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<String> moArr = new ArrayList<>();
        ArrayList<String> jaArr = new ArrayList<>();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        letters = new String[C];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            letters[i] = st.nextToken();
        }


        Arrays.sort(letters);

        generatePassword(0, 0);

        br.close();

    }

    static void generatePassword(int length, int start) {
        if (length >= L) {
            if (isValidPassword()) {
                System.out.println(String.join("", pwd));
            }
            return;
        }

        // 백트래킹 공식
        for (int i = start; i < C; i++) {
            pwd.add(letters[i]);
            generatePassword(length + 1, i + 1);
            pwd.remove(pwd.size() - 1);
        }
    }

    static boolean isValidPassword() {
        int vowelCount = 0;
        int consonantCount = 0;

        for (String c : pwd) {
            if (moAll.contains(c)) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }

}










//    // 정은이 버전
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int l = Integer.parseInt(st.nextToken());
//        int c = Integer.parseInt(st.nextToken());
//
//        ArrayList
//        for(int i = 0; i < c; i++){
//
//        }
//
//    }