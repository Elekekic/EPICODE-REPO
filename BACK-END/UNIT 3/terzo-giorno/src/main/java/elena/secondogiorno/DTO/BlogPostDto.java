package elena.secondogiorno.DTO;

import lombok.Data;

@Data
public class BlogPostDto {

    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
    private int autoreId;

}
