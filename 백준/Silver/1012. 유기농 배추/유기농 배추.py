from collections import deque

case = int(input())
dx = [0,0,1,-1]
dy = [1,-1,0,0]

def bfs(cabbage,a,b):
    queue = deque()
    queue.append((a,b))
    cabbage[a][b] = 0

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx <0 or nx>=n or ny < 0 or ny >=m:
                continue
            if cabbage[nx][ny] == 1:
                cabbage[nx][ny] = 0
                queue.append((nx,ny))
    return

count = [0 for _ in range(case)]
for i in range(case):
    m,n,num = map(int,input().split())
    cabbage= [[0]*m for i in range(n)]
    for j in range(num):
        locateY,locateX = map(int,input().split())
        cabbage[locateX][locateY] = 1
    for a in range(n):
        for b in range(m):
            if cabbage[a][b] == 1:
                bfs(cabbage,a,b)
                count[i] +=1
for i in count:
    print(i)