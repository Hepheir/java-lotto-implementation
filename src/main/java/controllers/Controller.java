package controllers;

import java.util.List;

/**
 * 사용자 입력을 올바르게 받아주는 책임이 있음.
 */
public interface Controller {
    String readLine();

    Integer readInteger();

    List<Integer> readIntegerSequence(String delimiter);
}
