package test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import service.NetworkplanCalculator;

class NetworkplanCalculatorTest {
    @Test
   public void calculateEndDate(){
        NetworkplanCalculator networkplanCalculator = new NetworkplanCalculator();
        Assertions.assertThat(networkplanCalculator.calculateEndDate(1,3)).isEqualTo(4);
    }




}