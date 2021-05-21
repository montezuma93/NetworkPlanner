package Exercise;

public final class ExerciseOne {

    public static int getGreatesCommonDivisor(int a, int b){
        if (a == b){
            return a;
        }
        int greaterNumber = a > b ? a : b;
        int smallerNumber = a < b ? a : b;

        int greatestCommonDivisor = greaterNumber / 2;
        while (greaterNumber % greatestCommonDivisor != 0 || smallerNumber % greatestCommonDivisor !=0){
            greatestCommonDivisor = greatestCommonDivisor -1;
        }
        return greatestCommonDivisor;
    }
}
