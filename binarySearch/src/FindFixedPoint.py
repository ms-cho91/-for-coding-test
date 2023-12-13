from bisect import bisect_left, bisect_right

def find_fixed_point(arr):
    start, end = 0, len(arr) - 1

    while start <= end:
        mid = (start + end) // 2

        if arr[mid] == mid:
            return mid
        elif arr[mid] < mid:
            start = mid + 1
        else:
            end = mid - 1

    return -1

# 입력 처리
n = map(int, input())
arr = list(map(int, input().split()))

# 결과 출력
result = find_fixed_point(arr)

if result > 0:
    print( "고정점 :",result)

else:
    print(result)
    print("데이터가 존재하지 않습니다.")

