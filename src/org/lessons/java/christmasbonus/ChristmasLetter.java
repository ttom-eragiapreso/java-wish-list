package org.lessons.java.christmasbonus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ChristmasLetter {
    private String senderName;
    private String senderAddress;
    private List<String> wishList;

    private boolean isGood;

    public ChristmasLetter(String senderName, String senderAddress, List<String> wishList) {
        Random rnd = new Random();
        boolean isGood = rnd.nextBoolean();
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.wishList = wishList;
    }

    public List<String> getWishList() {
        return wishList;
    }

    public void setWishList(List<String> wishList) {
        this.wishList = wishList;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String send(){

        if(wishList.size() > 5){
            throw new TooManyWishesException("I'm sorry, you were a bit too greedy.", wishList.size());
        }

        if(!isGood){
            throw new RuntimeException("I'm sorry, you were bad this year");
        }

        return "Your Christmas Letter was sent successfully." + "Sender: " + getSenderName() + " - Address: " + getSenderAddress() + "\n" + getPrintedList();
    }

    public String getPrintedList(){
        String printedList = "";
        for (String s : wishList) {
            printedList += s + "\n";
        }
        return printedList;
    }

    public Map<String, Integer> contaDesideri(){
        Map<String, Integer> desideriContati = new HashMap<>();

        for (String desiderio : wishList) {
            if (!desideriContati.containsKey(desiderio)) {
                desideriContati.put(desiderio, 1);
            }else {
                int numVolte = desideriContati.get(desiderio);
                desideriContati.put(desiderio, ++numVolte);
            }
        }
        return desideriContati;
    }
}
