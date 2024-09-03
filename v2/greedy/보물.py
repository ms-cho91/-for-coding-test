n = int(input("n값 입력 : "))

print(n)

a = []
b = []

for i in range(n):
    a.append(int(input(str(i)+' 번째 a값 입력 : ')))

for i in range(n):
    b.append(int(input(str(i)+' 번째 b값 입력 : ')))

a.sort()

print(a)
print(b)

s = 0
for i in range(n):
    s += a[i] * max(b)
    b.pop(b.index(max(b)))

print('s = ', s)