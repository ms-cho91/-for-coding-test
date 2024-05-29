"""
정사각형 모양의 지도가 있다.
1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고,
단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
대각선상에 집이 있는 경우는 연결된 것이 아니다.
지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

1. 아이디어
각 위치를 돌면서 연결된 구멍 방문
아이스크림 개수를 증가

2. 시간복잡도
O(N*M)

3. 자료구조
배열
"""

from collections import deque
def dfs(map, x, y, m):
    # 방향 벡터: 상, 하, 좌, 우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque([(x, y)])
    map[x][y] = 0  # 방문한 집은 0으로 변경
    count = 1  # 집의 수

    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx, ny = cx + dx[i], cy + dy[i]
            if 0 <= nx < m and 0 <= ny < m and map[nx][ny] == 1:
                map[nx][ny] = 0  # 방문 처리
                queue.append((nx, ny))
                count += 1

    return count


def find_complexes(n, m, map):

    complexes = []

    for i in range(n):
        for j in range(m):
            if map[i][j] == 1:
                # 새로운 단지를 발견했으므로, DFS를 통해 단지의 크기 계산
                complexes.append(dfs(map, i, j, m))

    return complexes

# 입력 받기
# n, m = map(int, input().split())
# ice_tray = []
# for _ in range(n):
#     ice_tray.append(list(map(int, input().strip())))

map = [
    [0, 1, 1, 0, 1, 0, 0],
    [0, 1, 1, 0, 1, 0, 1],
    [1, 1, 1, 0, 1, 0, 1],
    [0, 0, 0, 0, 1, 1, 1],
    [0, 1, 0, 0, 0, 0, 0],
    [0, 1, 1, 1, 1, 1, 0],
    [0, 1, 1, 1, 0, 0, 0]

]
n = len(map)
m = len(map[0])
# 단지 찾기
complexes = (find_complexes(n, m, map))

# 결과 출력
complexes.sort()
print(len(complexes))
for size in complexes:
    print(size)