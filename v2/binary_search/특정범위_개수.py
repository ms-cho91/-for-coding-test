import bisect

def count_in_range(arr, low, high):
    left_index = bisect.bisect_left(arr, low)
    print(f"left_index = [{left_index}]")
    right_index = bisect.bisect_right(arr, high)
    print(f"right_index = [{right_index}]")
    return right_index - left_index

# (정렬된 상태)
arr = [1, 2, 2, 3, 3, 3, 4, 5, 5, 6, 7, 8, 9, 10]

# 특정 범위
low = 3
high = 5

# 특정 범위에 속하는 요소의 개수 구하기
count = count_in_range(arr, low, high)
print(f"Number of elements in range [{low}, {high}]: {count}")