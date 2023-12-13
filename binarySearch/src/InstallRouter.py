def binary_search(houses, c):
    houses.sort()  # 집 좌표 오름차순 정렬
    start = 1      # 최소 거리
    end = houses[-1] - houses[0]  # 최대 거리 설정

    result = 0

    while start <= end:
        mid = (start + end) // 2 # mid는 가장 인접한 두 공유기 사이의 거리(gap)을 의미
        count = 1
        current_house = houses[0]

        # 현재의 mid 값을 이용해 공유기를 설치하기
        for i in range(1, len(houses)):
            if houses[i] - current_house >= mid:
                count += 1
                current_house = houses[i]

        if count >= c:      # C개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시키기
            result = mid
            start = mid + 1
        else:               # C개 이상의 공유기를 설치할 수 없는 경우, 거리를 감소시키기
            end = mid - 1

    return result

# 집의 개수(N)와 공유기의 개수(C)를 입력 받기
n, c = list(map(int, input().split(' ')))

# 전체 집의 좌표 정보를 입력 받기
houses = [int(input()) for _ in range(n)]


# 결과 출력
result = binary_search(houses, c)
print(result)