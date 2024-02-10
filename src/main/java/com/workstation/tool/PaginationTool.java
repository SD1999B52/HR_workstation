package com.workstation.tool;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.ui.Model;

public class PaginationTool {
    
    //количество кнопок перехода влево и право от текущей страницы
    private static final int RANGE = 2;
    
    //добавить атрибуты с наборами данных для инструментов пагинации страницы
    public static void addToModel(Page page, Model model) {
        
        //количество полученных страниц после разбиения
        int number = page.getTotalPages();
        
        //номер текущей страницы
        int current = page.getNumber();
        
        //предыдущие страницы
        List<Integer> previous = new ArrayList<>();
        for (int i = current - RANGE; i < current; i++) {
            if (i >= 0) previous.add(i);
        }
        
        //следующие страницы
        List<Integer> next = new ArrayList<>();
        for (int i = current + 1; i < current + 1 + RANGE; i++) {
            if (i < number) next.add(i);
        }
        
        //получаем параметры сортировки страницы так как 
        //у нас сортировка только по одному параметру то
        Order order = page.getSort().toList().get(0);
        
        //поле по которому будет проходить сортировка
        String property = order.getProperty();
        
        //направление сортировки
        Direction direction = order.getDirection();
        
        model.addAttribute("previous", previous);
        model.addAttribute("next", next);
        
        model.addAttribute("page", current);
        
        model.addAttribute("column", property);
        model.addAttribute("direction", direction);
    }
}