package ir.maktabsharif115.springboot.pagesetting.document;

import ir.maktabsharif115.springboot.mongo.crud.document.BaseDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(value = Footer.DOCUMENT_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Footer extends BaseDocument<String> {

    public static final String DOCUMENT_NAME = "footer";

    public static final String COLUMNS = "columns";

    @Field(value = COLUMNS)
    private List<FooterColumn> columns = new ArrayList<>();

//    @Indexed(unique = true)
//    private String key;
}
