package org.example;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection();
             Scanner sc = new Scanner(System.in)) {
            FlatDAOImpl dao = new FlatDAOImpl(conn, "Flat");
            dao.createTable(Flat.class);

            while (true) {
                System.out.println("1: add flat");
                System.out.println("2: view flats");
                System.out.println("3: select flat with area from");
                System.out.println("4: select flat with price range");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        System.out.print("Enter flat district: ");
                        String district = sc.nextLine();
                        System.out.print("Enter flat address: ");
                        String address = sc.nextLine();
                        System.out.print("Enter number of rooms: ");
                        String sRooms = sc.nextLine();
                        int rooms = Integer.parseInt(sRooms);
                        System.out.print("Enter area: ");
                        String sArea = sc.nextLine();
                        int area = Integer.parseInt(sArea);
                        System.out.print("Enter price: ");
                        String sPrice = sc.nextLine();
                        int price = Integer.parseInt(sPrice);

                        Flat f = new Flat(district, address, rooms, area, price);
                        dao.add(f);
                        break;
                    case "2":
                        List<Flat> list = dao.getAll(Flat.class);
                        for (Flat flat : list) {
                            System.out.println(flat);
                        }
                        break;
                    case "3":
                        System.out.print("Enter minimum area: ");
                        String sMinArea = sc.nextLine();
                        int minArea = Integer.parseInt(sMinArea);
                        List<Flat> list1 = dao.getAll(Flat.class);
                        for (Flat flat : list1) {
                            if (flat.getArea() >= minArea) {
                                System.out.println(flat);
                            }

                        }
                        break;
                    case "4":
                        System.out.print("Enter min price: ");
                        String sMinPrice = sc.nextLine();
                        int minPrice = Integer.parseInt(sMinPrice);
                        System.out.print("Enter max price: ");
                        String sMaxPrice = sc.nextLine();
                        int maxPrice = Integer.parseInt(sMaxPrice);
                        List<Flat> list2 = dao.getAll(Flat.class);
                        for (Flat flat : list2) {
                            if (flat.getPrice() >= minPrice && flat.getPrice() <= maxPrice) {
                                System.out.println(flat);
                            }

                        }
                        break;

                    default:
                        return;
                }
            }

        }

    }
}