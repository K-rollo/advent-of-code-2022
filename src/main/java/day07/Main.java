package day07;

public class Main {
    public static void main(String[] args) {
        final String path = "src/main/resources/day-7-input.txt";
        var result = DataFileReader.readFile(path);

        var advDirectories = result.get(0);
        var advFiles = result.get(1);

        for (DataStructure advDirectory : advDirectories) {
            AdvDirectory localAdvDirectory = (AdvDirectory) advDirectory;
            var directoryName = localAdvDirectory.getName();
            for (DataStructure advFile : advFiles) {
                AdvFile localAdvFile = (AdvFile) advFile;
                var isFileInDirectory = localAdvFile.getPath().stream()
                        .anyMatch(str -> str.equals(directoryName));
                if (isFileInDirectory) {
                    localAdvDirectory.increaseSize(localAdvFile.getSize());
                }
            }
        }
//        for (DataStructure advDirectory : advDirectories) {
//            System.out.println(advDirectory);
//        }

        var all = advDirectories.stream()
                .map(dts -> (AdvDirectory) dts)
                .map(AdvDirectory::getSize)
//                .filter(intgr -> intgr <= 100000)
//                .map(in -> {
//                    System.out.println(in);
//                    return in;
//                })
                .reduce(Integer::sum)
                .orElse(0);

        var lower = advDirectories.stream()
                .map(dts -> (AdvDirectory) dts)
                .map(AdvDirectory::getSize)
                .filter(intgr -> intgr <= 100000)
                .map(in -> {
                    System.out.println(in);
                    return in;
                })
                .reduce(Integer::sum)
                .orElse(0);

        var higher = advDirectories.stream()
                .map(dts -> (AdvDirectory) dts)
                .map(AdvDirectory::getSize)
                .filter(intgr -> intgr > 100000)
//                .map(in -> {
//                    System.out.println(in);
//                    return in;
//                })
                .reduce(Integer::sum)
                .orElse(0);


//        System.out.println(all + " " + (higher + lower));
        System.out.println(lower);

        var allfiles = advFiles.stream()
                .map(dts -> (AdvDirectory) dts)
                .map(AdvDirectory::getSize)
//                .filter(intgr -> intgr <= 100000)
//                .map(in -> {
//                    System.out.println(in);
//                    return in;
//                })
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println("Wszystkie pliki: " + allfiles);
    }
}
