package com.design.patterns.GFG.Array;

public class MissingInArray {
    public static void main(String[] args) {
        int arr[] = {1};
        int i1 = missingNumber(arr);
        int i2 = missingNumber(arr);

        System.out.println("Hi" + i1);
        System.out.println("Hello" + i2);
        int n = arr.length;

        boolean booleansArray[] = new boolean[n+2];

        for (int i = 0; i < n; i++) {
            booleansArray[arr[i]] = true;
        }

        for (int i = 1; i < booleansArray.length; i++) {
            if (booleansArray[i] == false) {
                System.out.println("Missing " + i + "");
                break;
            }
        }
       /* int arr[] = {1, 2, 4, 5, 6, 7, 8, 9, 10};
        int n = arr.length;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int i = 0; i < n; i++) {
            actualSum += arr[i];
        }

        int missingNumber = expectedSum - actualSum;
        System.out.println("Missing number: " + missingNumber);*/
    }

    static int missingNUmber1(int arr[]) {
        int n = arr.length;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int i = 0; i < n; i++) {
            actualSum += arr[i];
        }

        int missingNumber = expectedSum - actualSum;
        return missingNumber;
    }

    static int missingNumber(int arr[]) {
        int n = arr.length;

        boolean booleansArray[] = new boolean[n+2];

        for (int i = 0; i < n; i++) {
            booleansArray[arr[i]] = true;
        }

        for (int i = 1; i < booleansArray.length; i++) {
            if (booleansArray[i] == false) {
                return i;
            }
        }
        return -1;
    }
}
