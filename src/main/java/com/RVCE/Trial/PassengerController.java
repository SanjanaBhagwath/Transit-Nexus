// Trial/src/main/java/com/RVCE/Trial/PassengerController.java
package com.RVCE.Trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.Date;
import java.util.List;

    @Controller
    public class PassengerController
    {
        @Autowired
        private PassengerService passengerService;
        @Autowired
        private RechargeService rechargeService;

        // Handle initial RFID login
        @PostMapping("/passenger_login")
        public String validateRFID(@RequestParam("rfid") String rfid, Model model) {
            try {
                long rfidNo = Long.parseLong(rfid);
                if (passengerService.isValidRFID(rfidNo)) {
                    model.addAttribute("rfid", rfidNo);
                    return "passengerDashboard";
                } else {
                    model.addAttribute("error", "Invalid RFID");
                    return "passengerLogin";
                }
            } catch (NumberFormatException e) {
                model.addAttribute("error", "Invalid RFID format");
                return "passengerLogin";
            }
        }

        // Check balance
        @PostMapping("/passenger_balance")
        public String checkBalance(@RequestParam("rfid") String rfid, Model model) {
            try {
                Float balance = passengerService.getBalance(Long.parseLong(rfid));
                model.addAttribute("rfid", rfid);
                model.addAttribute("balance", balance);
                return "balanceResult";
            } catch (Exception e) {
                model.addAttribute("error", "Error checking balance");
                return "passengerDashboard";
            }
        }

        // Show recharge form
        @GetMapping("/passenger_recharge_form")
        public String showRechargeForm(@RequestParam("rfid") String rfid, Model model) {
            model.addAttribute("rfid", rfid);
            return "passengerRecharge";
        }

        // Process recharge
        @PostMapping("/process_recharge")
        public String processRecharge(@RequestParam("rfid") String rfid,
                                      @RequestParam("amount") Float amount,
                                      Model model) {
            try {
                Recharge recharge = new Recharge();
                recharge.setRFID_No(Long.parseLong(rfid));
                recharge.setRecharge_Amount(amount);
                recharge.setRecharge_Date(LocalDate.now());

                if (rechargeService.addRecharge(recharge)) {
                    model.addAttribute("message", "Recharge successful!");
                    model.addAttribute("rfid", rfid);
                    return "success";
                } else {
                    model.addAttribute("error", "Recharge failed");
                    model.addAttribute("rfid", rfid);
                    return "passengerRecharge";
                }
            } catch (Exception e) {
                model.addAttribute("error", "Error processing recharge: " + e.getMessage());
                model.addAttribute("rfid", rfid);
                return "passengerRecharge";
            }
        }

        // View recharge history
        @GetMapping("/passenger_recharge_history")
        public String viewRechargeHistory(@RequestParam("rfid") String rfid, Model model) {
            try {
                long rfidNo = Long.parseLong(rfid);
                List<Recharge> recharges = rechargeService.getRecharge_RFIDNo(rfidNo);
                model.addAttribute("recharges", recharges);
                model.addAttribute("rfid", rfidNo);
                return "passengerRechargesByRFID";
            } catch (Exception e) {
                model.addAttribute("error", "Error retrieving recharge history");
                return "passengerDashboard";
            }
        }
    }
