package com.vagdeviitsol;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
	//EnrollMember postMember(EnrollMember member);

	//Option getUserById(Long userid);

	EnrollMember updateMember(long id, EnrollMember member);
	
	List<EnrollMember> getMembers(String searchQuery);
	
	}

