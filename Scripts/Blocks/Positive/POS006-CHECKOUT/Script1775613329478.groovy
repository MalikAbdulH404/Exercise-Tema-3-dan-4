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

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_first_name'), 'test')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_last_name'), 'test')

WebUI.setText(findTestObject('Page_Checkout/text_input_company came_billing_company'), 'test')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_email'), email)

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_phone'), phone)

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_address_1'), 'test')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_city'), 'test')

WebUI.setText(findTestObject('Page_Checkout/text_input_billing_postcode'), postcode)

WebUI.click(findTestObject('Page_Checkout/button_place order'))

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

