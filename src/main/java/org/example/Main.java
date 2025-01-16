package org.example;

public class Main {
    public static void main(String[] args) {

        Config config = Config.parseArgs(args);

        if (config.getData().isEmpty() && config.getInFile() == null) {
            System.out.println("Error: No input data provided or invalid file");
            return;
        }

        String data = config.getData().isEmpty()
                ? FileManager.readFile(config.getInFile())
                : config.getData();

        if (data == null) {
            System.out.println("Error: Unable to read input file");
            return;
        }

        String result = TextProcessor.process(data, config);

        if (config.getOutFile() != null) {
            FileManager.writeFile(config.getOutFile(), result);
        } else {
            System.out.println(result);
        }
    }
}

