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

        int sumSafeReportsDel1 = 0;
        int sumSafeReportsDel2 = 0;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            int length = parts.length;
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = Integer.parseInt(parts[i]);
            }

            //del 1
            if (isSorted(array, length) || isSortedBackwards(array, length)) {
                if (noEqualIntegers(array, length)) {
                    if (noMoreThan3(array, length)) {
                        sumSafeReportsDel1++;
                    }
                }
            }

            //del 2
            int[] temp = array;
            for (int i = 0; i < length; i++) {
                temp = ignoreOne(array, length, i);
                if (isSorted(temp, length-1) || isSortedBackwards(temp, length-1)) {
                    if (noEqualIntegers(temp, length-1)) {
                        if (noMoreThan3(temp, length-1)) {
                            sumSafeReportsDel2++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("Safe reports del1: " + sumSafeReportsDel1);
        System.out.println("Safe reports del2: " + sumSafeReportsDel2);
    }

    public static boolean isSorted(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i-1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedBackwards(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i-1] < arr[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean noEqualIntegers(int arr[], int n) {
        for (int i = 0; i < n-1; i++) {
            if (arr[i] == arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean noMoreThan3(int[] arr, int n) {
        for (int i = 0; i < n-1; i++) {
            if (Math.abs(arr[i] - arr[i+1]) > 3) {
                return false;
            }
        }
        return true;
    }

    public static int[] ignoreOne(int[] arr, int n, int index) {
        int[] newArr = new int[n-1];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (i != index) {
                int j = arr[i];
                newArr[k] = j;
                k++;
            }
            
        }
        return newArr;
    }
}