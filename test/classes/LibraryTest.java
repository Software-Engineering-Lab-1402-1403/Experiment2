package test.classes;

import main.classes.Book;
import main.classes.Library;
import main.classes.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void lendBook() {
        Library library = new Library();

        Book book1 = new Book("Book-1", "Author-1", 10);
        Book book2 = new Book("Book-2", "Author-2", 11);
        Book book3 = new Book("Book-3", "Author-3", 12);
        Book book4 = new Book("Book-4", "Author-1", 13);
        Book book5 = new Book("Not-owned-book", "Author-1", 15);

        Student student1 = new Student("Alice", 10);
        Student student2 = new Student("Bob", 11);
        Student student3 = new Student("John", 12);
        Student student4 = new Student("Not-registered-student", 13);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        library.addStudent(student1);
        library.addStudent(student2);
        library.addStudent(student3);


        assertAll(() -> assertTrue(library.lendBook(book2, student3)),
                () -> assertFalse(library.lendBook(book1, student4)));
        assertFalse(library.lendBook(book5, student1));
        assertTrue(student3.hasBook(book2));
        assertFalse(library.hasBook(book2));
    }

    @Test
    void returnBook() {
        Library library = new Library();

        Book book1 = new Book("Book-1", "Author-1", 10);
        Book book2 = new Book("Book-2", "Author-2", 11);
        Book book3 = new Book("Book-3", "Author-3", 12);
        Book book4 = new Book("Book-4", "Author-1", 13);
        Book book5 = new Book("Not-owned-book", "Author-1", 15);

        Student student1 = new Student("Alice", 10);
        Student student2 = new Student("Bob", 11);
        Student student3 = new Student("John", 12);
        Student student4 = new Student("Not-registered-student", 13);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        library.addStudent(student1);
        library.addStudent(student2);
        library.addStudent(student3);


        library.lendBook(book1, student1);
        library.lendBook(book2, student3);
        library.returnBook(book2, student3);

        assertTrue(library.returnBook(book2, student3));
        assertFalse(library.returnBook(book5, student4));
        assertFalse(library.returnBook(book5, student3));
        assertTrue(library.hasBook(book2));
        assertFalse(student3.hasBook(book2));
    }

    @Test
    void searchStudents() {
    }

    @Test
    void searchBooks() {
    }

    @Test
    void displayBooks() {
    }

    @Test
    void displayStudents() {
    }
}