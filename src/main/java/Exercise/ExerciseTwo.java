package Exercise;

public final class ExerciseTwo {
    public static int multiply(int a, int b){
        if (a == 1){
           return b;

        }else if ( b == 1){
            return a;
        }else {
            return a + (multiply(a, b-1));
        }
    }
}
