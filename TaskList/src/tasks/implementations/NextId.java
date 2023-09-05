package tasks.implementations;

import tasks.interfaces.Id;

public class NextId implements Id {

    private long nextId=0;
    @Override
    public long nextId() {
        return ++nextId;
    }
}
