package lotto

import lotto.controller.LottoController
import lotto.validator.InputValidator
import lotto.service.LottoService
import lotto.handler.InputHandler
import lotto.handler.OutputHandler
import lotto.service.LottoCounterService
import lotto.service.LottoMatchService
import lotto.view.InputView
import lotto.view.MainView
import lotto.view.OutputView

fun main() {

    val inputHandler = InputHandler(InputView(), InputValidator())
    val outputHandler = OutputHandler(OutputView())
    val lottoController = LottoController(LottoService(LottoCounterService(), LottoMatchService()))
    val mainView = MainView(inputHandler, outputHandler, lottoController)
    mainView.start()
}
