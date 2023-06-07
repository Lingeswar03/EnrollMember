package com.vagdeviitsol;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	
//	@Autowired
//	private MemberService service;
	
	@Autowired
	MemberRepository repo;
	
	@Autowired
	MemberServiceImp service;
	
	@PostMapping("/addMember")
    public ResponseEntity<String> insertEntity(@RequestBody EnrollMember entity) {
        repo.save(entity);
        return new ResponseEntity<>("Entity inserted successfully", HttpStatus.CREATED);
    }
//	@PutMapping("/{memberId}") // Must be the same as the PathVariable
//    public ResponseEntity<String> getFormById(@PathVariable Long memberId,@RequestBody EnrollMember member){
//		service.updateMember(memberId, member);
//        return ResponseEntity.ok().body("{\"status\":\"success\"}"); 
//        		
//    }
//	@PutMapping("/{userid}")
//	public ResponseEntity<?> updateMember(@PathVariable int user_id,@RequestBody EnrollMember updateMember ) {
//	    System.out.println("Member id :"+user_id);
//	      
//		return null;
//	}
	@GetMapping("/searchMember")
	public List<EnrollMember> searchMember(@RequestBody String str) {
		
		  return service.getMembers(str);
	}
//	@RequestMapping(value="create",
//			method = RequestMethod.POST,
//			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
//			consumes = {MimeTypeUtils.APPLICATION_JSON_VALUE})
//	public ResponseEntity<EnrollMember> create(@RequestBody EnrollMember member){
//		
//		return new ResponseEntity<EnrollMember>(service.postMember(member),HttpStatus.OK);
//	}
	 
@PutMapping("/{id}")
public ResponseEntity<EnrollMember> updateEntity(@PathVariable Long id, @RequestBody EnrollMember member) {
	
//	System.out.println("memberid:"+id);
//	System.out.println("Member:"+member);
    Optional<EnrollMember> optionalEntity = repo.findById(id);

    if (optionalEntity.isPresent()) {
        EnrollMember entity = optionalEntity.get();
        entity.setDoj(member.getDoj());

        EnrollMember savedEntity = repo.save(entity);
        return ResponseEntity.ok(savedEntity);
    } else {
        return null;//ResponseEntity.notFound().build();
    }
}
}


