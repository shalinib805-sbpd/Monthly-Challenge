@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private final ChallengeRepository challengeRepository;

    public ChallengeController(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @GetMapping
    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    @PostMapping
    public Challenge createChallenge(@RequestBody Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    @GetMapping("/{id}")
    public Challenge getChallengeById(@PathVariable Long id) {
        return challengeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Challenge not found"));
    }

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
}