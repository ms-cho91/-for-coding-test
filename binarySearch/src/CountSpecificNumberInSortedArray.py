from bisect import bisect_left, bisect_right

# 값이 x인 데이터의 개수를 반환하는 함수
def count_occurrences(array, x):
    right_index = bisect_right(array, x)
    left_index = bisect_left(array, x)
    return right_index - left_index

# 입력 처리
n, x = map(int, input().split())
arr = list(map(int, input().split()))

# 결과 출력
result = count_occurrences(arr, x)

# 값이 x인 원소가 존재한다면
if result > 0:
    print( x,"의 개수 :",result)
# 값이 x인 원소가 존재하지 않는다면
else:
    print(-1)
    print("데이터가 존재하지 않습니다.")

