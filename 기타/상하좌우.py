N = int(input())
arr = list(map(input().split()))
spot = [1, 1]
# L: 왼쪽으로 한 칸 이동
# R: 오른쪽으로 한 칸 이동
# U: 위로 한 칸 이동
# D: 아래로 한 칸 이동

for i in arr:
    if (i == "L") and (spot[0] != 1):
        spot[0] -= 1
    elif (i == "R") and (spot[0] != N):
        spot[0] += 1
    elif (i == "U") and (spot[0] != 1):
        spot[1] -= 1
    elif (i == "D") and (spot[1] + 1 > N):
        spot[0] += 1

print(spot[0], spot[1])