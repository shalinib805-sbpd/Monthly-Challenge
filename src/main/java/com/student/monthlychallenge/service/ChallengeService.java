package com.student.monthlychallenge.service;

import com.student.monthlychallenge.entity.Challenge;
import com.student.monthlychallenge.exception.ResourceNotFoundException;
import com.student.monthlychallenge.repository.ChallengeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    // GET - Get all challenges
    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    // GET - Get challenge by ID
    public Challenge getChallengeById(Long id) {
        return challengeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Challenge not found with id: " + id));
    }

    // POST - Create challenge
    public Challenge createChallenge(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    // PUT - Update challenge
    public Challenge updateChallenge(
            Long id,
            Challenge updatedChallenge) {

        Challenge existingChallenge = challengeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Challenge not found with id: " + id));

        existingChallenge.setMonth(updatedChallenge.getMonth());
        existingChallenge.setTitle(updatedChallenge.getTitle());
        existingChallenge.setDescription(updatedChallenge.getDescription());

        return challengeRepository.save(existingChallenge);
    }

    // DELETE - Delete challenge
    public void deleteChallenge(Long id) {

        Challenge existingChallenge = challengeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Challenge not found with id: " + id));

        challengeRepository.delete(existingChallenge);
    }
}