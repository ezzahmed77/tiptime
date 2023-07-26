package com.example.android.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.android.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        // Set the view
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeScreen()
            }
        }
        // First set the bill and tip amounts
        composeTestRule.onNodeWithText("Bill amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)")
            .performTextInput("20")

        // Second make sure the tip amount shows as expected
        composeTestRule.onNodeWithText("Tip Amount: $2.00").assertExists()
    }
}