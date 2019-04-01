import com.herr.vogt.actions.ActionDispatcher;

public class Counter extends ActionDispatcher {


    protected int start, end, step, count;

    public static final String COUNTER_START = "counterStart";
    public static final String COUNTER_CHANGE = "counterChange";
    public static final String COUNTER_FINISH = "counterFinish";



    public Counter(int start, int end, int step) {
        reset(start, end, step);
    }

    public Counter(int start, int end) {
        this(start, end, 1);
    }

    public Counter() {
        this(0, 10, 1);
    }


    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public void run() {
        dispatchAction(COUNTER_START, this);
        for(; count < end; count += step) {
            dispatchAction(COUNTER_CHANGE, this);
        }
        dispatchAction(COUNTER_FINISH, this);
    }

    public void reset(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
        count = 0;
    }
}
