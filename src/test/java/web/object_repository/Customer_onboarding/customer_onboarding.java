package web.object_repository.Customer_onboarding;

import io.unity.performaction.autoweb.Element;
import io.unity.performaction.autoweb.Verify;
import io.unity.performaction.autoweb.Wait;
import org.openqa.selenium.WebDriver;

public class customer_onboarding {

    WebDriver driver = null;
    Element element = null;
    Verify verify = null;
    Wait wait = null;

    public customer_onboarding(WebDriver driver) {
        this.driver = driver;
        element = new Element(driver);
        verify = new Verify(driver);
        wait = new Wait(driver);
    }


}
