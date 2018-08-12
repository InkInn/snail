package patterns.state;

public interface ILift {

    void open();

    void close();

    void run();

    void stop();
}
