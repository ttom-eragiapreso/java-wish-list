package org.lessons.java.christmas;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> wishList = new ArrayList<>();
        boolean exit = false;
        while(!exit){
            System.out.println("Welcome to your wishlist, please write what you would like to receive");
            String wish = scan.nextLine();
            wishList.add(wish);
            System.out.println("Great! So far you've added " + wishList.size() + " items to your wishlist");
            System.out.println("Would you like to add more? (y/n)");
            exit = !scan.nextLine().equalsIgnoreCase("y");
        }

        System.out.println("Awesome, what is your name?");
        String senderName = scan.nextLine();
        System.out.println("Finally, what is your address?");
        String senderAddress = scan.nextLine();

        ChristmasLetter christmasLetter = new ChristmasLetter(senderName, senderAddress, wishList);

        try{
            System.out.println(christmasLetter.send());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        Collections.sort(wishList);
        System.out.println(wishList);
    }
}