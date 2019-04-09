#!/bin/python3


t = int(input().strip())
for _ in range(0, t):
    n = int(input().strip())
    flag = False
    strings = [''.join(sorted(input().strip())) for line in range(0, n)]

    for column in range(0, len(strings[0])):
        for row in range(1, n):
            up = strings[row-1][column]
            now = strings[row][column]
            if up > now:
                flag = True
    if flag is True:
        print("NO")
    else:
        print("YES")


