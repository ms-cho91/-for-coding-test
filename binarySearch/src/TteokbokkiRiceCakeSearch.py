def binary_search_height(array, target, start, end):
    result = 0
    while start <= end:
        total = 0
        mid = (start + end) // 2
        for x in array:
            if x > mid:
                total += x - mid
        if total < target:
            end = mid - 1
        else:
            result = mid
            start = mid + 1
    return result

# 입력 받기
n, m = map(int, input().split())
heights = list(map(int, input().split()))

# 결과 출력
print(binary_search_height(heights, m, 0, max(heights)))