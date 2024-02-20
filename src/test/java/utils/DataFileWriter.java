//package utils;
//
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.HashMap;
//
//public class DataFileWriter {
//    public static void writeDataToFile(HashMap<String, String> dataMap, String filePath) {
//        try (FileWriter writer = new FileWriter(filePath)) {
//            for (String key : dataMap.keySet()) {
//                String value = dataMap.get(key);
//                writer.write(key + "," + value + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
