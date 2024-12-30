package uz.old.bonprototype.screen.auth.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import uz.old.bonprototype.screen.auth.base.PasswordTextField
import uz.old.bonprototype.screen.auth.base.PhoneTextField
import uz.old.bonprototype.screen.auth.base.SkipComponent
import uz.old.bonprototype.screen.base.PrimaryButton
import uz.old.bonprototype.ui.theme.BonPrototypeTheme

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    viewModel: OnboardingViewModel = koinInject(),
    onSkipClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    OnboardingScreen(
        modifier = modifier,
        onSkipClick = onSkipClick,
        onForgotPasswordClick = onForgotPasswordClick,
        onLoginClick = onLoginClick
    )
}

@Composable
private fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onSkipClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    val (phoneNumber, setPhoneNumber) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
    ) {
        SkipComponent(
            modifier = Modifier.align(Alignment.End),
            onClick = onSkipClick
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            modifier = Modifier.padding(horizontal = 35.dp),
            text = "Take advantage of bonuses and the loyalty program",
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(24.dp))

        AuthSwitcher(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            PhoneTextField(
                value = phoneNumber,
                hint = "Enter phone number",
                onCountryClick = { },
                onValueChange = setPhoneNumber
            )

            PasswordTextField(
                value = password,
                hint = "Enter password",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                onValueChange = setPassword
            )

            ForgotPassword(
                modifier = Modifier.align(Alignment.End),
                onClick = onForgotPasswordClick
            )
        }

        Spacer(modifier = Modifier.heightIn(32.dp))

        PrimaryButton(
            text = "Login",
            onNextClick = onLoginClick
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(
    showBackground = true
)
@Composable
fun OnboardingScreenPreview() {
    BonPrototypeTheme {
        OnboardingScreen(
            onSkipClick = {},
            onForgotPasswordClick = {},
            onLoginClick = {}
        )
    }
}