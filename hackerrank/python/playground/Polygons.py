data = []

while(True):
    try:
        inputResult = input()
    except EOFError:
        break
    try:
        arr = [int(arr_temp) for arr_temp in inputResult.strip().split(' ')]
    except:
        continue
    data.append(arr)

square = 0
rectangle = 0
polygon = 0
for p in data:
    if p[0] <= 0 or p[1] <= 0 or p[2] <= 0 or p[3] <= 0:
        polygon += 1
    elif p[0] == p[1] == p[2] == p[3]:
        square += 1
    elif p[0] == p[2] and p[1] == p[3]:
        rectangle += 1
    else:
        polygon += 1

print(square, rectangle, polygon)


