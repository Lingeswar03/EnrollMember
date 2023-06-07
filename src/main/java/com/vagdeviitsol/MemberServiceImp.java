package com.vagdeviitsol;

import java.util.List;

import java.util.Optional;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService {
     @Autowired
     SearchMembers search; 
    
	@Autowired
	private MemberRepository repository;
	
//	public EnrollMember postMember(EnrollMember member) {
//		
//		return repository.save(member);
//	}
	public EnrollMember updateMember(long id, EnrollMember member) {
		Optional<EnrollMember> optionalMember = repository.findById(id);
		EnrollMember existingMember = null;
		if (optionalMember.isPresent()) {
			existingMember = optionalMember.get();
			existingMember.setUserId(member.getUserId());
			existingMember.setGymId(member.getGymId());
			existingMember.setPaymentMethod(member.getPaymentMethod());
			existingMember.setDoj(member.getDoj());
			existingMember.setPlanType(member.getPlanType());
		}else {
				throw new RuntimeException("Member not prisent");
		}
		return repository.save(existingMember);
		
	}
	public List<EnrollMember> getMembers(String selectQuery){
		String  SELECT_GET_MEMBER="SELECT * FROM  FitwalaProject.enroll_member where 1=1";
		JSONParser jsonPerser=new JSONParser();
		try {		
		JSONObject obj=(JSONObject) jsonPerser.parse(selectQuery);
		System.out.println("UserID:"+obj.get("user_id"));
		System.out.println("GymId:"+obj.get("Gym_id"));
		
		if(obj.get("user_id") !=null){
			SELECT_GET_MEMBER=SELECT_GET_MEMBER+" and user_id like '%"+obj.get("user_id")+ "%'";
			}
		if(obj.get("Gym_id") !=null) {
			SELECT_GET_MEMBER=SELECT_GET_MEMBER+"and Gym_id like '%"+obj.get("Gym_id")+"%'";
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return search.getMembers(SELECT_GET_MEMBER);
	}
	
	
}
