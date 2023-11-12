package Tasts;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationsAndTransactionTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://app.qacademy.rs/signin");
        loginPage.usernameField("MM");
        loginPage.passwordField("1234");
        loginPage.clickSignInButton();
    }

    @Test(priority = 10)
    public void inspectNotificationsAndTransactionFlowE2E() throws InterruptedException {
        sidebarPage.assertNotificationLink();
        sidebarPage.clickNotificartionLink();
        notificationsPage.assertNotificationsTitle();
        notificationsPage.assertNotificationPgImg();
        notificationsPage.assertEmptyNotificationTxt();
        notificationsPage.assertNotificationBadge();
        headerFooterLogosPage.assertNewTransactionBtn();
        headerFooterLogosPage.clickNewTransactionBtnAndAssertURL();
        transactionSelectContactPage.assertSelectContactTxt();
        transactionSelectContactPage.assertSearchInputField();
        transactionSelectContactPage.searchInputFieldSendKeys("Genije");
        transactionSelectContactPage.assertGenijeUserName();
        transactionSelectContactPage.clickGenijeUserTransaction();
        transactionPaymentPage.assertPaymentTxt();
        transactionPaymentPage.assertAmountField();
        transactionPaymentPage.assertEmptyAmountFieldTxt();
        transactionPaymentPage.assertAddANoteField();
        transactionPaymentPage.assertEmptyAddANoteField();
        transactionPaymentPage.amountFieldSendKeys(123);
        transactionPaymentPage.addANoteSendKeys("Daj");
        Thread.sleep(500);
        transactionPaymentPage.assertPayBtn();
        transactionPaymentPage.assertRequestBtn();
        transactionPaymentPage.requestBtnClick();
        transactionCompletePage.assertCompleteTxt();
        transactionCompletePage.assertRequestAmountFromUser();
        transactionCompletePage.assertReturnToTransactionsBtn();
        transactionCompletePage.assertCreateAnotherTransactionBtn();
        transactionCompletePage.createAnotherTransactionBtnClick();
        transactionSelectContactPage.transactionPageURL();
        transactionSelectContactPage.searchInputFieldSendKeys("Genije");
        transactionSelectContactPage.clickGenijeUserTransaction();
        transactionPaymentPage.amountFieldSendKeys(100.00);
        transactionPaymentPage.addANoteSendKeys("Evo ti!");
        transactionPaymentPage.payBtnClick();
        transactionCompletePage.assertCompleteTxt();
        transactionCompletePage.assertPaidAmountToUser();
        transactionCompletePage.assertReturnToTransactionsBtn();
        transactionCompletePage.assertCreateAnotherTransactionBtn();
        transactionCompletePage.returnToTransactionsBtnClick();
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.qacademy.rs/");
        sidebarPage.assertLogoutLink();
        sidebarPage.clickLogoutLink();
        Thread.sleep(500);
        loginPage.assertLoginPageUrl();
        loginPage.usernameField("Genije");
        loginPage.passwordField("1! #q");
        loginPage.clickSignInButton();
        //Should inspect/assert account amount on sidebar --> todo ask team
        notificationsPage.assertNotificationBadge();  //how to assert specific number  --> ask team
        headerFooterLogosPage.assertBellNotificationIcon();
        headerFooterLogosPage.clickBellNotificationIcon();
        notificationsPage.assertTemporaryPeraKojotRecievedTxt();
        notificationsPage.assertDismissBtn();
        notificationsPage.assertTemporaryMajaMReqPayNotifTxt();
        notificationsPage.assertLastTemporaryDismissBtnMajaM();
        notificationsPage.clickFirstDismissBtn();
        notificationsPage.lastTemporaryDismissBtnClickMajaM();
        notificationsPage.assertNotificationBadge();
        //todo --> when all dismissed btns are clicked --> assert Notification badge FALSE
    }

}
