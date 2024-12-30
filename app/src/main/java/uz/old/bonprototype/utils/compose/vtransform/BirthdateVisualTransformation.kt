package uz.old.bonprototype.utils.compose.vtransform

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class BirthdateVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val transformedText = text.toString()
            .mapIndexed { index, c ->
                when (index) {
                    1, 3 -> "$c."
                    else -> c
                }
            }.joinToString("")

        return TransformedText(
            text = AnnotatedString(transformedText),
            offsetMapping = BirthdateOffsetMapping()
        )
    }
}

private class BirthdateOffsetMapping : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
        return when (offset) {
            0, 1 -> offset
            2, 3 -> offset + 1
            else -> offset + 2
        }
    }

    override fun transformedToOriginal(offset: Int): Int {
        return when (offset) {
            0, 1 -> offset
            2, 3 -> offset - 1
            else -> offset - 2
        }
    }
}