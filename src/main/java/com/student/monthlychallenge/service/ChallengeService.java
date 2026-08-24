package com.student.monthlychallenge.service;

import com.student.monthlychallenge.entity.Challenge;
import com.student.monthlychallenge.repository.ChallengeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {

    private final ChallengeRepository repository;

    public ChallengeService(ChallengeRepository repository) {
        this.repository = repository;
    }

    public List<Challenge> getAllChallenges() {
        return repository.findAll();
    }

    public Challenge getChallengeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Challenge createChallenge(Challenge challenge) {
        return repository.save(challenge);
    }

    public Challenge updateChallenge(Long id, Challenge challenge) {

        Challenge existingChallenge = repository.findById(id).orElse(null);

        if (existingChallenge == null) {
            return null;
        }

        existingChallenge.setMonth(challenge.getMonth());
        existingChallenge.setTitle(challenge.getTitle());
        existingChallenge.setDescription(challenge.getDescription());

        return repository.save(existingChallenge);
    }

    public void deleteChallenge(Long id) {
        repository.deleteById(id);
    }
}