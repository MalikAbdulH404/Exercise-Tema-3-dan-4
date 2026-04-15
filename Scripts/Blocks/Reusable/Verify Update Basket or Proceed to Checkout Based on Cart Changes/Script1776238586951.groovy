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

int qtyValue = qty.toInteger()

WebUI.callTestCase(findTestCase('Blocks/Reusable/Open Browser'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Blocks/Positive/POS002-LOGIN'), [('username') : username, ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Product/link_shop'))

WebUI.click(findTestObject('Page_Product/button_add to basket'))

WebUI.click(findTestObject('Page_Product/button_view basket'))

if (qtyValue > 1) {
    WebUI.setText(findTestObject('Page_View Basket/text_input_qty'), qty)

    WebUI.click(findTestObject('Page_View Basket/input_Coupon_update_cart'))

    WebUI.verifyElementPresent(findTestObject('Page_View Basket/SuccessUpdate'), 0)

    WebUI.callTestCase(findTestCase('Blocks/Positive/POS006-CHECKOUT'), [('email') : 'testing001@gmail.com', ('phone') : '08124712642141'
            , ('postcode') : '1241421'], FailureHandling.STOP_ON_FAILURE)

    WebUI.comment('ADA UPDATE')
} else {
    WebUI.comment('Update button disabled → Go checkout')

    WebUI.callTestCase(findTestCase('Blocks/Positive/POS006-CHECKOUT'), [('email') : 'testing001@gmail.com', ('phone') : '08124712642141'
            , ('postcode') : '1241421'], FailureHandling.STOP_ON_FAILURE)

    WebUI.comment('TIDAK UPDATE')
}

// Cek apakah tombol update bisa diklik
//boolean isUpdateEnabled = WebUI.verifyElementClickable(findTestObject('Page_View Basket/button_update_basket'), FailureHandling.OPTIONAL)
//
//if (isUpdateEnabled) {
//    WebUI.comment('Update button enabled → Update basket')
//
//    WebUI.click(findTestObject('Page_View Basket/input_Coupon_update_cart'))
//
//    WebUI.verifyElementPresent(findTestObject('Page_View Basket/SuccessUpdate'), 0)
//
//    WebUI.callTestCase(findTestCase('Scenarios/Checkout/TC001-Checkout Sucess'), [('username') : 'testing001@gmail.com', ('password') : 'Bgd7citJOp/IS95AvpRAhA=='], 
//        FailureHandling.STOP_ON_FAILURE)
//
//    WebUI.comment('ADA UPDATE BASKET')
//} else {
//    WebUI.comment('Update button disabled → Go checkout')
//
//    WebUI.callTestCase(findTestCase('Blocks/Positive/POS006-CHECKOUT'), [('email') : 'testing001@gmail.com', ('phone') : '08124712642141'
//            , ('postcode') : '1241421'], FailureHandling.STOP_ON_FAILURE)
//
//    WebUI.comment('GAADA UPDATE Basket')
//}
WebUI.callTestCase(findTestCase('Blocks/Reusable/Close Browser'), [:], FailureHandling.STOP_ON_FAILURE)

