package com.mechadragonx.math;

import java.util.LinkedList;
import java.util.Queue;

public class Main
{
    public static void main(String[] args)
    {
        long start;
        long end;

        // Without Squaring
        System.out.println("Without Squaring:\n30");
        start = System.nanoTime();
        primes(30);
        end = System.nanoTime();
        System.out.println((((double)(end - start) / 1E+6) + " ms"));

        System.out.println("121");
        start = System.nanoTime();
        primes(121);
        end = System.nanoTime();
        System.out.println((((double)(end - start) / 1E+6) + " ms"));

        // Without Squaring
        System.out.println("\nWith Squaring:\n30");
        start = System.nanoTime();
        primesSquared(30);
        end = System.nanoTime();
        System.out.println((((double)(end - start) / 1E+6) + " ms"));

        System.out.println("121");
        start = System.nanoTime();
        primes(121);
        end = System.nanoTime();
        System.out.println((((double)(end - start) / 1E+6) + " ms"));
    }
    private static Queue<Integer> prepare(Queue<Integer> numbers, int number)
    {
        for(int i = 2; i <= number; i++)
        {
            numbers.add(i);
        }
        return new LinkedList<>();
    }
    private static void sieve(Queue<Integer> numbers, Queue<Integer> result, int number) {
        int prime = 0;
        int size = 0;
        int current = 0;
        while (prime < Math.sqrt(number)) {
            prime = numbers.remove();
            size = numbers.size();
            result.add(prime);
            for (int i = 0; current < numbers.peek(); i++) {
                if (numbers.peek() != null) {
                    current = numbers.remove();
                    if (current % prime != 0) numbers.add(current);
                }
            }
            current = 0;
        }
        result.addAll(numbers);
    }
    private static void sieveSquared(Queue<Integer> numbers, Queue<Integer> result, int number)
    {
        int prime = 0;
        int size = 0;
        int current = 0;
        int first= 0;
        while(prime < Math.sqrt(number))
        {
            prime = numbers.remove();
            size = numbers.size();
            result.add(prime);
            first = numbers.peek();
            for(int i = 0; current < numbers.peek(); i++)
            {
                if((numbers.peek() >= (prime * prime)) || (current != first || i == 0))
                {
                    current = numbers.remove();
                    if(current % prime != 0) numbers.add(current);
                }
                else numbers.add(numbers.remove());
            }
            current = 0;
        }
        result.addAll(numbers);
    }
    private static Queue<Integer> primes(int number)
    {
        Queue<Integer> numbers = new LinkedList<>();
        Queue<Integer> result = prepare(numbers, number);
        sieve(numbers, result, number);
        return result;
    }
    private static Queue<Integer> primesSquared(int number)
    {
        Queue<Integer> numbers = new LinkedList<>();
        Queue<Integer> result = prepare(numbers, number);
        sieveSquared(numbers, result, number);
        return result;
    }
}
