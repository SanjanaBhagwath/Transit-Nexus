package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private RouteService routeService; // Service for handling routes
    @Autowired
    private RoutesHaveStationsService rs; // Service for handling stations
    @Autowired
    private FareService fareService; // Service for handling fares
    @Autowired
    private RechargeService rechargeService;
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private TicketService ticketService;

    @GetMapping("/admin_login")
    public String showLoginPage() {
        return "adminLogin"; // JSP page for admin login
    }

    @PostMapping("/admin_login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        if ("admin".equals(username) && "password".equals(password)) { // Replace with actual authentication
            return "adminDashboard"; // Redirect to admin dashboard after successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "adminLogin"; // Return to login page with error
        }
    }

    @GetMapping("/admin/dashboard")
    public String showAdminDashboard() {
        return "adminDashboard"; // JSP page for admin dashboard
    }

    @GetMapping("/admin/addRoutes")
    public String showAddRoutesPage() {
        return "addRoutes"; // JSP page for adding routes
    }

    @GetMapping("/admin/routeSuccess")
    public String showRouteSuccessPage() {
        return "routeSuccess"; // Return the success JSP page
    }

    @PostMapping("/admin/saveRoute")
    public String saveRoute(@RequestParam("routeNo") String routeNo,
                            @RequestParam("source") String source,
                            @RequestParam("destination") String destination,
                            RedirectAttributes redirectAttributes) {
        Route route = new Route();
        route.setRoute_no(routeNo);
        route.setSource(source);
        route.setDestination(destination);
        routeService.addRoute(route);
        redirectAttributes.addFlashAttribute("message", "Route added successfully!");

        return "redirect:/admin/routeSuccess"; // Redirect to the success page
    }

    @GetMapping("/admin/addStations")
    public String showAddStationsPage() {
        return "addStations"; // JSP page for adding stations
    }

    @GetMapping("/admin/stationSuccess")
    public String showStationSuccessPage() {
        return "stationSuccess"; // Return the success JSP page
    }

    @PostMapping("/admin/saveStation")
    public String saveStation(@RequestParam("routeNo") String routeNo,
                              @RequestParam("stationName") String stationName,
                              @RequestParam("stationOrder") int stationOrder,
                              RedirectAttributes redirectAttributes) {
        RoutesHaveStations r = new RoutesHaveStations();
        r.setRoute_no(routeNo);
        r.setStation_name(stationName);
        r.setStation_order(stationOrder);
        rs.addRouteStation(r);
        redirectAttributes.addFlashAttribute("message", "Station added successfully!");
        return "redirect:/admin/stationSuccess"; // Redirect to dashboard after saving
    }

    @GetMapping("/admin/addPassengers")
    public String showAddPassengersPage() {
        return "addPassengers"; // JSP page for adding fares
    }

    @GetMapping("/admin/passengerSuccess")
    public String showPassengerSuccessPage() {
        return "passengerSuccess"; // Return the success JSP page
    }

    @PostMapping("/admin/savePassenger")
    public String savePassenger(@RequestParam("rfid") long rfid,
                           @RequestParam("balance") float balance,
                           RedirectAttributes redirectAttributes) {
        Passenger p = new Passenger();
        p.setRFID_No(rfid);
        p.setBalance(balance);
        passengerService.addPassenger(p);
        redirectAttributes.addFlashAttribute("message", "Passenger added successfully!");
        return "redirect:/admin/fareSuccess"; // Redirect to dashboard after saving
    }

    @GetMapping("/admin/addFares")
    public String showAddFaresPage() {
        return "addFares"; // JSP page for adding fares
    }

    @GetMapping("/admin/fareSuccess")
    public String showFareSuccessPage() {
        return "fareSuccess"; // Return the success JSP page
    }

    @PostMapping("/admin/saveFare")
    public String saveFare(@RequestParam("fare") float fare,
                           @RequestParam("station1") String station1,
                           @RequestParam("station2") String station2,
                           @RequestParam("routeNo") String routeNo,
                           RedirectAttributes redirectAttributes) {
        Fare f = new Fare();
        f.setFare(fare);
        f.setStation_1(station1);
        f.setStation_2(station2);
        f.setRoute_No(routeNo);
        fareService.addFare(f);
        redirectAttributes.addFlashAttribute("message", "Fare added successfully!");
        return "redirect:/admin/fareSuccess"; // Redirect to dashboard after saving
    }

    @GetMapping("/admin/viewReports")
    public String showReportOptionsPage() {
        return "reportOptions"; // Return the new report options JSP page
    }

    @GetMapping("/admin/rechargeHistoryPage")
    public String showRechargeHistoryForm(Model model) {
        // Add this method to display the initial form
        model.addAttribute("today", LocalDate.now());
        return "rechargeHistoryForm";
    }

    @GetMapping("/admin/viewRechargeHistory")
    public String viewRechargeHistory(@RequestParam(value = "date", required = false) String date, Model model) {
        // If date is null or empty, use today's date
        if (date == null || date.trim().isEmpty()) {
            date = LocalDate.now().toString();
        }

        try {
            // Parse the date string to LocalDate with validation
            LocalDate parsedDate = LocalDate.parse(date);
            Date sqlDate = Date.valueOf(parsedDate);

            List<Recharge> rechargeHistory = rechargeService.getRecharge_Date(sqlDate);
            model.addAttribute("rechargeHistory", rechargeHistory);
            model.addAttribute("selectedDate", date);

            return "rechargeHistory";
        } catch (DateTimeParseException e) {
            model.addAttribute("error", "Invalid date format. Please use YYYY-MM-DD format.");
            return "rechargeHistoryForm";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred: " + e.getMessage());
            return "rechargeHistoryForm";
        }
    }


    @GetMapping("/admin/ticketsByDatePage")
    public String showTicketsForm(Model model) {
        model.addAttribute("today", LocalDate.now());
        return "ticketsByDateForm";
    }

    @GetMapping("/admin/viewTickets")
    public String getTicketsByDate(@RequestParam(value = "date", required = false) String date, Model model) {
        if (date == null || date.trim().isEmpty()) {
            date = LocalDate.now().toString();
        }

        try {
            LocalDate parsedDate = LocalDate.parse(date);
            Date sqlDate = Date.valueOf(parsedDate);

            List<Ticket> tickets = ticketService.getTicket_Date(sqlDate);
            model.addAttribute("tickets", tickets);
            model.addAttribute("selectedDate", date);

            return "ticketsByDate";
        } catch (Exception e) {
            model.addAttribute("error", "Error retrieving tickets: " + e.getMessage());
            return "ticketsForm";
        }
    }

    @GetMapping("/admin/ticketsByRoutePage")
    public String showTicketsByRouteForm() {
        return "ticketsByRouteForm";
    }

    @GetMapping("/admin/viewTicketsByRoute")
    public String viewTicketsByRoute(@RequestParam("routeNo") String routeNo, Model model) {
        try {
            // Validate route first
            if (!routeService.isValidRoute(routeNo)) {
                model.addAttribute("error", "Invalid route number: " + routeNo);
                return "ticketsByRouteForm";
            }

            List<Ticket> tickets = ticketService.getTicket_RouteNo(routeNo);
            model.addAttribute("tickets", tickets);
            model.addAttribute("routeNo", routeNo);
            return "ticketsByRoute";
        } catch (Exception e) {
            model.addAttribute("error", "Error retrieving tickets: " + e.getMessage());
            return "ticketsByRouteForm";
        }
    }

    @GetMapping("/admin/rechargesByRFIDPage")
    public String showRechargesByRFIDForm() {
        return "rechargesByRFIDForm";
    }

    @GetMapping("/admin/viewRechargesByRFID")
    public String viewRechargesByRFID(@RequestParam("rfidNo") long rfidNo, Model model) {
        try {
            // Validate RFID exists
            if (!passengerService.isValidRFID(rfidNo)) {
                model.addAttribute("error", "Invalid RFID number: " + rfidNo);
                return "rechargesByRFIDForm";
            }

            List<Recharge> recharges = rechargeService.getRecharge_RFIDNo(rfidNo);
            model.addAttribute("recharges", recharges);
            model.addAttribute("rfidNo", rfidNo);
            return "rechargesByRFID";
        } catch (Exception e) {
            model.addAttribute("error", "Error retrieving recharges: " + e.getMessage());
            return "rechargesByRFIDForm";
        }
    }
}