/* ---------- Meal Plan Hierarchy ---------- */

interface MealPlan {
    String getMealType();
    int getCalories();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian Meal";
    }

    public int getCalories() {
        return 1800;
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan Meal";
    }

    public int getCalories() {
        return 1600;
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto Meal";
    }

    public int getCalories() {
        return 2000;
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein Meal";
    }

    public int getCalories() {
        return 2200;
    }
}

/* ---------- Generic Meal Wrapper ---------- */

class Meal<T extends MealPlan> {

    private final String userName;
    private final T plan;

    public Meal(String userName, T plan) {
        this.userName = userName;
        this.plan = plan;
    }

    public void displayMealPlan() {
        System.out.println(
                "User: " + userName +
                " | Plan: " + plan.getMealType() +
                " | Calories: " + plan.getCalories()
        );
    }

    public T getPlan() {
        return plan;
    }
}

/* ---------- Generic Meal Generator ---------- */

class MealPlanGenerator {

    // Generic method with bounded type parameter
    public static <T extends MealPlan> Meal<T> generateMeal(
            String userName, T plan) {

        // Simple validation logic
        if (plan.getCalories() <= 0) {
            throw new IllegalArgumentException("Invalid meal plan");
        }

        return new Meal<>(userName, plan);
    }
}

/* ---------- Driver Class ---------- */

public class MealPlanApp {

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal =
                MealPlanGenerator.generateMeal(
                        "Arpit", new VegetarianMeal());

        Meal<VeganMeal> veganMeal =
                MealPlanGenerator.generateMeal(
                        "Neha", new VeganMeal());

        Meal<KetoMeal> ketoMeal =
                MealPlanGenerator.generateMeal(
                        "Rahul", new KetoMeal());

        Meal<HighProteinMeal> proteinMeal =
                MealPlanGenerator.generateMeal(
                        "Simran", new HighProteinMeal());

        vegMeal.displayMealPlan();
        veganMeal.displayMealPlan();
        ketoMeal.displayMealPlan();
        proteinMeal.displayMealPlan();
    }
}
