package com.arpit.json_data_handling;

import java.io.*;
import java.util.*;
import org.json.*;

public class IPLCensorAnalyzer {

    // -------- CENSORING RULES --------
    private static String maskTeamName(String team) {
        int index = team.indexOf(" ");
        if (index == -1) {
            return "***";
        }
        return team.substring(0, index) + " ***";
    }

    private static String redactPlayer() {
        return "REDACTED";
    }

    // -------- JSON PROCESSING --------
    public static void processJson(String inputFile, String outputFile) throws Exception {
        StringBuilder jsonData = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line;
        while ((line = br.readLine()) != null) {
            jsonData.append(line);
        }
        br.close();

        JSONArray matches = new JSONArray(jsonData.toString());

        for (int i = 0; i < matches.length(); i++) {
            JSONObject match = matches.getJSONObject(i);

            String team1 = match.getString("team1");
            String team2 = match.getString("team2");

            match.put("team1", maskTeamName(team1));
            match.put("team2", maskTeamName(team2));
            match.put("player_of_match", redactPlayer());
        }

        FileWriter fw = new FileWriter(outputFile);
        fw.write(matches.toString(2));
        fw.close();
    }

    // -------- CSV PROCESSING --------
    public static void processCsv(String inputFile, String outputFile) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        FileWriter fw = new FileWriter(outputFile);

        String header = br.readLine();
        fw.write(header + "\n");

        String row;
        while ((row = br.readLine()) != null) {
            String[] data = row.split(",");

            data[1] = maskTeamName(data[1]); // team1
            data[2] = maskTeamName(data[2]); // team2
            data[6] = redactPlayer();        // player_of_match

            fw.write(String.join(",", data) + "\n");
        }

        br.close();
        fw.close();
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {
        try {
            processJson("ipl.json", "ipl_censored.json");
            processCsv("ipl.csv", "ipl_censored.csv");
            System.out.println("Censorship completed successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
