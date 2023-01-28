import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1926_dfs {

    static boolean[][] ch;
    static int[][] arr;
    static int n, m;
    static int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
    static int max_cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        ch = new boolean[n][m];
        int max = 0;
        int cnt = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1 && ch[i][j] == false){
                    max_cnt = 0;
                    max_cnt = dfs(i, j);
                    if(max_cnt == 0){
                        max_cnt = 1;
                    }
                    max = Math.max(max, max_cnt);
                    cnt = cnt + 1;
                }
            }
        }

//        if(n == 1 && m == 1 && arr[n-1][m-1] == 1){
//            cnt = 1;
//            max = 1;
//        }

        System.out.println(cnt);
        System.out.println(max);


    }

    public static int dfs(int x, int y){
//        if(x == n-1 && y == m-1){
//            return max_cnt;
//        }


        for(int i=0; i<4; i++){
            int nx = x + d[i][0];
            int ny = y + d[i][1];

            if(nx<n && nx>=0 && ny<m && ny>=0 && ch[nx][ny] == false && arr[nx][ny] == 1){
                ch[nx][ny] = true;
                max_cnt = max_cnt + 1;
                dfs(nx, ny);
            }
        }

        return max_cnt;
    }




}
