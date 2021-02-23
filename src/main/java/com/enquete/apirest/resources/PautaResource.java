package com.enquete.apirest.resources;

import com.enquete.apirest.models.Pauta;
import com.enquete.apirest.models.Associado;
import com.enquete.apirest.models.Voto;
import com.enquete.apirest.models.Votacao;

import com.enquete.apirest.repository.VotacaoRepository;
import com.enquete.apirest.repository.PautaRepository;
import com.enquete.apirest.repository.AssociadoRepository;
import com.enquete.apirest.repository.VotoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pauta")
@Api(value = "API REST PAUTA")
@CrossOrigin(origins = "*")
public class PautaResource {

    @Autowired
    PautaRepository pautaRepository;

    @Autowired
    VotacaoRepository votacaoRepository;

    @Autowired
    VotoRepository votoRepository;

    @Autowired
    AssociadoRepository associadoRepository;

    @GetMapping("/listar-todas")
    @ApiOperation(value = "Retorna uma lista de enquetes")
    public List<Pauta> getListPolls() {
        return pautaRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna uma enquete por ID")
    public ResponseEntity<?> getPoll(@PathVariable(value = "id") long id) {
        Pauta pauta = pautaRepository.findById(id);

        return !(pauta == null) ? ResponseEntity.ok(pauta) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    @ApiOperation(value = "Grava uma enquete com suas opções")
    public ResponseEntity<Pauta> postPauta(@RequestBody Pauta pauta) {
        Pauta pautaSalva = pautaRepository.save(pauta);

        return ResponseEntity.status(HttpStatus.CREATED).body(pautaSalva);
    }

    @PostMapping("/votacao")
    @ApiOperation(value = "Grava uma enquete com suas opções")
    public ResponseEntity<Votacao> postVotacao(@RequestBody Votacao votacao) {
        Votacao votacaoSalva = votacaoRepository.save(votacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(votacao);
    }

    @PostMapping("/Associado")
    @ApiOperation(value = "Grava uma enquete com suas opções")
    public ResponseEntity<Associado> postAssociado(@RequestBody Associado associado) {
        Associado associadoSalvo = associadoRepository.save(associado);

        return ResponseEntity.status(HttpStatus.CREATED).body(associadoSalvo);
    }

    @PostMapping("/{id}/voto")
    @ApiOperation(value = "Grava um voto passando o ID do associado")
    public ResponseEntity<String> postVoto(@PathVariable(value = "id") long id) {
        Associado associado = associadoRepository.findById(id);
        Voto voto = votoRepository.buscarAssociado(id);

        if (associado != null && voto == null) {
            Voto voteNew = new Voto();
            votoRepository.save(voteNew);
        }

        return (voto == null) ? ResponseEntity.ok("Voto registrado") : ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}/stats")
    @ApiOperation(value = "Retorna estatísticas de uma enquete, passando o ID da enquete")
    public ResponseEntity<?> getStats(@PathVariable(value = "id") long id) {

        Pauta pauta = pautaRepository.findById(id);
        Associado associado = new Associado();
        if (pauta != null) {
            associado = associadoRepository.findById(id);
        }

        return !(pauta == null) ? ResponseEntity.ok(associado) : ResponseEntity.notFound().build();
    }

}

