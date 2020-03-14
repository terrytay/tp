package studyarea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.Scanner;

public class SearchKeyDictionary {

    private static HashMap<String, ArrayList<String>> dictionary = new HashMap<>();

    public static void loadDictionary(){
        for(String temp : ENGINEERING){
            dictionary.put(temp, "engineering");
        }
        for(String temp : ENGINEERING){
            dictionary.put(temp, "engineering");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        loadDictionary();
        System.out.println("Engine: 0, Utown: 1 , Computing: 2 ");
        System.out.println("Search by faculty: ");

        while (true) {
            String input = in.nextLine();
            if(input.equals("bye")){
                break;
            }
            int index = 0;
            String searchedFac = null;
            for (HashSet<String> faculty : Dictionary) {
                if (faculty.contains(input)) {
                    break;
                }
                index++;
            }
            switch (index) {
                case 0:
                    searchedFac = "Engineering";
                    break;
                case 1:
                    searchedFac = "Utown";
                    break;
                case 2:
                    searchedFac = "Computing";
                    break;
                default:
                    searchedFac = "not found";
                    break;
            }
                System.out.println("Faculty searched is: " + searchedFac);

        }
    }
}
