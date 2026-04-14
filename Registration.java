package com.mycompany.login;

import java.util.Scanner;

class Login {
    private String storedUsername;
    private String storedPassword;

    public boolean checkUserName(String username) {
    
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPassword(String password) {
        if (password.length() < 8) return false;
        boolean hasUpper = false, hasNumber = false, hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasNumber = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }
        return hasUpper && hasNumber && hasSpecial;
    }

    public void register(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        if (!checkUserName(username)) {
            System.out.println("Invalid username.");
            return;
        }
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        if (!checkPassword(password)) {
            System.out.println("Invalid password.");
            return;
        }
        storedUsername = username;
        storedPassword = password;
        System.out.println("Registration successful!");
    }

    public void login(Scanner sc) {
        if (storedUsername == null) {
            System.out.println("Please register first.");
            return;
        }
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid login details.");
        }
    }
}

public class Registration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login user = new Login();
        int choice = 0;
        do {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); 
                switch (choice) {
                    case 1 -> user.register(sc);
                    case 2 -> user.login(sc);
                    case 3 -> System.out.println("Goodbye!");
                    default -> System.out.println("Invalid option.");
                }
            } else {
                System.out.println("Please enter a number.");
                sc.next();
            }
        } while (choice != 3);
        sc.close();
    }
}
