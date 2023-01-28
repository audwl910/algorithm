import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926_bfs {

    static boolean[][] ch;
    static int[][] arr;
    static int n, m;
    static int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
    static int max_cnt;

    static class me{
        int x;
        int y;
        me(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

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
                max_cnt = 0;
                if(arr[i][j] == 1 && ch[i][j] == false){
                    max_cnt = bfs(i, j);
                    max = Math.max(max, max_cnt);
                    cnt = cnt + 1;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);


    }

    public static int bfs(int x, int y){
        Queue<me> q = new LinkedList<>();
        ch[x][y] = true;
        q.add(new me(x, y));
        max_cnt = max_cnt + 1;

        while(!q.isEmpty()){
            me tmp = q.poll();

            for(int i=0; i<4; i++){
                int nx = tmp.x + d[i][0];
                int ny = tmp.y + d[i][1];

                if(nx<n && nx>=0 && ny<m && ny>=0 && arr[nx][ny] == 1 && ch[nx][ny] == false){
                    q.add(new me(nx, ny));
                    max_cnt = max_cnt + 1;
                    ch[nx][ny] = true;
                }
            }
        }

        return max_cnt;

    }


}
