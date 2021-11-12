package Exercise;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import Exercise.ExerciseOne;

class ExerciseOneTest {
    @Test
    public void getGreatesCommonDivisor(){
        ExerciseOne exerciseOne = new ExerciseOne();
        Assertions.assertThat(exerciseOne.getGreatesCommonDivisor(3,12)).isEqualTo(3);
    }

}