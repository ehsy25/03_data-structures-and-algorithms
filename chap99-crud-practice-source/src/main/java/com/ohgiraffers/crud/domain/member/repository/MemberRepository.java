package com.ohgiraffers.crud.domain.member.repository;

import com.ohgiraffers.crud.domain.member.dto.Member;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.crud.common.JDBCTemplate.close;

/*데이터베이스에 쿼리요청 후 결과값 리턴*/

public class MemberRepository {

    public int insertMember(Member member, Connection con) {

        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/MemberMapper.xml"));
            String sql = prop.getProperty("insertMenu");
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, member.getEmpId());
            pstmt.setString(2, member.getEmpName());
            pstmt.setString(3, member.getEmpNo());
            pstmt.setString(4, member.getDept().getDeptId());

            result = pstmt.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }
}
