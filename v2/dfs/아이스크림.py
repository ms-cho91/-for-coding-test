"""
문제
N × M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하라.
다음의 4 × 5 얼음 틀 예시에서는 아이스크림이 총 3개가 생성된다

입력
첫 번째 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어진다. (1 <= N, M <= 1,000)
두 번째 줄부터 N + 1 번째 줄까지 얼음 틀의 형태가 주어진다.
이때 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1이다.
출력
한 번에 만들 수 있는 아이스크림의 개수를 출력한다.

1. 아이디어
각 위치를 돌면서 연결된 구멍 방문
아이스크림 개수를 증가

2. 시간복잡도
O(N*M)

3. 자료구조
배열
"""

def count_ice_cream(n, m, ice_tray):
    def dfs(x, y):
        # 주어진 좌표가 얼음 틀의 범위를 벗어나면 종료
        if x < 0 or x >= n or y < 0 or y >= m:
            return False
        # 현재 노드를 아직 방문하지 않았다면
        if ice_tray[x][y] == 0:
            # 해당 노드 방문 처리
            ice_tray[x][y] = 1
            # 상, 하, 좌, 우의 위치도 모두 재귀적으로 호출
            dfs(x - 1, y)
            dfs(x + 1, y)
            dfs(x, y - 1)
            dfs(x, y + 1)
            return True
        return False

    result = 0
    for i in range(n):
        for j in range(m):
            # 현재 위치에서 DFS 수행
            if dfs(i, j):
                result += 1

    return result

# 입력 받기
# n, m = map(int, input().split())
# ice_tray = []
# for _ in range(n):
#     ice_tray.append(list(map(int, input().strip())))

ice_tray = [
    [0,0,1,1,0],
    [0,0,0,1,1],
    [1,1,1,1,1],
    [0,0,0,0,0]
]
n = len(ice_tray)
m = len(ice_tray[0])
# 아이스크림 개수 세기
print(count_ice_cream(n, m, ice_tray))
