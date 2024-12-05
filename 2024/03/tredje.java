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
        
        String rx2 = "(?:mul\\((\\d{1,3}),(\\d{1,3})\\))|do\\(\\)|don't\\(\\)";
        Pattern p2 = Pattern.compile(rx2);

        int sumDel1 = 0;
        int sumDel2 = 0;
        boolean canMult = true;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            Matcher matcher = p.matcher(line);
            Matcher matcher2 = p2.matcher(line);

            //del1
            while (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                //System.out.println(x + " | " + y);
                sumDel1 += x*y;
            }

            //del2
            while (matcher2.find()) {
                if (matcher2.group(1) != null && matcher2.group(2) != null) {
                    int x = Integer.parseInt(matcher2.group(1));
                    int y = Integer.parseInt(matcher2.group(2));
                    if (canMult) {
                        sumDel2 += x*y;
                    }
                } else if (matcher2.group(0).equals("do()")) {
                    canMult = true;
                } else if (matcher2.group(0).equals("don't()")) {
                    canMult = false;
                }
            }
        }
        System.out.println("Sum1: " + sumDel1);
        System.out.println("Sum2: " + sumDel2);
    }
}