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

        Collections.sort(wishList);
        System.out.println(wishList);
    }
}