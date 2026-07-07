package com.example.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.demo.ui.LoginScreen
import com.example.demo.ui.SignupScreen
import com.example.demo.ui.WelcomeScreen

private enum class Screen { WELCOME, LOGIN, SIGNUP }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    var currentScreen by remember { mutableStateOf(Screen.WELCOME) }

                    when (currentScreen) {
                        Screen.WELCOME -> WelcomeScreen(
                            onLoginClick = { currentScreen = Screen.LOGIN },
                            onSignupClick = { currentScreen = Screen.SIGNUP }
                        )

                        Screen.LOGIN -> LoginScreen(
                            onLoginClick = { _, _ -> },
                            onSignupClick = { currentScreen = Screen.SIGNUP }
                        )

                        Screen.SIGNUP -> SignupScreen(
                            onSignupClick = { _, _, _ -> currentScreen = Screen.LOGIN },
                            onLoginClick = { currentScreen = Screen.LOGIN }
                        )
                    }
                }
            }
        }
    }
}
