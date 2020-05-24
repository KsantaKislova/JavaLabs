package by.gsu.pms;
import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_UP;

class CurrencyConverter {
    public static BigDecimal convert(double money, int divisor, int scale) {
        BigDecimal bigDecimalMoney = new BigDecimal(money/divisor).setScale(scale, ROUND_HALF_UP);
        return bigDecimalMoney;
    }
}
