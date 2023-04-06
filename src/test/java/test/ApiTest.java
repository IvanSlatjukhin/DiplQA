package test;

import lombok.val;
import org.junit.jupiter.api.Test;

import static data.DataHelper.getValidApprovedCardData;
import static data.DataHelper.getValidDeclinedCardData;
import static data.RestApiHelper.fillPaymentFormWithCreditCardData;
import static data.RestApiHelper.fillPaymentFormWithDebitCardData;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApiTest {

    @Test
    void shouldGiveResponseForValidApprovedDebitCard() {
        val validApprovedCardForApi = getValidApprovedCardData();
        val response = fillPaymentFormWithDebitCardData(validApprovedCardForApi);
        assertTrue(response.contains("APPROVED"));
    }

    @Test
    void shouldGiveResponseForValidDeclinedDebitCard() {
        val validDeclinedCardForApi = getValidDeclinedCardData();
        val response = fillPaymentFormWithDebitCardData(validDeclinedCardForApi);
        assertTrue(response.contains("DECLINED"));
    }

    @Test
    void shouldGiveResponseForValidApprovedCreditCard() {
        val validApprovedCardForApi = getValidApprovedCardData();
        val response = fillPaymentFormWithCreditCardData(validApprovedCardForApi);
        assertTrue(response.contains("APPROVED"));
    }

    @Test
    void shouldGiveResponseForValidDeclinedCreditCard() {
        val validDeclinedCardForApi = getValidDeclinedCardData();
        val response = fillPaymentFormWithCreditCardData(validDeclinedCardForApi);
        assertTrue(response.contains("DECLINED"));
    }
}
