package lotto.view

import lotto.controller.LottoController
import lotto.handler.InputHandler
import lotto.handler.OutputHandler

class MainView(
    private val inputHandler: InputHandler,
    private val outputHandler: OutputHandler,
    private val lottoController: LottoController
) {

    fun start() {
        while (true) {
            try {
                lottoController.clearLottoNumbers()
                // 구매
                val count = inputPurchaseCount()

                // 유저 로또 번호, 당첨 번호, 보너스 번호
                generateNumbers(count)
                val winningNumbers = inputHandler.inputWinningNumbers()
                val bonusNumber = inputHandler.inputBonusNumber(winningNumbers)

                // 당첨 확인 및 통계 출력
                checkWinning(winningNumbers, bonusNumber)
                checkEarningRate(count)

            } catch (e: Exception) {
                println("[ERROR]" + e.message)
            }
        }
    }

    fun inputPurchaseCount(): Int {
        val count = inputHandler.inputPurchaseCount()
        outputHandler.printPurchaseCount(count)
        return count
    }

    fun generateNumbers(count: Int) {
        val generatedNumbers = lottoController.generateUserLottoNumbers(count)
        outputHandler.printGeneratedNumbers(generatedNumbers)
    }

    fun checkWinning(winningNumbers: List<Int>, bonusNumber: Int) {
        lottoController.checkWinning(winningNumbers, bonusNumber)
        outputHandler.printWinningStatistics(lottoController.getWinningResult())
    }

    fun checkEarningRate(count: Int) {
        val earningRate = lottoController.calculateEarningRate(count)
        outputHandler.printEarningRate(earningRate)
    }
}