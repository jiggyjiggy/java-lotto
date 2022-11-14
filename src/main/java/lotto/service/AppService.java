package lotto.service;

import lotto.domain.Machine;
import lotto.domain.User;
import lotto.model.Lotto;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class AppService {
    User user = new User();

    public BigInteger insertMoney() {
        Machine.Message.announceInsertMoney();
        return user.insertMoney();
    }

    public List<Lotto> purchaseLottos(BigInteger money) {
        BigInteger numberOfLottos = Machine.countNumberOfLottos(money);
        Machine.Message.announceNumberOfPurchases(numberOfLottos);
        List<Lotto> lottos = Machine.generateLottos(numberOfLottos);
        Machine.Message.printLottos(lottos);
        return lottos;
    }

    public List<Integer> inputWinningNumbers() {
        Machine.Message.announceInputWinningNumbers();
        return user.inputWinningNumbers();
    }
    public Integer inputBonusNumbers(List<Integer> winningNumbers) {
        Machine.Message.announceInputBonusNumber();
        return user.inputBonusNumber(winningNumbers);

    }

    public void printResultOfLottos(
            List<Integer> winningNumbers,
            Integer bonusNumber,
            List<Lotto> lottos,
            BigInteger money
    ) {
        Machine machine = new Machine(winningNumbers, bonusNumber);
        Map<String, Integer> resultOfLottos = machine.judge(lottos);
        double ratio = machine.calculateRatioOfWinningsToInsertMoney(resultOfLottos, money);
        Machine.Message.printResultOfLottos(resultOfLottos, ratio);
    }

}
