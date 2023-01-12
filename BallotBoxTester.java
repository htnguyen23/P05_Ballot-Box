import java.util.NoSuchElementException;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: BallotBoxTester.java
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

public class BallotBoxTester {

  public static boolean testCandidate() {
    try {
      // create instances of Candidate object
      Candidate person1 = new Candidate("Nancy Pelosi", Candidate.OFFICE[0]);
      Candidate person2 = new Candidate("Ruth Bader Ginsburg", Candidate.OFFICE[2]);
      // test accessors
      if (!person1.getName().equals("Nancy Pelosi"))
        return false;
      if (!person2.getOffice().equals("Supreme Court Justice"))
        return false;
      if (!person2.toString().contentEquals("Ruth Bader Ginsburg (Supreme Court Justice)"))
        return false;
      // create object with invalid argument
      Candidate person3 = new Candidate(null, null);
    } catch (IllegalArgumentException iae) {
      System.out.println(iae.getMessage());
    }
    catch (Exception e) {
      System.out.println("Problem detected: testing Candidate class has thrown"
        + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public static boolean testPartyConstructor() {
    Party party = new Party("Democrats");
    if (!party.getName().equals("Democrats"))
      return false;
    // tests partyGetSize()
    if (party.getSize() != 0)
      return false;
    return true;
  }

  public static boolean testPartyAddCandidate() {
    try {
      Party Democrats = new Party("Democrats");
      Candidate person1 = new Candidate("Nancy Pelosi", Candidate.OFFICE[0]);
      Candidate person2 = new Candidate("Ruth Bader Ginsburg", Candidate.OFFICE[2]);
      Democrats.addCandidate(person1);
      Democrats.addCandidate(person2);
      if (Democrats.getSize() != 2)
        return false;
      Candidate person3 = new Candidate("Susan Davis", "Speaker of the House");
      Democrats.addCandidate(person3);
      if (Democrats.getSize() != 2)
        return false;
    } 
    catch (IllegalArgumentException iae) {
      System.out.println(iae.getMessage());
    }
    catch (Exception e) {
      System.out.println("Problem detected: testing Party class has thrown"
        + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public static boolean testPartyGetCandidate() {
    try {
      Party Democrats = new Party("Democrats");
      Candidate person1 = new Candidate("Nancy Pelosi", Candidate.OFFICE[0]);
      Candidate person2 = new Candidate("Madeleine Albright", Candidate.OFFICE[1]);
      Democrats.addCandidate(person1);
      Democrats.addCandidate(person2);
      if (!Democrats.getCandidate("Speaker of the House").getName().equals("Nancy Pelosi"))
        return false;
      Democrats.getCandidate("Supreme Court Justice");
    } 
    catch (NoSuchElementException nse) {
      System.out.println(nse.getMessage());
    }
    catch (Exception e) {
      System.out.println("Problem detected: testing Party class has thrown"
        + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("testCandidate(): " + testCandidate() + "\n");
    System.out.println("testPartyConstructor(): " + testPartyConstructor() + "\n");
    System.out.println("testPartyAddCandidate(): " + testPartyAddCandidate() + "\n");
    System.out.println("testPartyGetCandidate(): " + testPartyGetCandidate() + "\n");
  }

}
