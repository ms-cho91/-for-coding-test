import bisect

# 예제 리스트 (정렬된 상태)
arr = [1, 1, 2, 3, 3, 3, 4, 5, 6, 7, 7]

# 타겟 값
target = 3

# bisect_left를 사용하여 이진 탐색
index_left = bisect.bisect_left(arr, target)

# bisect_right를 사용하여 이진 탐색
index_right = bisect.bisect_right(arr, target)

# 검색 결과 출력

print(f"bisect_left: Found target {target} at index {index_left}")

print(f"bisect_right: Found target {target} at index {index_right}")
