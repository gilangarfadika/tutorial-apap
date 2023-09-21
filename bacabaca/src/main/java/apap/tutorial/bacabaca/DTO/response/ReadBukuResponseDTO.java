package apap.tutorial.bacabaca.DTO.response;

import lombok.AllArgsConstructor;



import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReadBukuResponseDTO {
    private UUID id;
    
    private BigDecimal harga;
    private String namaPenerbit;
    private String judul;
    private String tahunTerbit;
}