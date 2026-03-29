package com.muhabet.userservice.config;

import com.muhabet.userservice.entity.*;
import com.muhabet.userservice.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProgressRepository progressRepository;
    private final FavoriteRepository favoriteRepository;
    private final AiTextRepository aiTextRepository;

    @Override
    public void run(String... args) {
        log.info("=== Inicijalizacija podataka za user-service ===");

        // Kreiranje korisnika
        User user1 = userRepository.save(User.builder()
                .username("naida_hasovic")
                .email("naida@muhabet.ba")
                .passwordHash("$2a$10$hashedpassword1")
                .role("USER")
                .build());

        User user2 = userRepository.save(User.builder()
                .username("lana_malinov")
                .email("lana@muhabet.ba")
                .passwordHash("$2a$10$hashedpassword2")
                .role("USER")
                .build());

        User admin = userRepository.save(User.builder()
                .username("admin")
                .email("admin@muhabet.ba")
                .passwordHash("$2a$10$hashedpasswordadmin")
                .role("ADMIN")
                .build());

        log.info("Kreirana {} korisnika", userRepository.count());

        // Kreiranje napretka (Progress) - lesson ID-ovi su placeholderi iz content-service
        progressRepository.save(Progress.builder()
                .user(user1)
                .lessonId("lesson-greetings-1")
                .completed(true)
                .accuracy(85.5f)
                .build());

        progressRepository.save(Progress.builder()
                .user(user1)
                .lessonId("lesson-food-1")
                .completed(false)
                .accuracy(60.0f)
                .build());

        progressRepository.save(Progress.builder()
                .user(user2)
                .lessonId("lesson-greetings-1")
                .completed(true)
                .accuracy(92.0f)
                .build());

        log.info("Kreirana {} zapisa o napretku", progressRepository.count());

        // Kreiranje favorita
        favoriteRepository.save(Favorite.builder()
                .user(user1)
                .wordId("word-hvala")
                .build());

        favoriteRepository.save(Favorite.builder()
                .user(user1)
                .wordId("word-dobrodosli")
                .build());

        favoriteRepository.save(Favorite.builder()
                .user(user2)
                .phraseId("phrase-kako-si")
                .build());

        log.info("Kreirana {} favorita", favoriteRepository.count());

        // Kreiranje AI provjera teksta
        aiTextRepository.save(AiText.builder()
                .user(user1)
                .originalText("Ja imam jedan veliku kucu u centar od grad.")
                .correctedText("Ja imam jednu veliku kuću u centru grada.")
                .suggestions("1. 'jedan' -> 'jednu' (rod imenice 'kuća' je ženski)\n" +
                             "2. 'centar od grad' -> 'centru grada' (lokativ s genitivom)")
                .build());

        aiTextRepository.save(AiText.builder()
                .user(user2)
                .originalText("Ja ucim bosanski jezik svaki dan.")
                .correctedText("Ja učim bosanski jezik svaki dan.")
                .suggestions("1. 'ucim' -> 'učim' (dijakritički znak č)")
                .build());

        log.info("Kreirana {} AI provjera teksta", aiTextRepository.count());
        log.info("=== Inicijalizacija podataka završena ===");
    }
}
