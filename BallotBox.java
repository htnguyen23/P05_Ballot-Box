import java.util.ArrayList;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: BallotBox.java
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

public class BallotBox {

  private ArrayList<Ballot> ballots = new ArrayList<Ballot>();

  public BallotBox() {
    ballots = new ArrayList<Ballot>();
  }

  /**
   * Finds the total number of unique Ballots in this BallotBox
   * 
   * @return
   */
  public int getNumBallots() {
    ArrayList<Ballot> tempList = new ArrayList<Ballot>(0);
    for (int i = 0; i < ballots.size(); i++) {
      if (!tempList.contains(ballots.get(i))) {
        tempList.add(ballots.get(i));
      }
    }
    return tempList.size();
  }

  /**
   * Adds a ballot to the BallotBox if and only if the Ballot has not already been added
   * 
   * @param b
   */
  public void submit(Ballot b) {
    if (!ballots.contains(b))
      ballots.add(b);
  }

  /**
   * Records all of the existing Ballots' votes for the given office and returns the Candidate with
   * the most votes.
   * 
   * @param office
   * @return
   */
  public Candidate getWinner(String office) {
    // Retrieve the list of potential Candidates for the given office
    ArrayList<Candidate> potential = new ArrayList<Candidate>();
    for (int i = 0; i < ballots.size(); i++) {
      potential.addAll(ballots.get(i).getCandidates(office));
    }
    // Track how many votes each Candidates receives with a parallel array
    int[] voteResult = new int[potential.size()];
    // Go through each of the Ballots in the BallotBox and get the vote for that office
    for (int i = 0; i < ballots.size(); i++) {
      Object CurrCandidate = ballots.get(i).getVote(office);
      //Add that vote to the corresponding Candidate's count
      if (potential.indexOf(CurrCandidate) != -1) {
        voteResult[potential.indexOf(CurrCandidate)] += 1;
      }
    }
    //Find the Candidate who has received the most votes
    int max = 0;
    int winIndex = 0;
    for (int z = 0; z < voteResult.length; z++) {
      if (voteResult[z] > max)
        max = voteResult[z];
        winIndex = z;
    }
    return potential.get(winIndex);
  }

}
