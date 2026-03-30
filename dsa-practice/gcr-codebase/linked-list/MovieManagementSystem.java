class MovieNode {
    String movieTitle;
    String director;
    int yearOfRelease;
    double rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String movieTitle, String director, int yearOfRelease, double rating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }

    void display() {
        System.out.println(
                "Movie Name : " + movieTitle +
                "\nDirector : " + director +
                "\nYear of Release : " + yearOfRelease +
                "\nRating : " + rating
        );
        System.out.println("----------------------");
    }
}

public class MovieManagementSystem {

    public static void main(String[] args) {

        // Initial node
        MovieNode head = new MovieNode("Marty Supreme", "Josh Safdie", 2025, 8.3);
        MovieNode tail = head;

        // addAtLast
        tail = addAtLast(tail, "Inception", "Christopher Nolan", 2010, 8.8);
        tail = addAtLast(tail, "Interstellar", "Christopher Nolan", 2014, 8.6);

        // addAtBeginning
        head = addAtBeginning(head, "Avatar", "James Cameron", 2009, 7.9);

        // addAtPosition
        head = addAtPosition(head, tail, "Tenet", "Christopher Nolan", 2020, 7.4, 3);

        // display from beginning
        System.out.println("Display From Beginning:");
        displayFromBeginning(head);

        // updateByMovieTitle
        updateByMovieTitle(head, "Avatar", 8.1);

        // searchByDirector
        MovieNode foundDirector = searchByDirector(head, "Christopher Nolan");
        if (foundDirector != null) {
            System.out.println("Found by Director:");
            foundDirector.display();
        }

        // searchByRating
        MovieNode foundRating = searchByRating(head, 8.6);
        if (foundRating != null) {
            System.out.println("Found by Rating:");
            foundRating.display();
        }

        // deleteByMovieTitle
        head = deleteByMovieTitle(head, "Inception");

        // update tail after deletion
        tail = head;
        while (tail.next != null) tail = tail.next;

        // display from last
        System.out.println("Display From Last:");
        displayFromLast(tail);
    }

    static MovieNode addAtBeginning(MovieNode head, String title, String director,
                                    int yearOfRelease, double rating) {

        MovieNode newNode = new MovieNode(title, director, yearOfRelease, rating);

        if (head == null) return newNode;

        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    static MovieNode addAtLast(MovieNode tail, String title, String director,
                               int yearOfRelease, double rating) {

        MovieNode newNode = new MovieNode(title, director, yearOfRelease, rating);

        if (tail == null) return newNode;

        tail.next = newNode;
        newNode.prev = tail;
        return newNode;
    }

    static MovieNode addAtPosition(MovieNode head, MovieNode tail, String title,
                                   String director, int yearOfRelease,
                                   double rating, int position) {

        if (position <= 1 || head == null) {
            return addAtBeginning(head, title, director, yearOfRelease, rating);
        }

        MovieNode temp = head;

        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            addAtLast(temp, title, director, yearOfRelease, rating);
            return head;
        }

        MovieNode newNode = new MovieNode(title, director, yearOfRelease, rating);

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;

        return head;
    }

    static MovieNode deleteByMovieTitle(MovieNode head, String title) {

        if (head == null) return null;

        if (head.movieTitle.equalsIgnoreCase(title)) {
            MovieNode newHead = head.next;
            if (newHead != null) newHead.prev = null;
            return newHead;
        }

        MovieNode temp = head;

        while (temp != null) {
            if (temp.movieTitle.equalsIgnoreCase(title)) {

                if (temp.next == null) {
                    temp.prev.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return head;
            }
            temp = temp.next;
        }

        System.out.println("Movie Title not found");
        return head;
    }

    static MovieNode searchByDirector(MovieNode head, String director) {
        while (head != null) {
            if (head.director.equalsIgnoreCase(director)) return head;
            head = head.next;
        }
        return null;
    }

    static MovieNode searchByRating(MovieNode head, double rating) {
        while (head != null) {
            if (Double.compare(head.rating, rating) == 0) return head;
            head = head.next;
        }
        return null;
    }

    static void displayFromBeginning(MovieNode head) {
        while (head != null) {
            head.display();
            head = head.next;
        }
    }

    static void displayFromLast(MovieNode tail) {
        while (tail != null) {
            tail.display();
            tail = tail.prev;
        }
    }

    static void updateByMovieTitle(MovieNode head, String movieTitle, double rating) {
        while (head != null) {
            if (head.movieTitle.equalsIgnoreCase(movieTitle)) {
                head.rating = rating;
                return;
            }
            head = head.next;
        }
        System.out.println("Movie not found");
    }
}
