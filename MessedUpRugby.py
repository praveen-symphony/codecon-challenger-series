n = int(raw_input())

for i in range(n / 7 + 1):
    for j in range(n / 3 + 1):
        for k in range(n / 2 + 1):
            if k * 2 + j * 3 + i * 7 == n:
                print str(i), str(j), str(k)
