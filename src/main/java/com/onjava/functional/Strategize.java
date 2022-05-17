package com.onjava.functional;

public class Strategize {
    Strategy strategy;
    String msg;
    Strategize(String msg) {
        strategy = new Soft(); // [1]
        this.msg = msg;
    }
    void communicate() {
        System.out.println(strategy.approach(msg));
    }
    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                // [2]
                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },
                // [3]相当于重写了approach()方法，即return msg.substring(0, 5)
                msg -> msg.substring(0, 5),
                // [4]相当于重写了approach()方法.即 approach调用了twice()方法
                Unrelated::twice
        };
        Strategy[] strategies2 = {String::toUpperCase};
        Strategize s = new Strategize("Hello there");
        s.communicate();

        for (Strategy newStrategy : strategies) {
            // [5]
            s.changeStrategy(newStrategy);
            // [6]
            s.communicate();
        }
    }
}
