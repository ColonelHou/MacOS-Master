package org.macos.java;

import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Predicate<Integer> predicate = i -> i > 10;
        System.out.println(predicate.test(9));
    }
}
