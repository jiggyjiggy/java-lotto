package lotto;

import lotto.model.Lotto;
import lotto.service.AppService;

import java.math.BigInteger;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        try {
            AppService appService = new AppService();

            BigInteger money = appService.insertMoney();

            List<Lotto> lottos = appService.purchaseLottos(money);

            List<Integer> winningNumbers = appService.inputWinningNumbers();
            Integer bonusNumber = appService.inputBonusNumbers(winningNumbers);
            appService.printResultOfLottos(winningNumbers, bonusNumber, lottos, money);

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
