/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

import DTO.RemindReviewEmail;
import Interface.Service.CommonService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author DINH KHANG
 */
@Configuration
@PropertySource("classpath:config.properties")
public class SendReviewEmail {

    @Autowired
    private Environment env;
    @Autowired
    CommonService commonService;

    public static String test = "a";

    public void SendReviewEmail() throws ParseException {
        try {
            System.out.println("Scheduler running");
            String baseUrl = env.getProperty("Youtripper.url");
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Calendar cal = Calendar.getInstance();
            List<RemindReviewEmail> bookingList = commonService.getBookingList();
            for (int i = 0; i < bookingList.size(); i++) {
                if (bookingList.get(i).getDurationType() == 0) {
                    if (bookingList.get(i).getDuration() < 24) {
                        cal.setTime(formatter.parse(bookingList.get(i).getSelectedDate()));
                        cal.add(Calendar.DATE, 1);
                        bookingList.get(i).setSelectedDate(String.valueOf((cal.getTime().getMonth() + 1) + "/" + cal.getTime().getDate() + "/" + (cal.getTime().getYear() + 1900)));

                    } else {
                        int days = bookingList.get(i).getDuration() / 24;
                        cal.setTime(formatter.parse(bookingList.get(i).getSelectedDate()));
                        cal.add(Calendar.DATE, days + 1);
                        bookingList.get(i).setSelectedDate(String.valueOf((cal.getTime().getMonth() + 1) + "/" + cal.getTime().getDate() + "/" + (cal.getTime().getYear() + 1900)));
                    }
                } else {
                    cal.setTime(formatter.parse(bookingList.get(i).getSelectedDate()));
                    cal.add(Calendar.DATE, bookingList.get(i).getDuration());
                    bookingList.get(i).setSelectedDate(String.valueOf((cal.getTime().getMonth() + 1) + "/" + cal.getTime().getDate() + "/" + (cal.getTime().getYear() + 1900)));
                }

            }
            //End for
            Date today = new Date();
            String currentDate = (today.getMonth() + 1) + "/" + today.getDate() + "/" + (today.getYear() + 1900);
            for (int i = 0; i < bookingList.size(); i++) {
                String selectedDate = bookingList.get(i).getSelectedDate();

                if (currentDate.equals(selectedDate)) {
                    boolean result = commonService.sendRemindReviewEmail("[YouTripper] Review Package", bookingList.get(i).getEmail(), bookingList.get(i).getPackageID(), baseUrl,bookingList.get(i).getCode());
                    if (result) {
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void change() {
        test = "b";
    }

}
