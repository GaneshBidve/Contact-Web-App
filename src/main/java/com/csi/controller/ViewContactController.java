package com.csi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.csi.pojo.Contact;
import com.csi.service.ContactService;

@Controller
public class ViewContactController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer cid, Model model) {
		Contact contact = contactService.getContactById(cid);
		model.addAttribute("contact", contact);
		return "index";
	}

	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer cid, RedirectAttributes attributes) {
		contactService.deleteContactById(cid);
		attributes.addFlashAttribute("succMsg", "Contact deleted");
		return "redirect:viewContacts";
	}
}
