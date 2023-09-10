package main;

import configuration.JPAConfig;
import entity.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepos;
import service.impl.BookServiceImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class MainTestBook {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepos repos = applicationContext.getBean("bookRepos", BookRepos.class);
    static BookServiceImpl service = applicationContext.getBean("bookServiceImpl", BookServiceImpl.class);

    public static void main(String[] args) {
//        createNewBook();
//        readBook();
//        readBook(1L);
//        deletedById(1L);
//        findAllByNameNotLike("java");
//        findAllByPublishDateBeforeNow();
//        updatePrice(90.0,100.0);
//        deletedByNameAndAuthor("Java","John");
    }

//    Create book
        private static void createNewBook(){
            Book result= service.save(Book.builder().name("Tester ")
                    .author("Roger")
                    .category("IT book")
                    .isbn("ISIBF234234324")
                    .numberOfPage(234)
                    .price(20.5)
                    .publishDate(new Date()).build());
        }
// Show book
    private static void readBook(){
        List<Book> bookList=(List<Book>) repos.findAll();
        System.out.println("Found " + bookList.size() + " book(s) in the table book");
        System.out.println("They are: ");
        bookList.forEach(System.out::println);
    }

// show book according to id
    private static void readBook(Long id){
        Optional<Book> book=repos.findById(id);

       if(book.isPresent()){
           System.out.println( book.get().toString());
       } else {
           System.out.println("Not found any book with book ID!");
       }
    }

// update book
    private static void updateBook(Book book){
       Optional<Book> isExisted=repos.findById(book.getId());

       if(isExisted.isPresent()){
           System.out.println("Book is updated!");
       } else {
           System.out.println("Not found any book with book ID!");
           System.out.println("Book is saved");
       }
       repos.save(book);
    }

// delete book according to id
    private static void deletedById(Long id){
        Optional<Book> isExisted=repos.findById(id);

        if(isExisted.isPresent()){
            repos.deleteById(id);
            System.out.println("Book is deleted!");
        } else {
            System.out.println("Not found any book with book ID!");
        }
    }

    // Hiển thị danh sách các Sách không có tên là Java
    private static void findAllByNameNotLike(String name){
        List<Book> bookList=repos.findAllByNameNotLike(name);

        if(!bookList.isEmpty()){
            bookList.forEach(System.out::println);
        } else {
            System.out.println("List is not found!");
        }
    }

    // Hiển thị danh sách các Sách có ngày publishDate bé hơn ngày hiện tại
    private static void findAllByPublishDateBeforeNow(){
        Date currentDate= new Date();
        List<Book> bookList=repos.findAllByPublishDateBefore(currentDate);

        if(!bookList.isEmpty()){
            System.out.println("Books has publishDate before now date");
            System.out.println("Now date: "+currentDate);
            bookList.forEach(System.out::println);
        } else {
            System.out.println("List is not found!");
        }
    }

    // Update toàn bộ Sách có Giá lớn hơn 100 thành giá 90
    private static void updatePrice(Double newPrice, Double oldPrice){
       List<Book> bookList=repos.findAllByPriceEquals(oldPrice);

       if(!bookList.isEmpty()){
           repos.updateByPrice(newPrice, oldPrice);
           System.out.println("Updating is successful!");
       } else {
           System.out.println("Not found any book with price = "+oldPrice);
       }
    }

    // Xoá toàn bộ Sách có tên là Java và tác giả là Jonh
    private static void deletedByNameAndAuthor(String name, String author){

        List<Book> bookList=repos.findAllByNameLikeAndAuthorLike(name, author);

        if(!bookList.isEmpty()){
            repos.deleteAllByNameLikeAndAuthorLike(name, author);
            System.out.println("Deleting is successful!");
        } else {
            System.out.println(String.format("Not found any book with name is %s and author is %s", name, author));
        }
    }

//    List<Book> findAllByAuthorLike(String author);
    private static void findAllByAuthorLike(String name){

    List<Book> bookList=repos.findAllByAuthorLike(name);

    if(!bookList.isEmpty()){
        System.out.println(String.format("List with name is %s",name));
        bookList.forEach(System.out::println);

    } else {
        System.out.println(String.format("Not found any book with name is %s ", name));
    }
}

//    List<Book> findAllByAuthorLikeAndPrice(String author, Double price);
    private static void findAllByAuthorLikeAndPrice(String name, Double price){

    List<Book> bookList=repos.findAllByAuthorLikeAndPrice(name, price);

    if(!bookList.isEmpty()){
        System.out.println(String.format("Books with name is %s and price is %.2f", name, price));
        bookList.forEach(System.out::println);

    } else {
        System.out.println(String.format("Not found any book with name is %s and price is %.2f", name, price));
    }
}

//    List<Book> findAllByPriceOrNumberOfPage(Double price,int pages);
    private static void findAllByPriceOrNumberOfPage(Double price, int pages){

    List<Book> bookList=repos.findAllByPriceOrNumberOfPage(price, pages);

    if(!bookList.isEmpty()){
        System.out.println(String.format("Books with price is %.2f and pages is %d",price, pages));
        bookList.forEach(System.out::println);

    } else {
        System.out.println(String.format("Not found any book with price is %.2f and pages is %d",price, pages));
    }
}

//    List<Book> findAllByPriceLessThan(Double price);
    private static void findAllByPriceLessThan(Double price){

    List<Book> bookList=repos.findAllByPriceLessThan(price);

    if(!bookList.isEmpty()){
        System.out.println(String.format("Books with price is %.2f",price));
        bookList.forEach(System.out::println);

    } else {
        System.out.println(String.format("Not found any book with price is %.2f",price));
    }
}

//    List<Book> findAllByPriceGreaterThanEqual(Double price);
    private static void findAllByPriceGreaterThanEqual(Double price){

    List<Book> bookList=repos.findAllByPriceGreaterThanEqual(price);

    if(!bookList.isEmpty()){
        System.out.println(String.format("Books with price is %.2f",price));
        bookList.forEach(System.out::println);

    } else {
        System.out.println(String.format("Not found any book with price is %.2f",price));
    }
}
//    List<Book> findAllByNameContaining(String name);
    private static void findAllByNameContaining(String name){

    List<Book> bookList=repos.findAllByNameContaining(name);

    if(!bookList.isEmpty()){
        System.out.println(String.format("List with name is containing %s",name));
        bookList.forEach(System.out::println);

    } else {
        System.out.println(String.format("Not found any book with name is %s ", name));
    }
}
//    List<Book> findAllByIsbnLike(String name);
    private static void findAllByIsbnLike(String name){

    List<Book> bookList=repos.findAllByIsbnLike(name);

    if(!bookList.isEmpty()){
        System.out.println(String.format("List with name is %s",name));
        bookList.forEach(System.out::println);

    } else {
        System.out.println(String.format("Not found any book with name is %s ", name));
    }
}
//    List<Book> findAllByPublishDateAfter(LocalDate date);
    private static void findAllByPublishDateAfter(LocalDate date){
    List<Book> bookList=repos.findAllByPublishDateAfter(date);

    if(!bookList.isEmpty()){
        System.out.println("Books has publishDate after now date");
        System.out.println("Now date: "+date);
        bookList.forEach(System.out::println);
    } else {
        System.out.println("List is not found!");
    }
}
}
