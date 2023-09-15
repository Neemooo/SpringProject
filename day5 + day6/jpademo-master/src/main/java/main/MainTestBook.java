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
//    static BookServiceImpl service = applicationContext.getBean("bookServiceImpl", BookServiceImpl.class);

    public static void main(String[] args) {
        findByBookDetailIsbn("test");

//        findAllByNameOrAuthor("Star Wars","aafsd");
    }

    private static void findAllByNameAndAuthor(String name, String author){

        List<Book> bookList=repos.findAllByNameLikeAndAuthorLike(name, author);

        if(!bookList.isEmpty()){
            System.out.println(String.format("Books with name are %s and author is %s", name, author));
            bookList.forEach(System.out::println);
        } else {
            System.out.println(String.format("Not found any book with name is %s and author is %s", name, author));
        }
    }

    private static void findAllByNameOrAuthor(String name, String author){

        List<Book> bookList=repos.findAllByNameLikeOrAuthorLike(name, author);

        if(!bookList.isEmpty()){
            System.out.println(String.format("Books with name are %s and author is %s", name, author));
            bookList.forEach(System.out::println);
        } else {
            System.out.println(String.format("Not found any book with name is %s or author is %s", name, author));
        }
    }

    private static void findAllByAuthorLike(String name){

        List<Book> bookList=repos.findAllByAuthorLike(name);

        if(!bookList.isEmpty()){
            System.out.println(String.format("List with name is %s",name));
            bookList.forEach(System.out::println);

        } else {
            System.out.println(String.format("Not found any book with name is %s ", name));
        }
    }

    private static void findByBookDetailIsbn(String name){
        Optional<Book> isExisted= Optional.ofNullable(repos.findByBookDetailIsbn(name));
        if(isExisted.isPresent()){
            System.out.println(String.format("Book with bookDetail is %s!", name));
            System.out.println(isExisted.get().toString());
        } else {
            System.out.println(String.format("Not found any book with bookDetail is %s!", name));
        }
    }

    private static void findAllByPriceLessThan(Integer price){

        List<Book> bookList=repos.findAllByBookDetailPriceLessThan(price);

        if(!bookList.isEmpty()){
            System.out.println(String.format("Books with price is > %d",price));
            bookList.forEach(System.out::println);

        } else {
            System.out.println(String.format("Not found any book with price is > %d",price));
        }
    }

    private static void findAllByPriceLessThanEqual(Integer price){

        List<Book> bookList=repos.findAllByBookDetailPriceLessThanEqual(price);

        if(!bookList.isEmpty()){
            System.out.println(String.format("Books with price is <= %d",price));
            bookList.forEach(System.out::println);

        } else {
            System.out.println(String.format("Not found any book with price is <=  %d",price));
        }
    }

    private static void findAllByNameContaining(String name){
        List<Book> bookList=repos.findAllByNameContaining(name);

        if(!bookList.isEmpty()){
            bookList.forEach(System.out::println);
        } else {
            System.out.println("List is not found!");
        }
    }

    private static void findAllByBookDetailPriceGreaterThanEqual(Integer price){

        List<Book> bookList=repos.findAllByBookDetailPriceGreaterThanEqual(price);

        if(!bookList.isEmpty()){
            System.out.println(String.format("Books with price is > %d",price));
            bookList.forEach(System.out::println);

        } else {
            System.out.println(String.format("Not found any book with price is > %d",price));
        }
    }

}
