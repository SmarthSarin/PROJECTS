# AND , OR , NOT 
# Here’s the hierarchy of the logical operators:

# not (Highest precedence) not true returns false , not false return true(simply for true it shows false / for false it shows true) 
# and (if all value is true it returns true)
# or (Lowest precedence) if one value is true it returns true

a = -10
b = -11
g = 10
h = 11
d = a and b or g and h

print (d) 

# so in python its like we break things like that in this d = a and b or g and h

# a and b = b

# g and h = h 

# now we have b or h 

# b or h = b

# answer  is b 

# and b is - 11

one = (10==9)
two = (7>5)
three = one and two 
six = two and one
four = one or two
seven = two or one 
five = not one
eight = not two
print (one, two, three , four , five, six, seven, eight)
