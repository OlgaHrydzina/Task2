package com.hrydzina.task2.entity;

import java.util.Collections;
import java.util.List;

public class TextLeaf implements TextComponent {

  private final char value;
  private final ComponentType type;

  public TextLeaf(char value, ComponentType type) {
    this.value = value;
    this.type = type;
  }
  @Override
  public void add(TextComponent component) {
    throw new UnsupportedOperationException("Cannot add components to a leaf"
    );
  }
  @Override
  public void remove(TextComponent component) {
    throw new UnsupportedOperationException("Cannot remove components from a leaf"
    );
  }
  @Override
  public List<TextComponent> getChildren() {
    return Collections.emptyList();
  }
  @Override
  public String restoreText() {
    return String.valueOf(value);
  }
  @Override
  public ComponentType getType() {
    return type;
  }
}