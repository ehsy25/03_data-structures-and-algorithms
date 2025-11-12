package com.ohgiraffers.crud.domain.member.service;


import com.ohgiraffers.crud.domain.member.dto.Member;
import com.ohgiraffers.crud.domain.member.repository.MemberRepository;

import java.sql.*;
import java.util.Scanner;

import static com.ohgiraffers.crud.common.JDBCTemplate.*;

public class MemberService {

    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Scanner sc = new Scanner(System.in);
    Connection con = getConnection();

    public void registerMember(Member member) {
        Connection con = getConnection();
        MemberRepository mr = new MemberRepository();
        int result = mr.insertMember(member, con);
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
    }

    public void selectAllMembers() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM employee");
            while(rs.next()) { // 결과 행의 존재여부를 확인
                System.out.print(rs.getString("emp_name") + " ");
                System.out.println(rs.getInt("salary"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectMember() {
        try {
            System.out.println("사번 입력");
            int num = sc.nextInt();
            int result = 0;
            ps = con.prepareStatement("""
                    SELECT emp_id, emp_name, salary 
                    FROM employee
                    WHERE emp_id = ? AND quit_yn = ?
            """);
            result = ps.executeUpdate();
            while(rs.next()){
                System.out.print(rs.getString("emp_id") + " ");
                System.out.print(rs.getString("emp_name") + " ");
                System.out.println(rs.getInt("salary"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertMember() {
        MemberRepository mr = new MemberRepository();
        mr.insertMember(new Member(), con);
    }

    public void updateMember() {
    }

    public void deleteMember() {
    }
}
