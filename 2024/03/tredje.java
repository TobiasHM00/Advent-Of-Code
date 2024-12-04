import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

class tredje {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String rx = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern p = Pattern.compile(rx);

        int sumDel1 = 0;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            Matcher matcher = p.matcher(line);

            while (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                //System.out.println(x + " | " + y);
                sumDel1 += x*y;
            }
        }
        System.out.println("Sum1: " + sumDel1);

        rx = "(?:mul\\((\\d{1,3}),(\\d{1,3})\\))|do\\(\\)|don't\\(\\)";
        p = Pattern.compile(rx);

        int sumDel2 = 0;
        boolean canMult = true;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            Matcher matcher = p.matcher(line);

            while (matcher.find()) {
                if (matcher.group(1) != null && matcher.group(2) != null) {
                    int x = Integer.parseInt(matcher.group(1));
                    int y = Integer.parseInt(matcher.group(2));
                    if (canMult) {
                        sumDel2 += x*y;
                    }
                } else if (matcher.group(0).equals("do()")) {
                    canMult = true;
                } else if (matcher.group(0).equals("don't()")) {
                    canMult = false;
                }
            }
        }
        System.out.println("Sum2: " + sumDel2);
    }
}