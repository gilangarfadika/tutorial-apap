package apap.tutorial.bacabaca.DTO;

import apap.tutorial.bacabaca.model.Buku;
import apap.tutorial.bacabaca.DTO.request.CreateBukuRequestDTO;
import apap.tutorial.bacabaca.DTO.request.CreatePenerbitRequestDTO;
import apap.tutorial.bacabaca.DTO.request.UpdateBukuRequestDTO;
import apap.tutorial.bacabaca.DTO.response.ReadBukuResponseDTO;
import apap.tutorial.bacabaca.model.Buku;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.github.javafaker.Book;


@Mapper(componentModel = "spring")
public interface BukuMapper {


    Buku createBukuRequestDTOToBuku(CreateBukuRequestDTO bukuDTO);

    Buku updateBukuRequestDTOToBuku(UpdateBukuRequestDTO updateBukuRequestDTO);

    UpdateBukuRequestDTO bukuToUpdateBukuRequestDTO(Buku buku);

    @Mapping(target = "namaPenerbit" , ignore = true)
    ReadBukuResponseDTO bukuToReadBukuResponseDTO(Buku buku);

    @AfterMapping
    default void setPenerbit(@MappingTarget  ReadBukuResponseDTO bukuToReadBukuResponseDTO , Buku buku) {
         bukuToReadBukuResponseDTO.setNamaPenerbit(buku.getPenerbit().getNamaPenerbit());
    }
}