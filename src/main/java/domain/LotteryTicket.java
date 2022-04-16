package domain;

import java.util.Set;

public interface LotteryTicket extends Ticket {
    public static final Integer PRICE = 1000;
    public static final Integer QUANTITY_OF_NUMBERS = 6;

    /**
     * 복권 객체에 대한 정보를 {@literal "[1, 2, 3, 4, 5, 6]"} 과 같은 형식의 문자열로 반환함.
     */
    String toString();

    /**
     * Lottery에 포함된 숫자들
     */
    Set<LotteryNumber> numbers();

    /**
     * 숫자를 추가.
     * 최대로 넣을 수 있는 숫자 보다 많이 넣으면
     * {@code IndexOutOfBoundsException} 를 발생시킨다.
     *
     * @param number
     * @throws IndexOutOfBoundsException
     */
    void addNumber(LotteryNumber number) throws IndexOutOfBoundsException;

    @Override
    default Integer getPrice() {
        return PRICE;
    }
}
