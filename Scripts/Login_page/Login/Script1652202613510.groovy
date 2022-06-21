import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword as Keyword
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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('https://app-stage.lagoframe.com')

if (WebUI.verifyElementPresent(Input_emailField, 5)) {
	KeywordUtil.markPassed('User is on creator portal login page')

	WebUI.setText(Input_emailField, Email)

	if (WebUI.verifyElementPresent(Email_NextButton, 2)) {
		KeywordUtil.markPassed('Next button is enabled')

		WebUI.click(Email_NextButton)

		if (WebUI.verifyElementPresent(Input_passwordField, 10)) {
			KeywordUtil.markPassed('User is on password field')

			WebUI.setText(Input_passwordField, Password)

			WebUI.click(Password_NextButton)

			if (WebUI.waitForElementPresent(LoggedIn_ToastMessage, 30)) {
				KeywordUtil.markPassed('User is logged in')

				if(WebUI.waitForElementPresent(Gallery_verification, 10)) {
					KeywordUtil.markPassed("Gallery page is opened up")

					if(WebUI.waitForElementPresent(CreateGallery_button, 10)) {
						KeywordUtil.markPassed("Gallery button is clickable")
						WebUI.click(CreateGallery_button)
						WebUI.click(CreateButton)

					}else {KeywordUtil.markFailed("Gallery button is not clickable")}
				}
				else {
					KeywordUtil.markFailed("Failed to access gallery page")
				}
			} else {
				KeywordUtil.markFailed('User is not logged in')
			}
		} else {
			KeywordUtil.markFailed('User is not on password field')
		}
	} else {
		KeywordUtil.markFailed('Please enter  the correct email')
	}
} else {
	KeywordUtil.markFailed('User is not on creator portal')
}

