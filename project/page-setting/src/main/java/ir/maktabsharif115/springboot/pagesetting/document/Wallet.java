package ir.maktabsharif115.springboot.pagesetting.document;

import ir.maktabsharif115.springboot.mongo.crud.document.BaseDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = Wallet.DOCUMENT_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Wallet extends BaseDocument<String> {

    public static final String DOCUMENT_NAME = "wallet";

    private Long cash = 0L;

    private Long credit = 0L;

    private Long total = 0L;

    @Indexed
    private Long userId;

    private UserInfo user;

}
