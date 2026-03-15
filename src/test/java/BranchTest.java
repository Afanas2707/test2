import org.example.Branch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BranchTest {

    @Test
    public void testFormatName_NormalString() {
        // Проверяем логику замены пробелов и смены регистра
        String formatted = Branch.formatName("New Feature UI");
        assertEquals("new-feature-ui", formatted);
    }

    @Test
    public void testFormatName_EmptyInput() {
        // Проверяем логику защиты от пустых строк (пробелов)
        String formatted = Branch.formatName("   ");
        assertEquals("untitled-branch", formatted);
    }

    @Test
    public void testIsProtected_MainBranch() {
        // Проверяем логику защищенных веток
        Branch mainBranch = new Branch("main");
        assertTrue(mainBranch.isProtected(), "Ветка 'main' должна распознаваться как защищенная");
    }

    @Test
    public void testIsProtected_RegularBranch() {
        // Обычная ветка не должна быть защищенной
        Branch featureBranch = new Branch("My Feature");
        assertFalse(featureBranch.isProtected(), "Обычная ветка не должна быть защищенной");
        // Заодно проверим, что конструктор отформатировал имя
        assertEquals("my-feature", featureBranch.getName());
    }
}