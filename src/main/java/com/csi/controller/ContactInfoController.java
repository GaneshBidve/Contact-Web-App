package com.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.csi.pojo.Contact;
import com.csi.service.ContactService;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/")
	public String displayContactForm(Model model) {
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj);
		return "index";
	}

	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") Contact c, RedirectAttributes model) {
		boolean isSaved = contactService.saveContact(c);
		if (isSaved) {
			if (c.getContactId() != null) {
				model.addFlashAttribute("succMsg", "Contact Updated Successfully...");
			}else {
				model.addFlashAttribute("succMsg", "Contact Saved Successfully...");
			}

		} else {
			model.addFlashAttribute("errMsg", "Failed to save contact");
		}
		return "redirect:/submitContact";
	}

	@GetMapping("/submitContact")
	public String submitContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "index";
	}

	@GetMapping("/viewContacts")
	public String viewContact(Model model) {

		List<Contact> allContacts = contactService.getAllContacts();

		model.addAttribute("contacts", allContacts);

		return "viewContacts";
	}
}
