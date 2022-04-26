package io;


import java.io.*;
import java.util.Optional;

public class Console {
    private BufferedReader bufferedReader;

    public Console() {
        setInputStream(System.in);
    }

    public String readLine() {
        Optional<String> line = Optional.empty();
        while (!line.isPresent()) {
            line = tryReadLine();
        }
        return line.get();
    }

    public void printLine(String line) {
        System.out.println(line);
    }

    protected void setInputStream(InputStream inputStream) {
        final Reader reader = new InputStreamReader(inputStream);
        this.bufferedReader = new BufferedReader(reader);
    }

    private Optional<String> tryReadLine() {
        try {
            return Optional.of(bufferedReader.readLine());
        } catch (IOException e) {
            // TODO: Exception handling
        }
        return Optional.empty();
    }
}
