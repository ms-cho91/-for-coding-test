def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        # 찾은 경우 중간점 인덱스 반환
        if array[mid] == target:
            return mid
        # 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        elif array[mid] > target:
            end = mid - 1
        # 중간점의 값보다 찾고자 하는 값이 작은 경우 오른쪽 확인
        else:
            start = mid + 1
    return None


# N(가게의 부품 개수) 입력
n = 5
# 가게에 있는 전체 부품 번호를 공백을 기준으로 구분하여 입력
arrayList = [8, 3, 7, 9, 2]
arraySet = set(arrayList)
print(arrayList)
print(arraySet)
arrayList.sort()  # 이진 탐색을 수행하기 위해 사전에 정렬 수행
print('정렬된 리스트 :',arrayList)
# M(손님이 확인 요청한 부품 개수) 입력
m = 3
# 손님이 확인 요청한 전체 부품 번호를 공백을 기준으로 구분하여 입력
x = [5, 7, 9]

# 손님이 확인 요청한 부품 번호를 하나씩 확인 재귀 이용
for i in x:
    # 해당 부품이 존재하는지 확인
    result = binary_search(arrayList, i, 0, n - 1)
    if result != None:
        print('yes', end=' ')
    else:
        print('no', end=' ')
print('')
# 손님이 확인 요청한 부품 번호를 하나씩 확인 set 이용
for i in x:
    # 해당 부품이 존재하는지 확인
    if i in arraySet:
        print('yes', end=' ')
    else:
        print('no', end=' ')
