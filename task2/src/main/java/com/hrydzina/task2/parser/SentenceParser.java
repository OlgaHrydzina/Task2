package com.hrydzina.task2.parser;

import com.hrydzina.task2.entity.ComponentType;
import com.hrydzina.task2.entity.CompositeText;
import com.hrydzina.task2.entity.TextComponent;

public class SentenceParser extends AbstractParser {

  private static final String LEXEME_DELIMITER = "\\s+";

  @Override
  public void parse(String text, TextComponent component) {

    String[] lexemes = text.split(LEXEME_DELIMITER);

    for (String lexeme : lexemes) {
      TextComponent lexemeComponent = new CompositeText(ComponentType.LEXEME);
      component.add(lexemeComponent);
      next.parse(lexeme, lexemeComponent);
    }
  }
}
