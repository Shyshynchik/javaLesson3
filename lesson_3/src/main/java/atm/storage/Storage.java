package atm.storage;

import java.util.List;

public interface Storage<T extends Cell> {

    List<T> getCells();

    void add(T cell);

    void addAll(List<T> cells);

}
