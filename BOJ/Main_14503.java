import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {

    static class ro{
        int r;
        int c;
        int d;

        ro(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ro robot = new ro(r, c, d);

        int[][] map = new int[N][M];
        boolean[][] ch = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방향(d) : 0 북 1 동 2 남 3 서
        // 빈 칸은 0, 벽은 1

        int cnt = 1;
        int x = 0;
        int nr = 0;
        int nc = 0;

        boolean fin = false;

        ch[robot.r][robot.c] = true;
        while(true){

            if(fin == true){
                break;
            }

            if(x == 4){
                switch (robot.d){
                    case 0:
                        nr = robot.r + 1;
                        nc = robot.c;
                        if(nr<N && nr>=0 && nc<M && nc>=0 && map[nr][nc] == 0){
                            robot.r = nr;
                            robot.c = nc;
                            x = 0;
                        } else{
                            fin = true;
                            break;
                        }
                        break;
                    case 1:
                        nr = robot.r;
                        nc = robot.c - 1;
                        if(nr<N && nr>=0 && nc<M && nc>=0 && map[nr][nc] == 0){
                            robot.r = nr;
                            robot.c = nc;
                            x = 0;
                        } else{
                            fin = true;
                            break;
                        }
                        break;
                    case 2:
                        nr = robot.r -1;
                        nc = robot.c;
                        if(nr<N && nr>=0 && nc<M && nc>=0 && map[nr][nc] == 0){
                            robot.r = nr;
                            robot.c = nc;
                            x = 0;
                        } else{
                            fin = true;
                            break;
                        }
                        break;
                    case 3:
                        nr = robot.r;
                        nc = robot.c + 1;
                        if(nr<N && nr>=0 && nc<M && nc>=0 && map[nr][nc] == 0){
                            robot.r = nr;
                            robot.c = nc;
                            x = 0;
                        } else{
                            fin = true;
                            break;
                        }
                        break;
                }
            }

            switch (robot.d){
                case 0:     // 북, 왼쪽은 서
                    nr = robot.r;
                    nc = robot.c -1;

                    if(nr<N && nr>=0 && nc<M && nc>=0 && map[nr][nc] == 0 && ch[nr][nc] == false){
                        robot.d = 3;
                        robot.r = nr;
                        robot.c = nc;
                        cnt = cnt + 1;
                        x = 0;
                        ch[nr][nc] = true;
                    } else {
                        robot.d = 3;
                        x = x + 1;
                    }
                    break;
                case 1:     // 동, 왼쪽은 북
                    nr = robot.r - 1;
                    nc = robot.c;

                    if(nr<N && nr>=0 && nc<M && nc>=0 && map[nr][nc] == 0 && ch[nr][nc] == false){
                        robot.d = 0;
                        robot.r = nr;
                        robot.c = nc;
                        cnt = cnt + 1;
                        x = 0;
                        ch[nr][nc] = true;
                    } else {
                        robot.d = 0;
                        x = x + 1;
                    }
                    break;
                case 2:     // 남, 왼쪽은 동
                    nr = robot.r;
                    nc = robot.c + 1;

                    if(nr<N && nr>=0 && nc<M && nc>=0 && map[nr][nc] == 0 && ch[nr][nc] == false){
                        robot.d = 1;
                        robot.r = nr;
                        robot.c = nc;
                        cnt = cnt + 1;
                        x = 0;
                        ch[nr][nc] = true;
                    } else {
                        robot.d = 1;
                        x = x + 1;
                    }
                    break;
                case 3:     // 서, 왼쪽은 남
                    nr = robot.r +1;
                    nc = robot.c;

                    if(nr<N && nr>=0 && nc<M && nc>=0 && map[nr][nc] == 0 && ch[nr][nc] == false){
                        robot.d = 2;
                        robot.r = nr;
                        robot.c = nc;
                        cnt = cnt + 1;
                        x = 0;
                        ch[nr][nc] = true;
                    } else {
                        robot.d = 2;
                        x = x + 1;
                    }
                    break;
            }


        }

        System.out.println(cnt);

    }

}
