package com.encore.basic.repository;


import com.encore.basic.domain.Member;
import com.encore.basic.domain.MemberResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class JdbcMemberRepository implements MemberRepository {

    //datasource
    @Autowired
    private DataSource dataSource;

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try{
            Connection connection =dataSource.getConnection();
            String sql="select * from member";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id= resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                String password=resultSet.getString("password");
                LocalDateTime now = resultSet.getTimestamp("created_time").toLocalDateTime();
                Member member= new Member(name,email,password);
                member.setId(id);
                member.setCreate_time(now);
                members.add(member);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return members;
    }

    @Override
    public Member save(Member member) {
        try{
            Connection connection =dataSource.getConnection();
            String sql="insert into member(name,email,password) values(?,?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,member.getName());
            preparedStatement.setString(2,member.getEmail());
            preparedStatement.setString(3,member.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Member> findById(int idInput) {
        Member member=null;
        try{
            Connection connection =dataSource.getConnection();
            String sql="select * from member where id=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1,idInput);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int id= resultSet.getInt("id");
            String name=resultSet.getString("name");
            String email=resultSet.getString("email");
            String password=resultSet.getString("password");
            LocalDateTime now = resultSet.getTimestamp("create_time").toLocalDateTime();
            member= new Member(name,email,password);
            member.setId(id);
            member.setCreate_time(now);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(member);
    }

    @Override
    public void delete(Member member) {

    }


}
