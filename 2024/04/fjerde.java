import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class fjerde {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[][] chars = null;

        while (sc.hasNext()) {
            String line = sc.nextLine();
        }
    }
}