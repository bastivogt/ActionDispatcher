import com.herr.vogt.actions.ActionListener;



public class Main {


    private Counter counter;
    public Main() {
        counter = new Counter(30, 60, 2);

        counter.addAction(Counter.COUNTER_START, this::counterStart);
        counter.addAction(Counter.COUNTER_CHANGE, this::counterChange);
        counter.addAction(Counter.COUNTER_FINISH, (String type, Object source) -> {
            this.counterFinish(type, source);
        });

        counter.run();
    }

    public void counterStart(String type, Object source) {
        Counter c = (Counter) source;
        System.out.println(type + " : " + c.getCount());
        //c.removeAction(Counter.COUNTER_FINISH);
    }

    public void counterChange(String type, Object source) {
        Counter c = (Counter) source;
        System.out.println(type + " : " + c.getCount());
    }

    public void counterFinish(String type, Object source) {
        Counter c = (Counter) source;
        System.out.println(type + " : " + c.getCount());
    }






    public static void main(String[] args) {
        Counter c = new Counter();


        c.addAction(Counter.COUNTER_START, new ActionListener() {
            @Override
            public void onAction(String type, Object source) {
                Counter c = (Counter) source;
                System.out.println(type + " : " + c.getCount());
                //c.removeAction(Counter.COUNTER_FINISH);
            }
        });

        c.addAction(Counter.COUNTER_CHANGE, (String type, Object source) -> {
            System.out.println(type + " : " + c.getCount());
        });




        //c.addAction(Counter.COUNTER_FINISH, Main::onCounterFinish);

        ActionListener counterFinish = (String type, Object source) -> {
            System.out.println(type + " : " + c.getCount());
        };

        c.addAction(Counter.COUNTER_FINISH, counterFinish);

        c.run();
        System.out.println("--------------------------------------------------------------------------------------");

        new Main();
    }

    public static void onCounterFinish(String type, Object source) {
        Counter c = (Counter) source;
        System.out.println(type + " : " + c.getCount());
    }

}
