package uz.old.bonprototype.screen.auth.passchange

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.old.bonprototype.R
import uz.old.bonprototype.screen.auth.base.NameTextField
import uz.old.bonprototype.screen.auth.base.PasswordTextField
import uz.old.bonprototype.screen.base.PrimaryButton
import uz.old.bonprototype.ui.theme.BonPrototypeTheme

@Composable
fun PasswordChangeScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    onPasswordChange: (String) -> Unit
) {
    val (password, setPassword) = remember { mutableStateOf("") }
    val (repeat, setRepeat) = remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
    ) {
        IconButton(onClick = onNavigateUp) {
            Icon(
                painter = painterResource(id = R.drawable.ic_button_back),
                contentDescription = null,
                tint = Color(0xFF5A3022)
            )
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Change password")

            Spacer(modifier = Modifier.height(10.dp))

            PasswordTextField(
                value = password,
                hint = "New password",
                onValueChange = setPassword
            )

            PasswordTextField(
                value = repeat,
                hint = "Repeat new password",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                onValueChange = setRepeat
            )

            Spacer(modifier = Modifier.height(18.dp))

            PrimaryButton(
                text = "Restore access",
                onNextClick = { onPasswordChange(password) },
                isEnabled = password.length >= 5 && password == repeat
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Preview
@Composable
fun PasswordChangeScreenPreview(modifier: Modifier = Modifier) {
    BonPrototypeTheme {
        PasswordChangeScreen(onNavigateUp = {}) {

        }
    }
}