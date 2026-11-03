package com.hrydzina.task2.parser;

import com.hrydzina.task2.entity.ComponentType;
import com.hrydzina.task2.entity.CompositeText;
import com.hrydzina.task2.entity.TextComponent;

public class ParagraphParser extends AbstractParser {

  private static final String SENTENCE_DELIMITER = "(?<=[.!?])\\s+";

  @Override
  public void parse(String text, TextComponent component) {

    String[] sentences = text.split(SENTENCE_DELIMITER);

    for (String sentence : sentences) {

      TextComponent sentenceComponent =
              new CompositeText(ComponentType.SENTENCE);

      component.add(sentenceComponent);

      next.parse(sentence, sentenceComponent);
    }
  }
}
