K = int(raw_input())
os = [map(float, raw_input().split(",")) for _ in range(K)]
ns = [map(float, raw_input().split(",")) for _ in range(K)]

for i in range(K):
    minidx, mindiff = 0, 99999999999999999
    for j in range(K):
        diff = sum(abs(a-b) for a,b in zip(os[i], ns[j]))
        if diff < mindiff:
            mindiff = diff
            minidx = j
    print "%d,%d" % (i, minidx)