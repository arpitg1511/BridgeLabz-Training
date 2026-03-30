class BookItem {
    private String title;
    private String author;

    public BookItem(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getKey() {
        return title + "-" + author;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}
