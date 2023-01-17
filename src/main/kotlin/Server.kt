import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date

fun main() {
    val timeFormat = SimpleDateFormat("HH:mm:ss")

    embeddedServer(Netty, port = 7070) {
        install(WebSockets)

        routing {
            webSocket("/time") {
                while (true) {
                    send(Frame.Text(timeFormat.format(Date())))
                    delay(1000)
                }
            }
        }
    }.start(wait = true)
}