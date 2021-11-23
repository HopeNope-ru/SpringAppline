package ru.appline.logic;

import java.util.HashMap;
import java.util.Map;

public class Compas {
  private final Map<String, Range> dir;

  public Compas() {
    dir = new HashMap<String, Range>();
  }

  public void put(String direction, Range range) {
    dir.put(direction, range);
  }

  public String getSide(int degree) {
    String direction = new String();

    for(Map.Entry<String, Range> entry : dir.entrySet()) {
      boolean isInRange = entry.getValue().isInRange(degree);

      if (isInRange) {
        direction = entry.getKey();
      }
    }

    return direction;
  }
}
