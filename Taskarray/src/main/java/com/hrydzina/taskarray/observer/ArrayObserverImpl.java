package com.hrydzina.taskarray.observer;

import com.hrydzina.taskarray.entity.NumberArray;
import com.hrydzina.taskarray.warehouse.ArrayParameters;
import com.hrydzina.taskarray.warehouse.ArrayWarehouse;

public class ArrayObserverImpl implements ArrayObserver {

  @Override
  public void onArrayChanged(NumberArray array) {

    int[] values = array.getValues();

    int sum = 0;
    int min = values[0];
    int max = values[0];

    for (int value : values) {
      sum += value;
      if (value < min) {
        min = value;
      }
      if (value > max) {
        max = value;
      }
    }
    double average = (double) sum / values.length;

    ArrayParameters parameters = new ArrayParameters(sum, average, min, max);

    ArrayWarehouse.getInstance().put(array.getId(), parameters);
  }
}
