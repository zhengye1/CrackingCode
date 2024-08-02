package com.vincent.util;

public class Interval {
    public int start;
    public int end;
    public boolean closed;
    public Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
        this.closed = true; // by default, the interval is closed
    }

    // set the flag for closed/open
    public void setClosed(boolean closed)
    {
        this.closed = closed;
    }
}
