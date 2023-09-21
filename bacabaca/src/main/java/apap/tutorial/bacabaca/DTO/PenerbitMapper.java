package apap.tutorial.bacabaca.DTO;

import apap.tutorial.bacabaca.controller.BukuController;
import apap.tutorial.bacabaca.controller.PenerbitController;
import apap.tutorial.bacabaca.DTO.request.CreatePenerbitRequestDTO;
import apap.tutorial.bacabaca.model.Penerbit;
import org.mapstruct.Mapper;

// Maps penerbitDTO to model Penerbit yg bakal connect ke db
@Mapper(componentModel = "spring")
public interface PenerbitMapper {
    Penerbit createPenerbitRequestDTOToPenerbit(CreatePenerbitRequestDTO createPenerbitRequestDTO);
}