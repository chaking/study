arr = [int(arr_temp) for arr_temp in input().strip().split(' ')]

print(arr[0], end=' ')
for i in range(1, len(arr)):
    diff = arr[i] - arr[i-1]
    escape = -128
    if diff < -127 or diff > 127:
        print(escape, end=' ')
    print(diff, end=' ')
