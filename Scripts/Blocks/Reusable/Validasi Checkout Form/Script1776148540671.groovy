import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Blocks/Reusable/Open Browser'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Blocks/Positive/POS002-LOGIN'), [('username') : username, ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Product/link_shop'))

WebUI.click(findTestObject('Page_Product/button_add to basket'))

WebUI.click(findTestObject('Page_Product/button_view basket'))

WebUI.waitForElementPresent(findTestObject('Page_View Basket/text_basket totals'), 0)

WebUI.click(findTestObject('Page_Checkout/button_proceed to checkout'))

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_first_name'), 'test')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_last_name'), 'test')

WebUI.setText(findTestObject('Page_Checkout/text_input_company came_billing_company'), 'test')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_email'), email)

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_phone'), phone)

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_address_1'), 'test')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_city'), 'test')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_postcode'), postcode)

// Ambil nilai text pada object
String firstName = WebUI.getText(findTestObject('Page_Checkout/text_input_billing_first_name'), FailureHandling.STOP_ON_FAILURE)

String lastName = WebUI.getText(findTestObject('Page_Checkout/text_input_billing_last_name'), FailureHandling.STOP_ON_FAILURE)

String companyName = WebUI.getText(findTestObject('Page_Checkout/text_input_company came_billing_company'), FailureHandling.STOP_ON_FAILURE)

String email = WebUI.getText(findTestObject('Page_Checkout/text_input_billing_email'), FailureHandling.STOP_ON_FAILURE)

String phone = WebUI.getText(findTestObject('Page_Checkout/text_input_billing_phone'), FailureHandling.STOP_ON_FAILURE)

String address = WebUI.getText(findTestObject('Page_Checkout/text_input_billing_address_1'), FailureHandling.STOP_ON_FAILURE)

String city = WebUI.getText(findTestObject('Page_Checkout/text_input_billing_city'), FailureHandling.STOP_ON_FAILURE)

String postcode = WebUI.getText(findTestObject('Page_Checkout/text_input_billing_postcode'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Checkout/input_PayPal Express Checkout_place_order'))

// Validasi form
boolean isFormValid = firstName != '' && lastName != '' && companyName != '' &&
                      email != '' && phone != '' &&
                      address != '' && city != '' && postcode != ''


if (isFormValid) {
	
    WebUI.verifyElementText(findTestObject('Page_Checkout/text_thank you'), 'Thank you. Your order has been received.')

    WebUI.verifyElementPresent(findTestObject('Page_Checkout/text_order number'), 0)

    WebUI.verifyElementPresent(findTestObject('Page_Checkout/text_make your payment directly into our bank account'), 0)

    WebUI.verifyElementText(findTestObject('Page_Checkout/text_Our Bank Details'), 'Our Bank Details')

    WebUI.verifyElementText(findTestObject('Page_Checkout/text_Order Details'), 'Order Details')

    WebUI.verifyElementPresent(findTestObject('Page_Checkout/table_Product'), 0)

    WebUI.verifyElementText(findTestObject('Page_Checkout/text_Customer Details'), 'Customer Details')

    WebUI.verifyElementPresent(findTestObject('Page_Checkout/table_email'), 0)

    WebUI.verifyElementText(findTestObject('Page_Checkout/text_Billing Address'), 'Billing Address')

    WebUI.verifyElementPresent(findTestObject('Page_Checkout/text_billing address (1)'), 0)
	
} else {
	
    String errorText = WebUI.getText(findTestObject('Page_Checkout/text_error message mandatory'))

    if (firstName == '') {
        WebUI.verifyMatch(errorText, '.*Billing First Name is a required field.*', true)
    }
}

WebUI.callTestCase(findTestCase('Blocks/Reusable/Close Browser'), [:], FailureHandling.STOP_ON_FAILURE)

