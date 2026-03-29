package com.muhabet.contentservice.config;

import com.muhabet.contentservice.entity.*;
import com.muhabet.contentservice.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final LessonRepository lessonRepository;
    private final WordRepository wordRepository;
    private final PhraseRepository phraseRepository;
    private final TranslationRepository translationRepository;
    private final SentenceExampleRepository sentenceExampleRepository;
    private final LessonContentRepository lessonContentRepository;

    @Override
    public void run(String... args) {
        log.info("=== Inicijalizacija podataka za content-service ===");

        // --- Kategorije ---
        Category greetings = categoryRepository.save(Category.builder()
                .name("Greetings")
                .description("Pozdravi i osnovne fraze")
                .build());

        Category foodDrink = categoryRepository.save(Category.builder()
                .name("Food & Drink")
                .description("Hrana i piće")
                .build());

        Category travel = categoryRepository.save(Category.builder()
                .name("Travel")
                .description("Putovanja i orijentacija")
                .build());

        log.info("Kreirane {} kategorije", categoryRepository.count());

        // --- Lekcije ---
        Lesson lesson1 = lessonRepository.save(Lesson.builder()
                .title("Basic Greetings")
                .description("Naučite osnovne pozdrave na bosanskom")
                .category(greetings)
                .orderInCategory(1)
                .build());

        Lesson lesson2 = lessonRepository.save(Lesson.builder()
                .title("Food Vocabulary")
                .description("Najčešće korištene riječi za hranu i piće")
                .category(foodDrink)
                .orderInCategory(1)
                .build());

        log.info("Kreirane {} lekcije", lessonRepository.count());

        // --- Riječi ---
        Word hvala = wordRepository.save(Word.builder()
                .text("Hvala")
                .language("bs")
                .partOfSpeech("exclamation")
                .build());

        Word dobarDan = wordRepository.save(Word.builder()
                .text("Dobar dan")
                .language("bs")
                .partOfSpeech("phrase")
                .build());

        Word molim = wordRepository.save(Word.builder()
                .text("Molim")
                .language("bs")
                .partOfSpeech("verb")
                .build());

        Word dobroJutro = wordRepository.save(Word.builder()
                .text("Dobro jutro")
                .language("bs")
                .partOfSpeech("phrase")
                .build());

        Word voda = wordRepository.save(Word.builder()
                .text("Voda")
                .language("bs")
                .partOfSpeech("noun")
                .build());

        Word hljeb = wordRepository.save(Word.builder()
                .text("Hljeb")
                .language("bs")
                .partOfSpeech("noun")
                .build());

        Word kafa = wordRepository.save(Word.builder()
                .text("Kafa")
                .language("bs")
                .partOfSpeech("noun")
                .build());

        log.info("Kreirane {} riječi", wordRepository.count());

        // --- Fraze ---
        Phrase kakoSi = phraseRepository.save(Phrase.builder()
                .text("Kako si?")
                .language("bs")
                .build());

        Phrase hvalaVamNaPomoci = phraseRepository.save(Phrase.builder()
                .text("Hvala vam na pomoći.")
                .language("bs")
                .build());

        log.info("Kreirane {} fraze", phraseRepository.count());

        // --- Prijevodi ---
        translationRepository.save(Translation.builder()
                .word(hvala)
                .language("en")
                .translationText("Thank you")
                .build());

        translationRepository.save(Translation.builder()
                .word(dobarDan)
                .language("en")
                .translationText("Good day")
                .build());

        translationRepository.save(Translation.builder()
                .word(molim)
                .language("en")
                .translationText("Please / You're welcome")
                .build());

        translationRepository.save(Translation.builder()
                .word(dobroJutro)
                .language("en")
                .translationText("Good morning")
                .build());

        translationRepository.save(Translation.builder()
                .word(voda)
                .language("en")
                .translationText("Water")
                .build());

        translationRepository.save(Translation.builder()
                .word(hljeb)
                .language("en")
                .translationText("Bread")
                .build());

        translationRepository.save(Translation.builder()
                .word(kafa)
                .language("en")
                .translationText("Coffee")
                .build());

        translationRepository.save(Translation.builder()
                .phrase(kakoSi)
                .language("en")
                .translationText("How are you?")
                .build());

        translationRepository.save(Translation.builder()
                .phrase(hvalaVamNaPomoci)
                .language("en")
                .translationText("Thank you for your help.")
                .build());

        log.info("Kreirani {} prijevoda", translationRepository.count());

        // --- Primjeri rečenica ---
        sentenceExampleRepository.save(SentenceExample.builder()
                .word(hvala)
                .sentence("Hvala vam na pomoći.")
                .translation("Thank you for your help.")
                .build());

        sentenceExampleRepository.save(SentenceExample.builder()
                .word(voda)
                .sentence("Mogu li dobiti čašu vode?")
                .translation("Can I get a glass of water?")
                .build());

        sentenceExampleRepository.save(SentenceExample.builder()
                .word(kafa)
                .sentence("Želim kafu s mlijekom, molim.")
                .translation("I would like coffee with milk, please.")
                .build());

        sentenceExampleRepository.save(SentenceExample.builder()
                .phrase(kakoSi)
                .sentence("Kako si? Nadam se da si dobro!")
                .translation("How are you? I hope you are well!")
                .build());

        log.info("Kreirana {} primjera rečenica", sentenceExampleRepository.count());

        // --- Sadržaj lekcija ---
        lessonContentRepository.save(LessonContent.builder()
                .lesson(lesson1).word(hvala).orderInLesson(1).build());
        lessonContentRepository.save(LessonContent.builder()
                .lesson(lesson1).word(dobarDan).orderInLesson(2).build());
        lessonContentRepository.save(LessonContent.builder()
                .lesson(lesson1).word(molim).orderInLesson(3).build());
        lessonContentRepository.save(LessonContent.builder()
                .lesson(lesson1).word(dobroJutro).orderInLesson(4).build());
        lessonContentRepository.save(LessonContent.builder()
                .lesson(lesson1).phrase(kakoSi).orderInLesson(5).build());

        lessonContentRepository.save(LessonContent.builder()
                .lesson(lesson2).word(voda).orderInLesson(1).build());
        lessonContentRepository.save(LessonContent.builder()
                .lesson(lesson2).word(hljeb).orderInLesson(2).build());
        lessonContentRepository.save(LessonContent.builder()
                .lesson(lesson2).word(kafa).orderInLesson(3).build());

        log.info("Kreiran {} sadržaj lekcija", lessonContentRepository.count());
        log.info("=== Inicijalizacija podataka završena ===");
    }
}
