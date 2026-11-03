package com.hrydzina.taskarray.entity;

import com.hrydzina.taskarray.observer.ArrayObserver;
import com.hrydzina.taskarray.observer.ArraySubject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberArray implements ArraySubject {

  private final String id;
  private final int[] values;
  private final List<ArrayObserver> observers = new ArrayList<>();

  public NumberArray(String id, int[] values) {
    this.id = id;
    this.values = values.clone();
  }
  public String getId() {

    return id;
  }
  public int[] getValues() {

    return values.clone();
  }
  public int getLength() {

    return values.length;
  }
  public int getValue(int index) {

    return values[index];
  }
  public void setValue(int index, int value) {
    if (values[index] != value) {
      values[index] = value;
      notifyObservers();
    }
  }
  @Override
  public void attach(ArrayObserver observer) {

    observers.add(observer);
  }
  @Override
  public void detach(ArrayObserver observer) {

    observers.remove(observer);
  }
  @Override
  public void notifyObservers() {
    for (ArrayObserver observer : observers) {
      observer.onArrayChanged(this);
    }
  }
  public NumberArray clone() {

    return new NumberArray(id, values);
  }
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof NumberArray)) {
      return false;
    }
    NumberArray other = (NumberArray) object;
    return id.equals(other.id)
            && Arrays.equals(values, other.values);
  }
  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + Arrays.hashCode(values);
    return result;
  }
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("NumberArray{id=");
    builder.append(id);
    builder.append(", values=");
    builder.append(Arrays.toString(values));
    builder.append("}");

    return builder.toString();
  }
}
