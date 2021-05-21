package test;

import Exercise.ExerciseTwo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ExerciseTwoTest {
    @Test
    public void multiply(){

    ExerciseTwo exerciseTwo = new ExerciseTwo();
    Assertions.assertThat(exerciseTwo.mulitply(4,2)).isEqualTo(8);
    }
}