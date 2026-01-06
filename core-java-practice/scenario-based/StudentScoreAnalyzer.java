class InvalidScoreException extends Exception {
	public InvalidScoreException(String message) {
		super(message);
	}
}

class ScoreUtility {

	static double calculateAverage(int[] scores) throws InvalidScoreException {
		int sum = 0;

		for (int score : scores) {
			validateScore(score);
			sum += score;
		}

		return (double) sum / scores.length;
	}

	static int findMax(int[] scores) throws InvalidScoreException {
		int max = scores[0];

		for (int score : scores) {
			validateScore(score);
			if (score > max) {
				max = score;
			}
		}

		return max;
	}

	static int findMin(int[] scores) throws InvalidScoreException {
		int min = scores[0];

		for (int score : scores) {
			validateScore(score);
			if (score < min) {
				min = score;
			}
		}

		return min;
	}

	static void validateScore(int score) throws InvalidScoreException {
		if (score < 0 || score > 100) {
			throw new InvalidScoreException("Invalid score found: " + score);
		}
	}
}

public class StudentScoreAnalyzer {

	public static void main(String[] args) {

		int[] scores = {78, 85, 92, 66, 89};

		try {
			double average = ScoreUtility.calculateAverage(scores);
			int highest = ScoreUtility.findMax(scores);
			int lowest = ScoreUtility.findMin(scores);

			System.out.println("Average Score: " + average);
			System.out.println("Highest Score: " + highest);
			System.out.println("Lowest Score: " + lowest);

		} catch (InvalidScoreException e) {
			System.out.println(e.getMessage());
		}
	}
}
