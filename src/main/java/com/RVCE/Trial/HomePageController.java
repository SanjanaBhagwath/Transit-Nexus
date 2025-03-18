package com.RVCE.Trial;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController
{
    @RequestMapping("/")
    public String homePage()
    {
        return "homePage";
    }

    // Trial/src/main/java/com/RVCE/Trial/HomePageController.java
    @RequestMapping("/admin_login")
    public String adminLoginPage() {
        return "adminLogin"; // This will render adminLogin.jsp
    }

    @RequestMapping("/passenger_login")
    public String passengerLoginPage() {
        return "passengerLogin"; // This will render passengerLogin.jsp
    }

    @RequestMapping("/admin_dashboard")
    public String adminDashboard() {
        return "adminDashboard"; // This will render adminDashboard.jsp
    }

}
