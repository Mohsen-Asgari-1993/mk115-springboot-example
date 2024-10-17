package ir.maktabsharif115.springboot.pagesetting.document;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FooterRow implements Serializable {

    @NotBlank
    private String title;

    private String link;
}
