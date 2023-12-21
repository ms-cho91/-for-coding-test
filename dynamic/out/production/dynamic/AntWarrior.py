def ant_warrior(N, food_storages):
    dp = [0] * N

    # 첫 번째 식량창고까지의 최대 식량 양
    dp[0] = food_storages[0]

    # 두 번째 식량창고까지의 최대 식량 양
    dp[1] = max(food_storages[0], food_storages[1])

    # 동적 프로그래밍을 사용하여 각 식량창고까지의 최대 식량 양 계산
    for i in range(2, N):
        dp[i] = max(dp[i - 1], dp[i - 2] + food_storages[i])

    # 결과 출력
    return dp[N - 1]

# 입력 받기
N = int(input())
food_storages = list(map(int, input().split()))

# 결과 출력
print(ant_warrior(N, food_storages))