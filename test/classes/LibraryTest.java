package test.classes;

import main.classes.Book;
import main.classes.Library;
import main.classes.SearchByType;
import main.classes.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

        assertTrue(library.returnBook(book2, student3));
        assertFalse(library.returnBook(book5, student4));
        assertFalse(library.returnBook(book5, student3));
        assertTrue(library.hasBook(book2));
        assertFalse(student3.hasBook(book2));
    }

    @Test
    void searchStudents() {
        Library library = new Library();

        Student student1 = new Student("Alice", 10);
        Student student2 = new Student("Bob", 11);
        Student student3 = new Student("John", 12);
        Student student4 = new Student("Not-registered-student", 13);

        library.addStudent(student1);
        library.addStudent(student2);
        library.addStudent(student3);

        ArrayList<Object> first_keys = new ArrayList<Object>();
        first_keys.add(10);
        first_keys.add(11);
        ArrayList<Student> first_answer = new ArrayList<Student>();
        first_answer.add(student1);
        first_answer.add(student2);

        ArrayList<Object> second_keys = new ArrayList<Object>();
        second_keys.add(10);
        second_keys.add(13);
        ArrayList<Student> second_answer = new ArrayList<Student>();
        second_answer.add(student1);

        ArrayList<Object> third_keys = new ArrayList<Object>();
        third_keys.add(14);
        third_keys.add(13);
        ArrayList<Student> third_answer = new ArrayList<Student>();

        ArrayList<Object> forth_keys = new ArrayList<Object>();
        forth_keys.add("Alice");
        forth_keys.add("John");
        ArrayList<Student> forth_answer = new ArrayList<Student>();
        forth_answer.add(student1);
        forth_answer.add(student3);

        ArrayList<Object> fifth_keys = new ArrayList<Object>();
        fifth_keys.add("Bob");
        fifth_keys.add("Not-registered-student");
        ArrayList<Student> fifth_answer = new ArrayList<Student>();
        fifth_answer.add(student2);


        assertAll(() -> assertIterableEquals(first_answer, library.searchStudents(SearchByType.ID, first_keys)),
                () -> assertIterableEquals(second_answer, library.searchStudents(SearchByType.ID, second_keys)),
                () -> assertIterableEquals(third_answer, library.searchStudents(SearchByType.ID, third_keys)),
                () -> assertIterableEquals(forth_answer, library.searchStudents(SearchByType.NAME, forth_keys)),
                () -> assertIterableEquals(fifth_answer, library.searchStudents(SearchByType.NAME, fifth_keys)));
    }

    @Test
    void searchBooks() {
        Library library = new Library();

        Book book1 = new Book("Book-1", "Author-1", 10);
        Book book2 = new Book("Book-2", "Author-2", 11);
        Book book3 = new Book("Book-3", "Author-3", 12);
        Book book4 = new Book("Book-4", "Author-1", 13);
        Book book5 = new Book("Not-owned-book", "Author-1", 15);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        ArrayList<Object> first_keys = new ArrayList<Object>();
        first_keys.add(10);
        first_keys.add(11);
        ArrayList<Book> first_answer = new ArrayList<Book>();
        first_answer.add(book1);
        first_answer.add(book2);

        ArrayList<Object> second_keys = new ArrayList<Object>();
        second_keys.add(10);
        second_keys.add(15);
        ArrayList<Book> second_answer = new ArrayList<Book>();
        second_answer.add(book1);

        ArrayList<Object> third_keys = new ArrayList<Object>();
        third_keys.add(14);
        third_keys.add(15);
        ArrayList<Book> third_answer = new ArrayList<Book>();

        ArrayList<Object> forth_keys = new ArrayList<Object>();
        forth_keys.add("Book-1");
        forth_keys.add("Book-2");
        ArrayList<Book> forth_answer = new ArrayList<Book>();
        forth_answer.add(book1);
        forth_answer.add(book2);

        ArrayList<Object> fifth_keys = new ArrayList<Object>();
        fifth_keys.add("Book-3");
        fifth_keys.add("Not-owned-book");
        ArrayList<Book> fifth_answer = new ArrayList<Book>();
        fifth_answer.add(book3);

        ArrayList<Object> sixth_keys = new ArrayList<Object>();
        sixth_keys.add("Author-1");
        ArrayList<Book> sixth_answers = new ArrayList<Book>();
        sixth_answers.add(book1);
        sixth_answers.add(book4);

        ArrayList<Object> seventh_keys = new ArrayList<Object>();
        seventh_keys.add("Author-2");
        seventh_keys.add("Author-4");
        ArrayList<Book> seventh_answer = new ArrayList<Book>();
        seventh_answer.add(book2);


        assertAll(() -> assertIterableEquals(first_answer, library.searchBooks(SearchByType.ID, first_keys)),
                () -> assertIterableEquals(second_answer, library.searchBooks(SearchByType.ID, second_keys)),
                () -> assertIterableEquals(third_answer, library.searchBooks(SearchByType.ID, third_keys)),
                () -> assertIterableEquals(forth_answer, library.searchBooks(SearchByType.TITLE, forth_keys)),
                () -> assertIterableEquals(fifth_answer, library.searchBooks(SearchByType.TITLE, fifth_keys)),
                () -> assertIterableEquals(sixth_answers, library.searchBooks(SearchByType.AUTHOR, sixth_keys)),
                () -> assertIterableEquals(seventh_answer, library.searchBooks(SearchByType.AUTHOR, seventh_keys)));
    }

    @Test
    void displayBooks() {
    }

    @Test
    void displayStudents() {
    }
}