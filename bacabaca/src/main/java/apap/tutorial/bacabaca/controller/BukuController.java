package apap.tutorial.bacabaca.controller;

import apap.tutorial.bacabaca.DTO.BukuMapper;
import apap.tutorial.bacabaca.DTO.request.CreateBukuRequestDTO;
import apap.tutorial.bacabaca.DTO.request.SearchBukuRequestDTO;
import apap.tutorial.bacabaca.DTO.request.UpdateBukuRequestDTO;
import apap.tutorial.bacabaca.model.Buku;
import apap.tutorial.bacabaca.repository.BukuDB;
import apap.tutorial.bacabaca.service.BukuService;
import apap.tutorial.bacabaca.service.PenerbitService;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
// Using Path Variable
import org.springframework.web.bind.annotation.*;

@Controller
public class BukuController {
    // BukuMapper
    @Autowired
    private BukuMapper bukuMapper;

    // Services
    @Autowired
    private BukuService bukuService;

    @Autowired
    private PenerbitService penerbitService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("buku/create")
    public String formAddBuku(Model model) {
        // New DTO for users answers
        var bukuDTO = new CreateBukuRequestDTO();
        

        model.addAttribute("bukuDTO", bukuDTO);
        model.addAttribute("listPenerbit", penerbitService.getAllPenerbit());

        return "form-create-buku";
    }

    @PostMapping("buku/create")
    public String addBuku(@Valid @ModelAttribute  CreateBukuRequestDTO bukuDTO, Model model ,
    BindingResult bindingResult) {
       

        if (bindingResult.hasErrors()){

            return errorhandler(bindingResult, model);

        }

         // Validate judul
        else if (bukuService.isJudulExist(bukuDTO.getJudul())) {
            // model.addAttribute("judul", bukuDTO.getJudul());
            // return "warning-title-exists";
            var errorMessage = "Maaf, judul buku sudah ada";
            model.addAttribute("errorMessage", errorMessage);
            return "error-view";
        }

        else {
            var buku = bukuMapper.createBukuRequestDTOToBuku(bukuDTO);
            // Call service addBuku
            bukuService.saveBuku(buku);

            // Add variable id buku to "id" to be rendered at thyme
            model.addAttribute("id", buku.getId());
            // Add variable judul ke 'judul' to be rendered di thyme
            model.addAttribute("judul", buku.getJudul());

            return "success-create-buku";
        }
        
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) 
    public String errorhandler(BindingResult bindingResult, Model model) {
        List<String> errorMassage = new ArrayList<>();

        for (FieldError error : bindingResult.getFieldErrors()) {

            errorMassage.add(error.getDefaultMessage());
        }

        model.addAttribute("errorMessage", errorMassage);

        return "error-view";
        
    }

    @GetMapping("buku/viewall")
    public String listBuku(Model model) {
        // Get all books in list
        List<Buku> listBuku = bukuService.getAllBuku();
        
        var bukuDTO = new  SearchBukuRequestDTO();

        // Add variable list of Buku models to be rendered at thyme
        model.addAttribute("listBuku", listBuku);
        model.addAttribute("bukuDTO", bukuDTO);
        return "viewall-buku";
    }

    @PostMapping("buku/viewall")
    public String searchBuku (@Valid @ModelAttribute SearchBukuRequestDTO bukuDTO, Model model){

        var listBuku = bukuService.getBukuByJudul(bukuDTO.getJudul());
        model.addAttribute("listBuku", listBuku);
        model.addAttribute("bukuDTO", bukuDTO);

        return "viewall-buku";
        
    }

    @GetMapping(value = "/buku/{id}")
    public String detailBuku(@PathVariable(value = "id") UUID id, Model model) {
       
        var bukuById = bukuService.getBukuById(id);
        var buku = bukuMapper.bukuToReadBukuResponseDTO(bukuById);

        
        model.addAttribute("buku", buku);
        return "view-buku";
    }

    // TODO: Method ke page form update buku
    @GetMapping(value = "/buku/{id}/update")
    public String formUpdateBuku(@Valid @PathVariable(value = "id") UUID id, Model model) {
       
        var buku = bukuService.getBukuById(id);
        var bukuDTO = bukuMapper.bukuToUpdateBukuRequestDTO(buku);

        // Variables to be rendered at thyme
        model.addAttribute("listPenerbit", penerbitService.getAllPenerbit());
        model.addAttribute("bukuDTO", bukuDTO);

        return "form-update-buku";
    }

    // TODO: Method untuk update buku
    @PostMapping("buku/update")
    public String updateBuku(@Valid @ModelAttribute  UpdateBukuRequestDTO bukuDTO, Model model ,
    BindingResult bindingResult) {

        if (bindingResult.hasErrors()){

            return errorhandler(bindingResult, model);

        }

        if (bukuService.isJudulExist(bukuDTO.getJudul(), bukuDTO.getId())) {
            // model.addAttribute("judul", bukuDTO.getJudul());
            // model.addAttribute("id", bukuDTO.getId());
            // return "warning-title-edit";
            var errorMessage = "Maaf, judul buku sudah ada";
            model.addAttribute("errorMessage", errorMessage);
            return "error-view";
        }

        var bukuFromDTO = bukuMapper.updateBukuRequestDTOToBuku(bukuDTO);

        
        var buku = bukuService.updateBuku(bukuFromDTO);

        model.addAttribute("id", buku.getId());
        model.addAttribute("judul", buku.getJudul());

        return "success-update-buku";
    }

    // TODO: Method untuk hapus selected buku
    @GetMapping("/buku/{id}/delete")
    public String deleteBuku(@PathVariable("id") UUID id, Model model) {
        
        var buku = bukuService.getBukuById(id);

    
        bukuService.deleteBuku(buku);

       
        model.addAttribute("deletedId", id);

        return "success-delete-buku";
    }

    


}