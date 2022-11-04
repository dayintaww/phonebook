package com.phonebook.service;

import com.phonebook.model.PhoneBook;
import com.phonebook.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.phonebook.repository.PhoneBookRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PhoneBookService {
    @Autowired
    PhoneBookRepository phoneBookRepository;

    private final int STATUS_WHEN_INSERT = 1;

    public List<PhoneBook> getPhoneBook() {
        return phoneBookRepository.findAll();
    }

    public int createPhoneBook(String name, String address, String phoneNumber1, String phoneNumber2, String createdBy) throws Exception {
        if (name.isEmpty()
                || address.isEmpty()
                || phoneNumber1.isEmpty()
                || createdBy.isEmpty()) {
            throw new Exception("Name, address, phoneNumber1, createdBy cannot be empty");
        }
        return phoneBookRepository.insertPhoneBook(getIdPhoneBook(), name, address, phoneNumber1, phoneNumber2, getCurrentDate(), createdBy, getCurrentDate(), createdBy, STATUS_WHEN_INSERT);// DateUtil.stringToDate(tanggalLahir));
    }

    public Optional<PhoneBook> getPhoneBookById(int id) {
        return phoneBookRepository.findById(id);
    }

    public int updatePhoneBook(int id, String name, String address, String phoneNumber1, String phoneNumber2, String updatedBy) throws Exception {
        if (id == 0) {
            throw new Exception("ID cannot br empty");
        }
        return phoneBookRepository.updatePhoneBook(name, address, phoneNumber1, phoneNumber2, getCurrentDate(), updatedBy, id);
    }

    public int softDeletePhoneBook(int id, String updatedBy) {
        return phoneBookRepository.softDeletePhoneBook(updatedBy, getCurrentDate(), id);
    }

    public int deletePhoneBook(int id) {
        return phoneBookRepository.deletePhoneBook(id);
    }

    private int getIdPhoneBook() {
        int number = phoneBookRepository.getIdPhoneBook();
        return number+1;
    }

    private Date getCurrentDate() {
        return DateUtil.getCurrentDate();
    }

}
