x = int(input().strip())
n = int(input().strip())
data = []
for _ in range(0, n):
    arr = [int(arr_temp) for arr_temp in input().strip().split(' ')]
    start = arr[0]
    end = arr[1]
    data.append((start, end))

data = sorted(data, key=lambda x: x[0])
maxX = 0

for origin in range(0, n):
    count = 1
    originStart = data[origin][0]
    for target in range(origin - 1, 0, -1):
        if originStart <= data[target][1]:
            count += 1
        else:
            break

    if maxX < count:
        maxX = count

if maxX > x:
    result = maxX - x
else:
    result = 0

print(result)


