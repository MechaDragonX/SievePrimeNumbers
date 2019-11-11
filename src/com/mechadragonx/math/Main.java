package com.mechadragonx.math;

import java.util.LinkedList;
import java.util.Queue;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(primes(30));
        System.out.println(primes(121));
    }
    private static Queue<Integer> prepare(Queue<Integer> numbers, int number)
    {
        for(int i = 2; i <= number; i++)
        {
            numbers.add(i);
        }
        return new LinkedList<>();
    }
    private static void sieve(Queue<Integer> numbers, Queue<Integer> result, int number)
    {
        int prime = 0;
        int size = 0;
        int current = 0;
        while(prime < Math.sqrt(number))
        {
            prime = numbers.remove();
            size = numbers.size();
            result.add(prime);
            for(int i = 0; current < numbers.peek(); i++)
            {
                current = numbers.remove();
                if(current % prime != 0) numbers.add(current);
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
}
