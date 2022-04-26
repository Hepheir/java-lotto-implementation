package domain.lot;


import io.Console;
import types.Drawable;

import java.util.EmptyStackException;
import java.util.StringTokenizer;


public class ConsoleDrawingLot implements Drawable<Integer> {
    private static final String DELIMITER = ", ";
    private final StringTokenizer tokenizer;

    public ConsoleDrawingLot(Console console) {
        this.tokenizer = new StringTokenizer(console.readLine(), DELIMITER);
    }

    @Override
    public Integer draw() throws EmptyStackException {
        return drawOneInteger();
    }

    private Integer drawOneInteger() {
        return Integer.parseInt(drawOneToken());
    }

    private String drawOneToken() {
        return tokenizer.nextToken();
    }
}
