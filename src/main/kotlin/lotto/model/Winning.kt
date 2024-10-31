package lotto.model

enum class Winning(
    private var count: Int = 0,
    val price: Int) {

    NONE(price = 0),
    THREE(price = 5_000),
    FOUR(price = 50_000),
    FIVE_NOT_BONUS(price = 1_500_000),
    FIVE_BONUS(price = 30_000_000),
    SIX(price = 2_000_000_000);

    fun increase() {
        count++
    }

    fun getCount(): Int = count

    fun clear() {
        count = 0
    }
}