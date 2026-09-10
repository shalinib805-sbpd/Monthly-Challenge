package com.student.monthlychallenge;

import com.student.monthlychallenge.entity.Challenge;
import com.student.monthlychallenge.repository.ChallengeRepository;
import com.student.monthlychallenge.service.ChallengeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ChallengeServiceTest {

    @Mock
    private ChallengeRepository challengeRepository;

    @InjectMocks
    private ChallengeService challengeService;

    @Test
    void testGetAllChallenges() {

        Challenge challenge = new Challenge();

        challenge.setId(1L);
        challenge.setMonth("January");
        challenge.setTitle("Java Practice");
        challenge.setDescription("Learn Java");

        when(challengeRepository.findAll())
                .thenReturn(List.of(challenge));

        List<Challenge> result = challengeService.getAllChallenges();

        assertEquals(1, result.size());
        assertEquals("Java Practice", result.get(0).getTitle());
    }

    @Test
    void testGetChallengeById() {

        Challenge challenge = new Challenge();

        challenge.setId(1L);
        challenge.setMonth("January");
        challenge.setTitle("Java Practice");
        challenge.setDescription("Learn Java");

        when(challengeRepository.findById(1L))
                .thenReturn(Optional.of(challenge));

        Challenge result = challengeService.getChallengeById(1L);

        assertEquals(1L, result.getId());
        assertEquals("Java Practice", result.getTitle());
    }

    @Test
    void testCreateChallenge() {

        Challenge challenge = new Challenge();

        challenge.setMonth("March");
        challenge.setTitle("DSA Practice");
        challenge.setDescription("Practice DSA");

        when(challengeRepository.save(challenge))
                .thenReturn(challenge);

        Challenge result = challengeService.createChallenge(challenge);

        assertEquals("March", result.getMonth());
        assertEquals("DSA Practice", result.getTitle());
        assertEquals("Practice DSA", result.getDescription());
    }

    @Test
    void testUpdateChallenge() {

        Challenge existing = new Challenge();

        existing.setId(1L);
        existing.setMonth("January");
        existing.setTitle("Java");
        existing.setDescription("Learn Java");

        Challenge updated = new Challenge();

        updated.setMonth("February");
        updated.setTitle("Spring Boot");
        updated.setDescription("Learn Spring Boot");

        when(challengeRepository.findById(1L))
                .thenReturn(Optional.of(existing));

        when(challengeRepository.save(existing))
                .thenReturn(existing);

        Challenge result =
                challengeService.updateChallenge(1L, updated);

        assertEquals("February", result.getMonth());
        assertEquals("Spring Boot", result.getTitle());
        assertEquals("Learn Spring Boot", result.getDescription());
    }

    @Test
    void testDeleteChallenge() {

        Challenge existing = new Challenge();

        existing.setId(1L);
        existing.setMonth("January");
        existing.setTitle("Java");
        existing.setDescription("Learn Java");

        when(challengeRepository.findById(1L))
                .thenReturn(Optional.of(existing));

        challengeService.deleteChallenge(1L);

        verify(challengeRepository).delete(existing);
    }
}