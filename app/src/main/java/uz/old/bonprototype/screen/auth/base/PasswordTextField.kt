package uz.old.bonprototype.screen.auth.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import uz.old.bonprototype.R

@Composable
internal fun PasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    hint: Any,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.Next
    ),
    onValueChange: (String) -> Unit,
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

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
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(
            mask = '*'
        ),
        keyboardOptions = keyboardOptions,
        placeholder = {
            val hintParsed = when (hint) {
                is Int -> stringResource(id = hint)
                else -> hint.toString()
            }

            Text(text = hintParsed)
        },
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    painter = painterResource(id = if (passwordVisible) R.drawable.ic_eye else R.drawable.ic_eye_closed),
                    contentDescription = null,
                    tint = Color(0xFF5A3022)
                )
            }
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