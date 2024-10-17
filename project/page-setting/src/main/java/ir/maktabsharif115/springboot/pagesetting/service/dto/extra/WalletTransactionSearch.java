package ir.maktabsharif115.springboot.pagesetting.service.dto.extra;

import ir.maktabsharif115.springboot.pagesetting.document.enumeration.WalletTransactionPurpose;
import ir.maktabsharif115.springboot.pagesetting.document.enumeration.WalletTransactionType;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletTransactionSearch implements Serializable {

    private Long userId;

    private String userFirstName;

    private String userLastName;

    private String userUsername;

    private WalletTransactionType type;

    private WalletTransactionPurpose purpose;

    private ZonedDateTime fromCreateDate;

    private ZonedDateTime toCreateDate;

    private Long fromTotalChange;

    private Long toTotalChange;
}
