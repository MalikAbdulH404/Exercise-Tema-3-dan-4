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

WebUI.click(findTestObject('Page_Checkout/button_proceed to checkout'))

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_first_name'), firstname)

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_last_name'), lastname)

WebUI.setText(findTestObject('Page_Checkout/text_input_company came_billing_company'), company)

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_email'), email)

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_phone'), phone)

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_address_1'), address)

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_city'), city)

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_postcode'), postcode)

select_radio = payments

switch (select_radio) {
    case 'Direct Bank Transfer':
        WebUI.click(findTestObject('Page_Checkout/btn_direct bank transfer'))

        break
    case 'Check Payments':
        WebUI.click(findTestObject('Page_Checkout/btn_check payments'))

        break
    case 'Cash on Delivery':
        WebUI.click(findTestObject('Page_Checkout/btn_cash on delivery'))

        break
    default:
        break
}

WebUI.click(findTestObject('Page_Checkout/button_place order'))

WebUI.verifyElementText(findTestObject('Page_Checkout/text_thank you'), 'Thank you. Your order has been received.')

