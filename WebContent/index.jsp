<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- To ensure proper rendering and touch zooming -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="PhotoHub welcome and sign in page.">
    <meta name="keywords" content="PhotoHub, welcome, sign in">
    <meta name="author" content="Zhan Shen, Qi shen, Pu fu er, Tang shunlei">

    <link rel="shortcut icon" href="http://getbootstrap.com/docs-assets/ico/favicon.png">

    <title>Welcome</title>

    <!-- Bootstrap core CSS -->
    <link href="LIB/bootstrap.min.css" rel="stylesheet">
    <!-- http://getbootstrap.com/dist/css/bootstrap.min.css -->

    <!-- Documentation extras -->
    <link href="LIB/docs.min.css" rel="stylesheet">
      <!-- http://getbootstrap.com/assets/css/docs.min.css -->
    <!--[if lt IE 9]><script src="../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    
    <link href="LIB/font-awesome.min.css" rel="stylesheet">
      <!-- http://libs.baidu.com/fontawesome/4.0.3/css/font-awesome.min.css -->
      
    <!-- Custom CSS -->
      <link href="custom.css" rel="stylesheet">
      
    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

  </head>

  <body class="body-custom">
  
    <nav class="navbar navbar-inverse navbar-custom" role="navigation">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">PhotoHub</a>
        </div>
      
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <!-- <li class="active"><a href="#">Link</a></li>
            <li><a href="#">Link</a></li> -->

            <!-- trigger modal -->
            <li><a data-toggle="modal" href="#myModal">关于我们</a></li>

            <!-- dropdown -->
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
                <li class="divider"></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>

          <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="搜你感兴趣的">
            </div>
            <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
          </form>

          <ul class="nav navbar-nav navbar-right">
          	<% if (session.getAttribute("userId") == null || session.getAttribute("userId").toString().equals("")) { %>
            <li><a data-toggle="modal" href="#signUp">登录 <span class="glyphicon glyphicon-log-in"></span></a></li>
	 		<% } else {%>
	 		<li><a href="./photostream.jsp">图片流 <span class="glyphicon glyphicon-log-in"></span></a></li>
	 		<% } %>
            <!-- dropdown -->
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li><a href="#">Separated link</a></li>
              </ul>
            </li>

          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>

    <div class="container">

      <div class="container-fluid">
        <div class="col-xs-12">
        <div id="carousel-welcome" class="carousel slide" data-ride="carousel">
          <!-- Indicators -->
          <ol class="carousel-indicators">
            <li data-target="#carousel-welcome" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-welcome" data-slide-to="1"></li>
            <li data-target="#carousel-welcome" data-slide-to="2"></li>
          </ol>

          <!-- Wrapper for slides -->
          <div class="carousel-inner">
            <div class="item">
              <img src="IMAGE/bg-2014worldcup.jpg" alt="Oops ...">
              <div class="carousel-caption">
                
                <h1>Welcome to PhotoHub, powered by Bootstrap</h1>
                <p>Bootstrap is a free collection of tools for creating websites and web applications. It contains HTML and CSS-based design templates for typography, forms, buttons, navigation and other interface components, as well as optional JavaScript extensions.
                It is the No.1 project on GitHub with 65,000+ stars and 23,800 forks (as of March 2014) [1] and has been used by NASA and MSNBC, among many others.</p>
              </div>
            </div>

            <div class="item active">
              <img src="IMAGE/bg-joker.jpg" alt="Oops ...">
              <div class="carousel-caption">
                
                <h1>Welcome to PhotoHub, powered by Bootstrap</h1>
                <p>Bootstrap is a free collection of tools for creating websites and web applications. It contains HTML and CSS-based design templates for typography, forms, buttons, navigation and other interface components, as well as optional JavaScript extensions.
                It is the No.1 project on GitHub with 65,000+ stars and 23,800 forks (as of March 2014) [1] and has been used by NASA and MSNBC, among many others.</p>
              </div>
            </div>
              
            <div class="item">
              <img src="IMAGE/bg-thewintersoldier.jpg" alt="Oops ...">
              <div class="carousel-caption">
                
                <h1>Welcome to PhotoHub, powered by Bootstrap</h1>
                <p>2014 World Cup in Brazil</p>
              </div>
            </div>
            
          </div>

          <!-- Controls -->
          <a class="left carousel-control" href="#carousel-welcome" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
          </a>
          <a class="right carousel-control" href="#carousel-welcome" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
          </a>
        </div>

        <hr class="half-rule">
          <div class="row">
            <div class="col-sm-9 col-md-6">
              <div class="thumbnail blurglass">
                <img src="http://hd.wallpaperswide.com/thumbs/field_sunrise-t2.jpg" alt="...">
                <div class="caption">
                  <h3>We provide extremely fast channel</h3>
                  <p>Sync your photo and share with your every device.</p>
                </div>
              </div>
            </div>
            <div class="col-sm-9 col-md-6">
              <div class="thumbnail blurglass">
                <img src="http://hd.wallpaperswide.com/thumbs/spring_mountain_landscape_2-t2.jpg" alt="...">
                <div class="caption">
                  <h3>现在注册</h3>
                  <!-- sign up -->
                    <form class="form-horizontal" role="form">
                      <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">用户邮箱</label>
                        <div class="col-sm-10">
                          <input type="email" class="form-control" name="signupEmail" placeholder="Email">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                          <input type="password" class="form-control" name="signupPassword" placeholder="Password">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">密码确认</label>
                        <div class="col-sm-10">
                          <input type="password" class="form-control" name="confirmPassword" placeholder="Password">
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                          <button type="submit" class="btn btn-warning">注册</button>
                        </div>
                      </div>
                    </form>
                  <!-- end sign up -->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    <!-- model -->
    <div class="modal fade" id="signUp">
      <div class="modal-dialog">
        <div class="modal-content">

          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">&times;</button>
            <h4 class="modal-title">用户登录</h4>
          </div>
          <div class="modal-body">
            <form role="form" action="signin" method="post">
              <div class="form-group">
                <label for="exampleInputEmail1">用户邮箱</label>
                <input type="email" class="form-control" name="signinEmail" placeholder="输入注册邮箱">
              </div>
              <div class="form-group">
                <label for="exampleInputPassword1">密码</label>
                <input type="password" class="form-control" name="signinPassword" placeholder="输入6-20位登录密码">
              </div>
              <div class="checkbox">
                <label>
                  <input type="checkbox" name="rememberPassword">记住密码
                </label>
              </div>
              <button type="submit" class="btn btn-primary" onclick="signin()">确定</button>
              <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </form>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    </div>
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./LIB/jquery.min.js"></script>
    <!--  https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js -->
    <script src="./LIB/bootstrap.min.js"></script>
    <!--  http://getbootstrap.com/dist/js/bootstrap.min.js -->
    <script src="./LIB/docs.min.js"></script>
    <!--  http://getbootstrap.com/assets/js/docs.min.js -->

  </body>
</html>