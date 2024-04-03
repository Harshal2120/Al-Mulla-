package web.tests.HeadersTest;

import io.unity.framework.init.base;
import org.testng.annotations.Test;
import web.object_repository.Headers.headers;

public class headers_test extends base {

    web.object_repository.Headers.headers headers;

    @Test
    public void verify_headers(){
        headers = new headers(driver);
        headers.click_and_verify_about_us_link("ABOUT US");
        headers.click_and_verify_services_link("WHY AL MULLA EXCHANGE?");
        headers.click_and_verify_branches_link("LOCATIONS");
        headers.click_and_verify_promotions_link("PROMOTIONS");
        headers.click_and_verify_contact_us_link("CONTACT");
        headers.click_and_verify_remit_online_link("LOGIN");
        headers.click_and_verify_news_link("NEWS");
        headers.click_and_verify_faq_link("How can we help you?");
        headers.click_and_verify_arabic_link("نبذة عن الشركة");


    }
}

