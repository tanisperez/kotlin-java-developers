package codes.tanis.demojug.common;

import java.util.Objects;

public final class Currency {

    public static Currency EUR = Currency.from("EUR");
    public static Currency USD = Currency.from("USD");

    private final String code;

    private Currency(String code) {
        this.code = code;
    }

    public static Currency from(String code) {
        return new Currency(code);
    }

    public String code() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;
        return Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    @Override
    public String toString() {
        return "Currency{code='" + code + "'}";
    }
}
