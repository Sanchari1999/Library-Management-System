package com.librarymanagementsystem.lms;

import java.util.List;
import com.librarymanagementsystem.lms.Member;
import java.util.Optional;


public interface MemberRepository {
    void add(Member member);
    void update(Member member);
    void remove(int id);
    List<Member> getAllMembers();
    Member getById(int id);
    Member getMemberById(int id);
    Optional<Member> findByIdOptional(int id);
    void deleteById(int id);
    Member getMemberByUsername(String username);
}
