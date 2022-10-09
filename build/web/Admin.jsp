<%-- 
    Document   : Admin
    Created on : Sep 9, 2021, 10:16:30 AM
    Author     : IPRC KARONGI
--%>

<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="newpackage.*"%>
<%@page import="newpackage.user"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedagogical system - Admin</title>

        <link rel="stylesheet" href="css/styleAdmin.css">

        <link rel="stylesheet" href="css/dataTables.bootstrap5.min.css">


        <script src ="https://kit.fontawesome.com/a076d05399.js"></script>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
        <script src="./js/bootstrap.bundle.min.js"></script>
        <script src="./js/jquery-3.5.1.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@3.0.2/dist/chart.min.js"></script>
        <script src="./js/jquery.dataTables.min.js"></script>
        <script src="./js/dataTables.bootstrap5.min.js"></script>
        <script src="./js/script.js"></script>
    </head>
    <body>
        <input type="checkbox" id="check">
        <label for="check">
            <i class="fas fa-bars" id="btn"></i>
            <i class="fas fa-times" id="cancel"></i>
        </label>
        <div class="sidebar">
            <header>ADMIN</header>
            <ul>
                <li><a href="#dashboard" id="a1" onclick="w3_open1()"><i class="fas fa-qrcode"></i>Dashboard</a></li>
                <!--<li><a href="#learners" id="a2" onclick="w3_open2()"><i class="fas fa-address-book"></i>Learners</a></li> -->
                <li><a href="#teachers" id="a3" onclick="w3_open3()"><i class="fas fa-chalkboard-teacher"></i>Teachers</a></li>
                <li><a href="#supervisors" id="a4" onclick="w3_open4()"><i class="fas fa-user"></i>Supervisors</a></li>
                <li><a href="#administrator" id="a5" onclick="w3_open5()"><i class="far fa-user"></i>Administrator</a></li>

            </ul>
        </div>
        <section>
            <div class="banner"></div>
            <div class="modal-header">
                <h3 style="color: white; overflow-y: hidden">Welcome Admin</h3>
                <button class="btn btn-primary"><a href="LogoutServlet" style="color: white;">Log Out</a></button>
            </div>
            <div class="main-content">
                <section id="dashboard">
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <div class="container-fluid">
                            <a class="navbar-brand text-left" href="#">DASHBOARD</a>
                        </div>
                    </nav>
                    <main class="mt-5 pt-3">
                        <%
                            Connection conCo = ConnectionPro.getConnection();
                            Connection conCo1 = ConnectionPro.getConnection();
                            Connection conCo2 = ConnectionPro.getConnection();
                            Connection conCo3 = ConnectionPro.getConnection();
                            Statement stCo, stCo1, stCo2, stCo3 = null;
                            ResultSet rsCo, rsCo1, rsCo2, rsCo3 = null;
                            stCo = conCo.createStatement();
                            stCo1 = conCo1.createStatement();
                            stCo2 = conCo2.createStatement();
                            stCo3 = conCo3.createStatement();

                            String qCo = "SELECT count( * ) FROM teacherupload";
                            String qCo1 = "SELECT count( * ) FROM teacher";
                            String qCo2 = "SELECT count( * ) FROM supervisordoc";
                            String qCo3 = "SELECT count( * ) FROM teacherdoc";
                            rsCo = stCo.executeQuery(qCo);
                            rsCo1 = stCo1.executeQuery(qCo1);
                            rsCo2 = stCo2.executeQuery(qCo2);
                            rsCo3 = stCo3.executeQuery(qCo3);

                            rsCo.next();
                            rsCo1.next();
                            rsCo2.next();
                            rsCo3.next();
                        %>
                        <div class="row">
                            <div class="col-md-3">
                                <div class="card text-white bg-success mb-3" style="max-width: 24rem;">
                                    <div class="card-header">Count</div>
                                    <div class="card-body">
                                        <h5 class="card-title" style="overflow: hidden">TEACHER DOC UPLOADED</h5>

                                        <p class="card-text">

                                        <h1 style="text-align: center; overflow: hidden">
                                            <%=rsCo.getInt(1)%>
                                        </h1>
                                        </p>
                                    </div>
                                </div>

                            </div>
                            <div class="col-md-3">
                                <div class="card text-white bg-primary mb-3" style="max-width: 24rem;">
                                    <div class="card-header">Count</div>
                                    <div class="card-body">
                                        <h5 class="card-title" style="overflow: hidden">TEACHERS</h5>
                                        <p class="card-text">

                                        <h1 style="text-align: center; overflow: hidden">
                                            <%=rsCo1.getInt(1)%>
                                        </h1>
                                        </p>
                                    </div>
                                </div>

                            </div>
                            <div class="col-md-3">
                                <div class="card text-dark bg-info mb-3" style="max-width: 24rem;">
                                    <div class="card-header">Count</div>
                                    <div class="card-body">
                                        <h5 class="card-title" style="overflow: hidden">SUPERVISOR DOC</h5>
                                        <p class="card-text">

                                        <h1 style="text-align: center; overflow: hidden">
                                            <%=rsCo2.getInt(1)%>
                                        </h1>
                                        </p>
                                    </div>
                                </div>

                            </div>
                            <div class="col-md-3">
                                <div class="card text-white bg-secondary mb-3" style="max-width: 24rem;">
                                    <div class="card-header">Count</div>
                                    <div class="card-body">
                                        <h5 class="card-title" style="overflow: hidden">TEACHER DOC</h5>
                                        <p class="card-text">

                                        <h1 style="text-align: center; overflow: hidden">
                                            <%=rsCo3.getInt(1)%>
                                        </h1>
                                        </p>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="card-body">
                                <div class="card">

                                    <div class="card-body">
                                        <div class="card">
                                            <div class="card-header">
                                                <h2> SUPERVISOR DOCUMENTS UPLOADED</h2>
                                            </div>
                                            <div class="card-body">

                                                <div class="row">

                                                    <div class="col-md-12 text-left">
                                                        <form action="" method="get">
                                                            <input type="text" class="form-control" name="docsearch" placeholder="search doc here..." style="width: 270px;"/>
                                                        </form>
                                                    </div>

                                                    <div class="col-md-12 text-right">

                                                    </div>
                                                </div>
                                                <br>
                                                <table class="table table-hover" >
                                                    <thead>
                                                        <tr>

                                                            <th scope="col">UPLOADED BY</th>
                                                            <th scope="col">FILENAME</th>

                                                            <th scope="col">ADDED DATE</th>
                                                            <th class="text-right">ACTIONS</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%
                                                            Connection connecti = ConnectionPro.getConnection();
                                                            Statement stts = null;
                                                            ResultSet resus = null;
                                                            stts = connecti.createStatement();
                                                            String querysupervisors = request.getParameter("docsearch");
                                                            String das;
                                                            if (querysupervisors != null) {
                                                                das = "select author, filename, added_date from supervisorupload where author like '%" + querysupervisors + "%' or filename like '%" + querysupervisors + "%'";
                                                            } else {
                                                                das = "select author, filename, added_date from supervisorupload";
                                                            }
                                                            resus = stts.executeQuery(das);
                                                            while (resus.next()) {
                                                        %>
                                                        <tr>
                                                            <%
                                                                // List<user> list=UserDatabase.getAllData(); 
                                                                //for(user e:list){ 

                                                            %>
                                                            <th scope="row"><%=resus.getString(1)%></th>
                                                            <td><%=resus.getString(2)%></td>
                                                            <td><%=resus.getString(3)%></td>


                                                            <td class="text-right">

                                                                <a href='SupervisorDownloadServlet?fileName=<%=resus.getString(2)%>' class="btn btn-primary badge-pill" style="width: 120px;">DOWNLOAD</a>

                                                            </td>
                                                        </tr>
                                                        <%}%>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>				
                                    </div>
                                </div>
                            </div>
                        </div>

                    </main>
                </section> 

                <section id="teachers">
                    <!-- Adding teacher data -->

                    <div class="modal fade" id="addteacher" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="TeacherRegisterServlet" method="post">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">ADD NEW TEACHER</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">

                                        <div class="mb-3">

                                            <label for="exampleFormControlInput1" class="form-label">Teacher ID</label>
                                            <input type="text" class="form-control" id="" placeholder="enter an ID of teacher" name="tid">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Teacher Names</label>
                                            <input type="text" class="form-control" id="" placeholder="enter a name of teacher" name="tname">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Teacher username</label>
                                            <input type="text" class="form-control" id="" placeholder="enter an email of a teacher" name="tuname" pattern='^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$' required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Teacher password</label>
                                            <input type="text" class="form-control" id="" placeholder="enter the password of a teacher" name="tpass" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Teacher telephone</label>
                                            <input type="text" class="form-control" id="" placeholder="enter the teacher's phone number" name="ttel" pattern="^\d{10}$" required>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Save changes</button>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <!--Editing teacher data -->

                    <div class="modal fade" id="editteacher" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="TeacherEditServlet" method="post">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">MODIFY DATA OF TEACHER</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">

                                        <div class="mb-3">


                                            <label for="exampleFormControlInput1" class="form-label">Teacher ID</label>
                                            <input type="text" class="form-control" placeholder="enter an ID of teacher" name="tid">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Teacher Names</label>
                                            <input type="text" class="form-control" placeholder="enter a name of teacher" name="tname">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Teacher Username</label>
                                            <input type="text" class="form-control" placeholder="Enter teacher's email" name="tuname" pattern='^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$' required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Teacher Password</label>
                                            <input type="text" class="form-control" placeholder="enter the password of teacher" name="tpass" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Teacher telephone</label>
                                            <input type="text" class="form-control" placeholder="enter the teacher's phone number" name="ttel" pattern="^\d{10}$" required>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Save Updates</button>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <!--Display data of teacher -->

                    <div class="card">
                        <div class="card-header">
                            <h2> Data for Teachers</h2>
                        </div>
                        <div class="card-body">

                            <div class="row">

                                <div class="col-md-12 text-left">
                                    <form action="" method="get">
                                        <input type="text" class="form-control" name="teachersearch" placeholder="search here..." style="width: 270px;"/>
                                    </form>
                                </div>

                                <div class="col-md-12 text-right">
                                    <button class="btn btn-success badge-pill" data-bs-toggle="modal" data-bs-target="#addteacher" style="width: 80px;"> ADD </button>
                                    <button class="btn btn-success badge-pill" data-bs-toggle="modal" onclick="window.print();return false;" style="width: 80px;"> PRINT </button>
                                </div>
                            </div>
                            <br>
                            <table class="table table-hover" >
                                <thead>
                                    <tr>
                                        <th scope="col">Teacher's ID</th>
                                        <th scope="col">Teacher Names</th>
                                        <th scope="col">Username</th>
                                        <th scope="col">Password</th>
                                        <th scope="col">Telephone</th>
                                        <th class="text-right">ACTIONS</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        Connection conn = ConnectionPro.getConnection();
                                        Statement sta = null;
                                        ResultSet res = null;
                                        sta = conn.createStatement();
                                        String queryteacher = request.getParameter("teachersearch");
                                        String d;
                                        if (queryteacher != null) {
                                            d = "select * from teacher where TeacherID like '%" + queryteacher + "%' or TeacherNames like '%" + queryteacher + "%' or TeacherUsername like '%" + queryteacher + "%'";
                                        } else {
                                            d = "select * from teacher order by TeacherID asc";
                                        }
                                        res = sta.executeQuery(d);
                                        while (res.next()) {
                                    %>
                                    <tr>
                                        <%
                                            // List<user> list=UserDatabase.getAllData(); 
                                            //for(user e:list){ 

                                        %>
                                        <th scope="row"><%=res.getInt(1)%></th>
                                        <td><%=res.getString(2)%></td>
                                        <td><%=res.getString(3)%></td>
                                        <td><%=res.getString(4)%></td>
                                        <td><%=res.getString(5)%></td>

                                        <td class="text-right">

                                            <a href='AdminTeacherEdit?tid=<%=res.getString(1)%>' class="btn btn-primary badge-pill" style="width: 150px;">VIEW & EDIT</a>


                                            <a href='TeacherDeleteServlet?tid=<%=res.getInt(1)%>' class="btn btn-danger badge-pill" style="width: 80px;">DELETE</a>

                                        </td>
                                    </tr>
                                    <%}%>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </section> 
                <section id="supervisors">
                    <!-- Adding Supervisor data -->
                    <div class="modal fade" id="addsupervisor" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="SupervisorRegisterServlet" method="post">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">ADD NEW SUPERVISOR</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">

                                        <div class="mb-3">

                                            <label for="exampleFormControlInput1" class="form-label">Supervisor ID</label>
                                            <input type="text" class="form-control" id="" placeholder="enter an ID of supervisor" name="sid">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Supervisor Names</label>
                                            <input type="text" class="form-control" id="" placeholder="enter a name of supervisor" name="sname">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Supervisor username</label>
                                            <input type="text" class="form-control" id="" placeholder="enter email of supervisor" name="suname" pattern='^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$' required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Supervisor password</label>
                                            <input type="text" class="form-control" id="" placeholder="enter the password of supervisor" name="spass" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Supervisor telephone</label>
                                            <input type="text" class="form-control" id="" placeholder="enter the supervisor's phone number" name="stel" pattern="^\d{10}$" required>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Save changes</button>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <!--Editing supervisor data -->

                    <div class="modal fade" id="editsupervisor" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="SupervisorEditServlet" method="post">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">MODIFY DATA OF SUPERVISOR</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">

                                        <div class="mb-3">


                                            <label for="exampleFormControlInput1" class="form-label">Supervisor ID</label>
                                            <input type="text" class="form-control" placeholder="enter an ID of supervisor" name="sid">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Supervisor Names</label>
                                            <input type="text" class="form-control" placeholder="enter a name of supervisor" name="sname">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Supervisor Username</label>
                                            <input type="text" class="form-control" placeholder="Enter supervisor's email" name="suname" pattern='^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$' required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Supervisor Password</label>
                                            <input type="text" class="form-control" placeholder="enter the password of supervisor" name="spass" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Supervisor telephone</label>
                                            <input type="text" class="form-control" placeholder="enter the supervisor's phone number" name="stel" pattern="^\d{10}$" required>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Save Updates</button>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header">
                            <h2> Data for Supervisors</h2>
                        </div>
                        <div class="card-body">

                            <div class="row">

                                <div class="col-md-12 text-left">
                                    <form action="" method="get">
                                        <input type="text" class="form-control" name="supervisorsearch" placeholder="search here..." style="width: 270px;"/>
                                    </form>
                                </div>

                                <div class="col-md-12 text-right">
                                    <button class="btn btn-success badge-pill" data-bs-toggle="modal" data-bs-target="#addsupervisor" style="width: 80px;"> ADD </button>
                                    <button class="btn btn-success badge-pill" data-bs-toggle="modal" onclick="window.print();return false;" style="width: 80px;"> PRINT </button>
                                </div>
                            </div>
                            <br>
                            <table class="table table-hover" >
                                <thead>
                                    <tr>
                                        <th scope="col">Supervisor's ID</th>
                                        <th scope="col">Supervisor Names</th>
                                        <th scope="col">Username</th>
                                        <th scope="col">Password</th>
                                        <th scope="col">Telephone</th>
                                        <th class="text-right">ACTIONS</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        Connection cone = ConnectionPro.getConnection();
                                        Statement stat = null;
                                        ResultSet resu = null;
                                        stat = cone.createStatement();
                                        String querysupervisor = request.getParameter("supervisorsearch");
                                        String da;
                                        if (querysupervisor != null) {
                                            da = "select * from supervisor where SupervisorID like '%" + querysupervisor + "%' or SupervisorNames like '%" + querysupervisor + "%' or SupervisorUsername like '%" + querysupervisor + "%'";
                                        } else {
                                            da = "select * from supervisor order by SupervisorID asc";
                                        }
                                        resu = stat.executeQuery(da);
                                        while (resu.next()) {
                                    %>
                                    <tr>
                                        <%
                                            // List<user> list=UserDatabase.getAllData(); 
                                            //for(user e:list){ 

                                        %>
                                        <th scope="row"><%=resu.getInt(1)%></th>
                                        <td><%=resu.getString(2)%></td>
                                        <td><%=resu.getString(3)%></td>
                                        <td><%=resu.getString(4)%></td>
                                        <td><%=resu.getString(5)%></td>

                                        <td class="text-right">

                                            <a href='AdminSupervisorEdit?sidx=<%=resu.getInt(1)%>' class="btn btn-primary badge-pill" style="width: 150px;">VIEW & EDIT</a>

                                            <a href='SupervisorDeleteServlet?sid=<%=resu.getInt(1)%>' class="btn btn-danger badge-pill" style="width: 80px;">DELETE</a>

                                        </td>
                                    </tr>
                                    <%}%>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </section> 
                <section id="administrator">
                    <!-- Adding Administrator data -->
                    <div class="modal fade" id="addadmin" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="AdministratorRegisterServlet" method="post">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">ADD NEW ADMINISTRATOR</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">

                                        <div class="mb-3">

                                            <label for="exampleFormControlInput1" class="form-label">Admin ID</label>
                                            <input type="text" class="form-control" id="" placeholder="enter an ID of admin" name="aid">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Admin Names</label>
                                            <input type="text" class="form-control" id="" placeholder="enter a name of admin" name="aname">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Admin username</label>
                                            <input type="text" class="form-control" id="" placeholder="enter email of admin" name="auname" pattern='^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$' required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Admin password</label>
                                            <input type="text" class="form-control" id="" placeholder="enter the password of admin" name="apass" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}">
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Save changes</button>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <!--Editing administrator data -->

                    <div class="modal fade" id="editadmin" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="AdministratorEditServlet" method="post">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">MODIFY DATA OF ADMINISTRATOR</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">

                                        <div class="mb-3">


                                            <label for="exampleFormControlInput1" class="form-label">Admin ID</label>
                                            <input type="text" class="form-control" placeholder="enter an ID of admin" name="aid">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Admin Names</label>
                                            <input type="text" class="form-control" placeholder="enter a name of admin" name="aname">
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Admin Username</label>
                                            <input type="text" class="form-control" placeholder="Enter admin's email" name="auname" pattern='^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$' required>
                                        </div>
                                        <div class="mb-3">
                                            <label for="exampleFormControlInput1" class="form-label">Admin Password</label>
                                            <input type="text" class="form-control" placeholder="enter the password of admin" name="apass" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}">
                                        </div>


                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Save Updates</button>

                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-header">
                            <h2> Data for Administrators</h2>
                        </div>
                        <div class="card-body">

                            <div class="row">

                                <div class="col-md-12 text-left">
                                    <form action="" method="get">
                                        <input type="text" class="form-control" name="adminsearch" placeholder="search here..." style="width: 270px;"/>
                                    </form>
                                </div>

                                <div class="col-md-12 text-right">
                                    <button class="btn btn-success badge-pill" data-bs-toggle="modal" data-bs-target="#addadmin" style="width: 80px;"> ADD </button>
                                    <button class="btn btn-success badge-pill" data-bs-toggle="modal" onclick="window.print();return false;" style="width: 80px;"> PRINT </button>
                                </div>
                            </div>
                            <br>
                            <table class="table table-hover" >
                                <thead>
                                    <tr>
                                        <th scope="col">Admin's ID</th>
                                        <th scope="col">Admin Names</th>
                                        <th scope="col">Username</th>
                                        <th scope="col">Password</th>

                                        <th class="text-right">ACTIONS</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        Connection conec = ConnectionPro.getConnection();
                                        Statement state = null;
                                        ResultSet resul = null;
                                        state = conec.createStatement();
                                        String queryadmin = request.getParameter("adminsearch");
                                        String dat;
                                        if (queryadmin != null) {
                                            dat = "select * from administrator where AdminID like '%" + queryadmin + "%' or AdminNames like '%" + queryadmin + "%' or AdminUsername like '%" + queryadmin + "%'";
                                        } else {
                                            dat = "select * from administrator order by AdminID asc";
                                        }
                                        resul = state.executeQuery(dat);
                                        while (resul.next()) {
                                    %>
                                    <tr>
                                        <%
                                            // List<user> list=UserDatabase.getAllData(); 
                                            //for(user e:list){ 

                                        %>
                                        <th scope="row"><%=resul.getInt(1)%></th>
                                        <td><%=resul.getString(2)%></td>
                                        <td><%=resul.getString(3)%></td>
                                        <td><%=resul.getString(4)%></td>


                                        <td class="text-right">

                                            <a href='AdminEdit?aidx=<%=resul.getInt(1)%>' class="btn btn-primary badge-pill" style="width: 150px;">VIEW & EDIT</a>

                                            <a href='AdministratorDeleteServlet?aid=<%=resul.getInt(1)%>' class="btn btn-danger badge-pill" style="width: 80px;">DELETE</a>

                                        </td>
                                    </tr>
                                    <%}%>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </section> 


            </div>
        </section>
        <script>
            function w3_open1() {
                document.getElementById("dashboard").style.display = "block";

                document.getElementById("teachers").style.display = "none";
                document.getElementById("supervisors").style.display = "none";
                document.getElementById("administrator").style.display = "none";

            }


            function w3_open3() {
                document.getElementById("dashboard").style.display = "none";

                document.getElementById("teachers").style.display = "block";
                document.getElementById("supervisors").style.display = "none";
                document.getElementById("administrator").style.display = "none";

            }
            function w3_open4() {
                document.getElementById("dashboard").style.display = "none";

                document.getElementById("teachers").style.display = "none";
                document.getElementById("supervisors").style.display = "block";
                document.getElementById("administrator").style.display = "none";

            }
            function w3_open5() {
                document.getElementById("dashboard").style.display = "none";

                document.getElementById("teachers").style.display = "none";
                document.getElementById("supervisors").style.display = "none";
                document.getElementById("administrator").style.display = "block";

            }

        </script>
    </body>

</html>


<section id="supervisors">
            <!-- Adding Supervisor data -->
            <div class="modal fade" id="addsupervisor" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="SupervisorRegisterServlet" method="post">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">ADD NEW SUPERVISOR</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">

                                <div class="mb-3">

                                    <label for="exampleFormControlInput1" class="form-label">Supervisor username</label>
                                    <input type="text" class="form-control" id="" placeholder="enter the username of supervisor" name="sid">
                                </div>
                                <div class="mb-3">
                                    <label for="exampleFormControlInput1" class="form-label">Supervisor Password</label>
                                    <input type="text" class="form-control" id="" placeholder="enter the password of supervisor" name="sname">
                                </div>
                                <div class="mb-3">
                                    <label for="exampleFormControlInput1" class="form-label">Supervisor first name</label>
                                    <input type="text" class="form-control" id="" placeholder="enter the first name of supervisor" name="suname" pattern='^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$' required>
                                </div>
                                <div class="mb-3">
                                    <label for="exampleFormControlInput1" class="form-label">Supervisor last name</label>
                                    <input type="text" class="form-control" id="" placeholder="enter the last name of supervisor" name="spass" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}">
                                </div>
                                <div class="mb-3">
                                    <label for="exampleFormControlInput1" class="form-label">Supervisor position</label>

                                    <select name="position" class="form-control">

                                        <%

                                            try {

                                                Connection con = ConnectionPro.getConnection();

                                                PreparedStatement pst = con.prepareStatement("select pname from jobposition");

                                                ResultSet rs = pst.executeQuery();
                                                while (rs.next()) {
                                                    String name = rs.getString("pname");
                                        %>

                                        <option value="<%=name%>"><%=name%></option>
                                        <%
                                                }
                                            } catch (Exception e) {
                                                out.print(e);
                                            }
                                        %>
                                    </select>
                                </div>

                            </div>
                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Supervisor telephone</label>
                                <input type="text" class="form-control" id="" placeholder="enter the supervisor's phone number" name="stel" pattern="^\d{10}$" required>
                            </div>
                            <div class="mb-3">
                                <label for="exampleFormControlInput1" class="form-label">Supervisor username</label>
                                <input type="text" class="form-control" id="" placeholder="enter email of supervisor" name="suname" pattern='^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$' required>
                            </div>
                            <div class="mb-3">
                                <select name="roln" class="form-control">

                                    <%
                                        try {

                                            Connection conr = ConnectionPro.getConnection();

                                            PreparedStatement pstr = conr.prepareStatement("select rolename from role");

                                            ResultSet rsr = pstr.executeQuery();
                                            while (rsr.next()) {
                                                String namer = rsr.getString("rolename");
                                    %>

                                    <option value="<%=namer%>"><%=namer%></option>
                                    <%
                                            }
                                        } catch (Exception e) {
                                            out.print(e);
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Save changes</button>

                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!--Editing supervisor data -->

            <div class="modal fade" id="editsupervisor" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="SupervisorEditServlet" method="post">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">MODIFY DATA OF SUPERVISOR</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">

                                <div class="mb-3">


                                    <label for="exampleFormControlInput1" class="form-label">Supervisor ID</label>
                                    <input type="text" class="form-control" placeholder="enter an ID of supervisor" name="sid">
                                </div>
                                <div class="mb-3">
                                    <label for="exampleFormControlInput1" class="form-label">Supervisor Names</label>
                                    <input type="text" class="form-control" placeholder="enter a name of supervisor" name="sname">
                                </div>
                                <div class="mb-3">
                                    <label for="exampleFormControlInput1" class="form-label">Supervisor Username</label>
                                    <input type="text" class="form-control" placeholder="Enter supervisor's email" name="suname" pattern='^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$' required>
                                </div>
                                <div class="mb-3">
                                    <label for="exampleFormControlInput1" class="form-label">Supervisor Password</label>
                                    <input type="text" class="form-control" placeholder="enter the password of supervisor" name="spass" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}">
                                </div>
                                <div class="mb-3">
                                    <label for="exampleFormControlInput1" class="form-label">Supervisor telephone</label>
                                    <input type="text" class="form-control" placeholder="enter the supervisor's phone number" name="stel" pattern="^\d{10}$" required>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Save Updates</button>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <h2> Data for Supervisors</h2>
                </div>
                <div class="card-body">

                    <div class="row">

                        <div class="col-md-12 text-left">
                            <form action="" method="get">
                                <input type="text" class="form-control" name="supervisorsearch" placeholder="search here..." style="width: 270px;"/>
                            </form>
                        </div>

                        <div class="col-md-12 text-right">
                            <button class="btn btn-success badge-pill" data-bs-toggle="modal" data-bs-target="#addsupervisor" style="width: 80px;"> ADD </button>
                            <button class="btn btn-success badge-pill" data-bs-toggle="modal" onclick="window.print();return false;" style="width: 80px;"> PRINT </button>
                        </div>
                    </div>
                    <br>
                    <table class="table table-hover" >
                        <thead>
                            <tr>
                                <th scope="col">Supervisor's ID</th>
                                <th scope="col">Supervisor Names</th>
                                <th scope="col">Username</th>
                                <th scope="col">Password</th>
                                <th scope="col">Telephone</th>
                                <th class="text-right">ACTIONS</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                Connection cone = ConnectionPro.getConnection();
                                Statement stat = null;
                                ResultSet resu = null;
                                stat = cone.createStatement();
                                String querysupervisor = request.getParameter("supervisorsearch");
                                String da;
                                if (querysupervisor != null) {
                                    da = "select * from supervisor where SupervisorID like '%" + querysupervisor + "%' or SupervisorNames like '%" + querysupervisor + "%' or SupervisorUsername like '%" + querysupervisor + "%'";
                                } else {
                                    da = "select * from supervisor order by SupervisorID asc";
                                }
                                resu = stat.executeQuery(da);
                                while (resu.next()) {
                            %>
                            <tr>
                                <%
                                    // List<user> list=UserDatabase.getAllData(); 
                                    //for(user e:list){ 

                                %>
                                <th scope="row"><%=resu.getInt(1)%></th>
                                <td><%=resu.getString(2)%></td>
                                <td><%=resu.getString(3)%></td>
                                <td><%=resu.getString(4)%></td>
                                <td><%=resu.getString(5)%></td>

                                <td class="text-right">

                                    <a href='AdminSupervisorEdit?sidx=<%=resu.getInt(1)%>' class="btn btn-primary badge-pill" style="width: 150px;">VIEW & EDIT</a>

                                    <a href='SupervisorDeleteServlet?sid=<%=resu.getInt(1)%>' class="btn btn-danger badge-pill" style="width: 80px;">DELETE</a>

                                </td>
                            </tr>
                            <%}%>

                        </tbody>
                    </table>
                </div>
            </div>
        </section>