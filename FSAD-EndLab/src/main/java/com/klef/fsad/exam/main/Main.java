package com.klef.fsad.exam.main;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        // Your existing code
        Map<String, Integer> map = new HashMap<>();
        map.put("pooja", 9);
        map.put("hari", 8);
        map.put("krishna", 6);
        map.put("bhavii", 3);
        map.put("indra", 4);
        map.put("hima", 5);
        map.put("nithya", 7);

        List<Map.Entry<String,Integer>>[] table = new List[8];

       

        System.out.println("Input Map:");
        System.out.println(map);

        System.out.println("\nHash Table (Bucket Representation):");

        for (int i = 0; i < table.length; i++) {
            System.out.print("Index " + i + " : ");

            if (table[i] == null || table[i].isEmpty()) {
                System.out.println("Empty");
            } else {
                for (int j = 0; j < table[i].size(); j++) {
                    var e = table[i].get(j);
                    System.out.print(e.getKey() + " -> " + e.getValue());

                    if (j < table[i].size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }
}