package com.workintech.fswebs18challengemaven.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer value;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Color color;

    public Card(Integer value, Type type, Color color){
        this.value = value;
        this.type = type;
        this.color = color;

        if(type == Type.JOKER){
            this.value =  null;
            this.color = null;
        }else if(type != null){
            this.value = null;
        }else if(value != null){
            this.type = null;
        }
    }
}
