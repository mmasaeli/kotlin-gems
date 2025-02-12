import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.time.withConstantNow
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import java.time.LocalDateTime

class `ForeverNow` : FunSpec({
    test("forever now works like a charm") {
        val foreverNow = LocalDateTime.now()
        withConstantNow(foreverNow) {
            LocalDateTime.now() shouldBe foreverNow
            delay(100) // Code is taking a small amount of time to execute, but now changed!
            LocalDateTime.now() shouldBe foreverNow
        }
    }
    test("same test without forever now fails") {
        val foreverNow = LocalDateTime.now()
        LocalDateTime.now() shouldBe foreverNow
        delay(100) // Code is taking a small amount of time to execute, but now changed!
        LocalDateTime.now() shouldBe foreverNow
    }
})