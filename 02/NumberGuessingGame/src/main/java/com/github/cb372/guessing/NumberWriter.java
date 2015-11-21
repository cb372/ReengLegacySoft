package com.github.cb372.guessing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Utility class to write a number to a file.
 *
 * Author: chris
 * Created: 6/2/14
 */
public final class NumberWriter {

    /**
     * Private constructor to avoid instantiation.
     */
    private NumberWriter() {
    }

    /**
     * Write the given number to the file.
     * @param number the number to write
     * @param charset the encoding in which to write
     * @throws IOException if the write fails
     */
    protected static void writeToFile(final int number, final String charset)
            throws IOException {
        try (
            FileOutputStream stream = new FileOutputStream("number.txt");
            OutputStreamWriter out = new OutputStreamWriter(stream, charset)
        ) {
            out.write(number);
        }
    }

}
