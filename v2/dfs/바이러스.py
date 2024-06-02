"""
DFS는 깊이 우선 탐색이라고도 부르며 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘이다.

DFS는 스택 자료구조(혹은 재귀 함수)를 이용하며, 구체적인 동작 과정은 다음과 같다.

1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
2. 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있으면 그 노드를 스택에 넣고 방문 처리한다. 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
3. 더이상 2번의 과정을 수행할 수 없을 때까지 반복한다.

1. 아이디어


2. 시간복잡도


3. 자료구조

"""
import numpy as np

# DFS 메서드 정의
def dfs(graph, v, visited):
    # 현재 노드를 방문 처리
    visited[v] = True
    print(v, end=' ')
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

# 인접 리스트 방식으로 그래프 표현
# 각 노드가 연결된 정보를 표현(2차원 리스트)
def count_infected_computers(num_computers, connections):
    # 그래프 초기화
    graph = [[] for _ in range(num_computers + 1)]
    for a, b in connections:
        graph[a].append(b)
        graph[b].append(a)

    # 각 노드가 방문된 정보를 표현(1차원 리스트)
    # 기본적으로 모든 값들을 False로 초기화하고, index 0은 사용하지 않는다.
    visited = [False]*len(graph)
    #
    # # 정의된 DFS 함수 호출
    dfs(graph,1,visited)

    print(end="\n")
    print(visited.count(True)-1)

def count(graph, visited, v):

    for i in range(len(graph)):
        if graph[i][v] == 0:
            visited.append(graph[i][v+1])
            graph[graph == graph[i][v+1]] = 0
    print(visited)

num_computers = 7

connections = [
    [],
    [1,2],
    [2,3],
    [1,5],
    [5,2],
    [5,6],
    [4,7],
    [8,6]
]

# NumPy
matrix = np.array([
    [1,2],
    [2,3],
    [1,5],
    [5,6],
    [4,7]
])

matrix[matrix == matrix[0][0]] = 0
visited = []
count(matrix, visited, 0)


# count_infected_computers(num_computers, connections)

