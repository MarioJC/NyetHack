import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CanPerformPurchaseTest {



    @Test
    fun tenGoldPieces() {
        assertTrue (canPerformPurchase(10, 0, 5.91))
    }

    @Test
    fun tenSilverPieces() {
        assertFalse (canPerformPurchase(0, 10, 5.91))
    }

    @Test
    fun notEnough() {
        assertFalse (canPerformPurchase(0, 0, 5.91))
        assertFalse (canPerformPurchase(10, 0, 10.01))
    }

    @Test
    fun exactlyEnough() {
        assertTrue (canPerformPurchase(10, 0, 10.00))
        assertTrue (canPerformPurchase(0, 100, 1.00))
        assertTrue (canPerformPurchase(10, 10, 10.10))
        assertTrue (canPerformPurchase(10, 1, 10.01))
    }
}