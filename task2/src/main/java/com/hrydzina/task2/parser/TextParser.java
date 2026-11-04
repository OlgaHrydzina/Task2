package com.hrydzina.task2.parser;

import com.hrydzina.task2.entity.ComponentType;
import com.hrydzina.task2.entity.CompositeText;
import com.hrydzina.task2.entity.TextComponent;

public class TextParser extends AbstractParser {

  private static final String PARAGRAPH_DELIMITER = "(?:\\R[\\t ]*){2,}";

  @Override
  public void parse(String text, TextComponent component) {

    String[] paragraphs = text.split(PARAGRAPH_DELIMITER);
    for (String paragraph : paragraphs) {

      TextComponent paragraphComponent =
              new CompositeText(ComponentType.PARAGRAPH);
      component.add(paragraphComponent);
      next.parse(paragraph, paragraphComponent);
    }
  }
}
