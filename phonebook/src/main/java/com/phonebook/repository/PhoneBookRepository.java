package com.phonebook.repository;

import com.phonebook.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBook, Integer> {
    @Modifying
    @Query(value = "INSERT INTO public.phone_book(id, name, address, phone_number_1, phone_number_2, created_date, created_by, updated_date, updated_by, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)", nativeQuery = true)
    public int insertPhoneBook(int id, String name, String address, String phoneNumber1, String phoneNumber2, Date createdDate, String createdBy, Date updatedDate, String updatedBy, int status);

    @Query(value = "SELECT id FROM public.phone_book order by id desc LIMIT 1", nativeQuery = true)
    public int getIdPhoneBook();

    @Modifying
    @Query(value = "UPDATE public.phone_book SET name=?, address=?, phone_number_1=?, phone_number_2=?, updated_date=?, updated_by=? where id=?", nativeQuery = true)
    public int updatePhoneBook(String name, String address, String phoneNumber1, String phoneNumber2, Date updatedDate, String updatedBy, int id);

    @Modifying
    @Query(value = "UPDATE public.phone_book SET status=0, updated_by=?, updated_date =? where id=?", nativeQuery = true)
    public int softDeletePhoneBook(String updatedBy, Date updatedDate, int id);

    @Modifying
    @Query(value = "DELETE FROM public.phone_book where id=?", nativeQuery = true)
    public int deletePhoneBook(int id);

}
