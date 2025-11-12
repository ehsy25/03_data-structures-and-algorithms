package com.ohgiraffers.crud.domain.member.controller;

import com.ohgiraffers.crud.domain.member.dto.Department;
import com.ohgiraffers.crud.domain.member.dto.Member;
import com.ohgiraffers.crud.domain.member.repository.MemberRepository;
import java.sql.*;
import java.util.Scanner;
import static com.ohgiraffers.crud.common.JDBCTemplate.getConnection;
import java.sql.*;

/*사용자로부터 전달받은 기능을 실행
* 1. 사용자가 만약에 전달한 값이 있는데 정제할 내용잉 있다면 처리
* 예) "1" 숫자가 있는데 이걸 정수형 변수에 담기위해서 형변환처리
* 2. 사용자 요청에 따른 적절한 서비스 메소드를 호출
* 3. 수행한 결과에 따라서 필요한 페이지를 보이거나 값을 리턴
* 여기서는 결과값을 콘솔에 출력한다*/
public class MemberController {

    public void insertMember() {

        Scanner sc = new Scanner(System.in);
        System.out.print("emp id : ");
        String empid = sc.nextLine();
        System.out.print("emp name : ");
        String empName = sc.nextLine();
        System.out.print("empno : ");
        String empNO = sc.nextLine();
        System.out.print("dept id: ");
        String deptId = sc.nextLine();
        System.out.print("dept title: ");
        String deptTitle = sc.nextLine();

        Connection con = getConnection();

        MemberRepository mr = new MemberRepository();
        mr.insertMember(new Member(empid, empName,empNO, new Department (deptId,deptTitle) ), con);
    }
}
