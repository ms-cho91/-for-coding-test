import heapq

def dijkstra(graph, start, n):
    # 최단 거리 테이블을 모두 무한으로 초기화
    distance = [float('inf')] * (n + 1)
    distance[start] = 0
    q = []
    heapq.heappush(q, (0, start))  # 시작 노드를 우선순위 큐에 삽입

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for next_node in graph[now]:
            cost = dist + 1
            if cost < distance[next_node]:
                distance[next_node] = cost
                heapq.heappush(q, (cost, next_node))

    return distance

def future_city(n, roads, x, k):
    graph = [[] for _ in range(n + 1)]

    for a, b in roads:
        graph[a].append(b)
        graph[b].append(a)

    # 1번 회사에서 모든 회사까지의 최단 거리
    distance_from_1 = dijkstra(graph, 1, n)
    # K번 회사에서 모든 회사까지의 최단 거리
    distance_from_k = dijkstra(graph, k, n)

    # 1번 회사에서 K번 회사를 거쳐 X번 회사로 가는 최단 시간 계산
    total_distance = distance_from_1[k] + distance_from_k[x]

    if total_distance >= float('inf'):
        return -1
    else:
        return total_distance

# 입력 예시
n = 5  # 회사의 개수
m = 7  # 경로의 개수
roads = [
    (1, 2),
    (1, 3),
    (1, 4),
    (2, 4),
    (3, 4),
    (3, 5),
    (4, 5)
]
x = 4  # 목표 회사
k = 5  # 소개팅 회사

# 결과 출력
print(future_city(n, roads, x, k))