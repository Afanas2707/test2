import org.example.GitCliExecutor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GitCliExecutorTest {

    @Test
    public void testGetBranchesNotNull() {
        GitCliExecutor executor = new GitCliExecutor();
        String branches = executor.getBranches();

        // Проверяем, что метод не упал с ошибкой и вернул строку (даже если пустую)
        assertNotNull(branches, "Результат команды git branch не должен быть null");
    }
}
