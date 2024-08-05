package com.vincent.util;

public class Interval {
    public int start;
    public int end;
    public boolean closed;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.closed = true; // by default, the interval is closed
    }

    // set the flag for closed/open
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + end;
        result = prime * result + start;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Interval other = (Interval) obj;
        if (end != other.end) return false;
        return start == other.start;
    }
}
