package mvc.controller;

import mvc.dto.BookDTO;
import mvc.dto.BookDetailDTO;
import mvc.models.book.Book;
import mvc.models.book.BookDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import mvc.service.interface_book.IBookDetailService;
import mvc.service.interface_book.IBookService;
import mvc.service.interface_book.ICategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    IBookService bookService;
    IBookDetailService bookDetailService;
    ICategoryService categoryService;

    @RequestMapping("")
    public String findAll(Model model){
        List<Book> books=bookService.findAll();

        List<BookDTO> list=books.stream()
                                .map(BookDTO::new)
                                .collect(Collectors.toList());
        model.addAttribute("bookList",list);
        return "/Book/index";
    }

    @RequestMapping("/edit/{id}")
    public String editBook(Model model, @PathVariable Long id){

        Optional<Book> book=bookService.findById(id);

        if(book.isPresent()){
           Optional<BookDetail>  bookDetail= bookDetailService.findById(id);
            model.addAttribute("book",new BookDTO(book.get()));
            model.addAttribute("category",categoryService.findAll());
            model.addAttribute("bookDetail",new BookDetailDTO(bookDetail.get()));

            return "/Book/form";
        }
        model.addAttribute("message","Not found any book with your request!");
        return "/Book/index";
    }

    @RequestMapping("/create")
    public String createBook(Model model){
        model.addAttribute("book",new BookDTO());
        model.addAttribute("category",categoryService.findAll());
        model.addAttribute("bookDetail",new BookDetailDTO());

        return "/Book/form";
    }

    @PostMapping("/update")
    public String updateBook(@Valid @ModelAttribute("book") BookDTO bookDTO,
                             @Valid @ModelAttribute("bookDetail") BookDetailDTO bookDetailDTO,
                             BindingResult result, Model model, RedirectAttributes attributes){
        Optional<Long> id=Optional.ofNullable(bookDTO.getId());

        if(result.hasErrors() && id.isPresent()){
            model.addAttribute("book",bookDTO);
            model.addAttribute("category",categoryService.findAll());
            model.addAttribute("bookDetail",bookDetailDTO);

            return "/Book/form";
        } else if(result.hasErrors() && !id.isPresent()){
            model.addAttribute("book",new BookDTO());
            model.addAttribute("category",categoryService.findAll());
            model.addAttribute("bookDetail",new BookDetailDTO());

            return "/Book/form";
        }


        if(id.isPresent()){
            Book book=new Book(bookDTO);
            book.setId(bookDTO.getId());
            BookDetail bookDetail=new BookDetail(bookDetailDTO);
            bookDetail.setId(bookDetailDTO.getId());
            attributes.addFlashAttribute("message","Edit success");
        } else {
            Book book=new Book(bookDTO);
            BookDetail bookDetail=new BookDetail(bookDetailDTO);
            attributes.addFlashAttribute("message","Create success!");
        }
        return "redirect:/Books";
    }

    @GetMapping("/deleted/{id}")
    public String deletedById(@PathVariable Long id, RedirectAttributes attributes){
        Optional<Book> book=bookService.findById(id);

        if(book.isPresent()){
            bookService.deletedById(id);
            attributes.addFlashAttribute("message","Delete success!");
        }
        return "redirect:/Books/index";
    }

}
