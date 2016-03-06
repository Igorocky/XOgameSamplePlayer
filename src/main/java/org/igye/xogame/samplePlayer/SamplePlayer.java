package org.igye.xogame.samplePlayer;

import akka.event.LoggingAdapter;
import org.igye.xogameclient.XOGamePlayer;
import org.igye.xogamecommons.Cell;
import org.igye.xogamecommons.Cells;
import org.igye.xogamecommons.XOField;
import scala.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SamplePlayer implements XOGamePlayer {
    private LoggingAdapter log;

    private String myName;

    private Cell myCellType;

    public SamplePlayer(String myName) {
        this.myName = myName;
    }

    @Override
    public void setLogger(LoggingAdapter loggingAdapter) {
        log = loggingAdapter;
    }

    @Override
    public String getName() {
        return myName;
    }

    @Override
    public void matchStarted(String s) {
        log.info("Match started: {}", s);
    }

    public void gameStarted(String msg, Cell cellType) {
        myCellType = cellType;
    }

    public int turn(XOField field) {
        List<Integer> availableCells = new ArrayList<>();
        for (int i = 0; i < field.cells().length(); i++) {
            if (field.cellAt(i).equals(Cells.EMPTY())) {
                availableCells.add(i);
            }
        }
        return availableCells.get(new Random().nextInt(availableCells.size()));
    }

    public void gameOver(Option<String> winner, String msg, XOField field) {
        log.info("Final state:\n{}", field);
        if (winner.isDefined() && winner.get().equals(myName)) {
            log.info("Game over: success!!!!");
        } else {
            log.info("Game over: fail:(");
        }
    }

    @Override
    public void matchOver(int gamesPlayed, Map<String, Integer> scores, Option<String> winner) {
        if (winner.isDefined() && winner.get().equals(myName)) {
            log.info("SUCCESS!!!!");
        } else {
            log.info("FAIL:(");
        }
    }
}
