package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import price.formatter.PriceFormatter;

/**
 * Write your tests for the PriceFormatter here. See the specification of the
 * PriceFormatter and formatPrice method in the PriceFormatter class.
 */
public class PriceFormatterTest {

    // Desimaalierottimena on pilkku
    @Test
    void priceFormat_Unit_OK() {
        PriceFormatter formatter = new PriceFormatter();
        // int = expected = 3.14;
        String result = formatter.formatPrice(Math.PI);
        assertEquals("3,14 €", result);
    }

    // Tuhaterottimena on välilöynti
    @Test
    void priceFormat_SpaceBetweenThounsand_OK() {
        PriceFormatter formatter = new PriceFormatter();
        // int = expected = 3.14;
        String result = formatter.formatPrice(1000);
        assertEquals("1 000 €", result);
    }

    // Desimaaliosa on kahden numeron pituinen, seuraavin tarkennuksin: Desimaaliosa
    // pyöristetään lähimpään sadasosaan (eli senttiin).
    @Test
    void priceFormat_DecimalIsLong_OK() {
        PriceFormatter formatter = new PriceFormatter();
        String result = formatter.formatPrice(11.685);
        assertEquals("11,69 €", result);
    }

    // Desimaaliosa on kahden numeron pituinen, seuraavin tarkennuksin: jos
    // desimaaliosa on pyöristyksen jälkeen nolla, jätetään desimaaliosa kokonaan
    // pois
    @Test
    void priceFormat_ZeroDeletePrice_OK() {
        PriceFormatter formatter = new PriceFormatter();
        String result = formatter.formatPrice(11.00);
        assertEquals("11 €", result);
    }

    // Hinnan lopussa on Euro-symboli €
    @Test
    void priceFormat_EndOfPriceIsEuro_OK() {
        PriceFormatter formatter = new PriceFormatter();
        String result = formatter.formatPrice(12);
        assertEquals("12 €", result);
    }

    // Negatiivinen
    @Test
    void priceFormat_Negative_OK() {
        PriceFormatter formatter = new PriceFormatter();
        String result = formatter.formatPrice(-12);
        assertEquals("-12 €", result);
    }
    /*
     * @Test
     * void removeThisTestWhenImplementingYourOwnTests() {
     * /*
     * The formatPrice method takes a double as a parameter and returns a String:
     *
     * PriceFormatter formatter = new PriceFormatter();
     * String formatted = formatter.formatPrice(Math.PI); // 3.14 €
     *
     * Call the method with different values in your tests and check that the
     * returned Strings match the specification.
     * PriceFormatter formatter = new PriceFormatter();
     * String result = formatter.formatPrice(Math.PI);
     * 
     * fail("Remove this test and implement your own tests for the PriceFormatter class."
     * );
     * }
     */

}
