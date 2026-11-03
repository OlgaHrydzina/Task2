package com.hrydzina.task2.entity;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class CompositeText implements TextComponent {

  private final ComponentType type;
  private final List<TextComponent> components = new ArrayList<>();

  public CompositeText(ComponentType type) {
    this.type = type;
  }
  @Override
  public void add(TextComponent component) {
    components.add(component);
  }
  @Override
  public void remove(TextComponent component) {
    components.remove(component);
  }
  @Override
  public List<TextComponent> getChildren() {
    return new ArrayList<>(components);
  }
  @Override
  public String restoreText() {
    StringBuilder builder = new StringBuilder();

    for (TextComponent component : components) {
      builder.append(component.restoreText());
    }
    return builder.toString();
  }
  @Override
  public ComponentType getType() {
    return type;
  }
}
