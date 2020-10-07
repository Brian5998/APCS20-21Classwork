
import static org.junit.Assert.*;

/**
 * RomanToDecimalTest.java is a JUnit test that tests a method in RomanToDecimal.java
 * to ensure that the method works for any case given.
 * @version 10/6/20
 * @author Brian Zhou
 */
public class RomanToDecimalTest {

    @org.junit.Test
    /**
     * Tests method romanToDecimal in class RomanToDecimal which converts a string to a valid decimal
     */
    public void romanToDecimalTest() {
        assertEquals(RomanToDecimal.romanToDecimal("XIV"),14);
        assertEquals(RomanToDecimal.romanToDecimal("YOUR_MOM"),-1);
        assertNotEquals(RomanToDecimal.romanToDecimal("MCMLXIV"),-1);
        assertNotEquals(RomanToDecimal.romanToDecimal("POTATO"),0);
        assertNotEquals(RomanToDecimal.romanToDecimal("LLL"),-1);
        assertNotEquals(RomanToDecimal.romanToDecimal("ICIC"),-1);
        assertNotEquals(RomanToDecimal.romanToDecimal("IMMI"),-1);
        assertNotEquals(RomanToDecimal.romanToDecimal("DDMI"),-1);
        assertNotEquals(RomanToDecimal.romanToDecimal("CLDM"),-1);
        assertNotEquals(RomanToDecimal.romanToDecimal("MMCIVIVI"),-1);
        assertEquals(RomanToDecimal.romanToDecimal("MCMXLII"),1942);
        assertEquals(RomanToDecimal.romanToDecimal("MMLM"),3050);
        assertEquals(RomanToDecimal.romanToDecimal("Cheesecurds"),-1);
        assertEquals(RomanToDecimal.romanToDecimal("CICI"),202);
        assertEquals(RomanToDecimal.romanToDecimal("CMCM"),1800);
        assertEquals(RomanToDecimal.romanToDecimal("CMCM"),1800);
        assertEquals(RomanToDecimal.romanToDecimal("IVMM"),2004);
        assertEquals(RomanToDecimal.romanToDecimal("JKLOL"),-1);
        assertEquals(RomanToDecimal.romanToDecimal("DDLLMM"),3100);
        assertEquals(RomanToDecimal.romanToDecimal("DDD"),1500);
        assertEquals(RomanToDecimal.romanToDecimal("BRIYEN"),-1);

    }
}