package org.igye.xogame.samplePlayer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.igye.xogameclient.XOGamePlayer;
import org.igye.xogamecommons.Cell;
import org.igye.xogamecommons.Cells;
import org.igye.xogamecommons.XOField;
import scala.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SamplePlayer implements XOGamePlayer {
    private Logger log = LogManager.getLogger();

    private String myName;

    private Cell myCellType;

    public SamplePlayer(String myName) {
        this.myName = myName;
    }

    @Override
    public String getName() {
        return myName;
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

    public void gameOver(Option<String> winner, String msg) {
        if (winner.isDefined() && winner.get().equals(myName)) {
            log.info("SUCCESS!!!!");
        } else {
            log.info("FAIL:(");
        }
    }
}
