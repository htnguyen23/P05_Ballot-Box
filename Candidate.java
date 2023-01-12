//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Candidate.java
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
import java.lang.IllegalArgumentException;

public class Candidate {

  protected static final String[] OFFICE = {"Speaker of the House", "Secretary of State", "Supreme Court Justice"};
  private String name;
  private String office;

  /**
   * A two-argument constructor, which initializes the instance variables for the object 
   * @param name the name of the candidate
   * @param office the office the candidate is running for
   * @throws IllegalArgumentException if the specified office is valid
   */
  public Candidate(String name, String office) throws IllegalArgumentException {
    try {
      if (name == null || office == null) 
        throw new IllegalArgumentException("Invalid argument for creating Candidate object.");
      if (!arrayContains(Candidate.OFFICE, office)) 
        throw new IllegalArgumentException("Invalid argument for creating Candidate object.");
      this.name = name;
      this.office = office;
    } finally {
      // can I leave this blank?
    }
  }

  /**
   * private helper method that checks if an element is in a String array 
   * @param arr array to look through
   * @param key String to look for
   * @return true is key is found, false if not
   */
  private static boolean arrayContains(String [] arr, String key) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals(key))
        return true;
    }
    return false;
  }
  
  /**
   * accessor to get the Candidate object name
   * @return String of name
   */
  public String getName() {
    return this.name;
  }

  /**
   * accessor to get the Candidate object office
   * @return String of office
   */
  public String getOffice() {
    return this.office;
  }
  /**
   * Gives information on the candidate
   * @return a String representation of this candidate as "Name (Office)"
   */
  public String toString() {
    String result = this.getName() + " (" + this.getOffice() + ")";
    return result;
  }
}
