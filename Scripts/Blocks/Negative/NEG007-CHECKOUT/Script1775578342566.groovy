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

WebUI.click(findTestObject('Page_Product/link_shop'))

WebUI.click(findTestObject('Page_Product/text_judul produk'))

WebUI.click(findTestObject('Page_View Product/button_add to basket'))

WebUI.click(findTestObject('Page_View Basket/button_view basket'))

WebUI.click(findTestObject('Page_Checkout/button_proceed to checkout'))

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_first_name'), '')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_last_name'), '')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_email'), '')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_phone'), '')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_address_1'), '')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_city'), '')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_postcode'), '')

WebUI.click(findTestObject('Page_Checkout/button_place order'))

// Ambil semua text error
String errorText = WebUI.getText(findTestObject('Page_Checkout/text_error message mandatory'))

// Verify satu per satu
WebUI.verifyMatch(errorText, '.*Billing First Name is a required field.*', true)

WebUI.verifyMatch(errorText, '.*Billing Last Name is a required field.*', true)

WebUI.verifyMatch(errorText, '.*Billing Email Address is a required field.*', true)

WebUI.verifyMatch(errorText, '.*Billing Phone is a required field.*', true)

WebUI.verifyMatch(errorText, '.*Billing Address is a required field.*', true)

WebUI.verifyMatch(errorText, '.*Billing Town / City is a required field.*', true)

WebUI.verifyMatch(errorText, '.*Billing Postcode / ZIP is a required field.*', true)

