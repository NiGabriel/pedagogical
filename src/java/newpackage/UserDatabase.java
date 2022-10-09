/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.*;
import java.util.*;

/**
 *
 * @author IPRC KARONGI
 */
public class UserDatabase {
    
     Connection con ;

    public UserDatabase(Connection con) {
        this.con = con;
    }
    
    //Admin login
    public user logAdministrator(String email, String pass){
        user usr=null;
        try{
            String query ="select * from administrator where AdminUsername=? and AdminPassword=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pass);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                usr = new user();
                usr.setId(rs.getInt("AdminID"));
                usr.setName(rs.getString("AdminNames"));
                usr.setEmail(rs.getString("AdminUsername"));
                usr.setPassword(rs.getString("AdminPassword"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usr;
    }
    //Supervisor login
    public user logSupervisor(String email, String pass){
        user usr=null;
        try{
            String query ="select * from supervisor where SupervisorUsername=? and SupervisorPassword=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pass);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                usr = new user();
                usr.setId(rs.getInt("SupervisorID"));
                usr.setName(rs.getString("SupervisorNames"));
                usr.setEmail(rs.getString("SupervisorUsername"));
                usr.setPassword(rs.getString("SupervisorPassword"));
		usr.setTel(rs.getString("SupervisorTelephone"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usr;
    }
    //Teacher login
    public user logTeacher(String email, String pass){
        user usr=null;
        try{
            String query ="select * from teacher where TeacherUsername=? and TeacherPassword=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pass);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                usr = new user();
                usr.setId(rs.getInt("TeacherID"));
                usr.setName(rs.getString("TeacherNames"));
                usr.setEmail(rs.getString("TeacherUsername"));
                usr.setPassword(rs.getString("TeacherPassword"));
		usr.setTel(rs.getString("TeacherTelephone"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usr;
    }
    
    //Teacher login
    public user logParent(String email, String pass){
        user usr=null;
        try{
            String query ="select * from parent where ParentUsername=? and ParentPassword=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pass);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                usr = new user();
                usr.setId(rs.getInt("ParentID"));
                usr.setName(rs.getString("ParentNames"));
                usr.setEmail(rs.getString("ParentUsername"));
                usr.setPassword(rs.getString("ParentPassword"));
		usr.setTel(rs.getString("ParentTelephone"));
		usr.setResidence(rs.getString("ParentResidence"));
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usr;
    }
    //for register user 
    public boolean saveUser(user user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into employee(name,email,password, role, tel, level) values(?,?,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getName());
           pt.setString(2, user.getEmail());
           pt.setString(3, user.getPassword());
	   pt.setString(4, user.getRole());
           pt.setString(5, user.getTel());
           pt.setString(6, user.getLevel());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    //insert learner
    public boolean saveLearner(user user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into learner values(?,?,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getLid());
           pt.setString(2, user.getLname());
           pt.setString(3, user.getLlevel());
	   pt.setString(4, user.getLbirth());
           pt.setString(5, user.getLfather());
           pt.setString(6, user.getLmother());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    
    //insert teacher
    public boolean saveTeacher(user user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into teacher values(?,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setInt(1, user.getTid());
           pt.setString(2, user.getTname());
           pt.setString(3, user.getTuname());
	   pt.setString(4, user.getTpass());
           pt.setString(5, user.getTtel());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    //insert supervisor
    public boolean saveSupervisor(user user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into supervisor values(?,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setInt(1, user.getSid());
           pt.setString(2, user.getSname());
           pt.setString(3, user.getSuname());
	   pt.setString(4, user.getSpass());
           pt.setString(5, user.getStel());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    //insert administrator
    public boolean saveAdmin(user user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into administrator values(?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setInt(1, user.getAid());
           pt.setString(2, user.getAname());
           pt.setString(3, user.getAuname());
	   pt.setString(4, user.getApass());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    //insert teacher documents
    public boolean saveTeacherDoc(user user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into teacherdoc values(null,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getDoctitle());
           pt.setString(2, user.getDocdescription());
           pt.setString(3, user.getDocauthor());
	   pt.setString(4, user.getDoccreatedOn());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    //insert teacher pending documents
    public boolean saveTeacherPendDoc(user user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into teacherpendingdoc values(null,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getDoctitlep());
           pt.setString(2, user.getDocdescriptionp());
           pt.setString(3, user.getDocauthorp());
	   pt.setString(4, user.getDoccreatedOnp());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    
    //insert supervisor documents
    public boolean saveSupervisorDoc(user user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into supervisordoc values(null,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getDoctitles());
           pt.setString(2, user.getDocdescriptions());
           pt.setString(3, user.getDocauthors());
	   pt.setString(4, user.getDoccreatedOns());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    
    //insert supervisor pending documents
    public boolean saveSupPendDoc(user user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into approveddoc values(null,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getDoctitlesup());
           pt.setString(2, user.getDocdescriptionsup());
           pt.setString(3, user.getDocauthorsup());
	   pt.setString(4, user.getDoccreatedOnsup());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    
    //insert not approved documents
    public boolean saveNotApDoc(user user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into notapproveddoc values(null,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getDoctitlenp());
           pt.setString(2, user.getDocdescriptionnp());
           pt.setString(3, user.getDocauthornp());
	   pt.setString(4, user.getDoccreatedOnnp());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    
    
    
    
    //Display learners data in table
    public static List<user> getAllData() {
	
	List<user> list = new ArrayList<user>();
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("select * from learner");
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		user e = new user();
		e.setLid(rs.getString(1));
		e.setLname(rs.getString(2));
		e.setLlevel(rs.getString(3));
		e.setLbirth(rs.getString(4));
		e.setLfather(rs.getString(5));
		e.setLmother(rs.getString(6));
		list.add(e);
	    }
	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return list;
    }
    //Delete data from learner table
    public static int delete(String id) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("delete from learner where LearnerID=?");
	    ps.setString(1, id);
	    status = ps.executeUpdate();

	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return status;
    }
    //Delete data from teacher table
    public static int deleteTeacher(int id) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("delete from teacher where TeacherID=?");
	    ps.setInt(1, id);
	    status = ps.executeUpdate();

	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return status;
    }
    //Delete data from supervisor table
    public static int deleteSupervisor(int id) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("delete from supervisor where SupervisorID=?");
	    ps.setInt(1, id);
	    status = ps.executeUpdate();

	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return status;
    }
    //Delete data from administrator table
    public static int deleteAdmin(int id) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("delete from administrator where AdminID=?");
	    ps.setInt(1, id);
	    status = ps.executeUpdate();

	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return status;
    }
    //Delete data from teacher document table
    public static int deleteTeacherDoc(int id) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("delete from teacherdoc where id=?");
	    ps.setInt(1, id);
	    status = ps.executeUpdate();

	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return status;
    }
    //Delete data from teacher pending document table
    public static int deleteTeacherPendDoc(int id) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("delete from teacherpendingdoc where id=?");
	    ps.setInt(1, id);
	    status = ps.executeUpdate();

	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return status;
    }
    
    //Delete data from supervisor document table
    public static int deleteSupervisorDoc(int id) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("delete from supervisordoc where id=?");
	    ps.setInt(1, id);
	    status = ps.executeUpdate();

	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return status;
    }
    
    //Delete data from Return document table
    public static int deleteSupervisorReturn(int id) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("delete from approveddoc where id=?");
	    ps.setInt(1, id);
	    status = ps.executeUpdate();

	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return status;
    }
    
    //Delete data from not approved document table
    public static int deleteSupervisorNotApproved(int id) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("delete from notapproveddoc where id=?");
	    ps.setInt(1, id);
	    status = ps.executeUpdate();

	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return status;
    }
    
     //Delete data from teacher uploaded document
    public static int deleteTeacherUploadDoc(int id) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("delete from teacherupload where id=?");
	    ps.setInt(1, id);
	    status = ps.executeUpdate();

	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return status;
    }
    
     //Delete data from supervisor uploaded document
    public static int deleteSupervisorUploadDoc(int id) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("delete from supervisorupload where id=?");
	    ps.setInt(1, id);
	    status = ps.executeUpdate();

	    con.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return status;
    }
    
    //Update data of learners
    public static int update(user e) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("update learner set LearnerNames=?,LearnerLevel=?,LearnerBirthdate=?,Fathername=?, Mothername=? where LearnerID=?");
	    ps.setString(1, e.getLname());
	    ps.setString(2, e.getLlevel());
	    ps.setString(3, e.getLbirth());
	    ps.setString(4, e.getLfather());
	    ps.setString(5, e.getLmother());
	    ps.setString(6, e.getLid());
	    status = ps.executeUpdate();
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return status;
    }
    //Update data of teachers
    public static int updateTeacher(user e) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("update teacher set TeacherNames=?,TeacherUsername=?,TeacherPassword=?,TeacherTelephone=? where TeacherID=?");
	    ps.setString(1, e.getTname());
	    ps.setString(2, e.getTuname());
	    ps.setString(3, e.getTpass());
	    ps.setString(4, e.getTtel());
	    ps.setInt(5, e.getTid());
	    status = ps.executeUpdate();
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return status;
    }
     //Update data of supervisor
    public static int updateSupervisor(user e) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("update supervisor set SupervisorNames=?,SupervisorUsername=?,SupervisorPassword=?,SupervisorTelephone=? where SupervisorID=?");
	    ps.setString(1, e.getSname());
	    ps.setString(2, e.getSuname());
	    ps.setString(3, e.getSpass());
	    ps.setString(4, e.getStel());
	    ps.setInt(5, e.getSid());
	    status = ps.executeUpdate();
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return status;
    }
     //Update data of administrator
    public static int updateAdmin(user e) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("update administrator set AdminNames=?,AdminUsername=?,AdminPassword=? where AdminID=?");
	    ps.setString(1, e.getAname());
	    ps.setString(2, e.getAuname());
	    ps.setString(3, e.getApass());
	    ps.setInt(4, e.getAid());
	    status = ps.executeUpdate();
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return status;
    }
    //Update data of teacher document
    public static int updateTeacherDoc(user e) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("update teacherdoc set title=?, description=?, author=?,createdOn=? where id=?");
	    ps.setString(1, e.getDoctitle());
	    ps.setString(2, e.getDocdescription());
	    ps.setString(3, e.getDocauthor());
	    ps.setString(4, e.getDoccreatedOn());
	    ps.setInt(5, e.getDocid());
	    status = ps.executeUpdate();
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return status;
    }
    
    //Update data of not approved teacher document
    public static int updateNotApprovedDoc(user e) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("update notapproveddoc set title=?, description=?, author=?,createdOn=? where id=?");
	    ps.setString(1, e.getDoctitle());
	    ps.setString(2, e.getDocdescription());
	    ps.setString(3, e.getDocauthor());
	    ps.setString(4, e.getDoccreatedOn());
	    ps.setInt(5, e.getDocid());
	    status = ps.executeUpdate();
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return status;
    }
    
    
    //Update data of supervisor document
    public static int updateSupervisorDoc(user e) {
	int status = 0;
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("update supervisordoc set title=?, description=?, author=?,createdOn=? where id=?");
	    ps.setString(1, e.getDoctitles());
	    ps.setString(2, e.getDocdescriptions());
	    ps.setString(3, e.getDocauthors());
	    ps.setString(4, e.getDoccreatedOns());
	    ps.setInt(5, e.getDocids());
	    status = ps.executeUpdate();
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return status;
    }
    
    //get learner by ID
    public static user getLearnerById(String id) {
	user e = new user();
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("select * from learner where LearnerID=?");
	    ps.setString(1, id);
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
		e.setLid(rs.getString(1));
		e.setLname(rs.getString(2));
		e.setLlevel(rs.getString(3));
		e.setLbirth(rs.getString(4));
		e.setLfather(rs.getString(5));
		e.setLmother(rs.getString(6));
	    }
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return e;
    } 
    //get teacher by ID
    public static user getTeacherById(int id) {
	user e = new user();
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("select * from teacher where TeacherID=?");
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
		e.setTid(rs.getInt(1));
		e.setTname(rs.getString(2));
		e.setTuname(rs.getString(3));
		e.setTpass(rs.getString(4));
		e.setTtel(rs.getString(5));
	    }
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return e;
    } 
    //get supervisor by ID
    public static user getSupervisorById(int id) {
	user e = new user();
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("select * from supervisor where SupervisorID=?");
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
		e.setSid(rs.getInt(1));
		e.setSname(rs.getString(2));
		e.setSuname(rs.getString(3));
		e.setSpass(rs.getString(4));
		e.setStel(rs.getString(5));
	    }
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return e;
    } 
    //get Admin by ID
    public static user getAdminById(int id) {
	user e = new user();
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("select * from administrator where AdminID=?");
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
		e.setAid(rs.getInt(1));
		e.setAname(rs.getString(2));
		e.setAuname(rs.getString(3));
		e.setApass(rs.getString(4));
	    }
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return e;
    } 
    //get doc by ID from teachers
    public static user getDocById(int id) {
	user e = new user();
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("select * from teacherdoc where id=?");
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
		e.setDocid(rs.getInt(1));
		e.setDoctitle(rs.getString(2));
		e.setDocdescription(rs.getString(3));
		e.setDocauthor(rs.getString(4));
		e.setDoccreatedOn(rs.getString(5));
		
	    }
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return e;
    }
     //get doc by ID from mot approved doc
    public static user getNotAppDocById(int id) {
	user e = new user();
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("select * from notapproveddoc where id=?");
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
		e.setDocid(rs.getInt(1));
		e.setDoctitle(rs.getString(2));
		e.setDocdescription(rs.getString(3));
		e.setDocauthor(rs.getString(4));
		e.setDoccreatedOn(rs.getString(5));
		
	    }
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return e;
    }
    
    //get doc by ID from supervisor
    public static user getDocByIdsup(int id) {
	user e = new user();
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("select * from supervisordoc where id=?");
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
		e.setDocidsup(rs.getInt(1));
		e.setDoctitlesup(rs.getString(2));
		e.setDocdescriptionsup(rs.getString(3));
		e.setDocauthorsup(rs.getString(4));
		e.setDoccreatedOnsup(rs.getString(5));
		
	    }
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return e;
    }
    
    //Counting learners
    public static user countLearners() {
	user e = new user();
	try {
	    Connection con = ConnectionPro.getConnection();
	    PreparedStatement ps = con.prepareStatement("SELECT count( * ) FROM learner");
	    
	    ResultSet rs = ps.executeQuery();
	    rs.next();
	    int count = rs.getInt(1);
	    con.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return e;
    }

    //Selet type
    public void selectType(){
	
try
{
	Connection con = ConnectionPro.getConnection();
     
     PreparedStatement pst=con.prepareStatement("select rolename from role");
     
     ResultSet rs=pst.executeQuery();
     while(rs.next())
     {
          String name = rs.getString("rolename");
	   }
}catch(Exception e)
{   // out.print(e);
}
    }
}
