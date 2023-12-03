import java.util.*;

//Comparable 인터페이스를 구현하여 거리를 기준으로 우선순위 큐에서 정렬
class City implements Comparable<City> {
    int number;
    int distance;

    public City(int number, int distance) {
        this.number = number;
        this.distance = distance;
    }

    @Override
    public int compareTo(City other) {
        return Integer.compare(this.distance, other.distance);
    }
}

public class ShortestPath {
    public static void main(String[] args) {

        /** 특정 거리의 도시 찾기
         * 어떤 나라에는 1 ~ N번까지의 도시와 M개의 단방향 도로가 존재합니다.
         * 모든 도로의 거리는 1입니다. 이때 특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서,
         * 최단 거리가 정확히 K인 모든 도시의 번호를 출력하는 프로그램을 작성하세요.
         * 또한 출발 도시 X에서 출발 도시 X로 가는 최단 거리는 항상 0이라고 가정합니다.
         *
         * 입력
         * 첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K,
         * 출발 도시의 번호 X가 주어집니다. (2<=N<=300,000 1<=M<=1,000,000 1<=K<=300,000 1<=X<=N)
         * 둘째 줄부터 M개의 줄에 걸쳐서 두 개의 자연수 A, B가 주어지며, 각 자연수는 공백으로 구분합니다.
         * 이는 A번 도시에서 B번 도시로 이동하는 단방향 도로가 존재한다는 의미입니다. (1<=A, B<=N) 단, A와 B는 서로 다른 자연수입니다.
         *
         * 출력
         * X로 부터 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력합니다.
         * 이 때 도달할 수 있는 도시 중에서, 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력합니다.
         */

        /** solution
         * 모든 도로의 거리는 1이다. 이는 다시 말해 모든 간선의 비용이 1이라는 의미인데,
         * 그래프에서 모든 간선의 비용이 동일할 때는 너비 우선 탐색(BFS)을 이용하여 최단 거리를 찾을 수 있다.
         * 다시 말해 '모든 도로의 거리는 1'이라는 조건 덕분에 너비 우선 탐색을 이용하여 간단히 해결할 수 있는 것이다.
         */

        // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시 번호
        Scanner scanner = new Scanner(System.in);

//        int N = scanner.nextInt();
//        int M = scanner.nextInt();
//        int K = scanner.nextInt();
//        int X = scanner.nextInt();

        int N = 4;
        int M = 4;
        int K = 2;
        int X = 1;

        // 그래프 초기화
        List<List<City>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

//        // 단방향 도로 정보 입력
//        for (int i = 0; i < M; i++) {
//            int A = scanner.nextInt();
//            int B = scanner.nextInt();
//            graph.get(A).add(new City(B, 1));
//        }

        graph.get(1).add(new City(2, 1));
        graph.get(1).add(new City(3, 1));
        graph.get(2).add(new City(3, 1));
        graph.get(2).add(new City(4, 1));


        // 다익스트라 알고리즘을 사용하여 최단 거리 계산
        int[] distances = dijkstra(graph, X, N);

        // 최단 거리가 K인 도시들 출력
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (distances[i] == K) {
                result.add(i);
            }
        }

        // 결과 출력
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int city : result) {
                System.out.println(city);
            }
        }
    }

    // 다익스트라 알고리즘 구현
    private static int[] dijkstra(List<List<City>> graph, int start, int N) {
        // distances 배열은 각 도시까지의 최단 거리를 저장
        int[] distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        // 우선순위 큐를 사용하여 최단 거리 계산
        PriorityQueue<City> queue = new PriorityQueue<>();
        queue.add(new City(start, 0));

        while (!queue.isEmpty()) {
            City current = queue.poll();

            if (current.distance > distances[current.number]) {
                continue;
            }

            for (City neighbor : graph.get(current.number)) {
                int distance = current.distance + neighbor.distance;

                if (distance < distances[neighbor.number]) {
                    distances[neighbor.number] = distance;
                    queue.add(new City(neighbor.number, distance));
                }
            }
        }

        return distances;
    }
}