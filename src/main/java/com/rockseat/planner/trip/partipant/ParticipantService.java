package com.rockseat.planner.trip.partipant;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {
    public void registerParticipantsToEvent(List<String> participantsToEnvite, UUID tripId){}

    public void trigerConfirmationEmailToParticipants(UUID tripId){}
}
