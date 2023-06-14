import sys
input = sys.stdin.readline

arr=["" for i in range(10)]
ansMap={}
sett=set()

for _ in range(4000):
    for i in range(1,10):
        arr[i]+=str(i)
        sett.add(int(arr[i]))


def upperRep(num):
    strNum=str(num)
    lenNum=len(strNum)
    
    firstNum=strNum[0]
    if firstNum=="9":
        nextNum="1"
        lenNum+=1
    else:
        nextNum=str(int(firstNum)+1)

    return int(nextNum*lenNum)

def rightUnderRep(repNum):
    strRepNum=str(repNum)
    lenRepNum=len(strRepNum)

    firstRepNum=strRepNum[0]
    if firstRepNum=="1":
        nextRepNum="9"
        lenRepNum-=1
    else:
        nextRepNum=str(int(firstRepNum)-1)

    return int(nextRepNum*lenRepNum)
    
t=int(input())

for i in range(t): #10^4
    num=int(input())

    if num in ansMap:
        print(ansMap[num][0],ansMap[num][1])
        continue
    a=upperRep(num)

    while True:

        a=rightUnderRep(a)
        b=num-a
        if b in sett:
            ansMap[num]=[a,b]
            print(a,b)
            break
        
