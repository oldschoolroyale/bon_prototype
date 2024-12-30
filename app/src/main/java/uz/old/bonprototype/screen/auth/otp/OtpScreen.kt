package uz.old.bonprototype.screen.auth.otp

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import uz.old.bonprototype.R
import uz.old.bonprototype.screen.auth.base.OtpTextField
import uz.old.bonprototype.screen.base.PrimaryButton
import uz.old.bonprototype.ui.theme.BonPrototypeTheme
import java.util.Locale

@Composable
fun OtpScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    onSendOtp: (String) -> Unit
) {
    val (otp, setOtp) = remember { mutableStateOf("") }
    var timeLeft by remember { mutableIntStateOf(59) }

    LaunchedEffect(key1 = timeLeft) {
        if (timeLeft > 0) {
            delay(1000)
            timeLeft--
        }
    }

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
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Checking the number")

            Text(
                text = "The code has been sent to +998 98 123 4567\nPlease enter it below:",
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(14.dp))

            OtpTextField(
                value = otp,
                onValueChange = setOtp,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = Modifier.height(22.dp))

            PrimaryButton(
                text = "Restore access",
                onNextClick = { onSendOtp(otp) },
                isEnabled = otp.length == 4
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Resend code in ${String.format(Locale.getDefault(), "%02d", (timeLeft % 60))} sec",
                color = Color(0xFF8D8986)
            )
        }
    }
}

@Preview
@Composable
fun OtpScreenPreview() {
    BonPrototypeTheme {
        OtpScreen(onNavigateUp = {}) {

        }
    }
}