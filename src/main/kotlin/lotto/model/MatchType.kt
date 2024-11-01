package lotto.model

enum class MatchType(
    val matchingCount: Int,
    val prize: Long,
    val isBonusMatch: Boolean
) {
    NONE(matchingCount = 0, prize = 0, isBonusMatch = false),
    THREE(matchingCount = 3, prize = 5_000, isBonusMatch = false),
    FOUR(matchingCount = 4, prize = 50_000, isBonusMatch = false),
    FIVE_NOT_BONUS(matchingCount = 5, prize = 1_500_000, isBonusMatch = false),
    FIVE_WITH_BONUS(matchingCount = 5, prize = 30_000_000, isBonusMatch = true),
    SIX(matchingCount = 6, prize = 2_000_000_000, isBonusMatch = false)
}