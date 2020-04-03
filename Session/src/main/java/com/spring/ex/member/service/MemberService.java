package com.spring.ex.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex.member.Member;
import com.spring.ex.member.dao.MemberDao;

@Service
public class MemberService implements IMemberService {

	@Autowired
	MemberDao dao;
	
	@Override
	public void memberRegister(Member member) {
		// TODO Auto-generated method stub
		printMembers(dao.memberInsert(member));
	}

	@Override
	public Member memberSearch(Member member) {
		// TODO Auto-generated method stub
		Member mem = dao.memberSelect(member);
		printMember(mem);
		return mem;
	}

	@Override
	public Member memberModify(Member member) {
		// TODO Auto-generated method stub
		Member memAft = dao.memberUpdate(member);
		printMember(memAft);
		
		return memAft;
	}

	@Override
	public void memberRemove(Member member) {
		// TODO Auto-generated method stub
		printMembers(dao.memberDelete(member));
	}
	
	private void printMembers(Map<String, Member> map) {
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			Member mem = map.get(key);
			printMember(mem);
					
		}
		
	}

	private void printMember(Member mem) {
		// TODO Auto-generated method stub
		System.out.print("ID:" + mem.getMemId() + "\t");
		System.out.print("|PW:" + mem.getMemPw() + "\t");
		System.out.print("|MAIL:" + mem.getMemMail() + "\n");
	}

}
