package com.hrydzina.task2.parser;

import com.hrydzina.task2.entity.TextComponent;

public abstract class AbstractParser {

  protected AbstractParser next;

  public void setNext(AbstractParser parser) {
    this.next = parser;
  }
  public abstract void parse(String text, TextComponent component);
}
