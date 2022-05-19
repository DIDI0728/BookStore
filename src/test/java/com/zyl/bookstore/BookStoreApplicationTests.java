package com.zyl.bookstore;

import com.zyl.bookstore.dao.BookDao;
import com.zyl.bookstore.dao.LendListDao;
import com.zyl.bookstore.pojo.Book;
import com.zyl.bookstore.pojo.LendList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.util.calendar.BaseCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class BookStoreApplicationTests {

    @Autowired
    LendListDao lendListDao;


    @Autowired
    BookDao bookDao;


    @Test
    void testGetOver() {
       String backDate="2022/5/16";
        for (LendList lendList : lendListDao.getOverTime(backDate)) {
            System.out.println(lendList);
        }
    }


    @Test
    void testDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        System.out.println(format);

    }


    @Test
    void testGetLessBook(){
        for (Book book : bookDao.getLessBook()) {
            System.out.println(book);
        }
    }

    @Test
    void testDays() throws ParseException {

        String date1="2022-05-18";
        String date2="2022-06-01";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse1 = simpleDateFormat.parse(date1);
        Date parse2 = simpleDateFormat.parse(date2);

        long parse1Time = parse1.getTime();
        long parse2Time = parse2.getTime();

        long times=parse2Time-parse1Time;

        int days=(int)times/(24*60*60*1000);
        System.out.println(days);
    }
}
