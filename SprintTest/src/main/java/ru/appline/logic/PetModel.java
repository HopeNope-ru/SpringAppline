package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PetModel implements Serializable {
  private static final PetModel instance = new PetModel();

  private final Map<Integer, Pet> pets;

  public PetModel() {
    pets = new HashMap<Integer, Pet>();
  }

  public static PetModel getInstance() {
    return instance;
  }

  public void add(int id, Pet pet) {
    pets.put(id, pet);
  }

  public void delete(int id) {
    pets.remove(id);
  }

  public void put(int id, Pet pet) {
    pets.put(id, pet);
  }

  public Pet getFromList(int id) {
    return pets.get(id);
  }

  public Map<Integer, Pet> getAll() {
    return pets;
  }
}
