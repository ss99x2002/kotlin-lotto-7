package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Winning

class LottoManager() {

    private var _userLottoNumbers: MutableList<List<Int>> = mutableListOf()
    val userLottoNumbers: List<List<Int>> get() = _userLottoNumbers

    fun generateUserLottoNumbers(count: Int) {
        repeat(count) {
            _userLottoNumbers.add(generateRandomNumber())
        }
    }

    fun checkWinning(userNumbers: List<List<Int>>): List<Winning> {
        userNumbers.forEach {
            getMatchCount()
        }
    }

    fun getMatchCount( ) : Int {

    }

    fun generateRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}