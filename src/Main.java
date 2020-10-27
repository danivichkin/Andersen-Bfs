import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input matrix size: ");
        int size = in.nextInt();
        Graphs a = new Graphs();
        a.inputMatrix(size);

    }

    static class Graphs {
        private final ArrayDeque<Integer> queue = new ArrayDeque<>();
        private final boolean[] used = new boolean[7];
        private boolean[][] graph;

        void inputMatrix(int size) {
            Scanner in = new Scanner(System.in);
            boolean[][] matrix = new boolean[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print("Input values: ");
                    matrix[i][j] = in.nextInt() == 1;
                    System.out.println(matrix[i][j] + "\t");
                }
            }
            graph = matrix;
        }

        void Bfs() {
            queue.add(1);
            used[0] = true;
            while (!queue.isEmpty()) {
                int i = queue.element() - 1;
                System.out.println(queue.element());
                for (int j = 0; j < graph.length; j++) {
                    if (graph[i][j] && !used[j]) {
                        used[j] = true;
                        queue.add(j + 1);
                    }
                }
                queue.remove();
            }
        }
    }
}
