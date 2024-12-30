package uz.old.bonprototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.old.bonprototype.screen.auth.onboarding.OnboardingScreen
import uz.old.bonprototype.screen.auth.otp.OtpScreen
import uz.old.bonprototype.ui.theme.BonPrototypeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BonPrototypeTheme {
                OnboardingScreen(
                    modifier = Modifier.imePadding(),
                    onSkipClick = {},
                    onForgotPasswordClick = {},
                    onLoginClick = {}
                )
            }
        }
    }
}