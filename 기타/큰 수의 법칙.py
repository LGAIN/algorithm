N, M, K = map(int, input().split())
arr = list(map(int, input().split()))
res = 0
arr.sort()
max_value = arr[-1]
max_value_2nd = arr[-2]

cnt = K
for i in range(M):
    if cnt != 0:
        res += max_value
        cnt -= 1
    else:
        res += max_value_2nd
        cnt = K

print(res)