// train reservation system

import java.util.*;

class Node {
    String trainName;
    String from;
    String to;
    public Node(String name,String from,String dest) {
        this.trainName = name;
        this.from = from;
        this.to =dest;
    }
}
class tNode {
    String password;
    String username;
    String from;
    String to;
    char type;
    String date;
    public tNode(char type,String from, String to,String date,String username) {
        this.type = type;
        this.from = from;
        this.to = to;
        this.date = date;
        this.username = username;
    }
}
class Main {
    public static void main(String[] args) {
        Map<Integer,Node> map =new HashMap<>();
        int pnr = 0;
        map.put(1,new Node("Tamil Nadu","chennai","NewDelhi"));
        map.put(2,new Node("Malwa Express","Indore","Jammutawi"));
        map.put(3,new Node("Mandore Express", "Jodhpur","New Delhi"));
        Scanner scanner = new Scanner(System.in);
        Map<Integer,tNode> map1 = new HashMap<>();
        System.out.println("enter username");
        String username = scanner.next();
        System.out.println("Password");
        String password = scanner.next();
        System.out.println("Login successfully");
        System.out.println("Enter the train number");
        boolean visited = false;
        int n = scanner.nextInt();
        if(n <= map.size() && n > 0){
            System.out.println(map.get(n).trainName);
            System.out.println("Enter the source");
            String source  = scanner.next();
            System.out.println("Enter the destination");
            String destination = scanner.next();
            if(source.equals(map.get(n).from) && destination.equals(map.get(n).to)) {
                System.out.println("Enter the class type");
                char c = scanner.next().toCharArray()[0];
                System.out.println("Enter the date");
                String date = scanner.next();
                System.out.println("Enter confirmation by pressing insert");
                String insert = scanner.next();
                if(insert.equals("insert")) {
                    tNode node = new tNode(c,source,destination,date,username);
                    System.out.println("Your PNR number for ticket is" + node.hashCode());
                    System.out.println("You successfully confirmed your ticket");
                    map1.put(node.hashCode(),node);
                    visited = true;
                }
            }
        }
        else {
            System.out.println("There is no train with with the number" + n);
        }
        if(visited) {
            System.out.println("You can cancel your ticket by pressing cancel");
            String s = scanner.next();
            if (s.equals("cancel")) {
                System.out.println("Enter your pnr number");
                n = scanner.nextInt();
                if (map1.containsKey(n)) {
                    tNode node = map1.get(n);
                    System.out.println(node.username);
                    System.out.println("from" + "  " + node.from + "\t" + "to" + " " + node.to);
                    System.out.println("Type of sitting " + "  " + node.type);
                    System.out.println("date of journey" + "  " + node.date);
                    System.out.println("confirm your cancellation by pressing OK");
                    String ok = scanner.next();
                    if (ok.equals("OK")) {
                        map.remove(n);
                        System.out.println("You successfully cancelled your cancellation");
                    }
                    else {
                        System.out.println("You have not cancelled your ticket");
                    }
                }
                else {
                    System.out.println("you have not booked any train");
                }
            }
            else {
                System.out.println("You have not cancelled your ticket");
            }
        }
    }
}
