num = int(input())
val = []
for i in range(num):
    val.append(int(input()))

for i in val:
    zero = [1,0]
    one = [0,1]
    if i==0:
        print(zero[0],one[0]) 
    else:
        for _ in range(i-len(zero)+1):
            zero.append(one[-1])
            one.append(zero[-2]+one[-1])
        print(zero[-1],one[-1])