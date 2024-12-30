package uz.old.bonprototype.utils.compose.vtransform

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneNumberVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val transformedText = text.toString()
            .mapIndexed { index, c ->
                when (index) {
                    1 -> "$c "
                    4,6 -> "$c "
                    else -> c
                }
            }.joinToString("")

        return TransformedText(
            text = AnnotatedString(transformedText),
            offsetMapping = PhoneNumberOffsetMapping()
        )
    }
}

private class PhoneNumberOffsetMapping : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
        return when {
            offset in 2..4 -> offset + 1
            offset in 5..6 -> offset + 2
            offset > 6 -> offset + 3
            else -> offset
        }
    }

    override fun transformedToOriginal(offset: Int): Int {
        return when {
            offset in 2..4 -> offset - 1
            offset in 5..6 -> offset - 2
            offset > 6 -> offset - 3
            else -> offset
        }
    }
}