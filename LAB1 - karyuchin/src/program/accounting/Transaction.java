package program.accounting;

import java.math.BigDecimal;

public record Transaction(int creditID, int creditQuantity, int debitID, int debitQuantity, BigDecimal balance, String comment) {
}
