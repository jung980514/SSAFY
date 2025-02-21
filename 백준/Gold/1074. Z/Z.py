num,row,col = map(int,input().split())
num = 2**num
cnt = 0
def division(n,x,y):
    global cnt
    if n == 2:
        if x == row and y == col:
            print(cnt)
            return
        cnt += 1
        if x == row and y+1 == col:
            print(cnt)
            return
        cnt += 1
        if x+1 == row and y == col:
            print(cnt)
            return
        cnt += 1
        if x+1 == row and y+1 == col:
            print(cnt)
            return
        cnt += 1
    elif not (x <= row < x + n and y <= col < y + n):
        cnt += n*n
        return
    else:
        division(n//2,x,y)
        division(n//2,x,y+n//2)
        division(n//2,x+n//2,y)
        division(n//2,x+n//2,y+n//2)

division(num,0,0)




