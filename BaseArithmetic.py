def getbase10(s):
    for i in range(2, 17):
        try: return int(s, i)
        except: continue
        
print getbase10(raw_input()) + getbase10(raw_input())