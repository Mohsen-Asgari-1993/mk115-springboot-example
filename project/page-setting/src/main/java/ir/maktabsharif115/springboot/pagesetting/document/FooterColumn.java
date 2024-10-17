package ir.maktabsharif115.springboot.pagesetting.document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FooterColumn implements Serializable {

    @NotBlank
    private String title;

    @NotNull
    @Size(min = 1)
    private List<FooterRow> rows = new ArrayList<>();
}
