import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class andre {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int sumSafeReports = 0;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            int length = parts.length;
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = Integer.parseInt(parts[i]);
            }

            for (int i = 0; i < length; i++) {
                
            }
            //sjekke om de to første enten siger eller synker så sjekke resten om alle tallene er enten 
            //lavere eller høyere i forhold til hva de to første bestemmer.
            //
        }
    }
}