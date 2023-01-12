//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Party.java
// Course: CS 300 Fall 2020
//
// Author: Huong Nguyen
// Email: htnguyen23@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Party {

  private String name;
  private ArrayList<Candidate> candidates = new ArrayList<Candidate>();

  /**
   * a one-argument constructor, which initialized the instance variables for the object
   * @param name the name for the party 
   */
  public Party(String name) {
    this.name = name;
  }

  /**
   * accessor method to get the Party object name
   * @return String of name
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * accessor method to get the Party object's candidate list size
   * @return int of list size
   */
  public int getSize() {
    return this.candidates.size();
  }

  /**
   * Finds the candidate from the Party running for the given office
   * @param office office to look for
   * @return Candidate object 
   * @throws NoSuchElementException if no candidate is found
   */
  public Candidate getCandidate(String office) throws NoSuchElementException {
    try {
      for (int i = 0; i < candidates.size(); i++) {
        if (candidates.get(i).getOffice().equals(office))
          return candidates.get(i);
      }
      throw new NoSuchElementException ("No Candidate is found.");
    }
    finally {
      //can I leave this blank?
    }
  }

  /**
   * Adds a Candidate to the Party
   * @param c candidate to add
   * @throws IllegalArgumentException if the provided Candidate is running for the same office as another member of the Party
   */
  public void addCandidate(Candidate c) throws IllegalArgumentException {
    try {
      for (int i = 0; i < candidates.size(); i++) {
        if (c.getOffice().equals(candidates.get(i).getOffice()))
          throw new IllegalArgumentException ("The provided Candidate is running for the same office as another member of the Party.");
      }
      candidates.add(c);
    }
    finally {
      //can I leave this blank?
    }
  }
}
