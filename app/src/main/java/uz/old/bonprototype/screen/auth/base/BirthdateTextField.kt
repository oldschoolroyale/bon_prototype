package uz.old.bonprototype.screen.auth.base

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import uz.old.bonprototype.utils.compose.vtransform.BirthdateVisualTransformation

@Composable
fun BirthdateTextField(
    modifier: Modifier = Modifier,
    value: String,
    hint: Any,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.NumberPassword,
        imeAction = ImeAction.Next
    ),
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        value = value,
        onValueChange = {
            if (it.isBlank() || (it.length <= 8 && it.isDigitsOnly())) {
                onValueChange(it)
            }
        },
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        visualTransformation = BirthdateVisualTransformation(),
        keyboardOptions = keyboardOptions,
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
            cursorColor = Color(0xFF252525),
            focusedPlaceholderColor = Color(0xFF9D9D9D),
            unfocusedPlaceholderColor = Color(0xFF9D9D9D),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}