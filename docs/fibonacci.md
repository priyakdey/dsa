## Fibonacci Sequence

Fibonacci sequence is a sequence of natural numbers, where n<sup>th</sup> term depends on n - 1<sup>th</sup>
and n - 2<sup>th</sup> term.

> $$
> F(n) =
> \begin{cases}
>     0 & \text{if } n \leq 1 \\
>     F(n-1) + F(n-2) & \text{if } n > 1
> \end{cases}
> $$

### Theory required for the Fibonacci Sequence:

#### 1. [Pisano Period](https://en.wikipedia.org/wiki/Pisano_period):

The sequence forms a cycle when mod with a number `x`, _i.e_, after a certain period the sequence starts to repeat
itself.
This period is called Pisano Period. The period is dependent on `x`, every `x` has a different period.
To calculate Pisano Period, we can use the below code:

```java
    public static long findNthTermSumLastDigit(long n) {
        if (n < 0) throw new IllegalArgumentException("n cannot be negative");
        if (n <= 1) return n;
    
        int pisanoPeriod = findPisanoPeriod(10);
        n = n % pisanoPeriod;
    
        long nPlus2TermLastDigit = findNthTerm(n + 2, 10);
    
        long lastDigitOfSum = nPlus2TermLastDigit - 1;
        if (lastDigitOfSum < 0) lastDigitOfSum += 10;
    
        return lastDigitOfSum;
    }
```

This is helpful to calculate n<sup>th</sup> terms of the sequence when n is huge and result
requires mod of a number.


#### 2. Summation of first `n` terms:

Summation of first `n` terms depends on the `n+2` term.

> $$
> \sum_{k=0}^nF(k) = F(n + 2) - 1
> $$

This becomes extremely helpful when trying to calculate summation of large n.
Instead of keeping a state of running sum, we can calculate the `n + 2` term.
Combining this with Pisano Period is helpful when trying to get the last digit of sum of `n` terms.


Extending this theory, we can now calculate summation of fibonacci sequences within any range.

Below is the maths for summation of `m` to `n` terms of fibonacci sequence:

> $$
> \sum_{k=m}^n F(k) = \sum_{k=1}^n F(k) - \sum_{k=1}^{m-1} F(k)
> $$
> 
> $$
> \Rightarrow \sum_{k=m}^n F(k) = \begin{cases}
>     (F(n + 2) - 1) - (F(m + 1) - 1) & \text{if } (F(n + 2) - 1) - (F(m + 1) - 1) \geq 0 \\
>     (F(n + 2) - 1) - (F(m + 1) - 1) + 10  & \text{if } (F(n + 2) - 1) - (F(m + 1) - 1) < 0
> \end{cases}
> $$

#### 3. Summation of squares of first `n` terms:

Summation of square of first `n` terms is defined in terms of `n` and `n+1` terms.

> $$
> \sum_{k=0}^n F(k)^2 = F(n) * F(n + 1)
> $$








