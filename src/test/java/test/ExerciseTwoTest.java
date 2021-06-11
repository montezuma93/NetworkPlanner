package test;

import Exercise.ExerciseTwo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ExerciseTwoTest {
    @Test
    public void multiply(){

    ExerciseTwo exerciseTwo = new ExerciseTwo();
    Assertions.assertThat(exerciseTwo.multiply(4,2)).isEqualTo(8);
    }

    @Test
    public void multiply_two(){

        ExerciseTwo exerciseTwo = new ExerciseTwo();
        Assertions.assertThat(exerciseTwo.multiply(1,2)).isEqualTo(2);
    }

}