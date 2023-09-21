package apap.tutorial.bacabaca.DTO.request;

import apap.tutorial.bacabaca.model.Penerbit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBukuRequestDTO {
    @NotEmpty(message = "Judul tidak boleh kosong")
    @Size(max = 100 , message = "Tema judul tidak boleh terlalu panjang")
    private String judul;

    @NotEmpty(message = "Tahun terbit tidak boleh kosong")
    @Size(max = 4 , message = "Tahun terbit hanya boleh terdiri dari 4 digit angka")
    private String tahunTerbit;
    
    @NotNull(message = "Harga tidak boleh kosong")
    private BigDecimal harga;

    @NotNull(message = "Penerbit tidak boleh kosong")
    private Penerbit penerbit;
}