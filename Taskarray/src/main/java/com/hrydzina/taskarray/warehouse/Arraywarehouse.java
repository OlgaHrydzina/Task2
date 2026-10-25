package com.hrydzina.taskarray.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ArrayWarehouse {
  private static ArrayWarehouse instance;

  private final Map<String, ArrayParameters> storage = new HashMap<>();

  private ArrayWarehouse() {
  }
  public static ArrayWarehouse getInstance() {
    if (instance == null) {
      instance = new ArrayWarehouse();
    }
    return instance;
  }
  public void put(String id, ArrayParameters parameters) {

    storage.put(id, parameters);
  }
  public Optional<ArrayParameters> get(String id) {

    return Optional.ofNullable(storage.get(id));
  }
  public void remove(String id) {
    storage.remove(id);
  }
}
