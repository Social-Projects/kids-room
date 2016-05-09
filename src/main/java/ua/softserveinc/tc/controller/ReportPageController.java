package ua.softserveinc.tc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.softserveinc.tc.entity.User;

import ua.softserveinc.tc.service.UserService;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Demian on 08.05.2016.
 */
@Controller
public class ReportPageController
{
    @Autowired
    UserService userService;

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public ModelAndView report(Principal principal)
    {
        ModelAndView model = new ModelAndView();
        model.setViewName("report");
        ModelMap modelMap = model.getModelMap();

        List<User> parentsList = userService.getAllParents();
        modelMap.addAttribute("parents", parentsList);

        Calendar calendar = Calendar.getInstance();
        String dateNow = calendar.get(Calendar.YEAR) + "-";
        dateNow += String.format("%02d", calendar.get(Calendar.MONTH) + 1) + "-";
        dateNow += String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
        modelMap.addAttribute("dateNow", dateNow);

        calendar.add(Calendar.MONTH, -1);
        String dateThen = calendar.get(Calendar.YEAR) + "-";
        dateThen += String.format("%02d", calendar.get(Calendar.MONTH) + 1) + "-";
        dateThen += String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
        modelMap.addAttribute("dateThen", dateThen);

        return model;
    }
}