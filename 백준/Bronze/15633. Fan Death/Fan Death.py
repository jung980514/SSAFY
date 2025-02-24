n = int(input())
total = 0  # 변수명 변경

for i in range(1, n+1):  # 괄호 제거
    if n % i == 0:
        total += i

print(total * 5 - 24)