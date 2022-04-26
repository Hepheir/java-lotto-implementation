package io;

import org.jetbrains.annotations.TestOnly;

import java.io.*;

@TestOnly
public class SampleConsole extends Console {
    public SampleConsole() {
        final byte[] buffer = String.join("\n",
                "7000",
                "2",
                "1, 2, 3, 4, 5, 6",
                "3, 4, 5, 6, 7, 8",
                "3, 4, 5, 6, 7, 8",
                "11").getBytes();
        setInputStream(new ByteArrayInputStream(buffer));
    }

    @Override
    public String readLine() {
        final String line = super.readLine();
        printLine(line);
        return line;
    }
}
