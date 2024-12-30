package uz.old.bonprototype.screen.auth.onboarding

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun AuthSwitcher(
    modifier: Modifier = Modifier
) {
    val (selected, setSelected) = remember {
        mutableIntStateOf(0)
    }
    CustomTab(
        modifier = modifier,
        selectedItemIndex = selected,
        items = listOf("Entrance", "Registration"),
        onClick = setSelected
    )
}

@Composable
fun CustomTab(
    modifier: Modifier = Modifier,
    selectedItemIndex: Int,
    items: List<String>,
    onClick: (Int) -> Unit,
) {
    val tabWidth = 184.dp

    val indicatorOffset: Dp by animateDpAsState(
        targetValue = if (selectedItemIndex == 0) 0.dp else (tabWidth * selectedItemIndex) + 4.dp,
        animationSpec = tween(easing = LinearEasing), label = "",
    )

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF1F0ED))
            .height(44.dp)
    ) {
        MyTabIndicator(
            indicatorWidth = tabWidth,
            indicatorOffset = indicatorOffset,
            indicatorColor = Color.White,
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clip(RoundedCornerShape(8.dp)),
        ) {
            items.mapIndexed { index, text ->
                val isSelected = index == selectedItemIndex
                MyTabItem(
                    isSelected = isSelected,
                    onClick = { onClick(index) },
                    tabWidth = tabWidth,
                    text = text,
                )
            }
        }
    }
}

@Composable
private fun MyTabItem(
    isSelected: Boolean,
    onClick: () -> Unit,
    tabWidth: Dp,
    text: String,
) {
    val tabTextColor: Color by animateColorAsState(
        targetValue = if (isSelected) {
            Color(0xFF342621)
        } else {
            Color(0x8092806B)
        },
        animationSpec = tween(easing = LinearEasing), label = "",
    )

    Box(
        modifier = Modifier
            .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
            .width(tabWidth)
            .height(36.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = tabTextColor
        )
    }
}


@Composable
private fun MyTabIndicator(
    modifier: Modifier = Modifier,
    indicatorWidth: Dp,
    indicatorOffset: Dp,
    indicatorColor: Color,
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .width(width = indicatorWidth)
            .height(36.dp)
            .offset(x = indicatorOffset)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = indicatorColor)
    )
}