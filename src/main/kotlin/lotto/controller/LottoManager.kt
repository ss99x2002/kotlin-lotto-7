package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.model.Winning
import lotto.view.OutputView

class LottoManager(
    private val lotto: Lotto,
    private val outputView: OutputView
) {

    private var _userLottoNumbers: MutableList<Lotto> = mutableListOf()
    val userLottoNumbers: List<Lotto> get() = _userLottoNumbers

    fun generateUserLottoNumbers(count: Int) {
        repeat(count) {
            _userLottoNumbers.add(Lotto(generateRandomNumber()))
        }
    }

    fun checkWinning(winningNumbers: List<Int>, bonusNumber: Int) {
        _userLottoNumbers.forEach {
            it.checkWinningCount(winningNumbers, bonusNumber)
        }
    }

    fun generateRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}