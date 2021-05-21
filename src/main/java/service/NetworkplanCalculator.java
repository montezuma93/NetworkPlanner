package service;

public final class NetworkplanCalculator {

    public static void fillNetworkplan(Networkplan networkplan) {
        // Calculate Networkplan
        // This is a new commit
        // This is Mangal

        //This is madness! - No, THIS IS SPARTA!


    }
    public int calculateEndDate(int start, int duration) {
        return start + duration;
    }

    //Aufgabenblatt 3
    //getGreatestCommonDivisior
    public static int getGreatestCommonDivisor(int a, int b){
        if (a == b) {
            return a;
        }
        int greaterNumber = a > b ? a : b;
        int smallerNumber = a < b ? a : b;

        int greatestCommonDivisor = greaterNumber / 2;
        while (greaterNumber % greatestCommonDivisor != 0 ||
                smallerNumber % greatestCommonDivisor != 0) {
            greatestCommonDivisor = greatestCommonDivisor -1;
        }
        return greatestCommonDivisor;
    }
    //multiply
    public static int multiply (int a, int b) {
        if (a == 1) {
            return b;
        } else if (b == 1){
            return a;
        } else {
            return a + (multiply(a, b - 1));
        }
    }


}