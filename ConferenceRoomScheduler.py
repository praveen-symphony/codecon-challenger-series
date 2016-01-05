N = int(raw_input())

avail = [[True]*33 for _ in range(N+1)]

while 1:
    try: _i = raw_input()
    except: break

    cmd = map(int, _i.split('-'))
    if len(cmd) == 3:
        room, start, length = cmd
        
        valid = True
        for i in range(start, start+length):
            if not avail[room][i]:
                valid = False
                break
        
        if valid:
            for i in range(start, start+length):
                avail[room][i] = False
    
        print 'Y' if valid else 'N'
    
    else:
        start, length = cmd
        free = []
        
        for room in range(1, N+1):
            valid = True
            for i in range(start, start+length):
                if not avail[room][i]:
                    valid = False
                    break
            
            if valid: free.append(str(room))
            
        print 'None' if len(free) == 0 else ' '.join(free)
