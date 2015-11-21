package com.github.cb372.guessing;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * The most fun game in the world.
 *
 * Author: chris
 * Created: 6/2/14
 */
public final class Game {

    /** The random number generator. */
    private static final Random RND = new Random();

    /** The number chosen will be smaller than this. */
    private static final int MAX = 10;

    /** The encoding of the file. */
    private static final String CHARSET = "UTF-8";

    /**
     * Default constructor.
     */
    public Game() {

    }

    /**
     * Think of a number, then ask the user to guess what it is.
     * @throws IOException if file writing fails, or we can't read from stdin
     */
    public void run() throws IOException {
        final int number = RND.nextInt(MAX);

        // save the chosen number to a file for posterity
        NumberWriter.writeToFile(number, CHARSET);

        System.out.println("Can you guess the number I have chosen?");
        final Scanner scanner = new Scanner(System.in, CHARSET);
        while (scanner.nextInt() != number) {
            System.out.println("Wrong! Try again!");
        }
        System.out.println("Correct! Well done!");
    }

}
