package day07;

import java.util.List;

public class AdvDirectory implements DataStructure {

    private int size = 0;
    private final String name;

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public List<String> getPath() {
        return path;
    }

    private final List<String> path;

    public AdvDirectory(String name, List<String> path) {
        this.name = name;
        this.path = path;
    }

    public String toString() {
        return path + " " + name + " " + size;
    }

    public void increaseSize(int additionalSize) {
        size += additionalSize;
    }
}
