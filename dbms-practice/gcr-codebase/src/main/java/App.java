
import dao.StudentDao;
import model.Student;

/**
 * 🚀 App — entry point. Demonstrates full CRUD with pure JDBC.
 */
public class App {

    public static void main(String[] args) throws Exception {

        StudentDao dao = new StudentDao();

        // ── CREATE ──────────────────────────────────────────
        System.out.println("\n━━━ CREATE ━━━");
        dao.insert(new Student("Shravan", "shravan@mail.com", 22));
        dao.insert(new Student("Ravi",    "ravi@mail.com",    25));
        dao.insert(new Student("Priya",   "priya@mail.com",   21));

        // ── READ ALL ────────────────────────────────────────
        System.out.println("\n━━━ READ ALL ━━━");
        dao.findAll().forEach(System.out::println);

        // ── READ ONE ────────────────────────────────────────
        System.out.println("\n━━━ READ BY ID ━━━");
        dao.findById(1).ifPresentOrElse(
            s -> System.out.println("  Found: " + s),
            () -> System.out.println("  Not found.")
        );

        // ── UPDATE ──────────────────────────────────────────
        System.out.println("\n━━━ UPDATE ━━━");
        dao.update(new Student(1, "Shravan Kumar", "shravan@mail.com", 23));

        // ── DELETE ──────────────────────────────────────────
        System.out.println("\n━━━ DELETE ━━━");
        dao.delete(2);

        // ── FINAL STATE ─────────────────────────────────────
        System.out.println("\n━━━ FINAL STATE ━━━");
        dao.findAll().forEach(System.out::println);
    }
}