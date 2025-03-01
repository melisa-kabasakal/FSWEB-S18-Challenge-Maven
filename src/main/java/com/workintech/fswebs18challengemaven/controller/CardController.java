package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.exceptions.CardNotFoundException;
import com.workintech.fswebs18challengemaven.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
@Slf4j
public class CardController {

    private final CardRepository cardRepository;

    @GetMapping
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @GetMapping("/byColor/{color}")
    public List<Card> getCardsByColor(@PathVariable String color) {
        List<Card> cards = cardRepository.findByColor(color);
        if (cards.isEmpty()) {
            throw new CardNotFoundException("Card not found", HttpStatus.NOT_FOUND);
        }
        return cards;
    }

    @PostMapping
    public Card saveCard(@RequestBody Card card) {
        return cardRepository.save(card);
    }

    @DeleteMapping("/{id}")
    public void removeCard(@PathVariable Long id) {
        cardRepository.remove(id);
    }


    @GetMapping("/byValue/{value}")
    public List<Card> getCardsByValue(@PathVariable Integer value) {
        return cardRepository.findByValue(value);
    }

    @GetMapping("/byType/{type}")
    public List<Card> getCardsByType(@PathVariable String type) {
        return cardRepository.findByType(type);
    }
}
