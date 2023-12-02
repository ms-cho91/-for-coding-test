import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 그래프를 나타내는 클래스
class BfsGraph {
    private int vertices; // 정점의 수
    private LinkedList<Integer>[] adjacencyList; // 인접 리스트

    // 그래프 생성자
    public BfsGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }

    // 간선 추가
    public void addEdge(int source, int destination) {
        this.adjacencyList[source].add(destination);
        this.adjacencyList[destination].add(source);
    }

    // BFS 구현
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            // 현재 정점과 연결된 모든 인접한 정점을 큐에 추가
            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

public class BFS {
    public static void main(String[] args) {

        /** 깊이 우선 탐색
         * 깊이 우선 탐색(DFS, Depth-First Search)은 그래프나 트리 등의 자료 구조에서 깊이 방향으로 탐색하는 알고리즘
         * DFS는 스택 또는 재귀 함수를 이용하여 구현할 수 있다.
         */

        /** solution
         */

        // 그래프 생성
        BfsGraph graph = new BfsGraph(6);

        // 간선 추가
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        // BFS 탐색
        System.out.println("BFS traversal starting from vertex 0:");
        graph.bfs(0);
    }
}