package com.phonebook.controller;

import com.phonebook.model.PhoneBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.phonebook.service.PhoneBookService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class PhoneBookController {
    @Autowired
    PhoneBookService phoneBookService;

    //1. get all phone book
    @RequestMapping(value = "/getAllPhoneBook", method = RequestMethod.GET)
    @ResponseBody
    public List<PhoneBook> getAllPhoneBook() {
        return phoneBookService.getPhoneBook();
    }

    //2. insert phone book
    @RequestMapping(value = "/addPhoneBook", method = RequestMethod.POST)
    @ResponseBody
    public String createPhoneBook(@RequestParam("name") String name,
                                  @RequestParam("address") String address,
                                  @RequestParam("phoneNumber1") String phoneNumber1,
                                  @RequestParam("phoneNumber2") String phoneNumber2,
                                  @RequestParam("createdBy") String createdBy) {

        String output;
        try {
            phoneBookService.createPhoneBook(name, address, phoneNumber1, phoneNumber2, createdBy);
            output = "SUKSES menambahkan data";
        } catch (Exception e) {
            output = "GAGAL menambahkan data";
            e.printStackTrace();
        }
        return output;
    }

    //3. get phone book by id
    @RequestMapping(value = "/getPhoneBookById", method = RequestMethod.GET)
    @ResponseBody
    public Optional<PhoneBook> getPhoneBookById(@RequestParam("id") int id) {
        return phoneBookService.getPhoneBookById(id);
    }

    //4. update phone book
    @RequestMapping(value = "/updatePhoneBook", method = RequestMethod.POST)
    @ResponseBody
    public String updatePhoneBook(@RequestParam("name") String name,
                                  @RequestParam("address") String address,
                                  @RequestParam("phoneNumber1") String phoneNumber1,
                                  @RequestParam("phoneNumber2") String phoneNumber2,
                                  @RequestParam("updatedBy") String updatedBy,
                                  @RequestParam("id") int id) {

        String output;
        try {
            phoneBookService.updatePhoneBook(id, name, address, phoneNumber1, phoneNumber2, updatedBy);
            output = "SUKSES update data";
        } catch (Exception e) {
            output = "GAGAL update data";
            e.printStackTrace();
        }
        return output;
    }

    //5. delete phone book (soft delete)
    @RequestMapping(value = "/softDeletePhoneBook", method = RequestMethod.POST)
    @ResponseBody
    public String softDeletePhoneBook(@RequestParam("id") int id,
                                      @RequestParam("updatedBy") String updatedBy) {

        String output;
        try {
            phoneBookService.softDeletePhoneBook(id, updatedBy);
            output = "SUKSES delete data";
        } catch (Exception e) {
            output = "GAGAL delete data";
            e.printStackTrace();
        }
        return output;
    }

    //6. delete phone book
    @RequestMapping(value = "/deletePhoneBook", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletePhoneBook(@RequestParam("id") int id) {

        String output;
        try {
            phoneBookService.deletePhoneBook(id);
            output = "SUKSES delete data";
        } catch (Exception e) {
            output = "GAGAL delete data";
            e.printStackTrace();
        }
        return output;
    }

}
