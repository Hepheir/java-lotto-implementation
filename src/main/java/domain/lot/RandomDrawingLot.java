package domain.lot;

import types.Drawable;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class RandomDrawingLot implements Drawable<Integer> {
    private final Stack<Integer> tokens = new Stack<>();

    public RandomDrawingLot(Integer rangeStartInclusive, Integer rangeEndInclusive) {
        addTokensToLot(rangeStartInclusive, rangeEndInclusive);
        randomiseTokens();
    }

    @Override
    public Integer draw() throws EmptyStackException {
        return tokens.pop();
    }

    private void addTokensToLot(Integer rangeStartInclusive, Integer rangeEndInclusive) {
        for (int i = rangeStartInclusive; i <= rangeEndInclusive; i++) {
            addToken(i);
        }
    }

    private void addToken(Integer token) {
        tokens.push(token);
    }

    private void randomiseTokens() {
        Collections.shuffle(tokens);
    }
}
