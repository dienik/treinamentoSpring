package br.com.solinftec.treinamentospringboot.service;

import br.com.solinftec.treinamentospringboot.dto.cooperativa.GetAllCooperativaDto;
import br.com.solinftec.treinamentospringboot.dto.cooperativa.SaveCooperativaDto;
import br.com.solinftec.treinamentospringboot.model.Cooperativa;
import br.com.solinftec.treinamentospringboot.model.Fazendeiro;
import br.com.solinftec.treinamentospringboot.repository.CooperativaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CooperativaService {

    private final CooperativaRepository cooperativaRepository;

    @PostConstruct
    public void init() {

        System.out.println(cooperativaRepository.findAll());
    }

    public List<GetAllCooperativaDto> getAll() {

        return cooperativaRepository.findAll()
                .stream().map(cooperativa -> new GetAllCooperativaDto(cooperativa)).toList();
    }

    public List<Fazendeiro> getFazendeirosDaCooperativa(Long idCooperativa) {

        Optional<Cooperativa> cooperativa = cooperativaRepository.findById(idCooperativa);

        if (cooperativa.isPresent()) {
            return cooperativa.get().getFazendeiros();
        } else {
            return new ArrayList<>();
        }
    }

    public SaveCooperativaDto save(SaveCooperativaDto saveCooperativaDto) {
        Cooperativa cooperativa = saveCooperativaDto.pegarModel();
        cooperativaRepository.save(cooperativa);
        saveCooperativaDto.setId(cooperativa.getId());
        return saveCooperativaDto;

    }

    public SaveCooperativaDto update(SaveCooperativaDto saveCooperativaDto) throws Exception {
        Optional<Cooperativa> cooperativa = cooperativaRepository.findById(saveCooperativaDto.getId());
        if (cooperativa.isPresent()) {

            cooperativaRepository.save(saveCooperativaDto.pegarModel());
            return saveCooperativaDto;
        } else {
            throw new Exception("Cooperativa não encontrada");
        }

    }

    public void delete(Long idCooperativa) {
        Optional<Cooperativa> cooperativa = cooperativaRepository.findById(idCooperativa);
        if (cooperativa.isPresent()) {
            cooperativaRepository.delete(cooperativa.get());
        } else {
            throw new RuntimeException("Cooperativa não encontrada");
        }
    }

}