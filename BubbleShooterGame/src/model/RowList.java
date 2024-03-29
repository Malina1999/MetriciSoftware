package model;

import java.util.ArrayList;
import java.util.Objects;

public class RowList extends ArrayList<Bubble> {
    private boolean full;

    /**
     * constructor, sets if the row a full row is
     * (if it fills the screen entirely)
     * @param full true is it is a full row, else false
     */
    public RowList(boolean full) {
        this.full = full;
    }

    /**
     * returns whether the row is a full row
     * @return true if it a full row, else false
     */
    public boolean isFull(){
        return full;
    }

    /**
     * sets the row to a full row
     */
    public void setFull(){
        full=true;
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

}
