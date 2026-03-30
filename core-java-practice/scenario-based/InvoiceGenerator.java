class InvoiceUtility {

	static String[] parseInvoice(String input) {
		if (input == null) input = "";
		return input.split(",");
	}

	static int getTotalAmount(String[] tasks) {
		int total = 0;

		for (String task : tasks) {
			String[] parts = task.split("-");

			if (parts.length < 2) continue;

			String amountPart = parts[1].replace("INR", "").trim();

			try {
				total += Integer.parseInt(amountPart);
			} catch (Exception e) {
			}
		}

		return total;
	}

	static void displayInvoice(String[] tasks) {
		for (String task : tasks) {
			String[] parts = task.split("-");

			if (parts.length < 2) continue;

			System.out.println(
				"Task: " + parts[0].trim() +
				" | Amount: " + parts[1].trim()
			);
		}
	}
}

public class InvoiceGenerator {

	public static void main(String[] args) {

		String input = "Logo Design - 3000 INR, Web Page - 4500 INR";

		String[] tasks = InvoiceUtility.parseInvoice(input);

		InvoiceUtility.displayInvoice(tasks);

		int total = InvoiceUtility.getTotalAmount(tasks);

		System.out.println("Total Invoice Amount: " + total + " INR");
	}
}
