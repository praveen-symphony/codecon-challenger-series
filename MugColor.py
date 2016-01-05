colors = set(['White', 'Black', 'Blue', 'Red', 'Yellow'])
N = int(raw_input())

for _ in range(N):
    color = raw_input()
    if color in colors:
        colors.remove(color)

print colors.pop()
