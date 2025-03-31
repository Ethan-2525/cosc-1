public class Main {
    public static void main(String[] args) {
        Author author = new Author("Phyllis Reynolds Naylor", "phyllis_naylor@comcast.net", "Amercian");

        Book book = new Book("Shiloh", 5.98, author);

        System.out.println(book);
    }
}