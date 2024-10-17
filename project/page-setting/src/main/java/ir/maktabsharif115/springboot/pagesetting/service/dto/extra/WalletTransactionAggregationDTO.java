package ir.maktabsharif115.springboot.pagesetting.service.dto.extra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WalletTransactionAggregationDTO implements Serializable {

    private Long userId;

    private Long totalChange;
}
