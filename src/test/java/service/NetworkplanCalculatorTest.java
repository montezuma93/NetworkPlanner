package service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkplanCalculatorTest {
    @Test
    public void calculateEndDate(){
        NetworkplanCalculator networkplanCalculator = new NetworkplanCalculator();
        Assertions.assertThat(networkplanCalculator.calculateEndDate(1, 5)).isEqualTo(6);

    }

    //Aufgabenblatt3
    @Test
    public void getGreatestCommonDivisor(){
        NetworkplanCalculator networkplanCalculator = new NetworkplanCalculator();
        Assertions.assertThat(networkplanCalculator.getGreatestCommonDivisor(12,16)).isEqualTo(4);
    }

    @Test
    public void multiply(){
        NetworkplanCalculator networkplanCalculator = new NetworkplanCalculator();
        Assertions.assertThat(networkplanCalculator.multiply(2,4)).isEqualTo(8);
    }

}