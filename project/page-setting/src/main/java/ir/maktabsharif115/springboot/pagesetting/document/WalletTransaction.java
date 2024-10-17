package ir.maktabsharif115.springboot.pagesetting.document;

import ir.maktabsharif115.springboot.mongo.crud.document.BaseDocument;
import ir.maktabsharif115.springboot.pagesetting.document.enumeration.WalletTransactionPurpose;
import ir.maktabsharif115.springboot.pagesetting.document.enumeration.WalletTransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.ZonedDateTime;

@Document(value = WalletTransaction.DOCUMENT_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WalletTransaction extends BaseDocument<String> {

    public static final String DOCUMENT_NAME = "wallet_transaction";

    public static final String USER_ID = "userId";
    public static final String USER = "user";
    public static final String PERFORMER_ID = "performerId";
    public static final String PERFORMER = "performer";
    public static final String TOTAL_CHANGE = "totalChange";
    public static final String CASH_CHANGE = "cashChange";
    public static final String CREDIT_CHANGE = "creditChange";
    public static final String WALLET_TOTAL = "walletTotal";
    public static final String WALLET_CASH = "walletCash";
    public static final String WALLET_CREDIT = "walletCredit";
    public static final String TYPE = "type";
    public static final String PURPOSE = "purpose";
    public static final String CREATE_DATE = "createDate";

    @Field(USER_ID)
    private Long userId;

    @Field(USER)
    private UserInfo user;

    @Field(PERFORMER_ID)
    private Long performerId;

    @Field(PERFORMER)
    private UserInfo performer;

    @Field(TOTAL_CHANGE)
    private Long totalChange;

    @Field(CASH_CHANGE)
    private Long cashChange;

    @Field(CREDIT_CHANGE)
    private Long creditChange;

    @Field(WALLET_TOTAL)
    private Long walletTotal;

    @Field(WALLET_CASH)
    private Long walletCash;

    @Field(WALLET_CREDIT)
    private Long walletCredit;

    @Field(TYPE)
    private WalletTransactionType type;

    @Field(PURPOSE)
    private WalletTransactionPurpose purpose;

    @Field(CREATE_DATE)
    private ZonedDateTime createDate;
}
