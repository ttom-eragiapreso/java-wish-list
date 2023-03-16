package org.lessons.java.christmasbonus;

public class TooManyWishesException extends RuntimeException{
    private int wishes;
    public TooManyWishesException(String message, int wishes) {
        super(message);
        this.wishes = wishes;
    }

    public int getWishes(){
        return wishes;
    }
}
