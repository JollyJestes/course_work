package com.example.demo4.controllers;


import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Database database = new Database();

        database.load();
        System.out.print("Введите имя -> ");
        String name = (new Scanner(System.in)).nextLine();
        System.out.print("Введите фирму -> ");
        String firm = (new Scanner(System.in)).nextLine();
        System.out.print("Введите цену за еденицу  -> ");
        float pr = (new Scanner(System.in)).nextFloat();
        System.out.print("Введите количество -> ");
        int am = (new Scanner(System.in)).nextInt();
        System.out.print("Введите номер склада -> ");
        int w = (new Scanner(System.in)).nextInt();
        System.out.print("Введите день -> ");
        int d = (new Scanner(System.in)).nextInt();
        System.out.print("Введите год -> ");
        int g = (new Scanner(System.in)).nextInt();
        System.out.print("Введите месяц -> ");
        int m = (new Scanner(System.in)).nextInt();
        System.out.print("Введите минимальную партию -> ");
        int mi = (new Scanner(System.in)).nextInt();
        database.add(new Warehouse(name, firm, pr, am, w, new GregorianCalendar(g, m, d), mi));
        //database.add(new Warehouse("name1", "firm1", 13.2f, 11, 2,  new GregorianCalendar(2019, 4 , 7), 1));
       System.out.println("1) \tудалить все товары заданные товары указанного склада.\n" +
                "2)\tвывести наименование товаров с минимальной партией более 50;\n" +
                "3) \tвывестеи наименование и количество всех товаров, хранящихся на указанном складе больш месяца;\n" +
             "4) \tполучить прайс-лист.");

        int fun = (new Scanner(System.in)).nextInt();
        int A = 1;
        int B = 2;
        int C = 3;
        int D = 4;
        if (fun == A) {
            System.out.println("1)");
            database.remove((new Scanner(System.in)).nextInt());
        }
        if (fun == B) {
            System.out.println("2)");
            System.out.println(database.getMoreThan50());
        }
        if (fun == C) {
            System.out.println("3)");
            System.out.println(database.getMoreMonth());

        }
        if (fun == D) {
            System.out.println("4)");
            System.out.println(Database.getStringDatabase());
        }
       /* System.out.println("а)");
        int A = (new Scanner(System.in)).nextInt();
        database.remove(A);
        System.out.println(database.getMoreThan50());
        System.out.println(Database.getStringDatabase());
        */
        database.save();
    }
}
