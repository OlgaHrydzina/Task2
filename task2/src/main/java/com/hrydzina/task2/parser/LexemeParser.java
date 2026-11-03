package com.hrydzina.task2.parser;

import com.hrydzina.task2.entity.ComponentType;
import com.hrydzina.task2.entity.TextComponent;
import com.hrydzina.task2.entity.TextLeaf;

public class LexemeParser extends AbstractParser {

  @Override
  public void parse(String text, TextComponent component) {

    for (char symbol : text.toCharArray()) {
      component.add(new TextLeaf(symbol, ComponentType.SYMBOL)
      );
    }
  }
}
