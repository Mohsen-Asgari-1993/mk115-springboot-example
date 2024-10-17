package ir.maktabsharif115.springboot.pagesetting.document.enumeration;

public enum WalletTransactionPurpose {

    WALLET_INCREASE_BY_ADMIN,
    WALLET_DECREASE_BY_ADMIN,
    WALLET_INCREASE_BY_USER,
    ORDER,
    CANCEL_ORDER;

    public static WalletTransactionPurpose[] getUserPurpose() {
        return new WalletTransactionPurpose[]{
                WALLET_INCREASE_BY_USER,
                ORDER
        };
    }

    public WalletTransactionType getType() {
        return switch (this) {
            case WALLET_INCREASE_BY_ADMIN, WALLET_INCREASE_BY_USER, CANCEL_ORDER -> WalletTransactionType.INCOME;
            case WALLET_DECREASE_BY_ADMIN, ORDER -> WalletTransactionType.OUTCOME;
        };
    }
}
