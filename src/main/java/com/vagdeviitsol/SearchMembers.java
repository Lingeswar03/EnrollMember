package com.vagdeviitsol;

import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class SearchMembers {
	@PersistenceContext
	EntityManager entitym;
	
	List<EnrollMember> getMembers(String SELECT_QUERY){
		List<EnrollMember> list=(List<EnrollMember>)entitym.createNativeQuery(SELECT_QUERY).getResultList();
		return list;
	}

}
