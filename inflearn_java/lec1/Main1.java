package lec1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
        char c = br.readLine().charAt(0);
        c = Character.toUpperCase(c);

        int res = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == c){
                res = res + 1;
            }
        }

        System.out.println(res);
    }



}
