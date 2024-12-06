import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class femte {
    public static void main(String[] args) {
        Scanner sc = null;

        try {
            sc = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        boolean swap = false;
        
        ArrayList<ArrayList<String>> correctUpdatesList = new ArrayList<>();

        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (line.equals("")) swap = true;
            if (swap) {
                String[] parts = line.strip().split(",");
                for (int i = 0; i < parts.length; i++) {
                    if (map.containsKey(parts[i])) {
                        
                    }
                }
            } else {
                String[] parts = line.strip().split("|");
                if (!map.containsKey(parts[0])) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(parts[1]);
                    map.put(parts[0], list);
                } else map.get(parts[0]).add(parts[1]);
            }
        }
    }
}
