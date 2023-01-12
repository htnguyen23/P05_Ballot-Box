//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Ballot.java
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

public class Ballot {
  // class variables
  private static ArrayList parties = new ArrayList<Party>();
  private static int counter = 0;

  public static void addParty(Party p) {
    parties.add(p);
  }

  public static ArrayList<Candidate> getCandidates(String office) {
    ArrayList<Candidate> result = new ArrayList<Candidate>();
    try {
      for (int i = 0; i < parties.size(); i++) {
        result.add(((Party) parties.get(i)).getCandidate(office)); // idky I have to cast (Party)
      }
    } catch (NoSuchElementException nse) {
      System.out.println(nse.getMessage());
    }
    return result;
  }

  // instance variables
  private Candidate[] votes = new Candidate[0];
  private final int ID;

  // constructor
  public Ballot() {
    this.ID = counter;
    counter += 1;
    votes = new Candidate[Candidate.OFFICE.length];
  }

  public Candidate getVote(String office) {
    for (int i = 0; i < votes.length; i++) {
      if (votes[i] != null && votes[i].getOffice().equals(office)) {
        return votes[i];
      }
    }
    return null;
  }

  /**
   * Returns true if the argument is equal to this Ballot, false otherwise
   * 
   * @param o the object to compare to this Ballot
   * @return true if the Ballots have the same ID, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Ballot) {
      Ballot o2 = (Ballot) o; // is this correct? did have have to create a variable just to cast o
                              // to a Ballot?
      if (this.ID == o2.ID)
        return true;
    }
    return false;
  }

  /**
   * Records the vote for the given Candidate at the appropriate index in the Ballot’s array. Can
   * overwrite an existing vote.
   * 
   * @param c
   */
  public void vote(Candidate c) {
    try {
      for (int i = 0; i < Candidate.OFFICE.length; i++) {
        if (Candidate.OFFICE[i].equals(c.getOffice())) {
          for (int y = 0; y < parties.size(); y++) {
            if (c.toString()
              .equals(((Party) parties.get(y)).getCandidate(c.getOffice()).toString()))
              votes[i] = c;
          }
        }
      }
    } catch (NoSuchElementException nse) {
      System.out.println(nse.getMessage());
    }
  }
}
