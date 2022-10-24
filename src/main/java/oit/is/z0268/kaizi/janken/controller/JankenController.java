package oit.is.z0268.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0268.kaizi.janken.model.Janken;
import oit.is.z0268.kaizi.janken.model.Entry;

@Controller
public class JankenController {
  @Autowired
  private Entry entry;

  @GetMapping("/janken")
  public String janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.entry.addUser(loginUser);
    model.addAttribute("yourName", loginUser);
    model.addAttribute("entry", this.entry);
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
