from sys import stdin
from heapq import heappush, heappop

# 표준 입력을 빠르게 받기 위해 stdin.readline을 사용
input = stdin.readline

# 공간의 크기 N을 입력받음
# n = int(input())
n = 6

# 공간의 상태를 입력받음
# array = [list(map(int, input().split())) for _ in range(n)]
# 우선순위 큐를 사용하여 BFS를 수행
q = []

# array = [
#     [4, 3, 2, 1],
#     [0, 0, 0, 0],
#     [0, 0, 9, 0],
#     [1, 2, 3, 4]
# ]

array = [
    [5, 4, 3, 2, 3, 4],
    [4, 3, 2, 3, 4, 5],
    [3, 2, 9, 5, 6, 6],
    [2, 1, 2, 3, 4, 5],
    [3, 2, 1, 6, 5, 4],
    [6, 6, 6, 6, 6, 6]
]

# 초기화 함수
def init():
    for i in range(n):
        for j in range(n):
            # 아기 상어의 위치를 찾으면
            if array[i][j] == 9:
                # 큐에 (거리, x, y) 형태로 초기 위치를 추가
                heappush(q, (0, i, j))
                # 아기 상어의 위치를 빈 칸으로 설정
                array[i][j] = 0
                return

# BFS 함수
def bfs():
    # 초기 상어의 크기, 먹은 물고기 수, 총 시간 초기화
    body, eat, ans = 2, 0, 0
    # 방문 확인 배열 초기화
    check = [[False]*n for _ in range(n)]
    while q:
        # 큐에서 현재 위치와 거리를 꺼냄
        d, x, y = heappop(q)
        # 현재 위치에 먹을 수 있는 물고기가 있다면
        if 0 < array[x][y] < body:
            # 물고기를 먹음
            eat += 1
            # 해당 칸을 빈 칸으로 만듦
            array[x][y] = 0
            # 먹은 물고기 수가 상어의 크기와 같다면 상어 크기 증가
            if eat == body:
                body += 1
                eat = 0
            # 이동한 거리를 총 시간에 더함
            ans += d
            # 현재 거리 초기화
            d = 0
            # 큐를 비우고 새로운 탐색을 위해 초기화
            while q:
                q.pop()
            check = [[False]*n for _ in range(n)]
        # 네 방향으로 이동
        for dx, dy in (-1, 0), (0, -1), (1, 0), (0, 1):
            nd, nx, ny = d+1, x+dx, y+dy
            # 범위를 벗어나면 무시
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            # 상어의 크기보다 큰 물고기가 있거나 이미 방문한 곳이면 무시
            if 0 < array[nx][ny] > body or check[nx][ny]:
                continue
            # 방문 표시 후 큐에 추가
            check[nx][ny] = True
            heappush(q, (nd, nx, ny))
    # 총 시간을 출력
    print(ans)

# 초기화 함수 호출
init()
# BFS 함수 호출
bfs()