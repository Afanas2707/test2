package org.example;

import java.io.*;

/**
 * Класс для выполнения команд Git через интерфейс командной строки (CLI).
 */
public class GitCliExecutor {

    /**
     * Возвращает список локальных веток репозитория в виде сырой строки.
     */
    public String getBranches() {
        return executeGitCommand("git branch");
    }

    /**
     * Возвращает текущий статус рабочего дерева (измененные/новые файлы).
     */
    public String getStatus() {
        return executeGitCommand("git status");
    }

    /**
     * Внутренний метод для выполнения консольных команд.
     * Устраняет дублирование кода (DRY).
     *
     * @param command строка команды (например, "git log")
     * @return вывод консоли в виде строки
     */
    private String executeGitCommand(String command) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (IOException e) {
            // В реальном проекте здесь должно быть логирование (Logger)
            System.err.println("Ошибка выполнения команды Git: " + e.getMessage());
        }
        return output.toString();
    }
}
