package com.revature.util;

import java.util.Scanner;

public class InputUtil {

    Scanner scanner = new Scanner(System.in);
    
    public String retrieveString(String msg){
        System.out.print(msg);
        return scanner.nextLine();
    }

    public Integer retrieveInt(String msg){
        Integer num = 0;
        System.out.println(msg);
        try{
            num = Integer.parseInt(scanner.nextLine());
            
        }catch(NumberFormatException nfe){
            System.out.println("Input is not an integer, try again.");
        }
        return num;
    }
    
}
