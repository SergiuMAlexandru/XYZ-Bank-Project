//package utils;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//
//public class DataFileReader {
//    public static HashMap<String, String> readDataFromFile(String filePath) {
//        HashMap<String, String> dataMap = new HashMap<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length >= 2) {
//                    String key = parts[0];
//                    String value = parts[1];
//                    dataMap.put(key, value);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return dataMap;
//    }
//}
