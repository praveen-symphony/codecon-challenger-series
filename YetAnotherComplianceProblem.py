import math
    
string = raw_input()

chars = {}
for c in string:
    if c in chars: chars[c] += 1
    else: chars[c] = 1
    
valid, odd = True, False
for k, v in chars.items():
    if v%2==1 and odd: valid = False
    elif v%2==1 and not odd: odd = True

if valid:
    ways = math.factorial(len(string)/2)
    for k, v in chars.items(): ways /= math.factorial(v/2)
    print ways
else:
    print 0