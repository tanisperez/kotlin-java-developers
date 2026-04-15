package codes.tanis.demojug.common;

import java.util.Objects;

public class Money {

    private final Amount amount;
    private final Currency currency;

    private Money(Amount amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money of(Amount amount, Currency currency) {
        return new Money(amount, currency);
    }

    public Amount amount() {
        return amount;
    }

    public Currency currency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;
        return Objects.equals(amount, money.amount) && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(amount);
        result = 31 * result + Objects.hashCode(currency);
        return result;
    }

    @Override
    public String toString() {
        return "Money{amount=" + amount + ", currency=" + currency + '}';
    }
}
