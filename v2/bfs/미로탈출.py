"""
문제
N x M 크기의 직사각형 형태의 미로에 여러 마리의 괴물이 있어 이를 피해 탈출해야 한다.
현재 위치는 (1, 1)이고 미로의 출구는 (N,M)의 위치에 존재하며 한 번에 한 칸씩 이동할 수 있다.
괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있다.
미로는 반드시 탈출할 수 있는 형태로 제시된다. 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하라.
칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산한다.

입력
첫째 줄에 두 정수 N, M(4 <= N, M <= 200)이 주어진다.
다음 N개의 줄에는 각각 M개의 정수(0혹은 1)로 미로의 정보가 주어진다.
각각의 수들은 공백 없이붙어서 입력으로 제시된다. 또한 시작 칸과 마지막 칸은 항상 1이다.

출력
첫째 줄에 최소 이동 칸의 개수를 출력한다.

1. 아이디어
시작점에서 출발해 BFS를 수행 거리를 기록

2. 시간복잡도
O(N*M)

3. 자료구조
배열
"""
from collections import deque

def escape_maze(n, m, maze):
    # 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    # BFS를 위한 큐 초기화
    queue = deque([(0, 0)])  # 시작점 (1, 1)은 인덱스로 (0, 0)

    while queue:
        x, y = queue.popleft()

        # 네 가지 방향으로 이동
        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            # 미로 범위를 벗어난 경우 무시
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue

            # 벽인 경우 무시
            if maze[nx][ny] == 0:
                continue

            # 처음 방문하는 경우에만 거리 기록
            if maze[nx][ny] == 1:
                maze[nx][ny] = maze[x][y] + 1
                queue.append((nx, ny))

    # 도착 지점 (N-1, M-1)의 거리 반환
    return maze[n-1][m-1]

# 입력 받기
# n, m = map(int, input().split())
# maze = [list(map(int, input().strip())) for _ in range(n)]

maze = [
    [1, 0, 1, 0, 1, 0],
    [1, 1, 1, 1, 1, 1],
    [0, 0, 0, 0, 0, 1],
    [1, 1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1, 1]
]

n = len(maze)
m = len(maze[0])
# 최소 이동 칸의 개수 출력
print(escape_maze(n, m, maze))