package com.student.monthlychallenge.controller;

import com.student.monthlychallenge.entity.Challenge;
import com.student.monthlychallenge.service.ChallengeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/challenges")
@Tag(
        name = "Challenge API",
        description = "APIs for managing monthly challenges"
)
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    // GET - Get all challenges
    @GetMapping
    @Operation(
            summary = "Get all challenges",
            description = "Returns all monthly challenges"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Challenges retrieved successfully"
            )
    })
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChallenges();
    }

    // POST - Create a new challenge
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Create a new challenge",
            description = "Creates and saves a new monthly challenge"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Challenge created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Validation failed"
            )
    })
    public Challenge createChallenge(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Monthly challenge details",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "month": "June",
                                              "title": "Java Practice",
                                              "description": "Learn Java and Spring Boot"
                                            }
                                            """
                            )
                    )
            )
            @RequestBody Challenge challenge) {

        return challengeService.createChallenge(challenge);
    }

    // GET - Get challenge by ID
    @GetMapping("/{id}")
    @Operation(
            summary = "Get challenge by ID",
            description = "Returns a challenge using its ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Challenge found"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Challenge not found"
            )
    })
    public Challenge getChallengeById(@PathVariable Long id) {
        return challengeService.getChallengeById(id);
    }

    // PUT - Update challenge
    @PutMapping("/{id}")
    @Operation(
            summary = "Update a challenge",
            description = "Updates an existing challenge using its ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Challenge updated successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Validation failed"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Challenge not found"
            )
    })
    public Challenge updateChallenge(
            @PathVariable Long id,
            @Valid @RequestBody Challenge updatedChallenge) {

        return challengeService.updateChallenge(id, updatedChallenge);
    }

    // DELETE - Delete challenge
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a challenge",
            description = "Deletes a challenge using its ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Challenge deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Challenge not found"
            )
    })
    public String deleteChallenge(@PathVariable Long id) {

        challengeService.deleteChallenge(id);

        return "Challenge deleted successfully";
    }
}