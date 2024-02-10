package snakeAndLadder.models;

public class Ladder {
    private int ladderEntry;
    private int ladderExit;

    public Ladder(int ladderEntry, int ladderExit) {
        this.ladderEntry = ladderEntry;
        this.ladderExit = ladderExit;
    }

    public int getLadderEntry() {
        return ladderEntry;
    }

    public void setLadderEntry(int ladderEntry) {
        this.ladderEntry = ladderEntry;
    }

    public int getLadderExit() {
        return ladderExit;
    }

    public void setLadderExit(int ladderExit) {
        this.ladderExit = ladderExit;
    }
}
