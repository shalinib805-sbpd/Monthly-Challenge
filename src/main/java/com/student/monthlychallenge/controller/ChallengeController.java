package com.student.monthlychallenge.controller;

import com.student.monthlychallenge.entity.Challenge;
import com.student.monthlychallenge.service.ChallengeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    // GET - Get all challenges
    @GetMapping
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChallenges();
    }

    // POST - Create a new challenge
    @PostMapping
    public Challenge createChallenge(@Valid @RequestBody Challenge challenge) {
        return challengeService.createChallenge(challenge);
    }

    // GET - Get challenge by ID
    @GetMapping("/{id}")
    public Challenge getChallengeById(@PathVariable Long id) {
        return challengeService.getChallengeById(id);
    }

    // PUT - Update challenge
    @PutMapping("/{id}")
    public Challenge updateChallenge(
            @PathVariable Long id,
            @Valid @RequestBody Challenge updatedChallenge) {

        return challengeService.updateChallenge(id, updatedChallenge);
    }

    // DELETE - Delete challenge
    @DeleteMapping("/{id}")
    public String deleteChallenge(@PathVariable Long id) {

        challengeService.deleteChallenge(id);

        return "Challenge deleted successfully";
    }
}