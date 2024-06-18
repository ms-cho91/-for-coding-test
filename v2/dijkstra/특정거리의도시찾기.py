import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

N, M, K, X = map(int, input().split())  # 노드수, 간선수, 목표 거리, 시작 노드
graph = [[] for _ in range(N+1)]  # 연결 리스트
distance = [INF]*(N+1)  # X로부터 각 노드 최소 거리, 무한수로 초기화

# 각 간선 연결
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)

def dijkstra(start):
    q = []
    distance[start] = 0  # start 노드 거리 초기화
    heapq.heappush(q, (0, start))  # 우선순위 큐에 (거리, 시작 노드) 삽입

    while q:  # 큐에 값이 있을 동안
        dist, now = heapq.heappop(q)  # 우선순위 큐에 존재하는 거리가 가장 짧은 노드
        if distance[now] < dist:  # 방문한 노드
            continue
        for i in graph[now]:  # now노드와 연결된 모든 노드
            cost = 1 + dist  # 1 + now노드의 최소 거리
            if cost < distance[i]:  # now -> i 거리가 작다면
                distance[i] = cost  # 업데이트
                heapq.heappush(q, (cost, i))  # 우선순위 큐 삽입


dijkstra(X)  # 실행 후 X로부터 각 노드가 떨어진 최소 거리 distance 작성 완료

flag = False  # K와 일치하는 거리가 있는지 판단
for i in range(1, N+1):
    if distance[i] == K:
        flag = True  # 일치 하는 것 존재
        print(i)
if not flag:  # 일치하는 것 존재하지 않음
    print(-1)



# import heapq
# import sys
# f = sys.stdin.readline
# INF = int(1e9)
#
# n, m, k, x = map(int, f().split())
# graph = [[] for _ in range(n+1)]
# distance = [INF] * (n+1)
#
# for _ in range(m):
#     a, b = map(int, f().split())
#     graph[a].append((b, 1))
#
# def dijkstra(start):
#     q = []
#     heapq.heappush(q, (0, start))
#     distance[start] = 0
#     while q:
#         dist, now = heapq.heappop(q)
#         if distance[now] < dist: continue
#         for j in graph[now]:
#             cost = dist + j[1]
#             if cost < distance[j[0]]:
#                 distance[j[0]] = cost
#                 heapq.heappush(q, (cost, j[0]))
#
# dijkstra(x)
# answer = []
# for i in range(1, n+1):
#     if distance[i] == k: answer.append(i)
#
# if len(answer) == 0: print(-1)
# else:
#     for i in answer: print(i, end='\n')