package com.muhabet.exerciseservice.config;

import com.muhabet.exerciseservice.entity.*;
import com.muhabet.exerciseservice.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ExerciseRepository exerciseRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserAnswerRepository userAnswerRepository;

    @Override
    public void run(String... args) {
        log.info("=== Inicijalizacija podataka za exercise-service ===");

        // --- Vježba 1: Multiple Choice Quiz za lekciju Greetings ---
        Exercise mcQuiz = exerciseRepository.save(Exercise.builder()
                .lessonId("lesson-greetings-1")
                .type("MULTIPLE_CHOICE")
                .title("Basic Greetings Quiz")
                .build());

        // Pitanje 1
        Question q1 = questionRepository.save(Question.builder()
                .exercise(mcQuiz)
                .questionText("Šta znači riječ 'Hvala'?")
                .build());

        Answer q1a1 = answerRepository.save(Answer.builder()
                .question(q1).answerText("Thank you")
                .isCorrect(true)
                .explanation("'Hvala' znači 'Thank you' na engleskom jeziku.")
                .build());
        answerRepository.save(Answer.builder()
                .question(q1).answerText("Good morning")
                .isCorrect(false)
                .explanation("'Good morning' je 'Dobro jutro' na bosanskom.")
                .build());
        answerRepository.save(Answer.builder()
                .question(q1).answerText("Please")
                .isCorrect(false)
                .explanation("'Please' je 'Molim' na bosanskom.")
                .build());
        answerRepository.save(Answer.builder()
                .question(q1).answerText("Goodbye")
                .isCorrect(false)
                .explanation("'Goodbye' je 'Doviđenja' na bosanskom.")
                .build());

        // Pitanje 2
        Question q2 = questionRepository.save(Question.builder()
                .exercise(mcQuiz)
                .questionText("Kako se kaže 'Good day' na bosanskom?")
                .build());

        Answer q2a1 = answerRepository.save(Answer.builder()
                .question(q2).answerText("Dobar dan")
                .isCorrect(true)
                .explanation("'Dobar dan' je standardni pozdrav koji odgovara 'Good day'.")
                .build());
        answerRepository.save(Answer.builder()
                .question(q2).answerText("Dobro jutro")
                .isCorrect(false)
                .explanation("'Dobro jutro' znači 'Good morning', ne 'Good day'.")
                .build());
        answerRepository.save(Answer.builder()
                .question(q2).answerText("Laku noć")
                .isCorrect(false)
                .explanation("'Laku noć' znači 'Good night'.")
                .build());
        answerRepository.save(Answer.builder()
                .question(q2).answerText("Hvala")
                .isCorrect(false)
                .explanation("'Hvala' znači 'Thank you', ne 'Good day'.")
                .build());

        log.info("Kreirana {} vježba tipa MULTIPLE_CHOICE sa {} pitanja",
                1, questionRepository.count());

        // --- Vježba 2: Fill in the Blank za lekciju Food ---
        Exercise fillBlank = exerciseRepository.save(Exercise.builder()
                .lessonId("lesson-food-1")
                .type("FILL_IN_BLANK")
                .title("Food Vocabulary - Fill in the Blank")
                .build());

        Question q3 = questionRepository.save(Question.builder()
                .exercise(fillBlank)
                .questionText("Mogu li dobiti čašu ___? (Can I get a glass of water?)")
                .build());

        Answer q3a1 = answerRepository.save(Answer.builder()
                .question(q3).answerText("vode")
                .isCorrect(true)
                .explanation("'Vode' je genitiv imenice 'voda' (water). Ispravno: 'čašu vode'.")
                .build());
        answerRepository.save(Answer.builder()
                .question(q3).answerText("kafe")
                .isCorrect(false)
                .explanation("'Kafe' je genitiv od 'kafa' (coffee), ali kontekst govori o vodi.")
                .build());

        Question q4 = questionRepository.save(Question.builder()
                .exercise(fillBlank)
                .questionText("Jedan ___ sa maslacem, molim. (One bread with butter, please.)")
                .build());

        answerRepository.save(Answer.builder()
                .question(q4).answerText("hljeb")
                .isCorrect(true)
                .explanation("'Hljeb' znači 'bread'. Ispravna rečenica: 'Jedan hljeb sa maslacem, molim.'")
                .build());
        answerRepository.save(Answer.builder()
                .question(q4).answerText("voda")
                .isCorrect(false)
                .explanation("'Voda' znači 'water', ne 'bread'.")
                .build());

        log.info("Kreirana {} vježba tipa FILL_IN_BLANK", 1);

        // --- Vježba 3: Matching Game ---
        Exercise matching = exerciseRepository.save(Exercise.builder()
                .lessonId("lesson-greetings-1")
                .type("MATCHING")
                .title("Match Bosnian words with English translations")
                .build());

        String[] bosnian = {"Hvala", "Molim", "Dobar dan", "Dobro jutro", "Kako si?"};
        String[] english  = {"Thank you", "Please / You're welcome", "Good day", "Good morning", "How are you?"};

        for (int i = 0; i < bosnian.length; i++) {
            Question mq = questionRepository.save(Question.builder()
                    .exercise(matching)
                    .questionText(bosnian[i])
                    .build());
            answerRepository.save(Answer.builder()
                    .question(mq)
                    .answerText(english[i])
                    .isCorrect(true)
                    .explanation("'" + bosnian[i] + "' odgovara '" + english[i] + "'.")
                    .build());
        }

        log.info("Kreirana {} vježba tipa MATCHING sa {} parova",
                1, bosnian.length);

        // --- Upisivanje probnih odgovora korisnika ---
        // Korisnik "user-naida" je odgovorio na pitanje 1 tačno
        userAnswerRepository.save(UserAnswer.builder()
                .userId("user-naida")
                .question(q1)
                .answer(q1a1)
                .isCorrect(true)
                .build());

        // Korisnik "user-naida" je odgovorio na pitanje 2 tačno
        userAnswerRepository.save(UserAnswer.builder()
                .userId("user-naida")
                .question(q2)
                .answer(q2a1)
                .isCorrect(true)
                .build());

        // Korisnik "user-lana" je odgovorio na pitanje 3 tačno
        userAnswerRepository.save(UserAnswer.builder()
                .userId("user-lana")
                .question(q3)
                .answer(q3a1)
                .isCorrect(true)
                .build());

        log.info("Kreirana {} odgovora korisnika", userAnswerRepository.count());

        log.info("=== Inicijalizacija podataka završena ===");
        log.info("Ukupno vježbi: {}", exerciseRepository.count());
        log.info("Ukupno pitanja: {}", questionRepository.count());
        log.info("Ukupno odgovora (opcija): {}", answerRepository.count());
    }
}
