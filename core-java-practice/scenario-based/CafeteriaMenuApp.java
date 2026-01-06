import java.util.Scanner;

class CafeteriaUtility {

	static void displayMenu(String[] items) {
		System.out.println("Cafeteria Menu:");
		for (int i = 0; i < items.length; i++) {
			System.out.println(i + " : " + items[i]);
		}
	}

	static String getItemByIndex(String[] items, int index) {
		if (index >= 0 && index < items.length) {
			return items[index];
		}
		return "Invalid Selection";
	}
}

public class CafeteriaMenuApp {

	public static void main(String[] args) {

		String[] menuItems = {
			"Samosa",
			"Veg Sandwich",
			"Burger",
			"Pasta",
			"Pizza",
			"Fried Rice",
			"Noodles",
			"Cold Coffee",
			"Tea",
			"Chocolate Shake"
		};

		Scanner sc = new Scanner(System.in);

		CafeteriaUtility.displayMenu(menuItems);

		System.out.print("Enter item index to order: ");
		int choice = sc.nextInt();

		String selectedItem =
				CafeteriaUtility.getItemByIndex(menuItems, choice);

		System.out.println("You selected: " + selectedItem);

		sc.close();
	}
}
