# 입력 받기
N = int(input())

# dp 리스트 초기화
dp = [0] * (N + 1)

# 초기값 설정
dp[1] = 1
dp[2] = 3

# 동적 프로그래밍을 사용하여 모든 경우의 수 계산
for i in range(3, N + 1):
    dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 796796

# 결과 출력
print(dp[N])