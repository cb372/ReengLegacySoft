package com.github.cb372.guessing;

import java.io.IOException;

/**
 * The entry point to the system.
 *
 * Author: chris
 * Created: 6/2/14
 */
public final class Main {

    /**
     * Private constructor to avoid instantiation.
     */
    private Main() {
    }

    /**
     * The entry point.
     * @param args command line arguments
     * @throws IOException if we fail to write to a file or read from stdin
     */
    public static void main(String[] args) throws IOException {
        new Game().run();
    }

}
