package pack.service;

import org.springframework.ui.Model;

import pack.entity.Member;
import pack.form.MemberForm;

public interface MemberService {

	void getAllMember (Model model);
	void getData(Long num, Model model);
	Member getOne(Long num);
	void insert (MemberForm form);
	void update (MemberForm form);
	void update2 (MemberForm form);
	void delete (Long num);
}
