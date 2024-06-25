# 특정 원소가 속한 집합을 찾기
def find_team(team, x):
    # 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
    if team[x] != x:
        team[x] = find_team(team, team[x])
    return team[x]

# 두 원소가 속한 집합을 합치기
def union_team(team, a, b):
    a = find_team(team, a)
    b = find_team(team, b)
    if a < b:
        team[b] = a
    else:
        team[a] = b

# n, m = map(int, input().split())

n = 7
m = 8
team = [0] * (n + 1) # 부모 테이블 초기화

# 팀 테이블, 팀 자기 자신으로 초기화
for i in range(0, n + 1):
    team[i] = i

# 각 연산을 하나씩 확인
for i in range(m):
    oper, a, b = map(int, input().split())
    # 팀 합치기 연산인 경우
    if oper == 0:
        union_team(team, a, b)
    # 팀 찾기 연산인 경우
    elif oper == 1:
        if find_team(team, a) == find_team(team, b):
            print('YES')
        else:
            print('NO')