package main.classes;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Student> students;

    public Library() {
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean hasBook(Book book) {return this.books.contains(book);}

    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Lends a book to a student. Removes the book from the library and adds it to the student's list.
     * This operation fails if the library doesn't have the student or the book or the student already has the book.
     *
     * @param book    The book to be lent.
     * @param student The student who is going to borrow the book.
     * @return        Returns true if the operation is successful and false otherwise.
     */
    public boolean lendBook(Book book, Student student) {
        if (!this.hasBook(book)) {
            System.out.println("!! Book " + book.getTitle() + " not registered.");
            return false;
        }
        if (!this.students.contains(student)) {
            System.out.println("!! Student " + student.getName() + " not registered.");
            return false;
        }
        if (student.hasBook(book)) {
            System.out.println("!! Student already has the book.");
            return false;
        }

        this.books.remove(book);
        student.addBook(book);
        System.out.println(book.getTitle() + " lent to " + student.getName() + ".");
        return true;
    }

    /**
     * The student returns the book to the library. Removes the book from the student's list and adds it to the library.
     * This operation fails if the library doesn't have the student or the student doesn't have the book.
     *
     * @param book    The book to be returned.
     * @param student The student who is going to return the book.
     * @return Returns true if the operation is successful and false otherwise.
     */
    public boolean returnBook(Book book, Student student) {
        if (!this.students.contains(student)) {
            System.out.println("!! Student " + student.getName() + " not registered.");
            return false;
        }
        if (!student.hasBook(book)) {
            System.out.println("!! " + student.getName() + " doesn't have the book.");
            return false;
        }

        this.books.add(book);
        student.removeBook(book);
        System.out.println(student.getName() + " returned " + book.getTitle() + ".");
        return true;
    }

    /**
     * Returns a list of students where the specified field matches any of the keys provided.
     * The specified field is determined by the searchByType argument, which can be id or name (but not title or author).
     *
     * @param searchByType Specifies the field used for searching (id, name).
     * @param keys         The list of keys to search for.
     * @return             The list of students that match the search criteria. Returns null if search type is title or author.
     */
    public ArrayList<Student> searchStudents(SearchByType searchByType, ArrayList<Object> keys) {
        ArrayList<Student> answer = new ArrayList<Student>();
        if (searchByType == SearchByType.ID) {
            for (Student student : students) {
                if (keys.contains(student.getId())) { answer.add(student);}
            }
        }
        if (searchByType == SearchByType.NAME) {
            for (Student student : students) {
                if (keys.contains(student.getName())) { answer.add(student);}
            }
        }
        return answer;
    }

    /**
     * Returns a list of books where the specified field matches any of the keys provided.
     * The specified field is determined by the searchByType argument, which can be id, title, or author (but not name).
     *
     * @param searchByType Specifies the field used for searching (id, title, or author).
     * @param keys         The list of keys to search for.
     * @return             The list of books that match the search criteria. Returns null if search type is name.
     */
    public ArrayList<Book> searchBooks(SearchByType searchByType, ArrayList<Object> keys) {
        ArrayList<Book> answer = new ArrayList<Book>();
        if (searchByType == SearchByType.ID) {
            for (Book book : books) {
                if (keys.contains(book.getId())) { answer.add(book);}
            }
        }
        if (searchByType == SearchByType.TITLE) {
            for (Book book : books) {
                if (keys.contains(book.getTitle())) { answer.add(book);}
            }
        }
        if (searchByType == SearchByType.AUTHOR) {
            for (Book book : books) {
                if (keys.contains(book.getAuthor())) { answer.add(book);}
            }
        }
        return answer;
    }

    /**
     * Displays the books of library.
     */
    public void displayBooks() {
        System.out.println("Available books in library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * Displays the students registered in the library.
     */
    public void displayStudents() {
        System.out.println("Registered students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}