## Number Theory

### Greatest Common Divisor

Greatest common divisor or GCD of two integers is the largest number which divides both
the numbers without a remainder.

Example: gcd(2, 4) = 2, as 2 is the largest numbers which can divide 2 and 4 without a remainder.

#### Theories required for GCD:

1. GCD is commutative.

> $$
> GCD(x, y) == GCD(y, x)
> $$

2. When either number is zero, gcd of other number, idea is that any number can divide 0.

> $$
> GCD(x, y) =
> \begin{cases}
>   x & \text{if}  y = 0 \\
>   y & \text{if}  x = 0 \\
> \end{cases}
> $$

#### Approach 1: Linear

With a linear approach, iterate from `1..min(x, y)` and find the best integer which divides
both numbers without any remainder. This comes out to be a `O(n)` solution, which is not
performant when it comes to large numbers.

#### Approach 2: [Euclidean Algorithm](https://en.wikipedia.org/wiki/Euclidean_algorithm)

This algorithm is based on the following:

> $$
> GCD(x, y) =
> \begin{cases}
>   x                 & \text{if } y = 0 \\
>   GCD(x \bmod y, y) & \text{if } y \neq 0 \\
> \end{cases}
> $$

Using theories from above and extending the fact that, if y divides x, y is the gcd and vice-versa,
we can extend the maths to `GCD(x, y) = GCD(x % y, y)`.


The above equation becomes recurrence, and hence in programming terms, recursion is the answer.



#### Approach 3: [Stein's Algorithm (Binary GCD)](https://en.wikipedia.org/wiki/Binary_GCD_algorithm)

Stein's algorithm is basically an extension of Euclidean algorithm, but replaces division with
simpler operations like shift, minus, etc.

The theory behind this algorithm is:

> $$
> GCD(x, y) =
> \begin{cases}
>   0                         & \text{if } y = 0 \\
>   2 * GCD(x/2, y/2)         & \text{if } x, y = even \\
>   GCD(x/2, y)               & \text{if } x = even, y = odd \\
>   GCD(x, y/2)               & \text{if } x = odd, y = even \\
>   GCD(abs(x - y), min(x, y) & \text{if } x = odd, y = odd \\
> \end{cases}
> $$

*NOTE*: There is some paper or book, where Knuth wrote about saving 20% processing power.
Does this still hold true? With modern x86_64, there are single instructions to divide like 
`DIV` and `IDIV`..... Need to research more on this.


### Lowest Common Multiple

Lowest Common Multiple of two integers is the smallest number, which when divided by both the
integers, does not leave any remainder.

> $$
> LCM(x, y) = (x * y) / GCD(x, y)
> $$


### Prime Number


Primes numbers are those whose only factors are 1 and the number itself.

#### Approach 1: Linear

The simplest approach to this problem, it to iterate from `2..n-1` and see 
no numbers can divide x. This approach is slow, if n is big. 

Code:


```java
    public static boolean isPrime(long n) {
        for (long i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
```

To make this faster, we can go till n/2, since we know that no number in the range [n/2, n-1]
can divide n.

```java
    public static boolean isPrime(long n) {
        if (n < 2) return false;
        
        for (long i = 2; i <= n / 2 + 1; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
```

But this is still `O(n)` when it comes to time complexity.


#### Approach 2: Square Root:

For any non-prime number n that has a divisor other than 1 and itself,
it must have a pair of factors, a and b, such that `a * b = n`. If n is not a
perfect square, one of these factors must be less than the square root of n,
and the other must be greater. This is because if both were greater than the
square root of n, their product would be greater than n, and if both were less,
their product would be less than n.

Therefore, if you don't find a factor of n by the time you've checked all
numbers up to the square root of n, you won't find a factor at all
(beyond the trivial factor of n itself).


```java
    public static boolean isPrime(long n) {
        if (n < 2) return false;
        
        for (long i = 2; i <= (int) Math.sqrt(n) + 1; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
```

This runs in $\sqrt{n}$ time complexity is much faster than the linear approach.


#### Generate Primes till N. 

Generation of primes till N, can be done in $O(n\sqrt{n})$ time, if we iterate over from
[1, n] and for each number, we check if it is prime or not.

For this problem we are going to use the [Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
which run in `O(n log(log n)))` time complexity.


