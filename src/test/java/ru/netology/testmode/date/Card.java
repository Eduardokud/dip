package ru.netology.testmode.date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Card {
    private String number;
    private String month;
    private String year;
    private String name;
    private String cvv;
}
