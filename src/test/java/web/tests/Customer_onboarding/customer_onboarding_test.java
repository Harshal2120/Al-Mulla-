package web.tests.Customer_onboarding;

import io.unity.framework.init.base;
import org.testng.annotations.Test;
import web.object_repository.Customer_onboarding.customer_onboarding;

public class customer_onboarding_test extends base {

    customer_onboarding customer_onboarding;

    @Test
    public void login_with_valid_credentials() {

        customer_onboarding = new customer_onboarding(driver);
        customer_onboarding.enter_ec_number("12345678901");
        customer_onboarding.enter_smart_card_number("1234567890");
        customer_onboarding.enter_otp("123456");
        customer_onboarding.click_on_submit_button();
    }
}
