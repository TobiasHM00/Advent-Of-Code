def a():
    f = open("input01.txt", "r")
    sum = 0
    for line in f:
        l = line.strip()
        num = ""
        for c in l:
            if c.isnumeric():
                num += c
                break
        
        for c in reversed(l):
            if c.isnumeric():
                num += c
                break
        
        sum += int(num)
    
    print(sum)
    f.close()
    
a()

def b():
    numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    print(1)
    
b()