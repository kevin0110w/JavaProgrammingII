/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author woohoo
 */
public class Model {

    private int round;
    private Player[] players;
    private Player winner;

    public Model() {
        this.round = 1;
        this.players = new Player[2];
        this.winner = null;
    }

    public int getRound() {
        return round;
    }

    public void incrementRound() {
        this.round++;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getActivePlayer() {
        if (this.round % 2 != 0) {
            return this.players[0];
        } else {
            return this.players[1];
        }
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
