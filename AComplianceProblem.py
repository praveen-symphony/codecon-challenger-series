string = raw_input()

chars = {}
for c in string:
    if c in chars: chars[c] += 1
    else: chars[c] = 1

valid, odd = True, False
for k, v in chars.items():
    if v % 2 == 1 and odd:
        valid = False
        break
    elif v % 2 == 1 and not odd:
        odd = True

print 'yes' if valid else 'no'
