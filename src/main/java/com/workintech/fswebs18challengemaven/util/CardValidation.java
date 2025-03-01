package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;

public class CardValidation {

    public static void validateCard(Card card) {
        if (card.getValue() != null && card.getType() != null) {
            throw new CardException("A card cannot have both a value and a type");
        }

        if (card.getType() == null && card.getValue() == null) {
            throw new CardException("A card must have either a value or a type");
        }

        if (card.getType() == Type.JOKER && (card.getValue() != null || card.getColor() != null)) {
            throw new CardException("JOKER card must have null value and color");
        }
    }
}
