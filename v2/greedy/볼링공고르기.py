# import itertools

n, m = map(int, input().split())
data = list(map(int, input().split()))

n = 5

m = 5

data = [1, 3, 2, 3, 2]

# 1부터 10까지의 무게를 담을 수 있는 리스트
array = [0] * 11

for x in data:
    # 각 무게에 해당하는 볼링공의 개수 카운트
    array[x] += 1

result = 0
# 1부터 m까지의 각 무게에 대하여 처리
for i in range(1, m + 1):
    n -= array[i] # 무게가 i인 볼링공의 개수(A가 선택할 수 있는 개수) 제외
    result += array[i] * n # B가 선택하는 경우의 수와 곱해주기

print(result)

# 리스트
# balls = [1, 5, 4, 3, 2]
#
# # 조합 생성 함수
# def get_combinations(lst, r):
#     return list(itertools.combinations(lst, r))
#
# # 예제: 2개를 선택하는 조합
# combinations_2 = get_combinations(balls, 2)
# print("2개를 선택하는 조합:")
# for comb in combinations_2:
#     print(comb)