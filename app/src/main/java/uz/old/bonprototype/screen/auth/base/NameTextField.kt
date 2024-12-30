package uz.old.bonprototype.screen.auth.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
internal fun NameTextField(
    modifier: Modifier = Modifier,
    value: String,
    hint: Any,
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        value = value,
        onValueChange = {
            if (it.isBlank() || (it.length <= 50)) {
                onValueChange(it)
            }
        },
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Unspecified,
            imeAction = ImeAction.Done
        ),
        placeholder = {
            val hintParsed = when (hint) {
                is Int -> stringResource(id = hint)
                else -> hint.toString()
            }

            Text(text = hintParsed)
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFFFFFFF),
            unfocusedContainerColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFFFFFFFF),
            disabledPlaceholderColor = Color(0xFF252525),
            focusedPrefixColor = Color(0xFF252525),
            unfocusedPrefixColor = Color(0xFF252525),
            cursorColor = Color(0xFF252525),
            focusedTextColor = Color(0xFF342621),
            unfocusedTextColor = Color(0xFF342621),
            focusedPlaceholderColor = Color(0xFF9D9D9D),
            unfocusedPlaceholderColor = Color(0xFF9D9D9D),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}