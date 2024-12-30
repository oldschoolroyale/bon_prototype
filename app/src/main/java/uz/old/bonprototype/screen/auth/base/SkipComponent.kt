package uz.old.bonprototype.screen.auth.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
internal fun SkipComponent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Text(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFFE5E0D6))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(
                    color = Color(0xFF000000).copy(
                        alpha = 0.16f
                    )
                ),
                onClick = onClick
            )
            .padding(horizontal = 8.dp, vertical = 4.dp),
        text = "Skip"
    )
}