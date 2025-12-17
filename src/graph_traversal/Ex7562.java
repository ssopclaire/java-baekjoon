package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex7562 {
    static final int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder out = new StringBuilder();

            int t = Integer.parseInt(br.readLine());

            while (t-- > 0) {
                out.append(solveCase(br)).append('\n');
            }

            System.out.print(out);
        } catch (IOException e) {
        }
    }

    private static int solveCase(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());

        int[] start = readPair(br);
        int[] target = readPair(br);

        int sr = start[0], sc = start[1];
        int tr = target[0], tc = target[1];

        if (sr == tr && sc == tc) return 0;

        return bfsKnightMinMoves(n, sr, sc, tr, tc);
    }

    private static int[] readPair(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        return new int[]{
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        };
    }

    private static int bfsKnightMinMoves(int n, int sr, int sc, int tr, int tc) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.add(sr * n + sc);
        dist[sr][sc] = 0;

        while (!q.isEmpty()) {
            int v = q.poll();
            int r = v / n, c = v % n;

            int nd = dist[r][c] + 1;

            for (int k = 0; k < 8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                if (dist[nr][nc] != -1) continue;

                if (nr == tr && nc == tc) return nd;

                dist[nr][nc] = nd;
                q.add(nr * n + nc);
            }
        }

        return dist[tr][tc];
    }
}