package serial;

import lombok.Data;

import java.io.Serializable;

@Data
public class FlyPig implements Serializable {

    private static String AGE = "269";

    private String name;

    private String color;

    transient private String car;

    @Override
    public String toString() {
        return "FlyPig{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", car='" + car + '\'' +
                ", AGE='" + AGE + '\'' +
                '}';
    }
}
