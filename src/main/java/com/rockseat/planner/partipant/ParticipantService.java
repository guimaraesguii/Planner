package com.rockseat.planner.partipant;

import com.rockseat.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParticipantService {
    @Autowired
    ParticipantRepository repository;

    public void registerParticipantsToEvent(List<String> participantsToEnvite, Trip trip){
        List<Participant> participants = participantsToEnvite.stream().map(email -> new Participant(email,trip)).toList();

        System.out.println(participants.get(0).getId());

        this.repository.saveAll(participants);

    }

    public void trigerConfirmationEmailToParticipants(UUID tripId){}
}
