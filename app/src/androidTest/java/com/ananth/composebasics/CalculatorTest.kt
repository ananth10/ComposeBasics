package com.ananth.composebasics

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import com.ananth.composebasics.basic_layouts.MyApp
import org.junit.Rule
import org.junit.Test

class CalculatorTest {

    //This test rule allows us to set the test content and interact with our app inside the test.
    //A test class should always have a test rule defined
    @get:Rule
    val rule = createComposeRule()

    //to access activity related things, string res
    @get:Rule
    val activityRule = createAndroidComposeRule<ComponentActivity>()

    val buttonOne = hasText("1") and hasClickAction()
    val buttonTwo = hasText("2") and hasClickAction()
    val buttonOThree = hasText("3") and hasClickAction()
    val buttonPlus = hasText("+") and hasClickAction()
    val buttonPerc= hasText("%") and hasClickAction()
    val buttonEqual = hasText("=") and hasClickAction()
    val buttonBackSpc = hasText(" ") and hasClickAction()

    @Test
    fun enterFormula_showsFormula() {
        //in this method we use setContent method to set the content of our screen to be our calculator
        rule.setContent {
            MyApp()

            //do something
            rule.onNode(buttonOne).performClick()
            rule.onNode(buttonPlus).performClick()
            rule.onNode(buttonTwo).performClick()
            rule.onNode(buttonPlus).performClick()
            //more complex matcher to identify "3" on calculate pad instead of result that displayed when perform 1+2
            rule.onNode(buttonOThree).performClick()
            //check something
            rule.onNodeWithText("1+2+3").assertExists()
        }
    }

    @Test
    fun enterInValid_showsError(){
        rule.setContent {
            MyApp()
        }

        rule.onNode(buttonPerc).performClick()
        rule.onNode(buttonEqual).performClick()

        rule.onNodeWithText("Format error").assertExists()

        rule.onNode(buttonBackSpc).performClick()
        rule.onNodeWithText("Format error").assertDoesNotExist()

    }
}