package org.example.implement;

public class DevSisters {
    public int solution(String jelly, int k) {
        int n = jelly.length();
        int answer = 0;

        int[] state = new int[n];
        for (int i = 0; i < n; i++) {
            char ch = jelly.charAt(i);
            if (ch == 'Y') state[i] = 0;
            else if (ch == 'P') state[i] = 1;
            else if (ch == 'I') state[i] = 2; // 목표 얼음곰
        }

        int[] delta = new int[n + 1];
        int add = 0;

        for (int i = 0; i < n; i++) {
            add += delta[i];
            int current = (state[i] + add) % 3;

            if(state[i]!=2){
                int need = (2-current+3)%3;

                if(i+k>n){
                    return -1;
                }

                answer +=need;
                delta[i] +=need;
                delta[i+k] -=need;
                add+=need;
            }


        }

        return answer;
    }
}

//
//package org.example.implement;
//
//public class DevSisters {
//    public int solution(String jelly, int k) {
//        int n = jelly.length();
//        int answer = 0;
//
//        int[] state = new int[n];
//        for (int i = 0; i < n; i++) {
//            char ch = jelly.charAt(i);
//            if (ch == 'Y') state[i] = 0;
//            else if (ch == 'P') state[i] = 1;
//            else if (ch == 'I') state[i] = 2; // 목표 얼음곰
//        }
//
//        int[] delta = new int[n + 1];
//        int add = 0;
//
//        for (int i = 0; i < n; i++) {
//            add += delta[i];
//            int current = (state[i] + add) % 3;
//
//            if (current != 2) {
//                int need = (2 - current + 3) % 3; // 음수 방지
//
//                if (i + k > n) {
//                    return -1; // 영역 초과
//                }
//
//                answer += need;
//                delta[i] += need;
//                delta[i + k] -= need;
//                add += need;
//            }
//        }
//
//        return answer;
//    }
//}


