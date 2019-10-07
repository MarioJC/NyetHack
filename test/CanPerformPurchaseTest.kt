import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CanPerformPurchaseTest {

    @Test
    fun fourDragonCoins() {
        assertFalse { canPerformPurchase(4.0,5.91) }
    }

    @Test
    fun fiveDragonCoins() {
        assertTrue { canPerformPurchase(5.0,5.91) }
    }
}