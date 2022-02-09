package br.com.solinftec.treinamentospringboot.resource;

import br.com.solinftec.treinamentospringboot.dto.cooperativa.GetAllCooperativaDto;
import br.com.solinftec.treinamentospringboot.dto.cooperativa.SaveCooperativaDto;
import br.com.solinftec.treinamentospringboot.model.Cooperativa;
import br.com.solinftec.treinamentospringboot.model.Fazendeiro;
import br.com.solinftec.treinamentospringboot.service.CooperativaService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cooperativa")
@RequiredArgsConstructor
public class CooperativaResource {

    
    private final CooperativaService cooperativaService;

    private static final Logger logger = LoggerFactory.getLogger(Cooperativa.class);

   




    @GetMapping()
    public ResponseEntity<List<GetAllCooperativaDto>> getAll(){
        try {
            return ResponseEntity.ok().body(cooperativaService.getAll());
            
        } catch (Exception e) {
            logger.error("Erro ao buscar todas as cooperativas", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/fazendeiros/{idCooperativa}")
    public ResponseEntity<List<Fazendeiro>> getFazendeirosDaCooperativa(@PathVariable("idCooperativa") Long idCooperativa){
        try {
            return ResponseEntity.ok().body(cooperativaService.getFazendeirosDaCooperativa(idCooperativa));
            
        } catch (Exception e) {
            logger.error("Erro ao buscar fazendeiros da cooperativa id {}, erro: {}", idCooperativa, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<SaveCooperativaDto> save(@RequestBody SaveCooperativaDto saveCooperativaDto){
        try {
            return ResponseEntity.ok().body(cooperativaService.save(saveCooperativaDto));
            
        } catch (Exception e) {
            logger.error("Erro ao salvar saveCooperativaDto: {}", saveCooperativaDto);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<SaveCooperativaDto> update(@RequestBody SaveCooperativaDto saveCooperativaDto){
        try {
            return ResponseEntity.ok().body(cooperativaService.update(saveCooperativaDto));
            
        } catch (Exception e) {
            logger.error("Erro ao atualizar saveCooperativaDto: {}, error: {}", saveCooperativaDto, e.getMessage());
            
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idCooperativa}")
    public ResponseEntity<Void> delete(@PathVariable("idCooperativa") Long idCooperativa){
        try {
            cooperativaService.delete(idCooperativa);
            return ResponseEntity.ok().build();
            
        } catch (Exception e) {
            logger.error("Erro ao deletar cooperativa: {}, error: {}", idCooperativa, e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
