package lec1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int m = Integer.MIN_VALUE;
        String res = "";

        String[] s = str.split(" ");
        for(int i=0; i<s.length; i++){
            if(s[i].length()>m){
                m = s[i].length();
                res = s[i];
            }
        }

        System.out.println(res);

    }

}
