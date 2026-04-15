package codes.tanis.demojug.common;

import java.math.BigDecimal;

public final class Amount {

    private final BigDecimal amount;

    private Amount(BigDecimal amount) {
        this.amount = amount;
    }

    public static Amount of(BigDecimal amount) {
        return new Amount(amount);
    }

    public BigDecimal amount() {
        return amount;
    }

}
