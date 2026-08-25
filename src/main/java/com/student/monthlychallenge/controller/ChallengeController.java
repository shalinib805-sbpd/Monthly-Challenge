package com.student.monthlychallenge.controller;

import com.student.monthlychallenge.entity.Challenge;
import com.student.monthlychallenge.repository.ChallengeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private final ChallengeRepository challengeRepository;

    public ChallengeController(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    // GET - Get all challenges
    @GetMapping
    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    // POST - Create a new challenge
    @PostMapping
    public Challenge createChallenge(@RequestBody Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    // GET - Get challenge by ID
    @GetMapping("/{id}")
    public Challenge getChallengeById(@PathVariable Long id) {
        return challengeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Challenge not found"));
    }

    // PUT - Update challenge
    @PutMapping("/{id}")
    public Challenge updateChallenge(
            @PathVariable Long id,
            @RequestBody Challenge updatedChallenge) {

        Challenge existingChallenge = challengeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Challenge not found"));

        existingChallenge.setMonth(updatedChallenge.getMonth());
        existingChallenge.setTitle(updatedChallenge.getTitle());
        existingChallenge.setDescription(updatedChallenge.getDescription());

        return challengeRepository.save(existingChallenge);
    }

    // DELETE - Delete challenge
    @DeleteMapping("/{id}")
    public String deleteChallenge(@PathVariable Long id) {

        Challenge existingChallenge = challengeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Challenge not found"));

        challengeRepository.delete(existingChallenge);

        return "Challenge deleted successfully";
    }
}