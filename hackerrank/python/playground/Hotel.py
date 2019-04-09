def ignore(oldString):
    removed = oldString.replace(",", "")
    removed = removed.replace(".", "")
    return removed

arr = [ignore(arr_temp) for arr_temp in input().strip().split(' ')]
wordDict = {}
for word in arr:
    wordDict[word] = 1


n = int(input().strip())

hotelDict = {}
for index in range(0, n):
    count = 0
    id = int(input().strip())
    arr = [ignore(arr_temp) for arr_temp in input().strip().split(' ')]
    for word in arr:
        if wordDict.get(word, 0) == 1:
            hotelDict[id] = hotelDict.get(id, 0) + 1

dictList = []
for key, value in hotelDict.items():
    temp = (key,value)
    dictList.append(temp)

dictList = sorted(dictList, key=lambda x: x[1], reverse=True)

for item in dictList:
    print(item[0], end=" ")



