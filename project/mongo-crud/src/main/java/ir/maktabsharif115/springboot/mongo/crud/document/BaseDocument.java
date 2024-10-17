package ir.maktabsharif115.springboot.mongo.crud.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDocument<ID extends Serializable> implements Serializable {

    public static final String ID = "_id";

    @Id
    private ID id;
}
