package ru.appline.logic;

public class Range {
  private int _low;
  private int _high;

  public Range(int low, int high) {
    _low  = low;
    _high = high;
  }

  public Range(String range) {
    _low  = Integer.parseInt(range.substring(0, range.indexOf("-")));
    _high = Integer.parseInt(range.substring(range.indexOf("-") + 1));
  }

  public boolean isInRange(int degree) {
    return degree >= _low && degree <= _high;
  }
}
