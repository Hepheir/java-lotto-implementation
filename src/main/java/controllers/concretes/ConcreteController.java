package controllers.concretes;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import controllers.Controller;

public class ConcreteController implements Controller {
    // TODO: Disable Sample Input
    private static final Boolean USE_SAMPLE_INPUT = false;
    private static Controller instance = new ConcreteController();
    private static BufferedReader bufferedReader;

    static {
        if (USE_SAMPLE_INPUT) {
            final byte[] buf = String.join("\n",
                    "7000",
                    "2",
                    "1, 2, 3, 4, 5, 6",
                    "3, 4, 5, 6, 7, 8",
                    "3, 4, 5, 6, 7, 8",
                    "11").getBytes();
            System.setIn(new ByteArrayInputStream(buf));
        }
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static Controller getInstance() {
        return instance;
    }

    private ConcreteController() {
    }

    @Override
    public String readLine() {
        Optional<String> line = Optional.empty();
        while (!line.isPresent()) {
            line = tryReadLine();
        }
        return line.get();
    }

    private Optional<String> tryReadLine() {
        try {
            return Optional.of(bufferedReader.readLine());
        } catch (IOException e) {
            // TODO: Exception handling
        }
        return Optional.empty();
    }

    @Override
    public Integer readInteger() {
        Optional<Integer> integer = Optional.empty();
        while (!integer.isPresent()) {
            integer = tryReadInteger();
        }
        return integer.get();
    }

    private Optional<Integer> tryReadInteger() {
        try {
            return Optional.of(Integer.parseInt(bufferedReader.readLine()));
        } catch (IOException e) {
            // TODO: Exception handling
        } catch (NumberFormatException e) {
            // TODO: Exception handling
        }
        return Optional.empty();
    }

    @Override
    public List<Integer> readIntegerSequence(String delimiter) {
        Optional<List<Integer>> integerSequence = Optional.empty();
        while (!integerSequence.isPresent()) {
            integerSequence = tryReadIntegerSequence(delimiter);
        }
        return integerSequence.get();
    }

    private Optional<List<Integer>> tryReadIntegerSequence(String delimiter) {
        try {
            return Optional.of(strictlyReadIntegerSequence(delimiter));
        } catch (IOException e) {
            // TODO: Exception handling
        } catch (NumberFormatException e) {
            // TODO: Exception handling
        }
        return Optional.empty();
    }

    private List<Integer> strictlyReadIntegerSequence(String delimiter) throws IOException,
            NumberFormatException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), delimiter);
        List<String> tokens = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            tokens.add(stringTokenizer.nextToken());
        }
        return tokens.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
