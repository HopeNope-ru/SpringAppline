package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Compas;
import ru.appline.logic.Range;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
  private Compas _compas = new Compas();

  @PostMapping(value = "/createCompas", consumes = "application/json")
  public void createCompas(@RequestBody Map<String, String> compas) {
    for(Map.Entry<String, String> entry : compas.entrySet()) {
      String  side  = entry.getKey();
      String  value = entry.getValue();
      System.out.println(side + " " + value);
      Range   range = new Range(value);
      _compas.put(side, range);
    }
  }

  @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
  public Map<String, String> getSide(@RequestParam int degree) {
    String side = _compas.getSide(degree);

    Map<String, String> map = new HashMap<String, String>();
    map.put("Side", side);

    return map;
  }
}
