def  StairCase(n):
    for index in range(0, n):
        for space in range(n - index - 1, 0, -1):
            print(" ", end='')
        for star in range(0, index + 1):
            print("#", end='')
        print()

StairCase(6)