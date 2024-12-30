package uz.old.bonprototype.screen.auth.additional

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.old.bonprototype.R
import uz.old.bonprototype.screen.auth.base.BirthdateTextField
import uz.old.bonprototype.screen.auth.base.EmailTextField
import uz.old.bonprototype.screen.auth.base.SkipComponent
import uz.old.bonprototype.screen.base.PrimaryButton

@Composable
fun AdditionalScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    onSkipClick: () -> Unit,
    onSendAdditional: (String, String) -> Unit
) {
    val (birthdate, setBirthdate) = remember { mutableStateOf("") }
    val (email, setEmail) = remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onNavigateUp) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_button_back),
                    contentDescription = null,
                    tint = Color(0xFF5A3022)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            SkipComponent(
                onClick = onSkipClick
            )
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Additional information")

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "We do not send spam. We use this\ninformation only for conformations that\nmay be of interest to you",
                textAlign = TextAlign.Center,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(24.dp))

            BirthdateTextField(
                value = birthdate,
                hint = "Date of birth (optional)",
                onValueChange = setBirthdate
            )

            Spacer(modifier = Modifier.height(24.dp))

            EmailTextField(
                value = email,
                hint = "Mail (optional)",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                onValueChange = setEmail
            )

            Spacer(modifier = Modifier.height(32.dp))

            PrimaryButton(
                text = "Continue",
                onNextClick = { onSendAdditional(birthdate, email) },
                isEnabled = birthdate.length == 8 && email.length >= 5
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
fun AdditionalScreenPreview() {
    AdditionalScreen(onNavigateUp = {},
        onSendAdditional = { _, _ -> },
        onSkipClick = {}
    )
}