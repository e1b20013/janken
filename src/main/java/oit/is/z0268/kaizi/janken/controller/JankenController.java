package oit.is.z0268.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0268.kaizi.janken.model.Janken;

@Controller
public class JankenController {

  @GetMapping("/janken")
  public String janken() {
    return "janken.html";
  }

  @PostMapping("/janken")
  public String jankenpost(@RequestParam String name, ModelMap model) {
    model.addAttribute("yourName", name);
    return "janken.html";

  }

  @GetMapping("/jankengame")
  public String lec02(@RequestParam String hand, ModelMap model) {
    String yourHand = hand;
    String cpuHand = "Gu";
    Janken janken = new Janken(yourHand, cpuHand);
    model.addAttribute("yourHand", yourHand);
    model.addAttribute("cpuHand", janken.getCpuHand());
    model.addAttribute("kekka", janken.getkekka());
    return "janken.html";
  }
}
