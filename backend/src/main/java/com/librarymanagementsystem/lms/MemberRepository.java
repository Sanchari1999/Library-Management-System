package com.librarymanagementsystem.lms;

import java.util.List;

public interface MemberRepository {
    void add(Member member);
    void update(Member member);
    void remove(int id);
    List<Member> getAllMembers();
    Member getById(int id);
}
