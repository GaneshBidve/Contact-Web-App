package com.csi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.dao.ContactDtlsRepository;
import com.csi.entity.ContactDtlsEntity;
import com.csi.pojo.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDtlsRepository contactDtlsRepo;

	/**
	 * This method is used to saved contact details
	 */
	@Override
	public boolean saveContact(Contact c) {
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(c, entity);
		ContactDtlsEntity savedEntity = contactDtlsRepo.save(entity);
		return savedEntity.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contactsList = new ArrayList<Contact>();
		List<ContactDtlsEntity> entitiesList = contactDtlsRepo.findAll();
		entitiesList.forEach(entity -> {
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			contactsList.add(c);
		});
		return contactsList;
	}

	@Override
	public Contact getContactById(Integer cid) {

		Optional<ContactDtlsEntity> optional = contactDtlsRepo.findById(cid);

		if (optional.isPresent()) {
			ContactDtlsEntity entity = optional.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}

		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContactById(Integer cid) {
		contactDtlsRepo.deleteById(cid);
		return true;
	}

}
