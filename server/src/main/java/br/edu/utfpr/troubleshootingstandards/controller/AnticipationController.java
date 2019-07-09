package br.edu.utfpr.troubleshootingstandards.controller;

import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.model.Modalitie;
import br.edu.utfpr.troubleshootingstandards.model.ReasonBy;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.EntityNotFoundException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import br.edu.utfpr.troubleshootingstandards.service.AnticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class AnticipationController {

    @Autowired
    private AnticipationService anticipationService;

    @GetMapping("/anticipations")
    public ResponseEntity<List<ProposalAnticipationDTO>> getAll() {
        return ResponseEntity.ok(anticipationService.getAll());
    }

    @PostMapping("/anticipations")
    public ResponseEntity<ProposalAnticipationDTO> save(@Valid @RequestBody ProposalAnticipationDTO proposalAnticipationDTO) throws ExceededAntecipationClassException, DateAnticipationException {
            anticipationService.include(proposalAnticipationDTO);
            return ResponseEntity.status(201).body(proposalAnticipationDTO);
    }

    @GetMapping ("/anticipations/{id}")
    public ResponseEntity<ProposalAnticipationDTO> getById(@PathVariable Long id) throws EntityNotFoundException {
        Optional<ProposalAnticipationDTO> clienteEncontrado = anticipationService.getById(id);
        return ResponseEntity.of(clienteEncontrado);
    }

    @DeleteMapping ("/anticipations/{id}")
    public ResponseEntity excluir (@PathVariable long id) {
            anticipationService.delete(id);
            return ResponseEntity.noContent().build();
    }

    @PutMapping("/anticipations/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody ProposalAnticipationDTO proposalAnticipationDTO, @PathVariable long id) throws ExceededAntecipationClassException, DateAnticipationException, EntityNotFoundException {

        Optional<ProposalAnticipationDTO> proposalAnticipation = anticipationService.getById(id);

        if (!proposalAnticipation.isPresent())
            return ResponseEntity.notFound().build();

        proposalAnticipationDTO.setId(id);

        anticipationService.include(proposalAnticipationDTO);

        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/anticipations/{id}/approvals")
    public ResponseEntity<ApprovalAnticipationDTO> getByAprroval(@PathVariable Long id) {
        Optional<ApprovalAnticipationDTO> approvalAnticipationDTO = anticipationService.getByIdApproval(id);
        return ResponseEntity.of(approvalAnticipationDTO);
    }

    @GetMapping("/anticipations/modalities")
    public ResponseEntity<Modalitie[]> getModalities() {
        return ResponseEntity.of(Optional.of(Modalitie.values()));
    }

    @GetMapping("/anticipations/reasons")
    public ResponseEntity<ReasonBy[]> getReasons() {
        return ResponseEntity.of(Optional.of(ReasonBy.values()));
    }

}
