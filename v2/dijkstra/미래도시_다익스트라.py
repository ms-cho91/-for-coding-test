import heapq
import sys
INF = int(1e9) # 무한을 의미하는 값으로 10억을 설정

# 노드의 개수, 간선의 개수를 입력받기
# n, m = map(int, input().split())
n=5
m=7
# 시작 노드 번호를 입력받기
c = 1

# 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
# graph = [[] for i in range(n + 1)]
# 방문한 적이 있는지 체크하는 목적의 리스트를 만들기
visited = [False] * (n + 1)
# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n + 1)

# 모든 간선 정보를 입력받기
# for _ in range(m):
#     x, y, z = map(int, input().split())
#     # x번 노드에서 y번 노드로 가는 비용이 z라는 의미
#     graph[x].append((y, z))

## 입력
# [1, 2],
# [1, 3],
# [1, 4],
# [2, 4],
# [3, 4],
# [3, 5],
# [4, 5]

graph = [
        [],
        [],
        [],
        [],
        [],
        []
        ]

def dijkstra(start):
    q = []
    # 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q: # 큐가 비어있지 않다면
        # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(q)
        # 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

# 다익스트라 알고리즘을 수행
dijkstra(c)

# 도시 C에서 보낸 메세지를 받게 되는 도시의 개수
count = 0
# 도시 C에서 보낸 메시지를 받을 수 있는 도시들이 모두 메시지를 받는 데까지 걸리는 시간
max = 0

for i in range(1, n + 1):
    # 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
    if distance[i] < INF:
        count += 1
        if distance[i] > max:
            max = distance[i]

# 시작 노드는 제거해야 하므로 count - 1을 출력
print(count - 1 , max)
