package lotto.model

class Lotto(private val numbers: List<Int>) {

    private var winningCounts: MutableMap<Winning, Int> = Winning.values().associateWith { 0 }.toMutableMap()

    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.all { it in 1..45 }) { "[ERROR] 로또 번호는 1부터 45 사이여야 합니다." }
        require(numbers.distinct().size == 6) { "[ERROR] 로또 번호는 중복될 수 없습니다." }
    }

    fun checkWinningCount(winningNumbers: List<Int>, bonusNumber: Int) {
        val matchCount = matchWinningNumber(winningNumbers)
        val isBonusMatch = numbers.contains(bonusNumber)
        updateWinningCount(matchCount, isBonusMatch)
    }

    private fun updateWinningCount(matchCount: Int, isBonusMatch: Boolean) {
        when (matchCount) {
            3 -> incrementCount(Winning.THREE)
            4 -> incrementCount(Winning.FOUR)
            5 -> incrementCount(if (isBonusMatch) Winning.FIVE_BONUS else Winning.FIVE_NOT_BONUS)
            6 -> incrementCount(Winning.SIX)
        }
    }

    private fun incrementCount(winning: Winning) {
        winningCounts[winning] = (winningCounts[winning] ?: 0) + 1
    }

    private fun matchWinningNumber(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun getWinningCounts(): Map<Winning, Int> = winningCounts.toMap()
    fun getNumbers(): List<Int> = numbers
}