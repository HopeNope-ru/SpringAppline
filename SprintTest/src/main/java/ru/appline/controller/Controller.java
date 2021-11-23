package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
  private static final PetModel model = PetModel.getInstance();

  private static final AtomicInteger newId = new AtomicInteger(1);

  @PostMapping(value = "/createPet", consumes = "application/json")
  public void createPet(@RequestBody Pet pet) {
    model.add(newId.getAndIncrement(), pet);
  }

  @GetMapping(value = "/getAll", produces = "application/json")
  public Map<Integer, Pet> getAll() {
    return model.getAll();
  }

  @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
  public Pet getPet(@RequestBody Map<String, Integer> id) {
    return model.getFromList(id.get("id"));
  }

  @DeleteMapping(value = "/deletePet", consumes = "application/json")
  public void deletePet(@RequestBody Map<String, Integer> id) {
    model.delete(id.get("id"));
  }

  @PutMapping(value = "/putPet/{id}", consumes = "application/json")
  public void putPet(@RequestBody Pet pet, @PathVariable("id") int id) {
    model.put(id, pet);
  }
}
