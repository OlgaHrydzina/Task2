package com.hrydzina.task2.service;

import com.hrydzina.task2.entity.ComponentType;
import com.hrydzina.task2.entity.TextComponent;

public class TextStatisticsService {

  public int countSymbols(TextComponent component) {

    if (component.getType() == ComponentType.SYMBOL) {
      return 1;
    }
    int count = 0;
    for (TextComponent child : component.getChildren()) {
      count += countSymbols(child);
    }
    return count;
  }
  public int countLetters(TextComponent component) {
    if (component.getType() == ComponentType.SYMBOL) {

      char symbol = component.restoreText().charAt(0);

      return Character.isLetter(symbol) ? 1 : 0;
    }
    int count = 0;
    for (TextComponent child : component.getChildren()) {
      count += countLetters(child);
    }
    return count;
  }
}
