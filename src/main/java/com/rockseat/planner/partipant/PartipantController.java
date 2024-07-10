package com.rockseat.planner.partipant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/participants")
public class PartipantController {

    @Autowired
    private ParticipantRepository repository;


    @PostMapping("/{id}/confirm")
    public ResponseEntity<Participant> confirmParticipant(@PathVariable UUID id, @RequestBody ParticipantRequestPayload payload){
        Optional<Participant> participant = repository.findById(id);

        if (participant.isPresent()){
            Participant rawParticipant = participant.get();

            rawParticipant.setIsConfirmed(true);
            rawParticipant.setName(payload.name());

            this.repository.save(rawParticipant);

            return ResponseEntity.ok(rawParticipant);
        }
        return ResponseEntity.notFound().build();
    }
}
