package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NetworkplanCalculatorTest {

    @Test
    public void calcuateEndDateTest() {
        NetworkplanCalculator networkplanCalculator = new NetworkplanCalculator();
        Assertions.assertThat(networkplanCalculator.calculateEndDate(1,3)).isEqualTo(4);
    }

}