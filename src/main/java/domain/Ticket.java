package domain;

public interface Ticket {
    /**
     * 복권 객체에 대한 정보를 {@literal "[1, 2, 3, 4, 5, 6]"} 과 같은 형식의 문자열로 반환함.
     */
    String toString();

    /**
     * Lottery 개당 가격
     */
    Integer getPrice();
}
