import re

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
    numbers = {"one": 1, "two": 2, "three": 3, "four": 4, "five": 5, "six": 6, "seven": 7, "eight": 8, "nine": 9}
    f = open("input01.txt", "r")
    sum = 0
    for line in f:
        num = ""
        
        print(num)
        sum += int(num)
    print(sum)
    
b()