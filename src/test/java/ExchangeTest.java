import model.Exchange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExchangeTest {

    Exchange underTest;

    @BeforeEach
    void setUp(){
        underTest = new Exchange();
    }

    @Test
    void testEurToHuf(){ assertEquals("378.3572",underTest.CalculateCurrency("1", "EURHUF"));};
    @Test
    void testEURtoGBP(){ assertEquals("0.8386",underTest.CalculateCurrency("1", "EURGBP"));};
    @Test
    void testEURtoUSD(){ assertEquals("1.0545",underTest.CalculateCurrency("1", "EURUSD"));};

    @Test
    void testUSDHUF(){ assertEquals("320.4377",underTest.CalculateCurrency("1", "USDHUF"));};
    @Test
    void testUSDEUR(){ assertEquals("0.884",underTest.CalculateCurrency("1", "USDEUR"));};
    @Test
    void testUSDGBP(){ assertEquals("0.7377",underTest.CalculateCurrency("1", "USDGBP"));};

    @Test
    void testHUFUSD(){ assertEquals("0.0028",underTest.CalculateCurrency("1", "HUFUSD"));};
    @Test
    void testHUFGBP(){ assertEquals("0.0022",underTest.CalculateCurrency("1", "HUFGBP"));};
    @Test
    void testHUFEUR(){ assertEquals("0.0026",underTest.CalculateCurrency("1", "HUFEUR"));};

    @Test
    void testGBPHUF(){ assertEquals("451.1558",underTest.CalculateCurrency("1", "GBPHUF"));};
    @Test
    void testGBPEUR(){ assertEquals("1.1924",underTest.CalculateCurrency("1", "GBPEUR"));};
    @Test
    void testGBPUSD(){ assertEquals("1.2573",underTest.CalculateCurrency("1", "GBPUSD"));};

    @Test
    void testHUFHUF(){ assertEquals("1.0",underTest.CalculateCurrency("1", "HUFHUF"));};
    @Test
    void testEUREUR(){ assertEquals("1.0",underTest.CalculateCurrency("1", "EUREUR"));};
    @Test
    void testUSDUSD(){ assertEquals("1.0",underTest.CalculateCurrency("1", "USDUSD"));};
    @Test
    void testGBPGBP(){ assertEquals("1.0",underTest.CalculateCurrency("1", "GBPGBP"));};





}