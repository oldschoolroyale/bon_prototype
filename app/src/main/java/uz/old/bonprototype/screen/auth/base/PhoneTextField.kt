package uz.old.bonprototype.screen.auth.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import uz.old.bonprototype.R
import uz.old.bonprototype.utils.compose.vtransform.PhoneNumberVisualTransformation

@Composable
internal fun PhoneTextField(
    modifier: Modifier = Modifier,
    value: String,
    hint: Any,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.NumberPassword,
        imeAction = ImeAction.Next
    ),
    onCountryClick: () -> Unit,
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        value = value,
        onValueChange = {
            if (it.isBlank() || (it.length <= 9 && it.isDigitsOnly())) {
                onValueChange(it)
            }
        },
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        visualTransformation = PhoneNumberVisualTransformation(),
        keyboardOptions = keyboardOptions,
        placeholder = {
            val hintParsed = when (hint) {
                is Int -> stringResource(id = hint)
                else -> hint.toString()
            }

            Text(text = hintParsed)
        },
        leadingIcon = {
            Row(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .height(60.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
                    .background(
                        Color(0xFFF1F0ED),
                        RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)
                    )
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(
                            color = Color(0xFF000000).copy(
                                alpha = 0.16f
                            )
                        ),
                        onClick = onCountryClick
                    )
                    .padding(start = 16.dp, end = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "998"
                )

                Icon(
                    modifier = Modifier.size(10.dp),
                    painter = painterResource(id = R.drawable.ic_direction_down),
                    contentDescription = null,
                    tint = Color(0xFF252525)
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