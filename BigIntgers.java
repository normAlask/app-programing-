
import java.util.Arrays;
/*
CS3443: Application Programming
Lab : 2
name : Noor Alaskari
Professor: Tanvir-Irfan Chowdhury
Sections: 001

Lab Summary
� Familiarity with Eclipse IDE.
� Java syntax.
� Object oriented programming.
Description
In this assignment, your task is to write a class in Java for big integer numbers.
Normally we cannot add (or subtract etc) very big numbers, say 1000 digits
long numbers. To do it, we need to store those numbers in character strings
and then add (or subtract etc) them like we did in elementary schools.
 */

public class BigIntgers {

    private char[] number;
    private int length = 1000;
/*
BigIntegers( ): Default constructor that creates a big integer equivalent to
zero
@pram char[] is a  a string to hold the number
@pram int Length: length of the number.
 */

    public BigIntgers() {
        //creates char array with starting value zero
        number = new char[length];
        populate(); }

    /*
    BigInteger (String num): Constructor that initializes num[ ] with the
number given in the argument and sets the Length.
     */
    public BigIntgers(String num) {
        number = new char[length];
        populate();

        //converts string
        // if satatment to check if the numbers have more than 1000 Digets
        if (num.length() > 1000) {
            System.out.println("Error!:\t number to large, overflow");
        } else {
            //converts string
            char[] tmpArray = num.toCharArray();
            for (int x = tmpArray.length - 1; x >= 0; x--) {
                number[(number.length) - (tmpArray.length - x)] = tmpArray[x];
            }
        }
    }
/*
Constructor Default constructor that creates a big integer
 */

    public BigIntgers(BigIntgers bigIntgers) {
        this.number = bigIntgers.number; }
/*
Constructor that initializes num[ ] with number[ ] and
sets the Length
 */
    public BigIntgers(char[] number) {
        this.number = number;
    }

/*
Constructor that initializes num[ ] with an long value
n and sets Length.
 */
    public BigIntgers(long number) {
        this.number = new char[1000];
        populate();
        //convert the long n to a string
        String numString = Long.toString(number);
        char[] tmpArray = numString.toCharArray();

        for (int x = tmpArray.length - 1; x >= 0; x--) {
            this.number[(this.number.length) - (tmpArray.length - x)] = tmpArray[x];
        }
    }

/*
This function is like the first constructor
that initializes num[ ] with a[ ] and sets the Length.
 */
    public void setBigInt(long number)
    {
        this.number = new char[1000];
        populate();
        //convert the long n to a string
        String numString = Long.toString(number);
        char[] tmpArray = numString.toCharArray();

        for (int x = tmpArray.length - 1; x >= 0; x--) {
            this.number[(this.number.length) - (tmpArray.length - x)] = tmpArray[x];
        }
    }
/*
Adds big integer n to current object and
returns the result, without affecting the current object
 */

    public BigIntgers add(BigIntgers bigInt) {
        char[] numberCopy = Arrays.copyOf(number,number.length);//gets copy of array
        char[] added = bigInt.number;//array passed
        int base, add, sum,carry=0;

        for (int index = 0; index < numberCopy.length; index++) {
            //converts char to corronsponding int
            base = toNum(numberCopy[numberCopy.length-1 - index]);
            add = toNum(added[added.length-1 - index]);
            sum = base + add+carry;

            if (sum >= 10) {
                if (index<numberCopy.length-1) {
                    carry = 1;
                    numberCopy[length-1 - index] = toChar(sum%10);
                }
            }
            else
            {
                carry=0;
                numberCopy[numberCopy.length-1-index] = toChar(sum);
            }

        }

        return new BigIntgers(numberCopy);
    }
/*
Multiplies big integer n with current
object and returns the result, without affecting the current object.
 */
    public BigIntgers  multiply(BigIntgers num)
    {
        //creates a copy of this big int
        BigIntgers decrement,numberCopy;
        numberCopy = new BigIntgers(this);
        for(decrement = num.subtract(new BigIntgers(1)); !decrement.isZero(); decrement.decrement())
        {
            numberCopy = numberCopy.add(this);
        }
        System.out.println();
        return numberCopy;
    }
/*
: Divides the current big integer with a non negative integer n and returns the quotient, without affecting the current
object.
 */
    public BigIntgers divide(BigIntgers number)
    {

        BigIntgers numberCopy;
        BigIntgers increment = new BigIntgers(0);
        numberCopy = new BigIntgers(this);
        while((!numberCopy.lessThan(number))||numberCopy.equals(number))
        {
            increment.increment();
            numberCopy = numberCopy.subtract(number);
        }
        return increment;

    }
    /*
    Divides the current big integer with a non negative
    integer n and returns the reminder, without affecting the current object
     */
    public BigIntgers mod(BigIntgers number)
    {
        BigIntgers numberCopy = new BigIntgers(this);//9
        BigIntgers increment = numberCopy.divide(number);//2
        return numberCopy.subtract(increment.multiply(number));

    }
/*
this function is to check numbers are less than the length of the other number it add zeros so we can add, mult and etc
just like we did in elementary schools
 */
    public boolean lessThan(BigIntgers num)
    {
        char[] numberCopy = Arrays.copyOf(number,number.length);
        char[] comparator = num.number;
        int copyIndex,compIndex;
        for (copyIndex = 0; numberCopy[copyIndex] == '0'; copyIndex++){
            if(copyIndex>=length-1)
                break;
        }
        for (compIndex = 0; comparator[compIndex] == '0'; compIndex++){
            if(compIndex>=length-1)
                break;
        }

        //if number has larger signigficant digit, obviously bigger
        if(copyIndex<compIndex){
            return false;
        }
        else
        {
            if( copyIndex>compIndex)
                return true;
            if(copyIndex==compIndex)
            {

                for(int index=compIndex;index<length;index++)
                {
                    if(toNum(numberCopy[index]) > toNum(comparator[index]))
                    {
                        return false;
                    }
                }
            }

        }
        return true;

    }

    /*
    this function is to check numbers are equals the length of the other number
     */

    public boolean equals(BigIntgers num)
    {
        char[] compare = num.number;
        for(int x=0;x<number.length;x++)
        {
            if(number[x]!=compare[x])
                return false;
        }
        return  true;

    }
    /*
    Increments the current object and also returns the result. Note that, current object is modified.
     */
    public void increment()
    {
        char[] added = new char[1000];

        added[length-1] = '1';//array passed
        for(int x=0;x<=added.length-2;x++)
            added[x]='0';
        int base, add, sum,carry=0;

        for (int index = 0; index < number.length; index++) {
            //converts char to corronsponding int
            base = toNum(number[number.length-1 - index]);
            add = toNum(added[added.length-1 - index]);
            sum = base +add +carry;


            if (sum >= 10) {

                if (index<number.length-1) {
                    carry = 1;
                    number[length-1 - index] = toChar(sum%10);

                }
            }
            else
            {
                carry=0;
                number[number.length-1-index] = toChar(sum);
            }



        }

    }

    /*
    Decrements the current object and also returns the result. Note that, current object is modified.
     */

    public void decrement() {

        int base, subtractor, result, borrow = 0;

        char[] subtracted = new char[1000];
        for(int x=0;x<=subtracted.length-2;x++)
            subtracted[x]='0';
        subtracted[length-1] = '1';//array passed
        for (int index = 0; index < number.length; index++) {

            base = toNum(number[length - 1 - index]) - borrow;
            subtractor = toNum(subtracted[length - 1 - index]);
            if (base < subtractor) {
                base += 10;
                borrow = 1;
                result = base - subtractor;
                number[length - 1 - index] = toChar(result);
            } else {
                result = base - subtractor;

                borrow = 0;
                number[length - 1 - index] = toChar(result);
            }
        }
    }
    /*
    Subtracts big integer n from current object and returns the result, without affecting the current object.
     */
    public BigIntgers subtract(BigIntgers num)
    {

        int base,subtractor,result,borrow=0;
        char[] numberCopy = Arrays.copyOf(number,number.length);//gets copy of array
        char[] subtracted = num.number;//array passed

        for (int index = 0; index < numberCopy.length; index++) {
            base = toNum(numberCopy[length-1-index])-borrow;
            subtractor = toNum(subtracted[length-1-index]);
            if(base<subtractor)
            {
                base+=10;
                borrow=1;
                result = base-subtractor;
                numberCopy[length-1-index]=toChar(result);
            }
            else
            {
                result = base-subtractor;
                borrow=0;
                numberCopy[length-1-index]=toChar(result);

            }

        }

        return new BigIntgers(numberCopy);
    }
/*
Prints the big integer on screen
 */
    public void print() {
        String num = new String(number);
        int index;
        for (index = 0; number[index] == '0'; index++){
            if(index>=length-1)
                break;
        }
        for (int start = index; start < number.length; start++) {

            System.out.print(number[start]);

        }
        System.out.println();
    }
/*
this fucnction pupulate numbers with zeros if one of numbers are larger than the other in order to do functions easier
 */
    public void populate() {

        for (int x = 0; x < number.length; x++) {
            number[x] = '0';
        }

    }

    /*
    function to changer char to numbers
     */
    private int toNum(char number) {
        switch (number) {
            case '0': {
                return 0;
            }
            case '1': {
                return 1;
            }
            case '2': {
                return 2;
            }
            case '3': {
                return 3;
            }
            case '4': {
                return 4;
            }
            case '5': {
                return 5;
            }
            case '6': {
                return 6;
            }
            case '7': {
                return 7;
            }
            case '8': {
                return 8;
            }
            case '9': {
                return 9;
            }
            default:
                return -99;


        }
    }
    /*
    function that transfers numbers to char
     */
    private char toChar ( int number)
    {
        switch (number) {
            case 0: {
                return '0';
            }
            case 1: {
                return '1';
            }
            case 2: {
                return '2';
            }
            case 3: {
                return '3';
            }
            case 4: {
                return '4';
            }
            case 5: {
                return '5';
            }
            case 6: {
                return '6';
            }
            case 7: {
                return '7';
            }
            case 8: {
                return '8';
            }
            case 9: {
                return '9';
            }
            default:
                return ' ';
        }
    }

    /*
    Default constructor
     */
    public BigIntgers getNum() {
        return this;
    }
/*
to check if the length of number is Zero
 */
    public boolean isZero()
    {
        for(int x=0;x<number.length;x++)
        {
            if(number[x]!='0')
                return false;
        }
        return true;
    }
}
