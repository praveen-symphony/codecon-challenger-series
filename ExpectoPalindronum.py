string = raw_input()
for i in reversed(range(len(string) + 1)):
    if string[:i] == string[:i][::-1]:
        print 2 * len(string) - i
        break
