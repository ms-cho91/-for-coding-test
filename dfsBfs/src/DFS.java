import java.util.ArrayList;
import java.util.Stack;

// 그래프를 나타내는 클래스
class DfsGraph {
    private int vertices; // 정점의 수
    private ArrayList<ArrayList<Integer>> adjacencyList; // 인접 리스트

    // 그래프 생성자
    public DfsGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    // 간선 추가
    public void addEdge(int source, int destination) {
        this.adjacencyList.get(source).add(destination);
        this.adjacencyList.get(destination).add(source);
    }

    // DFS 구현
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!visited[currentVertex]) {
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
            }

            // 현재 정점과 연결된 모든 인접한 정점을 스택에 추가
            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}

public class DFS {
    public static void main(String[] args) {

        /** 깊이 우선 탐색
         * 깊이 우선 탐색(DFS, Depth-First Search)은 그래프나 트리 등의 자료 구조에서 깊이 방향으로 탐색하는 알고리즘
         * DFS는 스택 또는 재귀 함수를 이용하여 구현할 수 있다.
         */

        /** solution
         */

        // 그래프 생성
        DfsGraph graph = new DfsGraph(6);

        // 간선 추가
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        // DFS 탐색
        System.out.println("DFS traversal starting from vertex 0:");
        graph.dfs(0);
    }
}