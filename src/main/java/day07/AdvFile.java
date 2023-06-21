package day07;

import java.util.List;

public class AdvFile implements DataStructure{

    private final int size;
    private final String name;
    private final List<String> path;

    public int getSize() {
        return size;
    }


    public String getName() {
        return name;
    }

    public List<String> getPath() {
        return path;
    }

    public AdvFile(String name, List<String> path, int size) {
        this.name = name;
        this.path = path;
        this.size = size;
    }

    public String toString() {
        return path + " " + name + " " + size;
    }
}
