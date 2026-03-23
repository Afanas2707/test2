package org.example;

import java.io.*;

public class GitHelper {
    // Метод 1: Получение веток
    public String getB() {
        String res = "";
        try {
            Process p = Runtime.getRuntime().exec("git branch");
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String l;
            while ((l = r.readLine()) != null) { res += l + "\n"; }
        } catch (Exception e) { e.printStackTrace(); }
        return res;
    }

    // Метод 2: Получение статуса
    public String getS() {
        String res = "";
        try {
            Process p = Runtime.getRuntime().exec("git status");
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String l;
            while ((l = r.readLine()) != null) { res += l + "\n"; }
        } catch (Exception e) { e.printStackTrace(); }
        return res;
    }
}
