import sys

#Using the square-and-multiply algorithm
def sqMul(a, e, n):
	if e == 0: #Base case a^0 = 1
		return 1
	if e == 1: #Base case a^1 = a
		return a 
	result = sqMul(a, e//2,  n) #Recursive call with a, integer divided e/2 and n
	result = result*result #square result
	if e & 1 != 0: #if exponent is odd
		result = result*a #then multiply the recursive result with the base
	return result % n #return a^e mod n


for line in sys.stdin:
	data = line.split(" ")
	a = int(data[0]);
	e = int(data[1]);
	n = int(data[2]);
	r = sqMul(a,e,n)
	print(r)


