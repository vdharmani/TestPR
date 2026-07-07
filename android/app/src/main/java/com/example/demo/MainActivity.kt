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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    var showSignup by remember { mutableStateOf(false) }

                    if (showSignup) {
                        SignupScreen(
                            onSignupClick = { _, _, _ -> showSignup = false },
                            onLoginClick = { showSignup = false }
                        )
                    } else {
                        LoginScreen(
                            onLoginClick = { _, _ -> },
                            onSignupClick = { showSignup = true }
                        )
                    }
                }
            }
        }
    }
}
