package lec1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder res = new StringBuilder();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(Character.isUpperCase(c)){
                res.append(Character.toLowerCase(c));
            } else{
                res.append(Character.toUpperCase(c));
            }
        }

        System.out.println(res);
    }
}
