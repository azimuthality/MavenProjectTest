import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;


public class LoginTest {

    private static java.lang.String baseUrl = "https://idemo.bspb.ru/";
    private SelenideElement loginInput = $(By.xpath("//input[@name='username']"));
    private SelenideElement passwordInput = $(By.xpath("//input[@name='password']"));
    private SelenideElement loginBtn = $(By.xpath("//button[@id='login-button']"));
    private SelenideElement otpCode = $(By.xpath("//input[@id='otp-code']"));
    private SelenideElement loginOtpBtn = $(By.xpath("//button[@id='login-otp-button']"));


    private SelenideElement reviewButton = $(By.xpath("//a[@id='bank-overview']"));
    private SelenideElement scoreButton = $(By.xpath("//a[@id='accounts-index']"));
    private SelenideElement paymentsButton = $(By.xpath("//a[@id='payments-form']"));
    private SelenideElement cardsButton = $(By.xpath("//a[@id='cards-overview-index']"));
    private SelenideElement depositsButton = $(By.xpath("//a[@id='deposits-index']"));
    private SelenideElement loansButton = $(By.xpath("//a[@id='loans-index']"));
    private SelenideElement extButton = $(By.xpath("//a[@id='externaltraderoom-index']"));
    private SelenideElement insuranceButton = $(By.xpath("//a[@id='insurance-travel']"));


    @BeforeAll
    static void beforeConfig() {
        Configuration.timeout = 3000;
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void before() {
        open(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {

        step1();

        step2();

        step3();

        sleep(1000);
    }

    @Step
    public void step1() {
        loginInput.should(Condition.visible).val("demo");
        passwordInput.should(Condition.visible).val("demo");
        loginBtn.should(Condition.visible).click();
    }

    public void step2() {
        otpCode.should(Condition.visible).val("0000");
        loginOtpBtn.should(Condition.visible).click();
    }

    public void step3() {

        CheckText(reviewButton.getText(), "??????????");
        CheckText(scoreButton.getText(), "??????????");
        CheckText(paymentsButton.getText(), "?????????????? ?? ????????????????");
        CheckText(cardsButton.getText(), "??????????");
        CheckText(depositsButton.getText(), "????????????");
        CheckText(loansButton.getText(), "??????????????");
        CheckText(extButton.getText(), "????????????");
        CheckText(insuranceButton.getText(), "??????????????????????");
    }

    private void CheckText(String someButton, String someText) {
        Assertions.assertEquals(someButton, someText);
    }

    @AfterEach
    public void after() {
    }
}