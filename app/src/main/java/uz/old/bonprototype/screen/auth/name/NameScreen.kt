package uz.old.bonprototype.screen.auth.name

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.old.bonprototype.R
import uz.old.bonprototype.screen.auth.base.NameTextField
import uz.old.bonprototype.screen.base.PrimaryButton
import uz.old.bonprototype.ui.theme.BonPrototypeTheme
import java.util.Locale

@Composable
fun NameScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    onSendName: (String) -> Unit
) {
    val (name, setName) = remember { mutableStateOf("") }

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
            Text(text = "What is your name?")

            Text(
                text = "Please enter your name so we know\nhow to address you.",
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(14.dp))

            NameTextField(
                value = name,
                hint = "Enter your name",
                onValueChange = setName
            )

            Spacer(modifier = Modifier.height(22.dp))

            PrimaryButton(
                text = "Continue",
                onNextClick = { onSendName(name) },
                isEnabled = name.length >= 3
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Preview
@Composable
fun NameScreenPreview(modifier: Modifier = Modifier) {
    BonPrototypeTheme {
        NameScreen(
            onNavigateUp = {},
            onSendName = {}
        )
    }
}