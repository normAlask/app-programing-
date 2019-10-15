# app-programing-
BigIntgers
Description
In this assignment, your task is to write a class in Java for big integer numbers.
Normally we cannot add (or subtract etc) very big numbers, say 1000 digits
long numbers. To do it, we need to store those numbers in character strings
and then add (or subtract etc) them like we did in elementary schools.
Class name: BigInteger.
Possible Variables: char Num[1000]: a string to hold the number.
int Length: length of the number.
Methods:
 BigInteger (char a[ ]): Constructor that initializes Num[ ] with a[ ] and sets
the Length.
 BigInteger (long n): Constructor that initializes Num[ ] with an long value
n and sets Length. You need to convert the long n to a string in this case.
 BigInteger( ): Default constructor that creates a big integer equivalent to
zero. void SetBigInteger(char a[ ] ): This function is like the rst constructor
that initializes Num[ ] with a[ ] and sets the Length.
 BigInteger Add(BigInteger n): Adds big integer n to current object and
returns the result, without aecting the current object.
 BigInteger Subtract(BigInteger n): Subtracts big integer n from current ob-
ject and returns the result, without aecting the current object.
 BigInteger Multiply(BigInteger n): Multiplies big integer n with current
object and returns the result, without aecting the current object.
 BigInteger Divide(int n): Divides the current big integer with a non negative
integer n and returns the quotient, without aecting the current object.
 BigInteger Mod(int n): Divides the current big integer with a non negative
integer n and returns the reminder, without aecting the current object. BigInteger Increment( ): Increments the current object and also returns the
result. Note that, current object is modied.
 BigInteger Decrement( ): Decrements the current object and also returns
the result. Note that, current object is modied.
 void Show( ): Prints the big integer on screen.
