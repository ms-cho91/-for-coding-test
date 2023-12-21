X = int(input())
# dp 리스트 초기화
dp = [0] * (X + 1)

# 2부터 X까지의 모든 수에 대해 최솟값 계산
for i in range(2, X + 1):
    dp[i] = dp[i - 1] + 1  # 1을 뺀 경우의 연산 횟수

    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i // 2] + 1)  # 2로 나눈 경우의 연산 횟수

    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)  # 3으로 나눈 경우의 연산 횟수

    if i % 5 == 0:
        dp[i] = min(dp[i], dp[i // 5] + 1)  # 5로 나눈 경우의 연산 횟수

print(dp[X])