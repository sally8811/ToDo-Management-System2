package com.dmm.task.survice;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CalendarController {
	
	@GetMapping("/home")
	public String home() {
	
	  List<List<LocalDate>> month = new ArrayList<>();
	  
	  List<LocalDate> weekDate = new ArrayList<>();
	  
	  LocalDate d = LocalDate.now().withDayOfMonth(1);
	  
	  DayOfWeek w = d.getDayOfWeek();
	  
	  int dayValue = w.getValue();
	  
	  LocalDate previousDate = d.minusDays(dayValue);
	  
	  for (int i = 0; i < 7; i++) {
		  weekDates.add(d.plusDays(i));
		  
		  if (weekDates.size() = 7 ) {
			  month.add(weekDates);
			  weekDates = new ArrayList<>();
		  }
		  
		  for (int l =0; l <7; l++) {
			  weekDates.add(d.plusDays(l));
			  
			  if (d.getDayOfWeek() == DayOfWeek.SATURDAY) {
				  month.add(weekDates);
				  weekDates = new ArrayList<>();
			  }
		  }
		  
		  if (!weekDates.isEnpty()) {
			  
			  LocalDate lastDay = weekDates.get(weekDates.size() - 1);
			  int lastDo = lastDay.getDayOfWeek().getValue();
			  
			  int pad = (DayOfWeek.SATURDAY.getValue() - lastDow + 7) % 7;
			  
			  for (int n = 1; n <= pad; n++) {
				  weekDates.add(lastDay.plusDays(n));
			  }
			  month.add(weekDates);
		  }
		  
		  return "home";
	  }
	  
	  

}
