"""
[문제4] 문자열 재정렬: 문제 설명
알파벳 대문자와 숫자(0~9)로만 구성된 문자열이 입력으로 주어집니다.
이때 모든 알파벳을 오름차순으로 정렬하여 이어서 출력한 뒤에,
그 뒤에 모든 숫자를 더한 값을 이어서 출력합니다.
예를 들어 K1KA5CB7이라는 값이 들어오면 ABCKK13을 출력합니다.

1. 아이디어
알파벳과 숫자를 분리
알파벳 정렬

2. 시간복잡도
O(nlogn + m)

3. 자료구조
리스트

"""
# 현재 나이트의 위치 입력받기
input_str  = input("문자열 입력 : ")
letters = []  # 알파벳을 저장할 리스트
numbers_sum = 0  # 숫자의 합을 저장할 변수

# 문자열을 순회하면서 알파벳과 숫자를 분리하여 처리
for char in input_str:
    if char.isalpha():
        letters.append(char)  # 알파벳은 리스트에 추가
    else:
        numbers_sum += int(char)  # 숫자는 합을 계산

# 알파벳을 오름차순으로 정렬
letters.sort()

print(''.join(letters)+str(numbers_sum))