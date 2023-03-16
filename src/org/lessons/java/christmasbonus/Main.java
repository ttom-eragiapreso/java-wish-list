package org.lessons.java.christmasbonus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
        }catch(TooManyWishesException e){
            System.out.println(e.getMessage());
            System.out.println("You listed " + e.getWishes() + " wishes, but you're only allowed 5");
            int difference = e.getWishes() - 5;
            System.out.println("Based on my superior intelligence, you have to remove " + difference + " " +
                    "wishes in order to send your letter");
            for (int i = 1; i <= difference; i++) {
                System.out.println("Which wish would you like to remove? (write the name of the wish to select it)");
                System.out.println(christmasLetter.getPrintedList());
                String wishToRemove = scan.nextLine();
                wishList.remove(wishToRemove);
            }
            System.out.println("Awesome, let's try and send your letter again.");
            try{
                christmasLetter.send();
            }catch(RuntimeException exception){
                System.out.println(exception.getMessage());
            }
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.out.println(christmasLetter.contaDesideri());
        System.out.println(christmasLetter.desideriUnici());
    }
}