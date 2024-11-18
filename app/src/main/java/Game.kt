import com.google.firebase.annotations.concurrent.Background
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class Game(val scope: CoroutineScope, val screenW:Int, val screenH: Int) {
    var counter = 0
    val state = MutableStateFlow(0)
    val background = Background(screenW)

    fun Play(){
        scope.launch {
            counter = 0
            while (counter<5000) {
                delay(40)
                background.Roll()
                counter++
                state.emit(counter)
            }
        }
    }