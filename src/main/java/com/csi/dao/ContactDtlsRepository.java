package com.csi.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csi.entity.ContactDtlsEntity;

@Repository
public interface ContactDtlsRepository extends JpaRepository<ContactDtlsEntity, Serializable> {

}
