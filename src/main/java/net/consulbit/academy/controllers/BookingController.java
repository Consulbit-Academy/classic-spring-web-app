package net.consulbit.academy.controllers;

import net.consulbit.academy.repositories.BookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookingController {

    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping("/")
    public String bookings(Model model) {
        model.addAttribute("bookings", this.bookingRepository.findAll());
        return "index";
    }
}