<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="photohub.*" import="java.util.*" %>
<%!
	Integer userid = null;
	String useremail = null;
	ArrayList<PhotoInfo> photolist = null;
%>
<% 
	userid = (Integer) (request.getSession()).getAttribute("userId");
	useremail = (String) (request.getSession()).getAttribute("userEmail");
   if ( userid == null || userid.intValue() < 0 ) {
   		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
	}
   photolist = TablePhoto.photoList();
%>
<!DOCTYPE html>
<html>
  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- To ensure proper rendering and touch zooming -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="PhotoHub welcome and sign in page.">
    <meta name="keywords" content="PhotoHub, welcome, sign in">
    <meta name="author" content="Meng zhanshuai, Wang qi, Pu yang, Tang shunlei">

    <link rel="shortcut icon" href="http://getbootstrap.com/docs-assets/ico/favicon.png">

    <title>图片流</title>

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
            <li><a data-toggle="modal" href="#aboutUs">关于我们</a></li>

          </ul>

          <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="搜你感兴趣的">
            </div>
            <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
          </form>

          <ul class="nav navbar-nav navbar-right">
            <li><a data-toggle="modal" href="./uploadphoto.html/#uploadPhoto"><span class="glyphicon glyphicon-cloud-upload"> 上传图片</span></a></li>

            <!-- dropdown -->
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%= useremail %><b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#"><span class="glyphicon glyphicon-picture"> 个人图册</span></a></li>
                <li><a data-toggle="modal" data-target="#resetPassword">修改密码</a></li>
                <li><a href="#">账号设置</a></li>
                <li class="divider"></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-out"> 注销</span></a></li>
              </ul>
            </li>

          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>

    <div class="container">

      <div class="container-fluid">
        <div class="col-md-8 col-md-offset-2 blurglass">
          <!-- <div class="row">
            <div class="col-xs-3">
              <a href="#" class="thumbnail">
                <img src="http://hd.wallpaperswide.com/thumbs/field_sunrise-t2.jpg" alt="...">
              </a>
            </div>
            <div class="col-md-9">
              <div class="thumbnail">
                <img src="http://hd.wallpaperswide.com/thumbs/field_sunrise-t2.jpg" alt="...">
                <div class="caption">
                  <h3>Thumbnail label</h3>
                  <p>...</p>
                  <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                </div>
              </div>
            </div>
          </div> -->
          <div class="row">
          <%
          if (photolist != null) {
	          ListIterator<PhotoInfo> photoIterator = photolist.listIterator(photolist.size());
	          PhotoInfo pinfo = null;
	          int count = 0;
	          System.out.println("Parsing photolist ...");
	          while (photoIterator.hasPrevious() && count < 5) {
	        	  pinfo = photoIterator.previous();
	        	  count ++;
	        	  System.out.println("photo " + pinfo.photo);
	        	  ArrayList<CommentInfo> commentlist = Comment.commentlist(pinfo.photoID);
          %>
            <div class="media">
              <a class="pull-left" href="#">
                <img class="media-object" src="IMAGE/userdefault.svg" alt="...">
              </a>
              <div class="media-body">
                <h4 class="media-heading"><%= pinfo.userID %></h4>
                <div>
                  <img src="<%= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath() + "/IMAGE/" + pinfo.photo.substring(pinfo.photo.lastIndexOf("\\") + 1) %>" alt="Oops...">
                  <!-- http://hd.wallpaperswide.com/thumbs/field_sunrise-t2.jpg -->
                  <h3><%= pinfo.introduction %></h3>
                  <br>
                  <%
    	          ListIterator<CommentInfo> commentIterator = commentlist.listIterator();
                  CommentInfo comment = null;
					while (commentIterator.hasNext()) {
						comment = commentIterator.next();
						%>
		                  <p><strong><%= comment.userName %></strong>: <%= comment.commentMess %></p>
				  <%
					}
                  %>
                  <p>
                  	<a data-toggle="modal" href="#commentPhoto<%= count %>" class="btn btn-default btn-xs" role="button">评论</a>
                  	<a data-toggle="modal" href="#editPhoto<%= count %>" class="btn btn-default btn-xs" role="button">美化</a>
                  </p>
                </div>
              </div>
            </div>

              <!-- model -->
		      <div class="modal fade" id="commentPhoto<%= count %>">
		        <div class="modal-dialog">
		          <div class="modal-content">
		            <div class="modal-header">
		              <button type="button" class="close" data-dismiss="modal" aria-hidden="true" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">&times;</button>
		              <h4 class="modal-title">添加评论</h4>
		            </div>
		            <div class="modal-body">
		              <form role="form" method="post" action="comment">
		                <div class="form-group">
		                  <textarea class="form-control" name="inputComment" rows="3"></textarea>
		                  <p class="help-block">评论小于140字</p>
		                </div>
		                <input type="hidden" name="inputUserId" value="<%= userid %>">
		                <input type="hidden" name="inputPhotoId" value="<%= pinfo.photoID %>">
		                <button type="submit" class="btn btn-default">确定</button>
		                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		              </form>
		            </div>
		          </div><!-- /.modal-content -->
		        </div><!-- /.modal-dialog -->
		      </div><!-- /.modal -->

              <!-- model -->
		      <div class="modal fade" id="editPhoto<%= count %>">
		        <div class="modal-dialog">
		          <div class="modal-content">
		            <div class="modal-header">
		              <button type="button" class="close" data-dismiss="modal" aria-hidden="true" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">&times;</button>
		              <h4 class="modal-title">图片美化</h4>
		            </div>
		            <div class="modal-body">
		              <form role="form" method="post" action="comment">
		              
		                <div class="form-group">
		              
		                  <div class="input-group">
						      <div class="input-group-btn">
						        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">过滤器 <span class="caret"></span></button>
						        <ul class="dropdown-menu">
						          <li><a href="#">图片变暗</a></li>
						          <li><a href="#">图片变灰</a></li>
						          <li><a href="#">图片锐化</a></li>
						          <li><a href="#">图像黑白化</a></li>
						          <li><a href="#">水印文字</a></li>
						        </ul>
						      </div><!-- /btn-group -->
						      <input type="text" class="form-control" name="inputText" placeholder="选取过滤器并输入参数">
						      <input type="hidden" class="form-control" name="inputFilter">
						    </div><!-- /input-group -->
		              
		                </div>
		                <input type="hidden" name="inputUserId" value="<%= userid %>">
		                <input type="hidden" name="inputPhotoId" value="<%= pinfo.photoID %>">
		                <input type="hidden" name="inputPath" value="<%= "C:/Users/cc/Documents/GitHub/PhotoHub/WebContent/IMAGE/" + pinfo.photo.substring(pinfo.photo.lastIndexOf("\\") + 1) %>">
		                <button type="submit" class="btn btn-default">确定</button>
		                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		              </form>
		            </div>
		          </div><!-- /.modal-content -->
		        </div><!-- /.modal-dialog -->
		      </div><!-- /.modal -->

            <%
            	}
        	}
            %>
            
          </div>
        </div>
      </div>

      <!-- model -->
      <div class="modal fade" id="uploadPhoto">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">&times;</button>
              <h4 class="modal-title">上传你的图片</h4>
            </div>
            <div class="modal-body">
              <form role="form" encType="multipart/form-data" method="post" action="UploadServlet">
                <div class="form-group">
                  <label for="input">添加评论</label>
                  <input type="text" class="form-control" name="inputIntroduction" placeholder="给图片添加一个评论">
                  <p class="help-block">评论小于140字</p>
                </div>
                <div class="form-group">
                  <label for="exampleInputFile">打开图片</label>
                  <input type="file" name="inputFile">
                </div>
                <button type="submit" class="btn btn-default">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
              </form>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
      </div><!-- /.modal -->

      <!-- model -->
      <div class="modal fade" id="resetPassword">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">&times;</button>
              <h4 class="modal-title">修改密码</h4>
            </div>
            <div class="modal-body">
              <form role="form">
                <div class="form-group">
                  <label for="exampleInputEmail1">原密码</label>
                  <input type="email" class="form-control" id="exampleInputEmail1">
                </div>
                <div class="form-group has-warning">
                  <label for="exampleInputPassword1">新密码</label>
                  <input type="password" class="form-control" id="exampleInputPassword1">
                  <p class="help-block">6-20位大小写字母或数字</p>
                </div>
                <div class="form-group has-warning">
                  <label for="exampleInputFile">新密码确认</label>
                  <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn btn-default">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
              </form>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
      </div><!-- /.modal -->
      
      	<!-- model -->
		<div class="modal fade" id="aboutUs">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title">软件工程第八组</h4>
		      </div>
		      <div class="modal-body">
		        <p><strong>王琦</strong><span> </span>（组长）</p>
		        <p>学号：111220125</p>
		        <p>邮箱：wangqi199204@gmail.com</p>
		        <hr>
		        <p><strong>孟占帅</strong></p>
		        <p>学号：837468357@qq.com</p>
		        <p>邮箱：</p>
		        <hr>
		        <p><strong>蒲阳</strong></p>
		        <p>学号：1696531551@qq.com</p>
		        <p>邮箱：</p>
		        <hr>
		        <p><strong>汤顺雷</strong></p>
		        <p>学号：111220111</p>
		        <p>邮箱：tangshunlei@gmail.com</p>
		      </div>
		      <div class="modal-footer">
		        <p>2014年06月18日 南京大学计算机系</p>
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
    
    <!-- Custom JacaScript -->
    <script src="custom.js"></script>

  </body>
</html>