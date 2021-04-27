/*<%
  if(session.getAttribute("usu") != null){
%>*/
<%@include file="header.jsp"%>
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1> <i class="fas fa-parking"></i> MyParking</h1>
          </div>
          <div class="col-sm-6">
            
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
<%@include file="footer.jsp"%>
  </body>
</html>

/*<%}else{
  response.sendRedirect("login.jsp");
}%>*/
