import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class first {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] parts = line.split("   ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            aList.add(a);
            bList.add(b);
        }

        firstA(aList, bList);
        firstB(aList, bList);
    }

    public static void firstA(ArrayList<Integer> aList, ArrayList<Integer> bList) {
        aList.sort(null);
        bList.sort(null);
        int distance = 0;

        for (int i = 0; i < 1000; i++) {
            int a = aList.get(i);
            int b = bList.get(i);

            if (a < b) {
                distance += b - a;
            } else {
                distance += a - b;
            }
        }
        System.out.println(distance);
    }

    public static void firstB(ArrayList<Integer> aList, ArrayList<Integer> bList) {
        int similarityScore = 0;

        for (int i = 0; i < 1000; i++) {
            int number = aList.get(i);
            int count = 0;
            for (int j = 0; j < 1000; j++) {
                if (number == bList.get(j)) {
                    count++;
                }
            }
            similarityScore += number * count;
        }

        System.out.println(similarityScore);
    }
}