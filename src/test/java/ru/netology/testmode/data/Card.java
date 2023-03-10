package ru.netology.testmode.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String number;
    private String month;
    private String year;
    private String name;
    private String cvv;
}
