package Exercise;

public final class ExerciseTwo {
    public static int mulitply (int a, int b){
        if (a == 1){
                return b;
    }else if ( b == 1){
            return a;
        }else {
            return a + (mulitply(a, b-1));
        }
    }
}
