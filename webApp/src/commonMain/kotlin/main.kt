import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import me.tbsten.tuple.skill.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() = ComposeViewport { App() }
