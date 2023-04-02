package lec1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main4 {

    // StringBuilder의 reverse를 사용한 방법
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<String> res = new ArrayList<>();
//
//        int N = Integer.parseInt(br.readLine());
//
//        for(int i=0; i<N; i++){
//            String str = br.readLine();
//            String tmp = new StringBuilder(str).reverse().toString();
//            res.add(tmp);
//        }
//
//        for(int i=0; i<res.size(); i++){
//            System.out.println(res.get(i));
//        }
//    }

    // lt와 rt를 사용해서 교환하는 방법
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> res = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String str = br.readLine();
            char[] s = str.toCharArray();
            int lt = 0;
            int rt = s.length-1;
            while(true){
                if(lt == rt || lt>rt){
                    break;
                }
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            res.add(String.valueOf(s));

        }

        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }

}
