N, M = map(int, input().split())
res_arr = []
for i in range(N):
    arr = list(map(int, input().split()))
    res_arr.append(min(arr))

print(max((res_arr)))
