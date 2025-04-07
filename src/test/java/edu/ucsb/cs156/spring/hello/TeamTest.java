package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;
    Team team_2;
    Team team_3;
    Team team_4; 
    Team team_5; 

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
        team_2 = new Team("test-team");
        team_3 = new Team("test-team");
        team_3.addMember("member 1");
        team_4 = new Team("other-team"); 
        team_5 = new Team("other-team"); 
        team_5.addMember("member 1");
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
       assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_bool() {
       assert(team.equals(team)); //Case 1
       assert(!team.equals("not a team")); //Case 2
       //Case 3
       //Same name, same members
       assert(team.equals(team_2)); 
       //Same name, different members
       assert(!team.equals(team_3));
       //Different name, same members
       assert(!team.equals(team_4)); 
       //Different name, different members
       assert(!team.equals(team_5)); 
    }

    @Test
    public void hashCode_returns_correct_int() {
       int result = team.hashCode(); 
       int expectedResult = -1226298695; 
       assertEquals(expectedResult, result);
    }
}
